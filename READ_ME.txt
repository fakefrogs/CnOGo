CnO Go
Paul C. Rogers II
January, 2018 -- (Expected May, 2018)


Semester project for Mobile Apps class.
"CnO Go" is a simple combat game based on the comic series "Clyde n Owen".

//--  Project Presentation Ready Update  --//
  --  April, 29th 2018
  
Application is now feature complete and ready for presentation.

Application gameplay mechanics now work.  Ability One, Two, and Three fully 
implemented.

Additional features implemented:  character unlocks and medals tied to player 
stats.  Additional player character selection screen tied to unlocks added to 
application.

Navigation and application state adjusted to help maintain character passing 
values between activities and UI elements when leaving and returning to activities.

Image resources added.  String resources added.  Color values added.  Layouts tweaked
and adjusted.
  

//--  Your Choice Project Update  --//
  --  April, 17th 2018
  
Began implementation of actual gameplay.  Created a Character class to assist in 
creating both player and opponent characters durring MatchActivity.  This class 
receives an integer value used to determine which character should be instantiated
(these are passed by the intent that calls the activity). As well, methods are 
provided to access character name, ability names, and ability values.

MatchActivity now has basic gameplay mechanics playable.  Code for methods that 
process player's move, opponent's move, health and victory checks has largely been 
implemented.  Character abilities One and Two have been implemented along with 
hit chances and defense chances (These determine how much damage an attack will do
and how effective the defense will be).

Ability Three has not been implemented at this stage.  When the player and opponent
use ability Three, nothing happens at this point.  Silly messages are displayed in
the combat info textview instead.

Have begun preparation for adding more visual resources for characters.  Code has
been put in place to assign the images for each character once these images have 
been drawn up.


//--  Saving Data Project update  --//
  --  April, 3rd 2018

Implemented saved stats in application.  These stats are saved in a file in
internal storage.  When application is first loaded up, the file is created
and saved to the app's internal storage where it will continue to persist 
and be updated with app usage.

File is saved as:  stats.txt
This file stores stat titles and values together as one string.
Sample: "Victories:0:Clyde:0:Owen:0:..."

In MainActivity, a checkFile() method checks to see if the file already exists
in the internal app storage.  If not, an AddFile() method is called to create 
stats.txt in the internal app storage.

A new StatsActivity has been added which is accessible from the MainActivity via
a "Stats" button.  The StatsActivity first checks that stats.txt exists then 
retrieves the stored string.  The string is then broken down into a String[] for 
further processing of the stat titles and values.
Stat titles are displayed in TextViews with their respective values in adjacent 
TextViews.
Examples:	Victories	0	//Number of player's victories
			Clyde		0	//Number of times this opponent has been beaten
			...
			
In EndMatchActivity, a checkFile() method checks for stats.txt.  If the file is 
there, an UpdateStats() method is called.  This method retrieves the stored string 
and breaks it down into a String[] for processing.  The method searches for a 
matching "title" entry based on the opponent value passed by the activity's calling 
intent.  This is done with a switch statement, a for loop, and an if statement.  
When a match is made to a "title" element in the String[], the corresponding "value"
element in the String[] is updated.
(Title elements are at indexes: 0, 2, 4, 6...)
(Value elements are at indexes: 1, 3, 5, 7...)
Then, the UpdateStats() method compiles all the String[] elements back into one 
String to be written back to stats.txt.  When all this has been done, stats.txt is 
updated with at least two new stat values.  These changes can be viewed when returning 
to the MainActivity and navigating to the StatsActivity.


//--  Development progress  --//

Layouts:        Basic layouts completed.
	To be done: layout localization
				
Navigation: 	Basic navigation completed.
				Fixed issue with value passings with intents
				Refined navigation
				Added basic state maintenance
	To be done: 
				
Data storing:	Basic saved stats completed
				Updated some stat titles and values
				Added unlocks:  Medals and player character unlocks
	To be done: 
				

Gameplay:		Implemented player/opponent moves with supporting methods for checking
				character health, who's turn is next, whether victory has been achieved,
				plus other character creation and supporting methods.
				Implemented abilities One, Two, and Three
	To be done: Refine character values

//--  Development notes  --//

Basic layout, navigation, data storage, and gameplay implemented.

Added all of actual gameplay mechanics.
Further refinements may be needed in time with further testing.

Added a stats screen as part of implementing data storage.
This feature is mostly complete.  Further features related to stats are planned.

Added unlocks tied to stats.  Medals and player character unlocks awarded based off
player stats.  Medals added to stats screen.  Secondary player select activity added.
MainActivity routes to new playerSelect activity when additional characters have been
unlocked.
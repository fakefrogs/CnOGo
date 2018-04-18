CnO Go
Paul C. Rogers II
January, 2018 -- (Expected May, 2018)


Semester project for Mobile Apps class.
"CnO Go" is a simple combat game based on the comic series "Clyde n Owen".

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
	To be done: layout refinements
				layout localization
				
Navigation: 	Basic navigation completed.
				Fixed issue with value passings with intents
				Refined navigation
	To be done: adjust value passing as needed
				further refine navigation as needed
				
Data storing:	Basic saved stats completed
				Updated some stat titles and values
	To be done: 
	Possible features to be added:	Medals/Awards
									Character unlocks
				

Gameplay:		Implemented player/opponent moves with supporting methods for checking
				character health, who's turn is next, whether victory has been achieved,
				plus other character creation and supporting methods.
				Implemented abilities One and Two
	To be done: Implement ability Three
				Refine opponent decision making

//--  Development notes  --//

Basic layout, navigation, data storage, and some gameplay implemented.

Added much of actual gameplay mechanics.  Remaining mechanics need to be implemented.
Further refinements needed.

Added a stats screen as part of implementing data storage.
This feature is mostly complete.  Further features related to stats are planned.
CnO Go
Paul C. Rogers II
January, 2018 -- (Expected May, 2018)


Semester project for Mobile Apps class.
"CnO Go" is a simple combat game based on the comic series "Clyde n Owen".

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
				Implemented basic value passing
				Refined navigation
	To be done: further refine value passing
				further refine navigation
				
Data storing:	Basic saved stats completed
	To be done: further refine stat features
				

Gameplay:		Begun implementation
	To be done: build gameplay mechanics

//--  Development notes  --//

Basic layout, navigation, and data storage implemented.

Added a stats screen as part of implementing data storage.
This feature is mostly complete.  Further features related to stats are planned.

Because no gameplay mechanics have been implemented, in order to navigate to
end match screen for testing purposes, ability buttons act as a shortcut.  
Press each ability button in order to access end match screen.
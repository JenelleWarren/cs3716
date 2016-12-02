# cs3716

Run Account.java
On start up log in screen is displayed
Enter user name into username field and password into password field
Usernames and passwords repectively for permission levels are listed below:
	Coach: coach, coachpass
	Organizer: organizer, organizerpass
	Referee: referee, refereepass
Guest button logs user in as guest
Tabs in tournament will display based on permission level
Tabs and their functionality are listed below
	
	Schedule:
	A list of games will be displayed here when a tournament has been started, sorted by the round in which they occur
	
	Team Manager:
	Shows a drop down box that contains the list of teams in the active tournament and a button to add a new team
		add new: opens a window that allows you to enter a name for a team and 
		slect whether the are designated good or not, which effects seeding in that		
		good teams will not play against each other where possible(via array shuffling)

	Tournament Manager:
	Shows a drop down list of tournaments, whichever is selected is considered the active tournament and can	
	then be modified. Also contains a button which creates a new tournament and a button which starts
	the active tournament whith the teams that have been added.
		add new: opens a window that lets  the user select single elimination, double elimination or divisions for bracket type
		and allows the entering of a name for the tournament, after confirmed, this new tournament is 		
		added to the list
	
	Score Matches:
	Displays a list of active games in the active tournament, the user can select one, enter A score for each team	
		and press submit to finalize the scores for the game. checks if scores are valid based on volleyball rules.

Single elimination works for any number of teams, bys work correctly 
double elimination must take 2 to the power of n teams 

Step by Step:

Login as organizer
in Manage tournaments tab click new Tournament
select bracket type and enter name
go to teams tab, create desired amount of teams with names and Designated good values
Go to manage tournaments and press Strat tournament
go to score matches and enter scores for each team for each match in the drop down box
veiw schedule in schedule tab
  

GitHub link https://github.com/TroyWarren/cs3716

Scores:
Troy 12
Josh 12
James 11
Mohamad 11
Michelle 8
Yang 6

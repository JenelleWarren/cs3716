

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

public class TournamentPanel extends Panel{
	//Initialize Variables/ Components
	private int permissions = 0; //0 = guest, 1 = ref, 2 = coach, 3 = organizer
	private ArrayList<Tournament> tournaments = new ArrayList();
	private Tournament activeTournament = new Tournament("Default");
	private JFrame ntour;
	private JFrame nteam;
	private JTextArea schedule;
	private JLabel tList;
	private JLabel chooseBracket;
	private JLabel enterName;
	private JButton start; 
	private JComboBox tournamentList;
	private JButton newTournament;
	private JComboBox teamList;
	private JButton newTeam;
	private JRadioButton singleElim;
	private JRadioButton doubleElim;
	private JRadioButton divisions;
	private JTextField newTournamentName;
	private JButton confirmTournament;
	private JRadioButton good;
	private JTextField newTeamName;
	private JButton confirmTeam;
	private JButton scoreMatch;
	private JTextField teamAScore;
	private JTextField teamBScore;
	private JComboBox matchList;
	private JLabel inv;
	final DefaultComboBoxModel model = new DefaultComboBoxModel(tournaments.toArray());
	final DefaultComboBoxModel model2 = new DefaultComboBoxModel((activeTournament.getList()).toArray());
	final DefaultComboBoxModel model3 = new DefaultComboBoxModel((activeTournament.getBracket().getGames()).toArray());
	private JLabel lblSelectAGame;
	JTabbedPane tabs = new JTabbedPane();
    
	//Constructor for main panel
	public void setPermissions(int i){
		permissions = i;
		JPanel tPanel = new JPanel();
		tPanel.setBackground(SystemColor.inactiveCaption);
		JPanel teamPanel = new JPanel();
		teamPanel.setBackground(SystemColor.inactiveCaption);
		JPanel schedulePanel = new JPanel();
		schedulePanel.setBackground(SystemColor.inactiveCaption);
		JPanel scorePanel = new JPanel();
		scorePanel.setBackground(SystemColor.inactiveCaption);
		JPanel grid1 = new JPanel();
		grid1.setBounds(123, 5, 394, 76);
		JPanel grid2 = new JPanel();
		grid2.setBackground(SystemColor.text);
	
		tList = new JLabel("    Select a Tournament from the list to make it active");
		tList.setBackground(SystemColor.textHighlight);
		tList.setFont(new Font("Tahoma", Font.BOLD, 14));
	    tournamentList = new JComboBox(model);
	    tournamentList.setBackground(SystemColor.textHighlight);
		newTeam = new JButton("Create New");
		newTeam.setBackground(SystemColor.textHighlight);
		newTeam.setFont(new Font("Times New Roman", Font.BOLD, 14));
		newTeam.setBounds(233, 63, 109, 49);
		teamList = new JComboBox(model2);
		teamList.setToolTipText("Select Team");
		teamList.setBounds(357, 64, 80, 49);
		scoreMatch = new JButton("Submit Scores");
		scoreMatch.setBackground(SystemColor.textHighlight);
		scoreMatch.setFont(new Font("Tahoma", Font.BOLD, 14));
		scoreMatch.setBounds(246, 50, 133, 41);
		teamAScore = new JTextField(5);
		teamAScore.setBounds(246, 119, 46, 41);
		teamBScore = new JTextField(5);
		teamBScore.setBounds(333, 119, 46, 41);
		matchList = new JComboBox(model3);
		matchList.setToolTipText("Select Game");
		matchList.setBounds(402, 60, 75, 31);
		
		timerListener tl = new timerListener();
		new Timer(3000, tl).start();
		startListener sl = new startListener();
		submitScoreListener ssl = new submitScoreListener();
		scoreMatch.addActionListener(ssl);
		newTournamentListener ntl = new newTournamentListener();
		tournamentListListener tll = new tournamentListListener();
		tournamentList.addActionListener(tll);
		newTeamListener ntel = new newTeamListener();
		newTeam.addActionListener(ntel);
		
		//set layouts
				grid1.setLayout(new BorderLayout());
				grid2.setLayout(new GridLayout(0,1));
				
				//And components to Panels
				tPanel.setPreferredSize(new Dimension(640, 480));
				tPanel.setLayout(null);
				grid1.add(tList,BorderLayout.CENTER);
				grid1.add(grid2,BorderLayout.SOUTH);
				grid2.add(tournamentList);
				tPanel.add(grid1);
				start = new JButton("Start Tournament");
				start.setForeground(new Color(0, 51, 255));
				start.setBackground(UIManager.getColor("MenuItem.selectionBackground"));
				start.setFont(new Font("Tahoma", Font.BOLD, 14));
				start.setBounds(163, 108, 289, 40);
				tPanel.add(start);
				newTournament = new JButton("Create New");
				newTournament.setForeground(new Color(0, 51, 255));
				newTournament.setBackground(UIManager.getColor("MenuItem.selectionBackground"));
				newTournament.setFont(new Font("Tahoma", Font.BOLD, 14));
				newTournament.setBounds(163, 175, 289, 40);
				tPanel.add(newTournament);
				newTournament.addActionListener(ntl);
				start.addActionListener(sl);
				teamPanel.setLayout(null);
				teamPanel.add(newTeam);
				teamPanel.add(teamList);
				teamPanel.setPreferredSize(new Dimension(600,600));
				
				JLabel lblCreateANew = new JLabel("Select a team or create a new one:");
				lblCreateANew.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblCreateANew.setBounds(215, 11, 260, 30);
				teamPanel.add(lblCreateANew);
				schedulePanel.add(schedule);
				scorePanel.setLayout(null);
				scorePanel.add(scoreMatch);
				scorePanel.add(teamAScore);
				scorePanel.add(teamBScore);
				scorePanel.add(matchList);
				scorePanel.setPreferredSize(new Dimension(600,600));
				
				JLabel lblTeamA = new JLabel("Team A");
				lblTeamA.setFont(new Font("Tahoma", Font.ITALIC, 13));
				lblTeamA.setBounds(246, 171, 60, 26);
				scorePanel.add(lblTeamA);
				
				JLabel lblTeamB = new JLabel("Team B");
				lblTeamB.setFont(new Font("Tahoma", Font.ITALIC, 13));
				lblTeamB.setBounds(333, 171, 60, 26);
				scorePanel.add(lblTeamB);
				
				lblSelectAGame = new JLabel("Select a game to submit scores:");
				lblSelectAGame.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblSelectAGame.setBounds(222, 11, 221, 28);
				scorePanel.add(lblSelectAGame);
		tabs.removeAll();
		if(permissions == 1){
			tabs.addTab("View Schedule", schedulePanel );
			tabs.addTab("Score Matches", scorePanel);
		}
		if(permissions == 2){
			tabs.addTab("View Schedule", schedulePanel );
			tabs.addTab("Manage Teams", teamPanel);
		}
		if(permissions == 3){
			tabs.addTab("View Schedule", schedulePanel );
			tabs.addTab("Score Matches", scorePanel);
			tabs.addTab("Manage Teams", teamPanel);
			tabs.addTab("Manage Tournaments", tPanel);
		}
		add(tabs);
	}
	public TournamentPanel(){
		
		
		JButton btnGuest = new JButton("Guest");
		btnGuest.setBounds(226, 177, 89, 23);
		//Create sub panels
		
		JPanel schedulePanel = new JPanel();
		schedulePanel.setBackground(SystemColor.inactiveCaption);
		//add tabs to tabbed pane
		tabs.addTab("View Schedule", schedulePanel );
		
		
		//Create components
		
		schedule = new JTextArea(10,8);
		schedule.setEditable(false);
		
		//Create and add action listener
		timerListener tl = new timerListener();
		new Timer(3000, tl).start();
		
		
		schedulePanel.add(schedule);
		schedulePanel.setPreferredSize(new Dimension(600,600));
		add(tabs);
	}
	
	//Action Listeners
	class newTeamListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JPanel newTeamPanel = new JPanel();
			good = new JRadioButton("Is this team a designated top team?");
			confirmTeam = new JButton("Confirm");
			newTeamName = new JTextField(10);
			confirmTeamListener ctl = new confirmTeamListener();
			confirmTeam.addActionListener(ctl);
			newTeamPanel.add(good);
			newTeamPanel.add(confirmTeam);
			newTeamPanel.add(newTeamName);
			nteam = new JFrame ("Create New Team");
			nteam.setBounds(100, 100, 750, 600);
			nteam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			nteam.getContentPane().add(newTeamPanel);
			nteam.pack();
			nteam.setVisible (true);
			
		}
	}
	class newTournamentListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JPanel newTournamentPanel = new JPanel();
			JPanel grid3 = new JPanel();
			JPanel grid4 = new JPanel();
			grid3.setLayout(new GridLayout(0,1));
			grid4.setLayout(new GridLayout(1,3));
			chooseBracket = new JLabel("Select a type of bracket");
			enterName = new JLabel("Enter a name for the tournament");
			confirmTournament = new JButton("Confirm");
			newTournamentName = new JTextField(10);
			singleElim = new JRadioButton("Single Elimination");
			
			doubleElim = new JRadioButton("Double Elimination");
			divisions = new JRadioButton("Divisions");
			ButtonGroup bracketType = new ButtonGroup();
			bracketType.add(singleElim);
			bracketType.add(doubleElim);
			bracketType.add(divisions);
			confirmTournamentListener ctl = new confirmTournamentListener();
			confirmTournament.addActionListener(ctl);
			grid3.add(chooseBracket);
			grid3.add(grid4);
			grid3.add(enterName);
			grid4.add(singleElim);
			grid4.add(doubleElim);
			grid4.add(divisions);
			grid3.add(newTournamentName);
			grid3.add(confirmTournament);
			newTournamentPanel.add(grid3);
			ntour = new JFrame ("Create New Tournament");
			ntour.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ntour.getContentPane().add(newTournamentPanel);
			ntour.pack();
			 ntour.setBounds(100, 100, 750, 600);
			ntour.setVisible (true);
		}

	}
	class confirmTeamListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			team temp = new team(newTeamName.getText(),good.isSelected());
			activeTournament.addTeam(temp);
			model2.addElement(temp);
			//coachName.getText();
			nteam.dispatchEvent(new WindowEvent(nteam, WindowEvent.WINDOW_CLOSING));
		}
	}
	class confirmTournamentListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Tournament temp = new Tournament(newTournamentName.getText());
			if(singleElim.isSelected()){
				temp.setbracketCode(0);
			}
			if(doubleElim.isSelected()){
				temp.setbracketCode(1);
			}
			if(divisions.isSelected()){
				temp.setbracketCode(2);
			}
			tournaments.add(temp);
			model.addElement(temp);
			ntour.dispatchEvent(new WindowEvent(ntour, WindowEvent.WINDOW_CLOSING));
		}
	}
	class submitScoreListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if((Integer.parseInt(teamAScore.getText())>24 && Integer.parseInt(teamAScore.getText()) - Integer.parseInt(teamBScore.getText()) > 1) || (Integer.parseInt(teamBScore.getText())>24 && Integer.parseInt(teamBScore.getText()) - Integer.parseInt(teamAScore.getText()) > 1)){
			new inputScore((game)matchList.getSelectedItem(),Integer.parseInt(teamAScore.getText()),Integer.parseInt(teamBScore.getText()));
			model3.removeAllElements();
			boolean allComplete = true;
			for(int i = 0; i < activeTournament.getBracket().getGames().size();i++){
				if(activeTournament.getBracket().getGames().get(i).getComplete() == false){
					allComplete = false;
				}
			}
			if(allComplete){
				activeTournament.getBracket().advanceSchedule();
				//activeTournament.getBracket().advanceSchedule();
			}
			
			Object[] templist = activeTournament.getBracket().getGames().toArray();
			for(int i = 0; i < templist.length; i++){
				if(((game)templist[i]).getComplete() == false){
				model3.addElement((game)templist[i]);
				}
			}
			}
			else{
				JPanel invalid = new JPanel();
				inv = new JLabel("Scores are Not Valid and were not accepted");
				invalid.add(inv);
				nteam = new JFrame ("Invalid");
				nteam.setBounds(100, 100, 750, 600);
				nteam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				nteam.getContentPane().add(invalid);
				nteam.pack();
				nteam.setVisible (true);
			}
		}
	}
	class tournamentListListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			activeTournament = (Tournament)tournamentList.getSelectedItem();
			model2.removeAllElements();
			Object[] templist = activeTournament.getList().toArray();
			for(int i = 0; i < templist.length; i++){
				model2.addElement((team)templist[i]);
			}
		}
	}
	class startListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			activeTournament.createBracket(activeTournament.getList());
			model3.removeAllElements();
			if(activeTournament.getBracket().getGames().toArray().length == 0){
				activeTournament.getBracket().advanceSchedule();
			}
			Object[] templist = activeTournament.getBracket().getGames().toArray();
			for(int i = 0; i < templist.length; i++){
				if(((game)templist[i]).getComplete() == false){
				model3.addElement((game)templist[i]);
				}
			}
		}
	}
	startListener sl = new startListener();
	Timer t = new Timer(1000, sl);
	class timerListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(activeTournament.getBracket().getPrintThis().size() > 0){
				schedule.setText("");
				for(int i = 0; i < activeTournament.getBracket().getPrintThis().size();i++){
					schedule.append((String)(activeTournament.getBracket().getPrintThis().toArray())[i] + "\n");
				}
					
			}
			
		}
	}
}


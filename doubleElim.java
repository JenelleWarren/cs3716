
import java.util.ArrayList;

class doubleElim implements Bracket{
	
	private ArrayList<team> t;  //list that holds the teams
	private ArrayList<team> lo; //list that holds losing teams
	private ArrayList<game> games;  //list that holds the games
	private ArrayList<game> losers; //list that holds the loser bracket
	private int gameNum;   //number to keep track of which game 
	private int losingGameNum;//number to keep track of which game in losing bracket
	private ArrayList<String> printThis = new ArrayList<String>();
	private int round = 1;
	private int check = 0;
	
	public doubleElim(ArrayList<team> t){  //double elimination constructor
		lo=new ArrayList<team>();  
		this.t= t;   
		
		
		for(int i = 0; i<t.size();i++){   //foor loop to switch team if its good (work in progress)
			if(t.get(i).getGood()==true && t.get(i+1).getGood()==true && i+1<t.size()){
				
				if(i<(t.size()/2) && t.get(t.size()-1).getGood()==false && t.get(t.size()-2).getGood()==false && 
						t.get(i).getSwitched()==false){
					team temp;
					System.out.println("Made it here");
					temp = t.get(i);
					t.set(i, t.get(t.size()-1));
					t.set((t.size()-1),temp);
					t.get(t.size()-1).setSwitched(true);
					i=t.size();
				}
					
				
			}
		}
		games = new ArrayList<game>();  //creates the new games bracket
		losers = new ArrayList<game>();  //create the losing games bracket
		gameNum = 1;
		losingGameNum = 1;
		createBracket();   //creates starting bracket
		System.out.println("Round 1");
		
		
	}
	
	public void createLoserBracket(){
		
		int l = lo.size();  //gets size of losing array
		int i =0;
		
		
		
		
		if(l<4 && l%3==0){  //if there are 3 teams left in the losing bracket
			while(i<l){    
				game a= new game(lo.get(i),lo.get(i+1),losingGameNum);  //create a game between 2 teams
				losingGameNum++;  //increase the game number
				losers.add(a);  //add the game to the losers list
				i=i+l;
				printLoserBracket();
				
				
		}
		}
		else if(l==1){  //if there is one team left in the losing bracker
			t.add(lo.get(0));  //add the team to the winning bracket
			deleteLosingTeam(lo.get(0));  //clear the losing bracket
			createBracket();   //create the winning bracket
		}
		
		else {
		System.out.println("Losing teams" + " team size:" + l );
			while(i<l){    //works for even number of teams
				game a= new game(lo.get(i),lo.get(i+1),losingGameNum);
				losingGameNum++;
				losers.add(a);
				i=i+2;
			}
		}
		
		
	}
	
	
	
	public void createBracket(){  //creates the starting double elimination bracket
		int l = t.size();
		int i =0;
		
		if(l==1 && lo.size()==0){
			
			System.out.println("Team " + t.get(0) + " is the winner! Congratulations");
			printThis.add("\n\nTeam " + t.get(0) + " is the winner! Congratulations");
			return;
		}
		
		else{
		System.out.println("Winning teams" + " team size:" + l );
			while(i<l){    //works for even number of teams
				game a= new game(t.get(i),t.get(i+1),gameNum);  //creates the game for the winning bracket
				gameNum++;  //increases the game counter by one
				games.add(a);  //add the game to the games list
				i=i+2;  //moves to the next test of teams in the list
			}
		}
		if (check == 0){
			printThis.add("Round 1");
			for(game temp:games){
				if (temp.getComplete() == false){
				printThis.add((temp.toString()));
				}
			}
			check = 1;
		}
		
		
	}
	
	

	
	
	
public void advanceSchedule(){  //advances the schedule by eliminating losing teams and adding new mathups to games
	
	if(t.size()==2 && lo.size() ==0){  //if its the final game of the tournament 
			if(t.get(0).getLoser()){  //if team 1 is the loser
				System.out.println("The winner is team " + t.get(1) +"! Congratulations");
				printThis.add("\n\nTeam " + t.get(0) + " is the winner! Congratulations");
				
			}
			
			else{
				if(t.get(1).getLoser()){  //if team 1 is the winner
					System.out.println("The winner is team " + t.get(0) +"! Congratulations");
					printThis.add("\n\nTeam " + t.get(0) + " is the winner! Congratulations");
				}
					}
			
		}
		
		else if(t.size()==1 && lo.size()==1){   //if theres one team left in each bracket
			
			t.add(lo.get(0));  //put the last team from losing bracket into winning bracket
			
			deleteLosingTeam(lo.get(0));  //clear the losing bracket
			for(int i = 0; i<t.size();i++ ){  //reset the losses for the final teams
				t.get(i).setLoser(false);
				t.get(i).setLosses(0);
			}
			
			createBracket();  //creates the winning bracket
			
		}
		
		else if(t.size()==1 && lo.size()>1){  //if theres 1 team left in the winning bracket and more then on in the losing
			
			advanceLoserSchedule();
			createLoserBracket();
			
			
			
		}
		
		
		
		
		
		else{
		for(game temp:games ){   //goes through the game list
			
			
			
			
			if(temp.getT1().getLoser()==true){   //if team1 is the loser remove them
					if(temp.getT1().getLBracket()==false){
						if(temp.getT1().getLosses() <2){
							
							lo.add(temp.getT1());
							temp.getT1().setLBracket(true);
							}
					}	
				
					deleteTeam(temp.getT1());
				}
				else{
					//if team2 is the loser remove them
					if(temp.getT2().getLBracket()==false){
						if(temp.getT2().getLosses() <2){
							
							lo.add(temp.getT2());
							temp.getT2().setLBracket(true);
							
						}
					}	
					
					deleteTeam(temp.getT2());
					
				}
			}
		if(lo.size()!=0){advanceLoserSchedule();}  //if the size of the losing bracket is not 0 advance the losing schedule
		
		if(t.size()>1){  //if theres more then one team in the winning bracket
			createBracket();
		}
		if(lo.size()>1){  //if theres more then 1 team in the losing bracket
			createLoserBracket();  //create losing bracket
		}
		}	
	int i = 0;
	for(game temp:games){
		if (temp.getComplete() == false){
		printThis.add((temp.toString()));
		i++;
		}
	}
	round++;
	if(i != 0){
	printThis.add("\nRound " + round);
	}
	for(game temp:games){
		if (temp.getComplete() == false){
		printThis.add((temp.toString()));
		}
	}
		}

public void advanceLoserSchedule(){   //advances the schedule in the losing bracket
	for(game temp:losers ){   //goes through the game list
		
		
		
		
		if(temp.getT1().getLosses()==2){   //if team1 is the loser remove them
			
				deleteLosingTeam(temp.getT1());
			}
			else{
				//if team2 is the loser remove them
				
				deleteLosingTeam(temp.getT2());
				
			}
		}
	
	if(t.size()==1 && lo.size()==1){   //if theres one team left in each bracket
		
		t.add(lo.get(0));  //put the last team from losing bracket into winning bracket
		
		deleteLosingTeam(lo.get(0));  //clear the losing bracket
		for(int i = 0; i<t.size();i++ ){  //reset the losses for the final teams
			t.get(i).setLoser(false);
			t.get(i).setLosses(0);
		}
		
		createBracket();  //creates the winning bracket
		
	}
}	



	public void deleteLosingTeam(team e){   //method to delete a team
		lo.remove(e);
	}
	
	public void deleteTeam(team e){   //method to delete a team
		t.remove(e);
	}

	public ArrayList<team> getTeam(){  //method to return the team list
		return t;
	}
	
	public ArrayList<team> getLosingTeam(){  //method to return the team list
		return lo;
	}
	
	public void setLosingTeam(ArrayList<team> te){  //method to set the ArrayList
		lo=te;
	}

	public void setTeam(ArrayList<team> te){  //method to set the ArrayList
		t=te;
	}
	
	public game getGameWinning(int i){
		return games.get(i);
	}
	
	public game getGameLosing(int i){
		return losers.get(i);
	}
	
	public ArrayList<game> getWinningBracket(){
		return games;
	}
	
	public ArrayList<game> getLosingBracket(){
		return losers;
	}
	public ArrayList<game> getGames(){
		ArrayList<game> temp = new ArrayList<game>();
		for(int i = 0; i < games.size(); i++){
			temp.add(games.get(i));
		}
		for(int i = 0; i < losers.size(); i++){
			temp.add(losers.get(i));
		}
		return temp;
	}
	
	

	public void printBracket(){  //method to print the bracket
		System.out.println("Winning teams Bracket");
		for(game temp:games){
			System.out.println(temp.toString() + " Game: " + temp.getGameN());
			
		}
		System.out.println("");
		
		
	}
	
	public void printLoserBracket(){  //method to print the bracket
		System.out.println("Losing team Bracket");
		for(game temp:losers){
			System.out.println(temp.toString() + " Game: " + temp.getGameN());
			
		}
		System.out.println("End of round");
		System.out.println("");
	}
	public ArrayList<String> getPrintThis(){
		return printThis;
	}
	
}



/////////////////////////////////////////////////////////////////////////////////

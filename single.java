import java.util.ArrayList;
import java.util.*;
import java.util.Iterator;

class single implements Bracket{
	private int startSize;
	private int numGames;
	private ArrayList<team> t;  //list that holds the teams
	private ArrayList<game> games;  //list that holds the games
	private int[] rounds;  //stores where the rounds are stored in the array
	private ArrayList<String> printThis = new ArrayList<String>();
	private int round = 1;
	private int check = 0;
	
	public single(ArrayList<team> t){  //single elimination constructor
		
		this.t= t;  
		startSize = t.size();
		games = new ArrayList<game>();
		
		numGames = t.size() -1;
		
		
		
		
		for(int i =0; i<t.size();i++){
			if((i+1)>(t.size()-1)){
				System.out.println("Avoided out of bounds");
			}
			else{
				if(t.get(i).getGood()&&t.get(i+1).getGood()){
					team a = t.get(i);
					team b = t.get(i+1);
					Collections.shuffle(t);
					
					System.out.println("shuffled");
					
					i=t.size();
				}
			}
		}
		
		createBracket();	
		
		
		
	}
	
	
	
	public void createBracket(){  //creates the starting single elimination bracket
		int l = t.size();
		int i =0;
		
		if(l==1){
			System.out.println("Team " + t.get(0) + " is the winner! Congratulations");
			printThis.add("\n\nTeam " + t.get(0) + " is the winner! Congratulations");
			return;
		}
		
		else if(l%2==0){
		System.out.println("Even teams" + " team size:" + l );
			while(i<l){    //works for even number of teams
				game a= new game(t.get(i),t.get(i+1));
				games.add(a);
				i=i+2;
			}
		}
		
		else{
			System.out.println("Odd teams" + " team size:" + l );
			if(l<startSize){
			Collections.shuffle(t);
			}
			while(i<l){    //works for odd number of teams
				game a= new game(t.get(i),t.get(i+1));
				games.add(a);
				i=i+2;
				if((i+1)>=l){
					game b= new game(t.get(i));
					games.add(b);
					return;
				}
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
		
		
		
		for(game temp:games ){   //goes through the game list
			
			/*if(!temp.getComplete()){ //checks if game is complete
					System.out.println("Please complete all games in the round before advancing schedule");
					
				}*/
			
			if(temp.getT1().getLoser()==true){   //if team1 is the loser remove them
					
					deleteTeam(temp.getT1());
				}
				else{
					//if team2 is the loser remove them
					deleteTeam(temp.getT2());
					
				}
			}
		
		
		createBracket();
		
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
	
	
	public int getStartSize(){
		return startSize;
	}
	
	
	public void deleteTeam(team e){   //method to delete a team
		t.remove(e);
	}
	
	public ArrayList<team> getTeam(){  //method to return the team list
		return t;
	}
	
	public void setTeam(ArrayList<team> te){  //method to set a the team list to a different list
		t=te;
	}
	
	public ArrayList<game> getGames(){
		return games;
	}
	
	public game getGame(int i){
		return games.get(i);
	}
	
	public void printBracket(){  //method to print the bracket
		for(game temp:games){
			System.out.println(temp.toString());
		}
		System.out.println("End of round");
	}
	
	public ArrayList<String> getPrintThis(){
		return printThis;
	}
	

	
	
}








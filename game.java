class game{
	private int score1;  //score of team 1
	private int score2;  //score of team 2
	private team team1;  //holds team 1
	private team team2;  //holds team 2
	private boolean complete;  //holds if the game is complete
	private int gameNum;  //holds the game number
	
	public game(team t1, team t2){  //constructor for game that doesnt keep track of game number
		score1 = 0;
		score2 = 0;
		team1 = t1;
		team2 = t2;
		complete = false;
	}
	
	public game(team t1, team t2, int gameNum){  //constructor for game that keeps track of game number
		score1 = 0;
		score2 = 0;
		team1 = t1;
		team2 = t2;
		complete = false;
		this.gameNum = gameNum;
	}
	
	public game(team t1){  //constructor for a single team
		team1 = t1;
		team2 = null;
		complete =true;
		t1.setLoser(false);
	}
	
	public team getT1(){  //returns team 1
		return team1;
	}
	
	public team getT2(){  //returns team 2
		return team2;
	}
	
	public void setComp(boolean c){  //sets if the game is complete and checks which teams score it higher
		complete = c;                //and sets the team with the lesser score to the loser
		if (complete){
			if(getS1() > getS2()){
				getT2().setLoser(true);
			}
			else{
				getT1().setLoser(true);
			}
		}
	}
	
	public boolean getComplete(){  //returns the game complete status
		return complete;
	}
	
	public void setS1(int s){  //sets the score of team 1
		score1 = s;
	}
	
	public void setS2(int s){  //sets the score of team 2
		score2 = s;
	}
	
	public int getS1(){  //gets the score of team1 
		return score1;
	}
	
	public int getS2(){  //gets the score of team2
		return score2;
	}
	
	public int getGameN(){  //returns the game number
		return gameNum;
	}
	
	public String toString(){  //print function to print the teams playing in the game
		if(team2==null)
		{return team1 + " has a bi";}
		
		else{return team1 + " vs " + team2;}
		
	}
		
	
	
}

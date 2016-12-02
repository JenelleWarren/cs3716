

class inputScore{
	
	private game a;
	
	public inputScore(game a,int score1,int score2){  //takes a game, and 2 scores and sets both the teams scores.
		this.a = a;
		a.setS1(score1);
		a.setS2(score2);
		a.setComp(true);     //sets the match to complete and sets the losing team as loser based on score
		
	}
	
	public void fixScore(int s2, int s1){    //takes 2 scores and replaces the currently stored scores. Fixes outcome if necessary
		a.setS1(s1);
		a.setS2(s2);
		a.setComp(true);
	}
	
	public int getScore1(){  //returns the score of team 1
		return a.getS1();
	}
	
	public int getScore2(){  //returns the score of team 2
		return a.getS2();
	}
	
	public String printScore(){   //prints the scores of both teams
		return a.getT1().getName() + "'s score is:" + getScore1() + " and " + a.getT2().getName() +"'s score is:"
			+ getScore2();	
	}
	
	
}
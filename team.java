class team{
	private String name;  //holds the team name
	private boolean good;  //holds if the team is good
	private boolean loser;  //holds if the team is a loser
	private int losses;   //keeps track of team losses
	private boolean losersBracket;   //holds if the team is in the losers bracket
	private boolean switched;
	
	public team(String name, boolean good){  //constructor for team
		this.name=name;
		this.good = good;
		loser = false;
		int losses = 0;
		losersBracket = false;
		switched = false;
	}
	
	public boolean getSwitched(){  //method to check if a good team was already swapped to not play another good team
		return switched;
	}
	
	public void setSwitched(boolean s){  //method to set if the team was swapped or not
		switched = s;
	}
	
	public String getName(){  //method to get name
		return name;
	}
	
	public boolean getGood(){  //method to get if a team is good
		return good;
	}
	
	public void setGood(boolean g){
		good = g;
	}
	
	public void setLoser(boolean l){  //method to set loser. setting loser also adds a loss the to theam
		loser = l;
		addLoss();
	}
	
	public boolean getLoser(){  //mthod to get if the team is a loser
		return loser;
	}
	
	public String toString(){  //method to return name
		return name;
	}
	
	public void addLoss(){  //method to add a loss
		losses = losses + 1;
	}
	
	public int getLosses(){  //method to turn the number of team losses
		return losses;
	}
	
	public void setLosses(int l){  //method to set the number of losses
		losses = 0;
	}
	
	public boolean getLBracket(){  //method to return if the team is in the losers bracket
		return losersBracket;
	}
	
	public void setLBracket(boolean b){  //method to set if the team is in the losers bracket
		losersBracket = b;
	}
	
}
import java.util.*;

public class Tournament {
	String name;
	ArrayList<team> teams = new ArrayList<team>();
	Bracket bracket = new single(teams);
	int bracketCode = 0;
	public Tournament(String n){
		name = n;
	}
	
	public ArrayList<team> getList(){
		return teams;
	}
	public void setbracketCode(int i){
		bracketCode = i;
	}
	
	public String toString(){
		return name;
	}
	
	public void addTeam(team t){
		teams.add(t);
	}
	
	public void start(){
		
	}
	public void createBracket(ArrayList<team> t){
		if(bracketCode == 0){
			bracket = new single(teams);
		}
		if(bracketCode == 1){
			bracket = new doubleElim(teams);
		}
		if(bracketCode == 2){
			bracket = new division(teams);
		}
	}
	public Bracket getBracket(){
		return bracket;
	}

//Tournament a = new Tournament();
//single d = new single(a.getList());
}

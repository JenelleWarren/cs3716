import java.util.ArrayList;
import java.util.Collection;


public class division implements Bracket{
	private int numDiv; //How many divisions. 
	private int divSize;//Ideally how many teams in each division
	private int numGames;
	private int gameNum;
	
	private ArrayList<team> t;  //list that holds the teams
	private ArrayList<team> temp;
	private ArrayList<game> games; 
	
	private ArrayList<ArrayList<team>> divsouter;
	private ArrayList<team> divsinner;
	private ArrayList<ArrayList<team>> divs;
	
	private ArrayList<team> top;
	
	
	public ArrayList<String> getPrintThis(){
		ArrayList<String> printThis = new ArrayList<String>() ;
		return printThis;
	}
	
	public division(ArrayList<team> t){  //division constructor. d is # of divisions
		int d = 2;
		divsouter = new ArrayList<ArrayList<team>>();
		divsinner = new ArrayList<team>();            //ArrayLists within ArrayLists
		top = new ArrayList<team>();
		games = new ArrayList<game>();  //creates the new games bracket
		this.numDiv = d;
		this.t = t;   
		
		divSize = t.size() / numDiv; //How many teams in a division
		
		if(divSize < 2 || divSize == 1){
		System.out.println("Invalid number of divisions");//Invalid division format
		}
		createDivs(t);
		
		//advanceSchedule();
		for(int i = 0;i<games.size();i++){
		System.out.println(games.get(i)); }
		//getGames();
	}
		
		public void createDivs(ArrayList<team> t){ //places teams into divisions    
			
			divs = new ArrayList<ArrayList<team>>();
			int asize = t.size();
			int dsize = divSize;   //various helper ints
			int num = numDiv;
			int i = 0;
			int j = 0;
			int count = 0;
			int rem = asize % dsize;
			int divNumber = 1;
			
			for (i=0;i <num ;i++){  //for i less than number of divisions
				
				for(j=0;j<dsize;j++){ //places the min amount of teams in the division
				divsinner.add((team) t.get(count));
				count++;
				divsouter.add((ArrayList<team>) divsinner);
				}
				
				if(rem !=0){
					divsinner.add((team) t.get(count)); //if remainder inserts team into the division before moving on
					rem = rem - 1;
					count++;
				}
				
				j=0;
				divs.add((ArrayList<team>) divsinner); //adds the inner arraylist to the outer arraylist
				
				//System.out.println("Division " + divNumber + "  "+ divs.get(i)); //helper for tracing
				//divListMatches(divs.get(i));
				
				
				//top.add((team) getDivWinner(( ArrayList<team>) divsinner));
				//single a = new single(top); creates the winning team
				System.out.println(divs.get(i));
				System.out.println("Print div winner below");
				//System.out.println(getDivWinner(( ArrayList<team>) divsinner) +" \n");
				
				getListMatches(divsinner);
				
				
				divsinner.clear();
				
				divNumber++;
				}
			/*single a = new single(top);
			a.createBracket(); //create bracket should add the games to the games list
			a.advanceSchedule();
			a.printBracket();*/
		}
			
			
		
		
		public void getListMatches(ArrayList d){ 
			
			
			
			for(int i = 0; i<d.size()-1; i++){
				
				for (int j= i+1; j<d.size(); j++){
	            
					game a = new game((team) d.get(i),(team) d.get(j));
					a.setComp(false);
					System.out.println("test: team " + d.get(i)+ " plays team " + d.get(j)); //helper info for tracing
					games.add(a);
					
					}
				
				}
			
			}
		public Object getDivWinner(ArrayList d){ //gets division winner
			
			int i=0;
			int j=0;        //various counters
			int count =-1;
			temp = new ArrayList<team>();
			
			for(i=0;i<d.size();i++){
				
				if(((team) d.get(i)).getLosses() <= ((team) d.get(j)).getLosses()){ //if a has less losses than b
					
					count++;
					temp.add((team) d.get(count)); //add that team to a temp list
					}
				
			}
				
			
			//System.out.println("Division winner is " + temp.get(count));
			
			return temp.get(count);
		}
		
		
		
		public Object getWinner(){ //gets winner from arraylist of division winners by placing in single elim tourny
		
		
		single a = new single(top);
		a.createBracket(); //create bracket should add the games to the games list
		a.advanceSchedule();
		a.printBracket();
		
		System.out.println(" ");
		
		
		return 0;
	}
	
	public void advanceSchedule(){
		
		getWinner();
		System.out.println("If it works, print this");
		
	}
	public ArrayList<game> getGames(){
		return games;
	}
}
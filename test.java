import java.util.ArrayList;

class test{
	
	
	public static void main(String[] args){
		team a = new team("a",false);
		team b = new team("b",false);
		team c = new team("c",false);
		team d = new team("d",false);
		team e = new team("e",false);
		team f = new team("f",false);
		team g = new team("g",false);
		team h = new team("h",false);
		a.setLoser(true);
		c.setLoser(true);
		f.setLoser(true);
		g.setLoser(true);
		a.setGood(true);
		b.setGood(true);
		ArrayList<team> ar = new ArrayList<team>();
		ar.add(a);
		ar.add(b);
		ar.add(c);
		ar.add(d);
		ar.add(e);
		ar.add(f);
		ar.add(g);
		ar.add(h);
		
		single test = new single(ar);
		//doubleElim test = new doubleElim(ar);
		//Start of tournament
		test.printBracket();
		/*test.advanceSchedule();
		//brackets split
		test.printBracket();
		test.printLoserBracket();
		
		//2nd round
		ArrayList<team> arte = test.getTeam();
		ArrayList<team> artex = test.getLosingTeam();		
		arte.get(0).setLoser(true);
		arte.get(2).setLoser(true);
		artex.get(0).setLoser(true);
		artex.get(3).setLoser(true);
		test.setTeam(arte);
		test.setLosingTeam(artex);
		test.advanceSchedule();
		test.printBracket();
		test.printLoserBracket();
		
		//third round
		ArrayList<team> art = test.getTeam();
		ArrayList<team> artt = test.getLosingTeam();
		
		art.get(0).setLoser(true);
		artt.get(2).setLoser(true);
		artt.get(0).setLoser(true);
		test.setTeam(art);
		test.setLosingTeam(artt);
		test.advanceSchedule();
		test.printBracket();
		test.printLoserBracket();
		
		//fourth round
		ArrayList<team> art1 = test.getTeam();
		ArrayList<team> artt2 = test.getLosingTeam();		
		artt2.get(1).setLoser(true);
		test.setLosingTeam(artt2);
		test.advanceSchedule();
		test.printBracket();
		test.printLoserBracket();
		
		//fifth round
		ArrayList<team> artt3 = test.getLosingTeam();
		artt3.get(0).setLoser(true);
		test.setLosingTeam(artt3);
		test.advanceSchedule();
		test.printBracket();
		
		//sixth round
		ArrayList<team> art12 = test.getTeam();
		art12.get(0).setLoser(true);
		test.setTeam(art12);
		test.advanceSchedule();
		test.printBracket();
		test.printLoserBracket();
		
		//7th round
		ArrayList<team> art123 = test.getTeam();
		art123.get(0).setLoser(true);
		test.setTeam(art123);
		test.advanceSchedule();*/
		
		
		
		
		
		/*
		ArrayList<team> artex = test.getLosingTeam();
		artex.get(0).setLoser(true);
		artex.get(3).setLoser(true);
		arte.get(0).setLoser(true);
		arte.get(2).setLoser(true);
		System.out.println(artex.get(0).getLosses());	
		System.out.println(artex.get(3).getLosses());
		test.setTeam(arte);
		test.setLosingTeam(artex);
		test.advanceSchedule();
		artex = test.getLosingTeam();
		arte = test.getTeam();
		for(int i = 0; i<artex.size();i++){
			System.out.println(artex.get(i).getName());
		}
		System.out.println("");
		for(int j = 0; j<arte.size();j++){
			System.out.println(arte.get(j).getName());
		}
		//test.printBracket();
		//test.printLoserBracket();
		//test.advanceSchedule();*/
		
	}
}
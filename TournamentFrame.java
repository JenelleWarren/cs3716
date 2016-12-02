
import javax.swing.*;

public class TournamentFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Tournament runner");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500, 200);
	    TournamentPanel panel = new TournamentPanel();
	    frame.add(panel);
	    frame.setVisible(true);

	}

}
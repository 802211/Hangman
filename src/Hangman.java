import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hangman {

	public static void main(String[] args) {
		Hangman h = new Hangman();
		h.setup();
		h.letterSetup();
	}

	int livess = 9;
	int wordssolved = 0;
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JLabel letter = new JLabel();
	JTextField dash = new JTextField();
	JLabel lives = new JLabel();
	JLabel solved = new JLabel();

	void setup() {
		f.setVisible(true);
		f.add(p);
		f.setSize(800, 500);
		p.add(letter);
		p.add(dash);
		p.add(lives);
		p.add(solved);
		p.setVisible(true);
	}

	void letterSetup() {
		letter.setVisible(true);
		dash.setVisible(true);
		lives.setVisible(true);
		solved.setVisible(true);
		letter.setVerticalTextPosition(JLabel.TOP);
		// dash.setVerticalTextPosition(JLabel.CENTER);
		// lives.setVerticalTextPosition(JLabel.);
		letter.setText("Guess a letter");
		dash.setText("_");
		lives.setText("You have " + livess + " lives left");
		solved.setText("You have solved " + wordssolved + " words");
	}

}

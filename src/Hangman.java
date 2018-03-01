import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hangman implements KeyListener {

	public static void main(String[] args) {
		Hangman h = new Hangman();
		h.setup();
		h.start();
		h.letterSetup();
	
	}

	ArrayList<Integer> alist = new ArrayList<Integer>();
	Stack<String> s = new Stack<String>();
	int livess = 9;
	int wordssolved = 0;
	JFrame f = new JFrame();
	//JPanel p = new JPanel(new GridLayout(4, 1));
	JPanel p = new JPanel();
	JLabel letter = new JLabel();
	JLabel dash = new JLabel();
	JLabel lives = new JLabel();
	JLabel solved = new JLabel();
	String random = new String();

	int n = 0;
BufferedReader read;
	void start() {
		String number = JOptionPane.showInputDialog("How many words would you like to solve?");
		n = Integer.parseInt(number);
		try {
			
			for (int j = 0; j < n; j++) {
				int r = new Random().nextInt(3000);
				alist.add(r);
			}
			read = new BufferedReader(new FileReader("src/dictionary.txt"));
			String line = read.readLine();
			int counter = 0;
			while(line != null) {
				if(alist.contains(counter)) {
					s.push(line);
				}
				
				counter++;
				line = read.readLine();
				System.out.println(s);
				
			}
			
			}
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	
	
	void blanks() {
	
	}

	void setup() {
		f.addKeyListener(this);
		f.setVisible(true);
		f.add(p);
		f.setSize(400, 120);
		p.add(letter);
		p.add(dash);
		p.add(lives);
		p.add(solved);
		p.setVisible(true);
	}
String str;
String numDash = "";
	void letterSetup() {
		numDash = "";
		letter.setVisible(true);
		dash.setVisible(true);
		lives.setVisible(true);
		solved.setVisible(true);

		letter.setText(" \n                                          Guess a letter" + "                           "
				+ "                         ");
		str = s.pop();
		String singleDash = "-";
		
		for(int h = 0; h < str.length(); h++) {
		numDash = numDash + singleDash;
		}
		dash.setText(numDash);
		lives.setText("                         "
				+ "      " + "\n You have " + livess + " lives left" + "                        ");
		solved.setText("\n You have solved " + wordssolved + " words");


		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
String displayword = "";
		// TODO Auto-generated method stub
boolean guess;
if(str.contains("" + e.getKeyChar())) {
	guess = true;
}
else {
	guess = false;
	livess = livess -1;
	lives.setText("                         "
			+ "      " + "\n You have " + livess + " lives left" + "                        ");
}
if(guess = true) {
for (int j = 0; j < str.length(); j++) {
if(str.charAt(j) == e.getKeyChar()){
	//System.out.println(e.getKeyChar());
		displayword += str.charAt(j);
		
	}
else {
	displayword += numDash.charAt(j);
}



}
	numDash = displayword;
	dash.setText(numDash);
}


if(numDash.contains("-") && livess == 0) {
	JOptionPane.showMessageDialog(null, "Game over. \n You lost.");
}

else if(numDash.contains("-") && livess >=1){
	
}
else if(numDash.contains("-") && livess <=1) {
	livess =0;
	lives.setText("                         "
			+ "      " + "\n You have " + livess + " lives left" + "                        ");
	JOptionPane.showMessageDialog(null, "You already lost. Game is over.");
}
else if(wordssolved+1 == n) {
	JOptionPane.showMessageDialog(null, "You won! You solved " + wordssolved + " words");
}
else {
	JOptionPane.showMessageDialog(null, "You solved a word.");

wordssolved = wordssolved + 1;
solved.setText("\n You have solved " + wordssolved + " words");
letterSetup();
}
}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

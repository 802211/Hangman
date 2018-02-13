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
		h.letterSetup();
		h.start();
	}

	ArrayList<Integer> alist = new ArrayList<Integer>();
	Stack<String> s = new Stack<String>();
	int livess = 9;
	int wordssolved = 0;
	JFrame f = new JFrame();
	JPanel p = new JPanel(new GridLayout(4, 1));
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
				int r = new Random().nextInt();
				alist.add(r);
			}
			read = new BufferedReader(new FileReader("src/dictionary.txt"));
			
			for(int i = 0; i < n; i++) {
			System.out.println(read.read());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	void setup() {
		f.addKeyListener(this);
		f.setVisible(true);
		f.add(p);
		f.setSize(200, 500);
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

		letter.setText(" \n Guess a letter");
		dash.setText("\n -");
		lives.setText("\n You have " + livess + " lives left");
		solved.setText("\n You have solved " + wordssolved + " words");

	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

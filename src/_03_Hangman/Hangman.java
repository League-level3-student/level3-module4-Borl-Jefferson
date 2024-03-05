package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	JFrame jeff = new JFrame();
JPanel jepp = new JPanel();
JLabel jell = new JLabel("Press space to start");
	Utilities util = new Utilities();
	String length = JOptionPane.showInputDialog("How many words do you want to guess?");
	int inle = Integer.parseInt(length);
Stack<String> stin = new Stack<String>();
int lifes = 26;
char[] chrary;
String fintxt="";
int count=0;
String word;
int lecount=0;
boolean tolive=false;

public void run() {
	
for (int i = 0; i < inle; i++) {
	stin.add(util.readRandomLineFromFile("dictionary.txt"));
}
jeff.addKeyListener(this);
jepp.add(jell);
jeff.add(jepp);
jeff.pack();
jeff.setVisible(true);

restart();


}

@Override
public void keyTyped(KeyEvent e) {
	tolive=false;
	for (int i = 0; i < chrary.length; i++) {
	
		if(e.getKeyChar()==(chrary[i])) {
			tolive=true;
			StringBuilder fintxtbld = new StringBuilder(fintxt);
			fintxtbld.setCharAt(i, chrary[i]);
			fintxt=fintxtbld.toString();
			jell.setText(fintxt);
			System.out.println("good");
		}
		
	}
	if(!tolive) {
		lifes--;
		StringBuilder fintxtbld = new StringBuilder(fintxt);
		if(lifes>=9) {
		fintxtbld.replace(fintxt.length()-2, fintxt.length(), Integer.toString(lifes));
		}
		if(lifes<9) {
			fintxtbld.replace(fintxt.length()-1, fintxt.length(), Integer.toString(lifes));
			
		}
		//fintxtbld.append(lifes);
		fintxt=fintxtbld.toString();
		jell.setText(fintxt);
		if(lifes==0) {
			JOptionPane.showMessageDialog(null, "You ran out of lifes :(");
		}
	}
	if(!fintxt.contains("_")) {
		JOptionPane.showMessageDialog(null, "Congrats! You guessed the word: " + word);
		if(lecount<inle){
	restart();
		}
		else {
			JOptionPane.showMessageDialog(null, "You beated hangman!");
		}
		}
	
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
public void restart() {
	count=0;
	word = stin.pop();
	fintxt="";
	for (int i = 0; i < word.length(); i++) {
		fintxt+="_";
	}
	fintxt += " | Lives: " + lifes;
	jell.setText(fintxt);
	chrary=word.toCharArray();
}
}


package _00_IntroToStacks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
    public static void main(String[] args) {
		
	}
    String txtfld = ""  ;
    		// Create a JFrame with a JPanel and a JLabel.
    public void setup(){ 
	JFrame jeff = new JFrame();
     JPanel jepp = new JPanel();
     JLabel jell = new JLabel("test");
     jell.setVisible(true);
     Dimension d = new Dimension(300, 125);
     
     jell.setSize(d);
     jeff.addKeyListener(this);
     jepp.add(jell);
     jepp.setBackground(Color.ORANGE);
     jeff.add(jepp);
     jeff.setVisible(true);
     Dimension d2 = new Dimension(500, 500);
     jeff.setPreferredSize(d2);
     jeff.pack();
    
    }
     // Every time a key is pressed, add that character to the JLabel. It should
     // look like a basic text editor.
      public static void run() {
    	  
      }
     // Make it so that every time the BACKSPACE key is pressed, the last
     // character is erased from the JLabel.
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		txtfld += e.getKeyChar();
		System.out.println(txtfld);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
      
     // Save that deleted character onto a Stack of Characters.
      
     // Choose a key to be the Undo key. Make it so that when that key is
     // pressed, the top Character is popped  off the Stack and added back to
     // the JLabel.
     


}

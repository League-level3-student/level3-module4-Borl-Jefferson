package _00_IntroToStacks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
  
    String txtfld = ""  ;
    JLabel jell = new JLabel("test");
    Stack<Character> restore = new Stack<Character>();
    		// Create a JFrame with a JPanel and a JLabel.
    public void setup(){ 
	JFrame jeff = new JFrame();
     JPanel jepp = new JPanel();
     
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
		if(((e.getKeyCode()>=65 && e.getKeyCode()<=90)) || e.getKeyCode()==32) {
		txtfld += e.getKeyChar();
		System.out.println(txtfld);
		jell.setText(txtfld);
		}
		
		if(e.getKeyCode()==8) {
			StringBuilder txtbld = new StringBuilder(txtfld);
			restore.add(txtfld.charAt(txtfld.length()-1));
			txtbld.deleteCharAt(txtfld.length()-1);
			txtfld = txtbld.toString();
			jell.setText(txtfld);
			
		}
		
		if(e.getKeyCode()==17) {
			txtfld += restore.pop().toString();
			jell.setText(txtfld);
			System.out.println(restore.toString());
		}
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

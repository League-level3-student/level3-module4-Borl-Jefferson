package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
Stack<Double> dsta = new Stack<Double>();
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
Random r = new Random();
for (int i = 0; i < 100; i++) {
	dsta.push(r.nextDouble()*100);
}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
String nums = JOptionPane.showInputDialog("Enter two numbers 0-100 seperated by a space");
Double ind1 = Double.parseDouble(nums.subSequence(0, nums.indexOf(' ')).toString());
Double ind2 = Double.parseDouble(nums.subSequence(nums.indexOf(' ')+1, nums.length()).toString());
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
System.out.println(dsta.size());
for (int i = 0; i < dsta.size(); i++) {
Double idsta = dsta.pop();
if(idsta>ind1 && idsta<ind2) {
	System.out.println(idsta + " ind1: " + ind1 + " ind2: " + ind2);
}
}


        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}

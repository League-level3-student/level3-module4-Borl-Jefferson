package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
        Stack<Character> stck = new Stack<Character>();
        for (int i = 0; i < b.length(); i++) {
			stck.add(b.toCharArray()[i]);
		}
        int oc =0;
        int cc=0;
        for (int i = 0; i < b.length(); i++) {
        	System.out.println(stck.toString());
			if(stck.pop()==('{')) {
				oc++;
				if(oc>cc) {
					return false;
				}
			}
			else {
				cc++;
				
			}
		}
        System.out.println(oc);
        System.out.println(cc);
        if(cc!=oc) {
        return false;
        }
        else {
        	return true;
        }
    }
}
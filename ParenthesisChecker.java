/*
Parenthesis Checker:
===================
Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

Input:
The first line of input contains an integer T denoting the number of test cases.  Each test case consists of a string of expression, in a separate line.

Output:
Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ |s| ≤ 100

Example:
Input:
3
{([])}
()
([]

Output:
balanced
balanced
not balanced

*/

// Solution:

import java.util.*;
import java.lang.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class GFG 
{
   static Stack<Character> myStack = new Stack<Character>();
    
   public static void checkBalance(String s)
    {
        int l = s.length();
             
        for(int i = 0; i < l; i++)
        {
            char c;
            c = s.charAt(i);
            if((c == '(') || (c == '{') || (c == '['))
            {
                myStack.push(c);
            }
            else
            {  
                if (i==0)
                {
                    System.out.println("not balanced"); 
                    return;
                }
                if(!myStack.empty())
                {
                    if(!checkPair(myStack.peek(), c))
                    {
                        System.out.println("not balanced"); 
                        return;
                    }
                    else
                    {
                         myStack.pop();
                    }
                }
            }
        }
        
        if(!myStack.empty())
        {
           System.out.println("not balanced");
        }
        else
        {
            System.out.println("balanced");
        }
    }
    
    public static boolean checkPair(char s, char e)
    {
       return (s == '(' && e == ')') || (s =='{' && e == '}') || (s == '[' && e ==']');
    }
    
    public static void main (String[] args) throws IOException 
    {
		 BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
        
        //Get the total number of test cases
        String lines = input.readLine();    
        
        int total_test = Integer.parseInt(lines);
        
        while(total_test > 0)
        {
            String lines1 = input.readLine();
            myStack.clear();
            checkBalance(lines1);
            total_test--;
        }
   }
  
}

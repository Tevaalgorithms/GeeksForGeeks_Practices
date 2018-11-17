/*
Missing number in array
=======================
Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.

Input:
The first line of input contains an integer T denoting the number of test cases.
For each test case first line contains N, size of array. The ssubsequent line contains N-1 array elements.

Output:
Print the missing number in array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ C[i] ≤ 107

Example:
Input:
2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10

Output:
4
9

Explanation:
Testcase 1: Given array : 1 2 3 5. Missing element is 4.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Missing_Number 
{
    public static void missing_number(int[] arr)
    {
        int lenght = arr.length;
        // Total number of n continuous integer from 1 to n is : n * (n+1) /2
        // NOTE: Here we need to add + 1 to the array lenght since it's missing an elemenet
        int total = ((lenght + 1) * (lenght + 2)) / 2;
        
        for(int i = 0; i < lenght ; i++)
        {
            total -= arr[i];
        }
        
        System.out.println(total);
                
    }
    
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
        
        //Get the total number of test cases
        String lines = input.readLine();        
        int total_test = Integer.parseInt(lines);
        
        while(total_test > 0)
        {
            // Get the array size of each problem 
            int n = Integer.parseInt(input.readLine());
            
            int arr[] = new int[n];
            
            // Get the elements of array
            String lines1 = input.readLine();
            String[] srs = lines1.trim().split("\\s+");  
            
            for(int i = 0; i < srs.length; i++)
            {
                arr[i] = Integer.parseInt(srs[i]);
            }
            
            // Call maxsum function
            missing_number(arr);
            
            total_test--;
        }
    }
}

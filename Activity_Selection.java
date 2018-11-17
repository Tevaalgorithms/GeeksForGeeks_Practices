/*
Activity Selection
==================
Given N activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

Note : The start time and end time of two activities may coincide.

Input:
The first line contains T denoting the number of testcases. Then follows description of testcases. First line is N number of activities then second line contains N numbers which are starting time of activies.Third line contains N finishing time of activities.
 
Output:
For each test case, output a single number denoting maximum activites which can be performed in new line.
 

Constraints:
1<=T<=50
1<=N<=1000
1<=A[i]<=100
 

Example:
Input:
1
6
1 3 2 5 8 5
2 4 6 7 9 9

Output:
4
*/

import java.util.*;

class Activity_Selection 
{
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
   // Get the total number of testcases
		int t = sc.nextInt();
                
		int n;
		
     // Iterate the test cases
		for(int tc = 0;tc < t;tc++)
		{
        // Get total number of activities for each test cases
		    n = sc.nextInt();
		    
        // Create array for storing start time of activities
		    int[] start = new int[n];
                    
        // Create array for storing end time of activities
		    int[] end = new int[n];
		    
		    Map<Integer,ArrayList<Integer>> m = new TreeMap<Integer,ArrayList<Integer>>();
		    
        // Getting values for starting time of activites
		    for(int i = 0;i < n;i++)
		        start[i]=sc.nextInt();
		        
		    for(int i = 0;i < n;i++)
		        end[i]=sc.nextInt();
		        
		    // relative sorting
		    for(int i = 0;i < n;i++)
		    {
		        if(m.containsKey(end[i]))
		            m.get(end[i]).add(start[i]);
		        else
		        {
		            ArrayList<Integer> l=new ArrayList<Integer>();
		            l.add(start[i]);
		            m.put(end[i],l);
		        }
		    }
		   
		    int ind1 = 0,ind2 = 0;
                    
		    for(Integer itr:m.keySet())
		    {
		       for(int i=0;i<m.get(itr).size();i++)
		       {
		           start[ind1]=m.get(itr).get(i);
		           end[ind2]=itr;
		           ind1++;
		           ind2++;
		       }
		    }
                    
       /*
		    Here is the actual Greedy Algorithm part
                    =========================================
                    1) Sort the activities according to their finishing time. (Done above)
                    2) Select the first activity from the sorted array.
                    3) Do following for remaining activities in the sorted array.
                        a) If the start time of THIS activity is greater than or equal to the finish time of PREVIOUSLY selected activity 
                           then select this activity.
		    
       */
       int count = 1; // Always get the first activity
       int max = end[0]; // First activity end time
		    for(int i = 1;i < n;i++)
		    {
		        if(start[i]>=max)
		        {
		            count++; 
		            max=end[i];		            
		        }
		    }
                    
		    System.out.println(count);
		}
	}
}



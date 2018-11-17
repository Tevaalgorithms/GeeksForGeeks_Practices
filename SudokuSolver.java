/*
Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix (mat[][]) the task to print a solution of the Sudoku. For simplicity you may assume that there will be only one unique solution.

Example

3   6 5   8 4   2
5 2 
  8 7         3 1
    3   1     8  
9     8 6 3     5
  5     9   6 
1 3         2 5 
              7 4
    5     6 3 


For the above configuration the solution is
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9


Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents empty block.

Output:
For each test case in a new line print the space separated values of the solution of the the sudoku.

Constraints:
1<=T<=10
0<=mat[]<=9

Example:
Input:
1
3 0 6 5 0 8 4 0 0 5 2 0 0 0 0 0 0 0 0 8 7 0 0 0 0 3 1 0 0 3 0 1 0 0 8 0 9 0 0 8 6 3 0 0 5 0 5 0 0 9 0 6 0 0 1 3 0 0 0 0 2 5 0 0 0 0 0 0 0 0 7 4 0 0 5 2 0 6 3 0 0

Output:
3 1 6 5 7 8 4 9 2 5 2 9 1 3 4 7 6 8 4 8 7 6 2 9 5 3 1 2 6 3 4 1 5 9 8 7 9 7 4 8 6 3 1 2 5 8 5 1 7 9 2 6 4 3 1 3 8 9 4 7 2 5 6 6 9 2 3 5 1 8 7 4 7 4 5 2 8 6 3 1 9 

*/

public class SudokuSolver
{
     
static boolean solve_Sudoku(int[][] grid, int n)
{
    int row = -1, col = -1;

    boolean notEmpty = true;

    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(grid[i][j] == 0)
            {
                row = i;
                col = j;
                notEmpty = false;
                break;
            }                
        }
        if(!notEmpty)
        {
            break;
        }
    }

    // no empty space left 
    if (notEmpty) 
    { 
        return true; 
    } 
    
    // else for each-row backtrack 
    for (int num = 1; num <= n; num++) 
    { 
        if (isSafe(grid, row, col, num)) 
        { 
            grid[row][col] = num; 

                if (solve_Sudoku(grid, n)) 
                { 
                     return true; 
                } 
                else
                { 
                     grid[row][col] = 0; // replace it 
                } 
        } 
    } 
    return false; 
    }
        
static boolean isSafe(int[][] grid, int row, int col, int num)
{
        // Check rowwise
        for(int c = 0; c < grid.length; c++)
        {
            if(grid[row][c] == num)
            {
                return false;
            } 
        }
        
        //Check columnwise
        for(int r = 0; r < grid.length; r++)
        {
            if(grid[r][col] == num)
            {
                return false;
            }
        }
        
        //Check in the box
        int sqrt = (int) Math.sqrt(grid.length);
        int boxStartRow = row - row % sqrt;
        int boxStartCol = col - col % sqrt;
        for(int r = boxStartRow; r < boxStartRow + sqrt; r++)
        {
            for(int c = boxStartCol; c < boxStartCol + sqrt; c++)
            {
                if(grid[r][c] == num)
                {
                    return false;
                }
            }
        }
        
        return true;       
    }
    
public static void print(int[][] board, int N) 
{ 
	// we got the answer, just print it 
	for (int r = 0; r < N; r++) 
	{ 
            for (int d = 0; d < N; d++) 
            { 
                System.out.print(board[r][d]); 
                System.out.print(" "); 
            } 
            
            System.out.print("\n"); 

            if ((r + 1) % (int) Math.sqrt(N) == 0) 
            { 
                System.out.print(""); 
            } 
	} 
}  
   
public static void main(String[] args)
{
            
        int[][] board = new int[][] 
	{ 
			{3, 0, 6, 5, 0, 8, 4, 0, 0}, 
			{5, 2, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 8, 7, 0, 0, 0, 0, 3, 1}, 
			{0, 0, 3, 0, 1, 0, 0, 8, 0}, 
			{9, 0, 0, 8, 6, 3, 0, 0, 5}, 
			{0, 5, 0, 0, 9, 0, 6, 0, 0}, 
			{1, 3, 0, 0, 0, 0, 2, 5, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 7, 4}, 
			{0, 0, 5, 2, 0, 6, 3, 0, 0} 
	}; 
        
        int[][] grid = new int[][]
        {
                      {0,0,3,4},
                      {3,4,0,0},
                      {0,0,4,3},
                      {0,3,2,0}
        };
        
        int[][] grid1 = new int[][]
        {
                      {0,2,0,1},
                      {1,0,0,4},
                      {0,4,0,2},
                      {4,0,3,0}
        };
        
        int[][] grid2 = new int[][]
        {
                      {0,2,0,1},
                      {1,0,0,4},
                      {0,3,0,2},
                      {4,0,1,0}
        };
           

        int N = grid2.length; 

	if (solve_Sudoku(grid2, N)) 
	{ 
		print(grid2, N); // print solution 
	} 
	else
	{ 
		System.out.println("No solution"); 
	} 
        
    }
    
}

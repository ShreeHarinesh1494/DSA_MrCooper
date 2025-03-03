import java.util.*;
class Main
{
    static int n;
    static int maze[][];
    static int sol[][];
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        maze = new int[n][n];
        sol = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                maze[i][j] = sc.nextInt();
            }
        }
        
        solveMaze();
    }
    
    
    public static void solveMaze()
    {
        for(int i=0;i<n;i++)
        {
            Arrays.fill(sol[i],0);
        }
        
        if(!solveMazeUtil(0,0))
        {
            System.out.println("No Solution Exists.");
        }
        else
        {
            printsol();
        }
    }
    
    public static boolean solveMazeUtil(int x,int y)
    {
        if(x==n-1&& y==n-1 && maze[x][y]==1)
        {
            sol[x][y]=1;
            return true;
        }
        
        if(issafe(x,y))
        {
            if(sol[x][y]==1)
            return false;
            
            sol[x][y]=1;
            
            if(solveMazeUtil(x+1,y))
            return true;
            if(solveMazeUtil(x,y+1))
            return true;
            
            sol[x][y]=0;
            return false;
        }
        return false;
        
    }
    
    public static boolean issafe(int x,int y)
    {
        if(x>=0 && x<n && y>=0 && y<n && maze[x][y]==1)
        return true;
        
        return false;
    }
    
    public static void printsol()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
}

import java.util.*;
class Main
{
    static int n;
    static int chess[][];
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        chess = new int[n][n];
        
        solvechess();
    }
    
    public static void solvechess()
    {
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                chess[i][j] = 0;
            }
        }
        if(!solveutilchess(0))
        {
            System.out.println("No Solutions.");
        }
        else
        {
            printboard();
        }
    }
    
    public static boolean solveutilchess(int col)
    {
        if(col>=n)
        return true;
        
        for(int i=0;i< n;i++)
        {
            if(issafe(i,col))
            {
                chess[i][col]=1;
                if(solveutilchess(col+1))
                return true;
            }
            chess[i][col]=0;
        }
        return false;
    }
    
    public static boolean issafe(int row,int col)
    {
        for(int i=0;i<col;i++)
        {
            if(chess[row][i]==1)
            return false;
            
        }
        
        for(int i=row,j=col;i>=0 && j>=0;i--,j--)
        {
            if(chess[i][j] == 1)
            return false;
        }
        for(int i=row,j=col;i<n && j>=0;i++,j--)
        {
            if(chess[i][j] == 1)
            return false;
        }
        
        return true;
    }
    
    public static void printboard()
    {
        for(int i=0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(chess[i][j]==1)
                System.out.print("Q ");
                else
                System.out.print(". ");
            }
            System.out.println();
        }
    }
}

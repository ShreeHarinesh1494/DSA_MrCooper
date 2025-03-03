import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int grid[][] = new int[n][m];
        int dp[][] = new int[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }
        
        dp[0][0] = grid[0][0];
        
        for(int i=1;i<n;i++)
        {
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }
        
        for(int j=1;j<m;j++)
        {
            dp[0][j] = grid[0][j]+dp[0][j-1];
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        
        System.out.println(dp[n-1][m-1]);
    }
}

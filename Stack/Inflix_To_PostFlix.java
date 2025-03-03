import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = PostFlix(str);
        System.out.println(ans);
    }
    
    public static String PostFlix(String str)
    {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        
        for(int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if(c==' ')
            continue;
            
            if(Character.isLetterOrDigit(c))
            {
                res.append(c);
            }
            
            else if(c=='(')
            {
                st.push(c);
            }
            else if(c==')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                {
                    res.append(st.pop());
                }
                st.pop();
            }
            else 
            {
                while(!st.isEmpty() && prec(c)<=prec(st.peek()))
                {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }
        
        while(!st.isEmpty())
        res.append(st.pop());
        return res.toString();
    }
    
    public static int prec(char c)
    {
        if(c=='^')
        return 3;
        else if(c=='/'||c=='*')
        return 2;
        else if(c=='+'||c=='-')
        return 1;
        else 
        return -1;
    }
}

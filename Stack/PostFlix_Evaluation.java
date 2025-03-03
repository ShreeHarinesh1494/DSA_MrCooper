import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = PostFlix(str);
        System.out.println(ans);
    }
    
    public static int PostFlix(String str)
    {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
            if(c==' ')
            continue;
            
            if(Character.isDigit(c))
            {
                st.push(c - '0');
            }
            else
            {
                int a = st.pop();
                int b = st.pop();
                
                switch(c)
                {
                    case '+':
                        st.push(a+b);
                        break;
                    case '-':
                        st.push(a-b);
                        break;
                    case '*':
                        st.push(a*b);
                        break;
                    case '/':
                        st.push(b/a);
                        break;
                    case '%':
                        st.push(b%a);
                        break;
                }
            }
        }
        return st.pop();
    }
}

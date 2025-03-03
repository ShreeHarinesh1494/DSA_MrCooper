import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        String str = sc.nextLine();
        for(int i=0;i<str.length();i++)
        {
            char c = str.charAt(i);
                if(c=='{'||c=='['||c=='(')
                {
                    st.push(c);
                }
                
                else if(!st.isEmpty() &&(
                (c=='}' && st.peek()=='{') ||
                (c==')' && st.peek()=='(') ||
                (c==']' && st.peek()=='[')
                ))
                {
                    st.pop();
                }
                else
                {
                    st.push(c);
                }
        }
        
        if(st.isEmpty())
        {
            System.out.println("Bracket Balanced");
        }
        else
        {
            System.out.println("Not Bracket Balanced");
            
        }
    }
}

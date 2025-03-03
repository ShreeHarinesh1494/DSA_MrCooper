import java.util.*;
class Tree
{
    public Node root;
    
    class Node
    {
        int value;
        Node left;
        Node right;
        
        Node(int value)
        {
            this.value=value;
        }
    }
    
    public boolean insert(int value)
    {
        Node newNode = new Node(value);
        if(root==null)
        {
            root=newNode;
        }
        
        Node curr = root;
        while(true)
        {
            if(curr.value==newNode.value)
            {
                return false;
            }
            
            if(curr.value>=newNode.value)
            {
                if(curr.left==null)
                {
                    curr.left=newNode;
                    return true;
                }
                curr = curr.left;
            }
            
            
            if(curr.value<=newNode.value)
            {
                if(curr.right==null)
                {
                    curr.right=newNode;
                    return true;
                }
                curr = curr.right;
            }
        }
    }
    
    public ArrayList<Integer> BFS()
    {
        ArrayList<Integer> ls = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            ls.add(curr.value);
            
            if(curr.left!=null)
            {
                q.add(curr.left);
            }
            if(curr.right!=null)
            {
                q.add(curr.right);
            }
        }
        
        return ls;
    }
    
    public ArrayList<Integer> PreOrder()
    {
        ArrayList<Integer> ls = new ArrayList<>();
        class Traverse
        {
            Traverse(Node root)
            {
                ls.add(root.value);
                
                if(root.left!=null)
                {
                    new Traverse(root.left);
                }
                if(root.right!=null)
                {
                    new Traverse(root.right);
                }
            }
        }
        
        new Traverse(root);
        return ls;
    }
    public ArrayList<Integer> InOrder()
    {
        ArrayList<Integer> ls = new ArrayList<>();
        class Traverse
        {
            Traverse(Node root)
            {
                
                if(root.left!=null)
                {
                    new Traverse(root.left);
                }
                ls.add(root.value);
                if(root.right!=null)
                {
                    new Traverse(root.right);
                }
            }
        }
        
        new Traverse(root);
        return ls;
    }
    public ArrayList<Integer> PostOrder()
    {
        ArrayList<Integer> ls = new ArrayList<>();
        class Traverse
        {
            Traverse(Node root)
            {
                
                if(root.left!=null)
                {
                    new Traverse(root.left);
                }
                if(root.right!=null)
                {
                    new Traverse(root.right);
                }
                ls.add(root.value);
            }
        }
        
        new Traverse(root);
        return ls;
    }
    
    public int height()
    {
        return height(root);
    }
    
    private int height(Node root)
    {
        if(root==null)
        {
            return -1;
        }
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.max(lh,rh)+1;
    }
    
    public int sumofleaf()
    {
        return sumofleaf(root);
    }
    
    private int sumofleaf(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        
        if(root.left==null && root.right==null)
        {
            return root.value;
        }
        
        return sumofleaf(root.left)+sumofleaf(root.right);
    }
    
    public boolean isbst()
    {
        return isbst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    private boolean isbst(Node root,int min,int max)
    {
        if(root==null)
        {
            return true;
        }
        
        if(root.value<=min || root.value>=max)
        {
            return false;
        }
        
        return isbst(root.left,min,root.value) && isbst(root.right,root.value,max);
    }
    
    public boolean sym()
    {
        return sym(root.left,root.right);
    }
    
    private boolean sym(Node left,Node right)
    {
        if(left==null && right==null)
        return true;
        
        if(left==null || right==null)
        return false;
        
        if(left.value!=right.value)
        return false;
        
        return sym(left.left,right.right) && sym(left.right,right.left);
    }
    
    public boolean balanced()
    {
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.abs(lh-rh)<=1;
    }
    
    public int diah()
    {
        int d[] = new int[1];
        diah(root,d);
        return d[0];
    }
    
    private int diah(Node root,int d[])
    {
        if(root==null)
        return 0;
        
        int lh = diah(root.left,d);
        int rh = diah(root.right,d);
        d[0] = Math.max(d[0],lh+rh);
        return Math.max(rh,lh)+1;
    }
    
    public void zigag()
    {
        ArrayList<Integer> ls = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean f = true;
        while(!q.isEmpty())
        {
            int n = q.size();
            Deque<Integer> dq = new LinkedList<>();
            for(int i=0;i<n;i++)
            {
                Node node = q.poll();
                if(f)
                {
                    dq.offerLast(node.value);
                }
                else
                {
                    dq.offerFirst(node.value);
                }
                
                if(node.left!=null)
                q.offer(node.left);
                
                if(node.right!=null)
                q.offer(node.right);
            }
            for(int num:dq)
            System.out.print(num+" ");
            f=!f;
        }
    }
}

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Tree t = new Tree();
        boolean istrue = true;
        while(istrue)
        {
            int n = sc.nextInt();
            if(n!=0)
            t.insert(n);
            else
            istrue = false;
        }
        
        ArrayList<Integer> ans = t.BFS();
        System.out.println("BFS : ");
        for(int num:ans)
        System.out.print(num+" ");
        System.out.println();
        
        ArrayList<Integer> ans1 = t.PreOrder();
        System.out.println("PreOrder : ");
        for(int num:ans1)
        System.out.print(num+" ");
        System.out.println();
        
        ArrayList<Integer> ans2 = t.InOrder();
        System.out.println("InOrder : ");
        for(int num:ans2)
        System.out.print(num+" ");
        System.out.println();
        
        ArrayList<Integer> ans3 = t.PostOrder();
        System.out.println("PostOrder : ");
        for(int num:ans3)
        System.out.print(num+" ");
        System.out.println();
        
        System.out.println("zigag : ");
        t.zigag();
        System.out.println();
        System.out.println("Height : "+t.height());
        System.out.println("Sum of leaf : "+t.sumofleaf());
        System.out.println("BST or NOt : "+t.isbst());
        System.out.println("Symmetrical : "+t.sym());
        System.out.println("balanced : "+t.balanced());
        System.out.println("Diameter : "+t.diah());
        
    }
}

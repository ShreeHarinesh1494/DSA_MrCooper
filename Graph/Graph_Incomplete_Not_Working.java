import java.util.*;
class Main
{
    static class Edge
    {
        int src;
        int dest;
        int wt;
        
        Edge(int src,int dest,int wt)
        {
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    
    public static void creategraph(ArrayList<Edge> graph[],int E,Scanner sc)
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<Edge>();
        }
        
        for(int i=0;i<E;i++)
        {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int wt = sc.nextInt();
            
            graph[src].add(new Edge(src,dest,wt)); 
            graph[dest].add(new Edge(dest,src,wt)); 
        }
    }
    
    public static void AdjMat(ArrayList<Edge> graph[],int V)
    {
        int a[][] = new int[V][V];
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                a[i][j] = 0;
            }
        }
        
        for(int i=0;i<V;i++)
        {
            for(Edge e:graph[i])
            {
                a[e.src][e.dest]=e.wt;
                a[e.dest][e.src]=e.wt;
            }
        }
        
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    
    public static void AdjList(ArrayList<Edge> graph[],int V)
    {
        for(int i=0;i<V;i++)
        {
            System.out.print(i+" ");
            for(Edge e:graph[i])
            {
                System.out.print("-> "+e.dest);
            }
            System.out.println();
        }
    }
    
    
    public static void BFS(ArrayList<Edge> graph[],boolean visited[],Queue<Integer> q)
    {
        if(q.isEmpty())
        return;
        
        int curr = q.poll();
        System.out.print(curr+" ");
        for(Edge e:graph[curr])
        {
            if(!visited[e.dest])
            {
                visited[e.dest]=true;
                q.add(e.dest);
            }
        }
        BFS(graph,visited,q);
    }
    
    public static void DFS(ArrayList<Edge> graph[],boolean visited[],int stv)
    {
        System.out.print(stv+" ");
        visited[stv]=true;
        
        for(Edge e:graph[stv])
        {
            if(!visited[e.dest])
            {
                DFS(graph,visited,e.dest);
            }
        }
    }
    
    
    // **Detect cycle in an UNDIRECTED graph using DFS**
    public static boolean isCyclicUndirected(ArrayList<Edge> graph[], boolean visited[], int curr, int parent)
    {
        visited[curr] = true;

        for (Edge e : graph[curr])
        {
            if (!visited[e.dest]) 
            {
                if (isCyclicUndirected(graph, visited, e.dest, curr)) 
                {
                    return true;
                }
            } 
            else if (e.dest != parent) 
            {
                return true; // If visited and not the parent, cycle exists
            }
        }
        return false;
    }

    // **Detect cycle in a DIRECTED graph using DFS**
    public static boolean isCyclicDirected(ArrayList<Edge> graph[], boolean visited[], boolean recStack[], int curr) 
    {
        visited[curr] = true;
        recStack[curr] = true;

        for (Edge e : graph[curr]) 
        {
            if (!visited[e.dest] && isCyclicDirected(graph, visited, recStack, e.dest)) 
            {
                return true;
            } 
            else if (recStack[e.dest]) 
            {
                return true;
            }
        }
        recStack[curr] = false;
        return false;
    }

    // **Check for Negative Edge**
    public static boolean hasNegativeEdge(ArrayList<Edge> graph[]) 
    {
        for (ArrayList<Edge> edges : graph) 
        {
            for (Edge e : edges) 
            {
                if (e.wt < 0) 
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of vertices : ");
        int V = sc.nextInt();
        System.out.println("Enter the no of Edges : ");
        int E = sc.nextInt();
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph,E,sc);
        System.out.println("Adj Matrix : ");
        AdjMat(graph,V);
        System.out.println("Adj List : ");
        AdjList(graph,V);
        int stv = sc.nextInt();
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(stv);
        visited[stv]=true;
        System.out.println("BFS : ");
        BFS(graph,visited,q);
        Arrays.fill(visited,false);
        System.out.println("DFS : ");
        DFS(graph,visited,stv);
        
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];

        // **Check for Cycle in Undirected Graph**
        boolean isCycleUndirected = false;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUndirected(graph, visited, i, -1)) {
                    isCycleUndirected = true;
                    break;
                }
            }
        }
        
        // **Check for Cycle in Directed Graph**
        Arrays.fill(visited, false);
        boolean isCycleDirected = false;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicDirected(graph, visited, recStack, i)) {
                    isCycleDirected = true;
                    break;
                }
            }
        }

        // **Check for Negative Edge**
        boolean hasNegative = hasNegativeEdge(graph);

        System.out.println("Cycle in Undirected Graph: " + isCycleUndirected);
        System.out.println("Cycle in Directed Graph: " + isCycleDirected);
        System.out.println("Graph has Negative Edge: " + hasNegative);
        
    }
}

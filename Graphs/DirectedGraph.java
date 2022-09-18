package Graphs;
import java.util.*;

public class DirectedGraph{
    private List<Integer>[] edges;

    public DirectedGraph(int n){ // n: number of vertices
        this.edges = new List[n];
        for(int i = 0; i < n; i++){
            this.edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int target){
        this.edges[source].add(target);
    }

    public int getNumVertices(){
        return this.edges.length;
    }

    //Breadth First Search:

    public boolean connectedBfs(int from, int to){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from); // enqueue
        while(!queue.isEmpty()){
            int current = queue.remove(); // dequeue
            if(current == to){
                return true;
            }
            if(visited.contains(current)){
                continue;
            }
            visited.add(current);
            queue.addAll(edges[current]);
        }
        return false;
    }

    //Death First Search:

    Set<Integer> visited;

    public boolean connectedDfs(int from, int to){
        visited = new HashSet<>();
        return connectedDfsInner(from, to);
    }

    private boolean connectedDfsInner(int from, int to){
        if(from == to){
            return true;
        }
        for(int child : edges[from]){
            if(visited.contains(child)){
                continue;
            }
            visited.add(child);
            if(connectedDfsInner(child, to)){
                return true;
            }
        }
        return false;
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Write a description of class BFS here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BFS
{
    public static ArrayList<Integer> bfs(Digraph g){
        boolean[] visited = new boolean[g.size()];
        ArrayList<Integer> camino = new ArrayList<Integer>();
        bfs(g,0,visited,camino);   
        return camino;
    }
    
    private static void bfs(Digraph g, int nodo, boolean[] visited, ArrayList c){
        visited[nodo] = true;
        Queue<Integer> hijos = new LinkedList<Integer>();
        ArrayList<Integer> sucesores = new ArrayList<Integer>();
        hijos.add(nodo);
        while(!hijos.isEmpty()){
            c.add(hijos.peek());
            sucesores=g.getSuccessors(hijos.poll());
            if(sucesores!=null){                
              for(Integer sucesor: sucesores){
                 if(!visited[sucesor]){
                        visited[sucesor] = true;
                        hijos.add(sucesor);
                 }
              }
            }   
        }
    }
}

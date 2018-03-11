import java.util.ArrayList;
import java.util.Stack;
/**
 * Write a description of class CaminoCortoDFS here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DFS
{    
    public static ArrayList<Integer> hayCaminoDFS(Digraph g, int inicio, int fin){
        boolean[] visited = new boolean[g.size()];
        ArrayList<Integer> camino = new ArrayList<Integer>();
        Stack<Integer> pila = new Stack<Integer>();
        hayCaminoDFS(g,inicio,fin,visited, pila);
        camino.add(inicio);
        while(!pila.isEmpty()){
            camino.add(pila.pop());
        }
        return camino;
    }
    
       private static boolean hayCaminoDFS(Digraph g, int nodo, int objetivo, boolean[] visited, Stack<Integer> c){
        visited[nodo] = true;
        ArrayList<Integer> sucesores = g.getSuccessors(nodo);
        if(sucesores != null){
            for(Integer sucesor : sucesores){              
                if(!visited[sucesor] && (sucesor == objetivo || hayCaminoDFS(g, sucesor, objetivo, visited, c))){      
                    c.push(sucesor);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        DigraphAL g = new DigraphAL(4);
        g.addArc(0,1,1);
        g.addArc(0,2,10);
        g.addArc(0,3,4);
        g.addArc(1,0,7);
        g.addArc(1,2,6);
        g.addArc(1,3,2);
        g.addArc(2,0,11);
        g.addArc(2,1,20);
        g.addArc(2,3,1);
        g.addArc(3,0,5);
        g.addArc(3,1,9);
        g.addArc(3,2,13);
        
        System.out.println(hayCaminoDFS(g,0,2));
        System.out.println(hayCaminoDFS(g,1,3));
        System.out.println(hayCaminoDFS(g,0,3));
    }
}

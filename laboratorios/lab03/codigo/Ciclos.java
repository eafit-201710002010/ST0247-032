import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;;
/**
 * Write a description of class Ciclos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ciclos
{
    public static boolean hayCiclo(Digraph g){
        boolean[] visited = new boolean[g.size()];
        ArrayList<Integer> c = new ArrayList<Integer>();
        return hayCiclo(g,0,visited, c);
    }
    
    private static boolean hayCiclo(Digraph g, int nodo, boolean[] visited, ArrayList<Integer>c){
        visited[nodo] = true;
        ArrayList<Integer> sucesores = new ArrayList<Integer>();
        Queue<Integer> hijos = new LinkedList<Integer>();
        hijos.add(nodo);
        while(!hijos.isEmpty()){
            c.add(hijos.peek());
            sucesores = g.getSuccessors(hijos.poll());
            if(sucesores!=null){
                for(Integer sucesor : sucesores){
                    if(!visited[sucesor]){
                        visited[sucesor] = true;
                        hijos.add(sucesor);
                    }
                    else{
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

import java.util.ArrayList;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAM extends Digraph
{
    int[][] matriz;
   
    public DigraphAM(int size){
        super(size);
        matriz = new int[size][size];
    }
   
    public int getWeight(int source, int destination){
        return matriz[source][destination];
    }
   
    public void addArc(int source, int destination, int weight){
        matriz[source][destination] = weight;
    }
  
    public ArrayList<Integer> getSuccessors(int vertex){
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for(int j = 0; j < size; ++j){
            if(matriz[vertex][j] != 0){
                lista.add(j);
            }
        }
        return lista;
    }
    
    public static void dibujarGrafo(Digraph g){
        System.out.println("digraph Grafo {");
        System.out.println("node [color=cyan, style=filled];");
        int nv = g.size();
        for (int i = 0; i < nv; i++){
           ArrayList<Integer> lista = g.getSuccessors(i);
           for (int j = 0; j < lista.size(); j++)
             System.out.println("\"" + i + "\" -> \"" + lista.get(j) + "\" [ label=\""+ g.getWeight(i,lista.get(j)) +"\"];");
        }
        System.out.println("}");
     }
     
    public static void main(String [] args){
        DigraphAM dgam = new DigraphAM(5);
        dgam.addArc(0,1,10);
        dgam.addArc(0,2,3);
        dgam.addArc(1,2,1);
        dgam.addArc(1,3,2);
        dgam.addArc(2,1,4);
        dgam.addArc(2,3,8);
        dgam.addArc(2,4,2);
        dgam.addArc(3,4,7);
        dgam.addArc(4,3,9);
         
        dibujarGrafo(dgam);
    }
}


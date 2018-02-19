import java.util.ArrayList;
/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 * 
 * @author Mauricio Toro 
 * @version 1
 */
public class DigraphAM extends Graph
{
    int[][] matriz;
   
    public DigraphAM(int size){
       super(size);
       matriz = new int[size][size];
   }
   
   public String getWeight(int source, int destination){
       return String.valueOf(matriz[source][destination]);
    }
   
   public void addArc(int source, int destination, String weight){
       int peso = Integer.parseInt(weight);
       matriz[source][destination] = peso;
   }
   
   public ArrayList<Integer> getSuccessors(int vertex){
       ArrayList<Integer> lista = new ArrayList<Integer>();
       for(int i = 0; i < size; ++i){
           if(matriz[vertex][i]  != 0){
               lista.add(i);
           }
       }
       return lista;
   }
}

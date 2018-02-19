import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 * 
 * @author Mauricio Toro 
 * @version 1
 */
public class DigraphAL extends Graph
{
   ArrayList<LinkedList<Pareja>> lista;
   
   public DigraphAL(int size){
       super(size);
       lista = new ArrayList<LinkedList<Pareja>>();
       for(int i = 0; i < size; ++i){
           lista.add(new LinkedList<Pareja>());
       }
   }
   
   public void addArc(int source, int destination, String weight){
       lista.get(source).add(new Pareja(destination, weight));
   }
   
   public String getWeight(int source, int destination){
       for(Pareja pareja : lista.get(source)){
           if(pareja.vertice == destination){
               return pareja.peso;
            }
       }
       return "";
   }
  
   public ArrayList<Integer> getSuccessors(int vertice){
       ArrayList<Integer> vecinos = new ArrayList<Integer>();
       for(Pareja pareja : lista.get(vertice)){
           vecinos.add(pareja.vertice);
       }
       return vecinos;
   }
}

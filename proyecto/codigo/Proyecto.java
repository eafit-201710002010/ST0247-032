import java.util.*;
import java.io.*;
import javafx.util.Pair;
/**
 * Write a description of class Pd2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Proyecto
{
  private static ArrayList<Integer> agenteViajero(Digraph g)
  { 
     boolean[] visitado = new boolean[g.size()];
     ArrayList<Integer> recorrido = new ArrayList<Integer>();
     ArrayList<Integer> sucesores = new ArrayList<Integer>();
     int deposito = 0;
     int actual = deposito;
     int costo = 0;
     for(int i = 0; i < g.size(); ++i){
         int minimo = Integer.MAX_VALUE;
         int cerca = 0;
         sucesores = g.getSuccessors(actual);
         visitado[actual] = true;
         if(i == g.size()-1){
             visitado[deposito] = false;
         }
         for(Integer sucesor : sucesores){
                if(!visitado[sucesor] && sucesor != actual && (g.getWeight(actual, sucesor) < minimo)){
                    minimo = g.getWeight(actual, sucesor);
                    cerca = sucesor;
                }
          }
         actual = cerca;
         recorrido.add(i,actual);
         costo += minimo;
     }   
     return recorrido;
  }  
  
  private static Digraph leer(String filename) throws IOException{
      BufferedReader lector = new BufferedReader(new FileReader(filename));
      String linea;
      int k=0, n=0, m=0, u=0, breaks=0;
      float r=0.0f, speed=0.0f, Tmax=0.0f, Smax=0.0f, st_customer=0.0f,Q=0.0f;
      while(k <= 12){
          linea = lector.readLine();
          String[] arr = linea.split(" ");
          if(arr[0].equals("n")){
              n = Integer.parseInt(arr[2]);
          }
          if(arr[0].equals("m")){
              m = Integer.parseInt(arr[2]);
            }
          if(arr[0].equals("u")){
              u = Integer.parseInt(arr[2]);
            }
          if(arr[0].equals("breaks")){
              breaks = Integer.parseInt(arr[2]);
          }
          if(arr[0].equals("r")){
              r = Float.parseFloat(arr[2]);
          }
          if(arr[0].equals("speed")){
              speed = Float.parseFloat(arr[2]);
          }
          if(arr[0].equals("Tmax")){
              Tmax = Float.parseFloat(arr[2]);
          }
          if(arr[0].equals("Smax")){
              Smax = Float.parseFloat(arr[2]);
          }
          if(arr[0].equals("st_customer")){
              st_customer = Float.parseFloat(arr[2]);
          }
          if(arr[0].equals("Q")){
              Q = Float.parseFloat(arr[2]);
          }
         ++k;
      }
      Pair<Float,Float>[] arreglo = new Pair[n];
      Digraph g = new DigraphAL(n);
      
      while ((linea = lector.readLine()) != null){  
          String[] lineaPartida = linea.split(" ");
          if(lineaPartida.length == 6){
              if (lineaPartida[4].equals("d") || lineaPartida[4].equals("c") || lineaPartida[4].equals("s")){
                  arreglo[Integer.parseInt(lineaPartida[0])] = new Pair(Float.parseFloat(lineaPartida[2]),Float.parseFloat(lineaPartida[3]));
                }
            }
        }       
      for (int i = 0; i< n; i++){
          for (int j = 0; j < n; j++){
              g.addArc(i,j,(int)Math.sqrt(
                                       Math.pow(arreglo[i].getKey()-arreglo[j].getKey(),2) 
                                       + Math.pow(arreglo[i].getValue()-arreglo[j].getValue(),2)));
          }
      }
      return g;
  }
  
  public static void main(String[] args)throws IOException{
     Digraph g = leer("tc2c320s24cf0.txt");
     ArrayList<Integer> solucion = agenteViajero(g);
     System.out.println(solucion);
  }
}

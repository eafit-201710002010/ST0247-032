import java.util.*;
/**
 * Write a description of class ejercicioEnLinea here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ejercicioEnLinea
{
    
   public static void leer() {
       Scanner sc= new Scanner(System.in);
       System.out.println("");
       int n = sc.nextInt();
       int m = sc.nextInt();
       DigraphAL g = new DigraphAL(n+1);
    
       for(int i =0; i < m; ++i){
           int ai= sc.nextInt();
           int bi= sc.nextInt();
           int wi= sc.nextInt();
           g.addArc(ai, bi, wi);
           g.addArc(bi, ai, wi);
         
        }
       if( hayCaminoDFS(g, 1, n)){
           ArrayList <Integer> res =recorrido(g,1);
           for(int num : res){
               System.out.print(num);
            }
        } else
            System.out.println(-1);

    } 
   public static ArrayList<Integer> recorrido(Digraph g, int inicio)
     {
         boolean[] recorrido = new boolean[g.size()];
         ArrayList <Integer> res = new ArrayList<Integer>();
         int index = 0;
         int actual = inicio;
         do {        
             int cerca = 0;
             int pesoMin = 1000000; 
             recorrido[actual] = true;
             ArrayList<Integer> sucesores = g.getSuccessors(actual);
                 for (int sucesor: sucesores){                     
                  if (g.getWeight(actual,sucesor) < pesoMin 
                    && sucesor != actual 
                    && !recorrido[sucesor] )
                  {   cerca = sucesor;
                      pesoMin = g.getWeight(actual,sucesor);
                     
                  }
            }
             res.add(actual);
             if(actual==g.size()-1){break;}
             actual = cerca;
        } while (index < g.size());
    
        return res;
     }
         public static boolean hayCaminoDFS(Digraph g, int inicio, int fin){
        boolean[] visited = new boolean[g.size()];
        return hayCaminoDFS(g,inicio,fin,visited);
    }
       private static boolean hayCaminoDFS(Digraph g, int nodo, int objetivo, boolean[] visited){
        visited[nodo] = true;
        ArrayList<Integer> sucesores = g.getSuccessors(nodo);
        if(sucesores != null){
            for(Integer sucesor : sucesores){              
                if(!visited[sucesor] && (sucesor == objetivo || hayCaminoDFS(g, sucesor, objetivo, visited))){      
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String [] args){
        leer();
    }
    }
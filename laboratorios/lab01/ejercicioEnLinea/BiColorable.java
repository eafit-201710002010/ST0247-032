import java.util.*;
import java.lang.*;
import java.io.*;

public class BiColorable
{  
    boolean esBipartito(int G[][],int src){
        int colorArr[] = new int[G.length];
        for (int i=0; i<G.length; ++i)
            colorArr[i] = -1;
    
        colorArr[src] = 1; 
        LinkedList<Integer>q = new LinkedList<Integer>();
        q.add(src);
    
        while (q.size() != 0){
            int u = q.poll();
            if (G[u][u] == 1)
                return false;  
            for (int v=0; v<G.length; ++v){
                if (G[u][v]==1 && colorArr[v]==-1){
                    colorArr[v] = 1-colorArr[u];
                    q.add(v);
                }
                else if (G[u][v]==1 && colorArr[v]==colorArr[u])
                    return false;
            }
        }
        return true;
    }
     private static void esBicolorable (){
        Scanner sc= new Scanner(System.in);
        System.out.println(" ");   
        int nodos= sc.nextInt();
            if(nodos!=0){
            int arcos= sc.nextInt();
            int G[][] = new int[nodos][nodos];
            for(int x =0; x<arcos; ++x){
                int ini= sc.nextInt();
                int fin= sc.nextInt();
                G[ini][fin]=1;
                G[fin][ini]=1;
                
            }
            
            BiColorable b = new BiColorable();
            if (b.esBipartito(G, 0))
               System.out.println("BICOLORABLE");
            else
               System.out.println("NO BICOLORABLE");
        
            esBicolorable();
        }
    
    }
    public static void main(String [] args){
        esBicolorable();
    }
}
   
    


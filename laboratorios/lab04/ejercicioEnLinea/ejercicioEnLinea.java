import java.util.*;
import java.io.*;
/**
 * Write a description of class ejrcicioEnLinea here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ejercicioEnLinea
{
   private static int ejercicio2()throws IOException{
    Scanner sc = new Scanner(System.in);
    int n=0;
    int d=0;
    int r=0;
      System.out.print(" ");
    while((n=sc.nextInt())!=0 &&(d=sc.nextInt())!=0 && (r=sc.nextInt())!=0){
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader (isr);
      
      String rutaM =br.readLine();
      String duracionRutaM[] = new String [n];
      duracionRutaM= rutaM.split(" ");
      String rutaT =br.readLine();
      String duracionRutaT[] = new String [n];
      duracionRutaT= rutaT.split(" ");
      int duraciontotalM=0;
      int duraciontotalT=0;
      for(int i=0; i< n;i++){
            duraciontotalM+= Integer.parseInt(duracionRutaM[i]);
            duraciontotalT+= Integer.parseInt(duracionRutaT[i]);
        }
     duraciontotalM=(duraciontotalM-d)*r;
     duraciontotalT=(duraciontotalT-d)*r;
     System.out.println(duraciontotalM+duraciontotalT);
    }
    return 0;
    }
   public static void main (String [] args)throws IOException{
    System.out.println(ejercicio2());
    }
}

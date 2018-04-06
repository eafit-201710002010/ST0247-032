
/**
 * Write a description of class Taller8 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Taller8
{
    private static void merge(int[] a, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        
        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];
        
        for(int i = 0; i < n1; ++i){
            temp1[i] = a[l+i];
        }
        for(int j = 0; j < n2; ++j){
            temp2[j] = a[m+1+j];
        }
        
        int i = 0;
        int j = 0;
        int k = l;
        while(i < n1 && j < n2){
            if(temp1[i] <= temp2[j]){
                a[k] = temp1[i];
                ++i;
            }
            else{
                a[k] = temp2[j];
                ++j;
            }
            ++k;
        }
        
        while(i < n1){
            a[k] = temp1[i];
            ++i;
            ++k;
        }
        
        while(j < n2){
            a[k] = temp2[j];
            ++j;
            ++k;
        }
    }
    
    public static void mergeSort(int[] a){
        mergeSort(a,0,a.length-1);
        for(int i = 0; i < a.length; ++i){
            System.out.println(a[i]);
        }
    }
    
    private static void mergeSort(int[] a, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,r);
            merge(a,l,m,r);
        }        
    }
        
    private static int particion(int[] a, int menor, int mayor){
        int pivote = a[mayor];
        int i = menor-1;
        for(int j = menor; j < mayor; ++j){
            if(a[j] <= pivote){
                ++i;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i+1];
        a[i+1] = a[mayor];
        a[mayor] = temp;
        
        return i+1;
    }
    
    public static void quickSort(int[] a){
        quickSort(a,0,a.length-1);
        for(int i = 0; i < a.length; ++i){
            System.out.println(a[i]);
        }
    }
    
    private static void quickSort(int[] a, int menor, int mayor){
        if(menor < mayor){
            int pivote = particion(a,menor,mayor);
            quickSort(a,menor,pivote-1);
            quickSort(a,pivote+1,mayor);
        }
    }
}

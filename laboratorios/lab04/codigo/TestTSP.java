import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestTSP
{
    @Test
    public void testTSP(){
        DigraphAL g = new DigraphAL(4);
        g.addArc(0,1,7);
        g.addArc(0,2,15);
        g.addArc(0,3,6);
        g.addArc(1,0,2);
        g.addArc(1,2,7);
        g.addArc(1,3,3);
        g.addArc(2,0,9);
        g.addArc(2,1,6);
        g.addArc(2,3,12);
        g.addArc(3,0,10);
        g.addArc(3,1,4);
        g.addArc(3,2,8);
        
        int[] respuesta = {3,1,2,0};
        int[] res = AgenteViajero.agenteViajero(g,0);
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> sol = new ArrayList<Integer>();
        for(int i = 0; i<res.length; ++i){
            ans.add(respuesta[i]);
            sol.add(res[i]);
        }
        System.out.println(sol);
        assertEquals(sol, ans);
    }
}

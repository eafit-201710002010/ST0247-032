import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Write a description of class nReinasTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NReinasTest
{
    @Test
    public void nReinasTest(){
        assertEquals(NReinas.nReinas(1), true);
        assertEquals(NReinas.nReinas(2), false);
        assertEquals(NReinas.nReinas(3), false);
        assertEquals(NReinas.nReinas(4), true);
        assertEquals(NReinas.nReinas(5), true);
        assertEquals(NReinas.nReinas(6), true);
    }
}

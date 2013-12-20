/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author p1104350
 */
public class CombinaisonTest extends TestCase {
    
    /**
     * Test of comparer method, of class Combinaison.
     */
    @Test
     public void testCombinaisonTrouvee() {
        Combinaison combiSecrète = new Combinaison("aaaa");
        combiSecrète.comparer("aaaa");
        assertEquals(true, combiSecrète.trouvée);
     
     }
     @Test
     public void testCombinaisonNonTrouvee1() {
        Combinaison combiSecrète = new Combinaison("aaaa");
        combiSecrète.comparer("baaa");
        assertEquals(false, combiSecrète.trouvée);
     
     }
     @Test
     public void testCombinaisonNonTrouvee2() {
        Combinaison combiSecrète = new Combinaison("aaaa");
        combiSecrète.comparer("abaa");
        assertEquals(false, combiSecrète.trouvée);
     
     }
       @Test
     public void testCombinaisonNonTrouvee3() {
        Combinaison combiSecrète = new Combinaison("aaaa");
        combiSecrète.comparer("aaba");
        assertEquals(false, combiSecrète.trouvée);
     
     }
     @Test
     public void testCombinaisonNonTrouvee4() {
        Combinaison combiSecrète = new Combinaison("aaaa");
        combiSecrète.comparer("aaab");
        assertEquals(false, combiSecrète.trouvée);
     
     }
     @Test
      public void testPointMauvaisLettre() {
        Combinaison combiSecrète = new Combinaison("aaaa");
        assertEquals("ooo-", combiSecrète.comparer("aaab"));
     
     }
      @Test
      public void testPointInversée() {
        Combinaison combiSecrète = new Combinaison("abcd");
        assertEquals("xxoo", combiSecrète.comparer("bacd"));
     
     }
      @Test
      public void testPointToutJuste() {
        Combinaison combiSecrète = new Combinaison("abcd");
        assertEquals("oooo", combiSecrète.comparer("abcd"));
     
     }
      public void testPointToutFaux() {
        Combinaison combiSecrète = new Combinaison("abcd");
        assertEquals("----", combiSecrète.comparer("ffff"));
     }
}
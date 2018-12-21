/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opgave6;

import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Frans
 */
public class WordListTest {

    public WordListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testContructor1() {
        System.out.println("test 1: first constructor");

        WordList planetsA = new WordList(new String[]{"Mars", "Aarde", "Mars", "Venus"});
        assertEquals(planetsA.size(), 3);
        assertEquals(planetsA.get(0), "Aarde");
        assertEquals(planetsA.get(1), "Mars");
        assertEquals(planetsA.get(2), "Venus");

        WordList planetsB = new WordList(new String[]{"Venus", "Aarde", "Jupiter", "Mars"});
        assertEquals(planetsB.size(), 4);
        assertEquals(planetsB.get(0), "Aarde");
        assertEquals(planetsB.get(1), "Jupiter");
        assertEquals(planetsB.get(2), "Mars");
        assertEquals(planetsB.get(3), "Venus");
    }

    @Test
    public void testHasWord() {
        System.out.println("test 2: hasWord");

        WordList planets = new WordList(new String[]{"Mars", "Aarde", "Venus"});
        assertTrue(planets.hasWord("Mars"));
        assertTrue(planets.hasWord("Aarde"));
        assertTrue(planets.hasWord("Venus"));
        assertFalse(planets.hasWord("Jupiter"));
        assertFalse(planets.hasWord("Pluto"));
        assertFalse(planets.hasWord("Zeist"));

    }

    @Test
    public void testHashSet() {
        System.out.println("test 3: hashSet");
        WordList planetsA = new WordList(new String[]{"Mars", "Aarde", "Venus"});
        WordList planetsB = new WordList(new String[]{"Aarde", "Mars", "Venus"});
        WordList planetsC = new WordList(new String[]{"Aarde", "Mars", "Jupiter"});

        HashSet<WordList> listSet = new HashSet<>();

        listSet.add(planetsA);
        assertEquals(listSet.size(), 1);

        listSet.add(planetsB); // zou geen effect moeten hebben
        assertEquals(listSet.size(), 1);

        listSet.add(planetsC); // zou wel effect moeten hebben
        assertEquals(listSet.size(), 2);

        listSet.add(planetsC); // zou geen effect moeten hebben
        assertEquals(listSet.size(), 2);
    }
    
    @Test
    public void testContructor2() {
        System.out.println("test 4: extra constructor");
        WordList planetsA = new WordList(new String[]{"Mars", "Aarde", "Saturnus", "Pluto", "Venus"});
        WordList planetsB = new WordList(new String[]{"Aarde", "Mars", "Venus", "Jupiter"});
        WordList planetsC = new WordList(planetsA, planetsB);
        assertEquals(planetsC.size(), 6);
        assertEquals(planetsC.get(0), "Aarde");
        assertEquals(planetsC.get(1), "Jupiter");
        assertEquals(planetsC.get(2), "Mars");
        assertEquals(planetsC.get(3), "Pluto");
        assertEquals(planetsC.get(4), "Saturnus");
        assertEquals(planetsC.get(5), "Venus");
    }

}

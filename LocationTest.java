import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test implementation of the Location class.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
public class LocationTest
{
    Location startLocation;
    Location destination;
    Location otherLocation;

    /**
     * Default constructor for test class LocationTest
     */
    public LocationTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        startLocation = new Location(1, 2);
        destination = new Location(2, 2);
        otherLocation = new Location(3, 2);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test the distance method of the Location class.
     */
    @Test
    public void testDistance()
    {
        assertEquals(startLocation.distance(new Location(5, 7)), 5);
        assertEquals(startLocation.distance(destination), 1);
        //Misma prueba utilizando otra aserción:
        assertTrue(startLocation.distance(destination) == 1);
    }

    /**
     * Run tests of the nextLocation method of the Location class.
     */
    @Test
    public void testAdjacentLocations()
    {
        Location siguiente = startLocation.nextLocation(new Location(5, 7));
        assertEquals(siguiente, new Location(2, 3));
        siguiente = siguiente.nextLocation(new Location(5, 7));
        assertEquals(siguiente, new Location(3, 4));
        siguiente = siguiente.nextLocation(new Location(5, 7));
        assertEquals(siguiente, new Location(4, 5));
        siguiente = siguiente.nextLocation(new Location(5, 7));
        assertEquals(siguiente, new Location(5, 6));
        siguiente = siguiente.nextLocation(new Location(5, 7));
        assertEquals(siguiente, new Location(5, 7));
         
        Location otherSiguiente = otherLocation.nextLocation(new Location(2, 1));
        assertEquals(otherSiguiente, new Location(2, 1));
        otherSiguiente = otherSiguiente.nextLocation(new Location(2, 1));
        assertEquals(otherSiguiente, new Location(2, 1));
    }
}

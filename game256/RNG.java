
/**
 * Write a description of class RNG here.
 *
 * @author (Sai Vaishnavi Alla)
 * @version (a version number or a date)
 */
public class RNG
{
    // instance variables - replace the example below with your own
    private int minimumValue;
    private int maximumValue;

    /**
     * Constructor for objects of class RNG
     */
    public RNG()
    {
        // initialise instance variables
        maximumValue = 1;
        minimumValue = 0;
    }
    /**
     * Non Default constructer of class RNG
     * @param newMaximumValue Integer which sets the maximum value
     * @param newMinimumValue Integer which sets the minimum value
     * 
     */
    public RNG(int newMaximumValue,int newMinimumValue)
    {
        //Number initialise instance variables
        maximumValue = newMaximumValue;
        minimumValue = newMinimumValue;
              
    }
    /**
     * random function generates a random value and is converted into int at the last
     * @return A random integer 
     */
    public int generateRandomNumber()
    {
        return (int)(Math.random() * (maximumValue - minimumValue + 1) + minimumValue);
    }   
    
    
}


/**
 * Write a description of class Multiple here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Multiple
{
    // instance variables - replace the example below with your own
    private int value;

    /**
     *  Default Constructor for objects of class Multiple
     */
    public Multiple()
    {
        // initialise instance variables
        value = 0;
    }

    /**
     * Non-Default Constructor for objects of class Multiple
     * @param newValue is the new integer value
     */
    public Multiple(int newValue)
    {
        value = newValue;
    }
    
    /**
     *Accessor method for class Multiple 
     *@return the integer value
     */
    public int getValue()
    {
       return value; 
    }
    /**
     *Mutator method for class Multiple 
     *@param newValue is the new integer value
     */
    public void setValue(int newValue)
    {
        value=newValue;
    }
    
}


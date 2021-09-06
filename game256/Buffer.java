
/**
 * Write a description of class Buffer here.
 *
 * @author (Sai Vaishnavi Alla)
 * @version (a version number or a date)
 */
import java.util.*;
public class Buffer
{
    // instance variables - replace the example below with your own
    private ArrayList<Multiple> list;
    private int maxElements ;

    /**
     * Constructor for objects of class Buffer
     */
    public Buffer()
    {
        // initialise instance variables
        list = new ArrayList<>();
        maxElements = 5;
    }

    /**
     * Non Default Constructer for objects of clas Buffer
     * @param   newList is a new ArrayList of type Multiple
     * @param   newMaxElements is the integer value of the new maximum elements
     */
    public Buffer(ArrayList<Multiple> newList,int newMaxElements)
    {
        list = newList;
        maxElements = newMaxElements;
    }

    /**
     * Method to split the Buffer
     * @param total is the integer total passed to the Split Method
     * 
     */
    public void split(int total)
    {
        Multiple multi = new Multiple();
        if(list.size() < maxElements)
        {
            multi.setValue(total);
            list.add(multi);
        }
        else
            System.out.println("Buffer Length Exceded!!");
    }

    /**
     * Method to Merge into the Buffer
     * @param total is the integer total passed to the Merge Method
     * @return total integer after merging the values 
     */
    public int merge(int total)
    {
        Multiple multi = new Multiple();
        int result = 0;

        for(int i=0;i<list.size();i++)
        {
            if(total == list.get(i).getValue())
            {
                int value = list.get(i).getValue();
                list.remove(i);
                result = value + total;
                multi.setValue(result); 
                //total = result;
            }

        }
        return result ;
    }

    /**
     * Accessor method to return the List
     *
     * @return    the entire List as an arraylist
     */
    public ArrayList<Multiple> getList()
    {
        return list;
    }

    /**
     * Accessor method to return a specific item in the collection
     *
     * @param     a specific index in the collection
     * @return    The value of the list at a particular index
     */
    public Multiple getSpecificList(int index)
    {
        return list.get(index);
    }

    /**
     * Mutator method to set value of new ArrayList
     * 
     * @param       newList be the new Array List of type Multiple
     */
    public void setList(ArrayList<Multiple> newList)
    {
        this.list = newList;
    }

    /**
     * Mutator method to set value of maxElements
     * 
     * @param       newMaxElements be the new maximum elements of type int
     */
    public void setMaxElements(int newMaxElements)
    {
        maxElements = newMaxElements;
    }
     /**
     * Method to return the size of the list
     * 
     * @return  Integer list size
     */
    public int getSize()
    {
        return list.size();
    }

    /**
     * Accessor method to return the maxElements
     *
     * @return   The maxElements in the buffer
     */
    public int getMaxElements()
    {
        return maxElements;
    }

    /**
     *  Method to Display Elements of the List
     * 
     */
    public void displayList()
    {
        for(Multiple multi : list)
        {
            System.out.println("["+multi.getValue()+"]");
        }
    }
    
    /**
     * Method to set Elements to the List
     * 
     */
    public void setElement(int[] fileContents)
    {
        Multiple multi = new Multiple();
        for(int i=0;i<fileContents.length;i++)
        {
            multi.setValue(fileContents[i]);
            list.add(multi);
        }
    }

}

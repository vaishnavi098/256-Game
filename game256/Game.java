
/**
 * Write a description of class Game here.
 *
 * @author (Sai vaishnavi Alla)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
import java.lang.*;
public class Game
{
    // instance variables - replace the example below with your own
    private String playerName ;
    private int gameTotal;
    private ArrayList<Buffer> multipleList;
    /**
     *  Default Constructor for objects of class Game
     */
    public Game()
    {
        playerName= "";
        gameTotal=0;
        multipleList = new ArrayList<Buffer>();
    }

    /**
     * Non-Default Constructor for objects of class Game
     * @param newPlayerName is the name of the new Player
     * @param newGameTotal is the new total of the game
     */
    public Game(String newPlayerName,int newGameTotal,ArrayList<Buffer> newMultipleList)
    {
        playerName= newPlayerName;
        gameTotal=newGameTotal;
        multipleList = newMultipleList;
    }

    /**
     * Start game class
     */
    public void start()
    {
        try{
            displayMenu();
            Scanner console = new Scanner(System.in);
            int option = console.nextInt();
            do{

                switch(option)
                {
                    case 1 :
                    {
                        option1();
                        System.out.println("\n");
                        displayMenu();
                        option = console.nextInt();
                    }
                    break;
                    case 2 :
                    {
                        if(stringIsBlank(playerName) == true)
                        {
                            System.out.println("Please register yourself first !!");
                            option1();
                            option2();
                            System.out.println("\n");
                            displayMenu();
                            option = console.nextInt();
                        }
                        else
                        {
                            option2();
                            System.out.println("\n");
                            displayMenu();
                            option = console.nextInt();
                        }
                    }
                    break;
                    case 3 :
                    {
                        option3();
                        System.out.println("\n");
                        displayMenu();
                        option = console.nextInt();
                    }
                    break;
                    case 4 : System.exit(0);
                    break;
                    default  :
                    {
                        System.out.println("Please Enter a Valid number in the menu\n");
                        displayMenu();
                        option = console.nextInt();
                    }
                    break;
                }
            }while((option >=1 && option < 4) || option > 4 || option <1);
        }
        catch(Exception e)
        {
            System.out.println("Please Enter from the given List of Options only ");
            start();
        }
    }
/**
 * Displays the  Start Menu 
 * 
 */
    public void displayMenu()
    {
        System.out.println("Please select from the following options");
        System.out.println("Press 1 to register the player");
        System.out.println("Press 2 to start the game");
        System.out.println("Press 3 to view the help menu");
        System.out.println("Press 4 to exit");
        System.out.println("Please select an option :");
    }

    /**
     *  Method if player chooses option 1
     */
    public void option1()
    {
        Scanner console = new Scanner(System.in);
        System.out.println(" Enter Player Name : \n");
        playerName = console.nextLine();
        if(playerName.trim().length() >= 3 && playerName.trim().length() <= 10 )
        {
            System.out.println("Registration Complete");
            System.out.println("\n");
            System.out.println("Welcome "+playerName);
        }
        else
        {
            System.out.println(" Enter a name between 3-10 characters :" );
            playerName = console.nextLine();
            System.out.println("Registration Complete");
            System.out.println("\n");
            System.out.println("Welcome  "+playerName);
        }
    }

    /**
     * 
     * Method if player Chooses option 2
     */
    public void option2()
    {
        Scanner console = new Scanner(System.in);
        Buffer b1 = new Buffer();
        Buffer b2 = new Buffer();

        boolean check1;

        int maximum = 0;
        String s = read();
        try
        {
            System.out.println("Please select from the following List of the options :");
            System.out.println("Press 1 to Play Easy Mode");
            System.out.println("Press 2 to Play Medium Mode");
            System.out.println("Press 3 to Play Hard Mode");
            int mode = console.nextInt();
            if(mode==1)
            {
                b1.setMaxElements(9);
                b2.setMaxElements(7);
            }
            else if(mode==2)
            {
                b1.setMaxElements(7);
                b2.setMaxElements(5);
            }
            else if(mode==3)
            {
                b1.setMaxElements(5);
                b2.setMaxElements(3);
            }
            System.out.println("Please select from the following List of the options :");
            System.out.println("Please 1 to select the multiples 2 4 8 ");
            System.out.println("Please 2 to select the multiples 3 9 27 ");
            System.out.println("Please 3 to select the multiples 4 16 64 ");
            int select = console.nextInt();
            if(select ==1 || select==2 ||select ==3)
            {
                System.out.println("\n");
                System.out.println("Enter the Maximum Score You want To Play : ");
                maximum = console.nextInt();
                if(maximum >= 32 && maximum %8 ==0)
                {
                    setBuffer(s);
                    int num =read1(select);
                    gameTotal = num;
                    boolean proceed = true;
                    while(gameTotal < maximum && b1.getSize() <= b1.getMaxElements() && proceed == true && b2.getSize() <= b2.getMaxElements())
                    {   
                        System.out.println("Randomly Generated Number :\t"+gameTotal);
                        displayMenu2();
                        int option = console.nextInt();
                        switch(option)
                        {
                            case 1: 
                            {
                                if(b2.getSize()<b2.getMaxElements())
                                {
                                    b2.split(gameTotal);
                                    System.out.println("Left Buffer");
                                    b1.displayList();
                                    System.out.println("Right Buffer");
                                    b2.displayList();
                                    num = read1(select);
                                    gameTotal = num;
                                    proceed = true;
                                }
                                else 
                                    proceed = false;                         
                            }
                            break;
                            case 2 :
                            {
                                if(gameTotal != 0 && b2.getSize()!= 0 && b2.getSize()<=b2.getMaxElements() )
                                {
                                    int total = b2.merge(gameTotal);
                                    gameTotal = total;
                                    System.out.println("Left Buffer");
                                    b1.displayList();
                                    System.out.println("Right Buffer");
                                    b2.displayList();
                                    proceed = true;
                                }
                                else
                                {
                                    System.out.println("\n Merge not Possible !!");
                                }
                            }
                            break;
                            case 3:
                            {
                                if(b1.getSize()<b1.getMaxElements())
                                {
                                    b1.split(gameTotal);
                                    System.out.println("Left Buffer");
                                    b1.displayList();
                                    System.out.println("Right Buffer");
                                    b2.displayList();
                                    num = read1(select);
                                    gameTotal = num;
                                    proceed = true;
                                }
                                else 
                                    proceed = false;    
                            }
                            break;
                            case 4 :
                            {
                                if(gameTotal != 0 && b1.getSize()!= 0 && b1.getSize()<=b1.getMaxElements() )
                                {
                                    int total = b1.merge(gameTotal);
                                    gameTotal = total;
                                    System.out.println("Left Buffer");
                                    b1.displayList();
                                    System.out.println("Right Buffer");
                                    b2.displayList();
                                    proceed = true;
                                }
                                else
                                {
                                    System.out.println("\n Merge not Possible !!");
                                }
                            }
                            break;
                            default :System.out.println("Enter option 1 or 2 only ");
                            break;
                        }
                    }
                }
                else
                {
                    System.out.println("Enter a valid Maximum Score ");
                    option2();
                }
            }
            else
            {
                System.out.println("Enter a Valid Option");
                option2();
            }
        }
        catch(Exception e)
        {
            System.out.println("Please Enter from the Given Options Only");
            option2();
        }

        if(b1.getSize() >= b1.getMaxElements() || gameTotal >= maximum ||b2.getSize()<=b2.getMaxElements())
        {
            System.out.println("Game Over!!");
            check1 = true;
        }
        else
        {
            System.out.println("You have won the game");
            check1 = false;
        }
        result(maximum,check1);
    }

    /**
     * Method that displays and checks the game result
     * 
     */
    public void result(int max,boolean check)
    {
        Buffer buffer = new Buffer();
        FileIO io = new FileIO();
        if(gameTotal >= max && check == true)
        {
            String display = playerName +" has won with a high score of " +gameTotal;
            io.writeFile(display);
        }
        else
        {
            String display1 = playerName +" has lost with a  score of " +gameTotal;
            io.writeFile(display1);
        }
    }
/**
 * Method to display the Player moves Menu
 * 
 */
    public void displayMenu2()
    {
        System.out.println("Press 1 to Split Right(->) ");
        System.out.println("Press 2 to Merge Right(<- <-)");
        System.out.println("Press 3 to Split Left(<-)");
        System.out.println("Press 4 to Merge Left(-> ->)");
    }

    /**
     * Method read to read the input File
     * 
     * @return String of the input
     */
    public String read()
    {
        FileIO io = new FileIO();
        String input = io.readFile();
        return input;
    }

    /**
     * 
     * Method to set Buffer values into the multipleList
     * 
     */
    public void setBuffer(String s)
    {
        Buffer buffer=new Buffer();
        int random=0;

        Buffer ob1 = new Buffer();
        Buffer ob2 = new Buffer();
        Buffer ob3 = new Buffer();
        String[] inputArray = s.split("\n");
        String twoString = inputArray[0];
        String[] twoArray = twoString.split(",");
        String threeString = inputArray[1];
        String[] threeArray = threeString.split(",");
        String fourString = inputArray[2];
        String[] fourArray = fourString.split(",");

        int[] fileContents1 = new int[3];
        int[] fileContents2 = new int[3];
        int[] fileContents3 = new int[3];
        for(int i=0;i<twoArray.length;i++)
        {
            fileContents1[i] = Integer.parseInt(twoArray[i]);
        }
        ob1.setElement(fileContents1);

        for(int i=0;i<threeArray.length;i++)
        {
            fileContents2[i] = Integer.parseInt(threeArray[i]);
        }
        ob2.setElement(fileContents2);

        for(int i=0;i<fourArray.length;i++)
        {
            fileContents3[i] = Integer.parseInt(fourArray[i]);
        }
        ob3.setElement(fileContents3);
        multipleList.add(ob1);
        multipleList.add(ob2);
        multipleList.add(ob3);
        //return random;
    }
/**
 *Method to get the random number 
 *
 * @return random number of integer type
 */
    public int read1(int select)
    {
        int number = 0;
        int random = 0;
        RNG rng = new RNG(2,0);
        number = rng.generateRandomNumber();
        switch(select)
        {
            case 1 :
            {
                random = multipleList.get(0).getSpecificList(number).getValue();
            }
            break;
            case 2 :
            {
                random = multipleList.get(1).getSpecificList(number).getValue();
            }
            break;
            case 3 :
            {
                random = multipleList.get(2).getSpecificList(number).getValue();
            }
            break;
            default : 
            break;
        }
        return random;
    }

    /**
     * Method to Display Menu
     * 
     */
    public void option3()
    {
        System.out.println("------HELP MENU-------");
        System.out.println("1. The game starts by registering a player to play the game.\n"+
            "2. The Arraylist buffer (b1) is empty.\n "+
            "3. The game then provides a random multiple to the player which\n is stored in the game total from the available multiples."+
            "4. The player can then perform the following actions:\n"+
            " 1->Split\n"+
            "a) This allows the player to move the number from the game total (t)\n and add it to the arraylist buffer (b1).\n"+
            " 2->Merge \n"+
            "a) This allows the player to merge the number in the game total box with \n a matching number in the arraylist at any position. The total is then put \n"+
            "in the game total box and the number which is added is then removed from the arraylist.\n"+
            "5. The game ends when either of the following occur\n"+
            "  a) The game total reaches a total of 256 or higher.\n"+
            " b)The arraylist buffer (b1) has reached the maximum limit of 5 numbers and no more \n"+
            "numbers can be stored and none of the existing numbers can be merged to the game total (t).");
    }

    /**
     *  Method to check if the Name string is blank
     *  @return true or false boolean value
     */
    public boolean stringIsBlank(String value)
    {
        boolean blank = true;
        if (value.trim().length() > 0)
            blank = false;
        return blank;
    }

}

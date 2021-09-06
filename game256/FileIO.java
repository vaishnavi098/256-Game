//import libraries here

/**
 * Class to read and write a string to a file
 *
 * @author <<INSERT NAME>>
 * @version <<INSERT DATE>>
 */
import java.io.*;
import java.util.*;
public class FileIO
{
    //Declare fields here
    private String fileName;
    /**
     * Default constructor to initialize the object of the FileIO class
     * 
     */
    public  FileIO()
    {
        fileName="";
    }
    /**
     * Non default constructor to initialize the object of the FileIO class
     * 
     * @param newFileName Name of the file to be read or written to
     */
    public FileIO(String newFileName)
    {
        fileName=newFileName;
    }
    /**
     * Accessor Method to get the filename
     * 
     * @return A single string which represents the file name being read or written to
     */
    public String getFileName()
    {
        return fileName;
    }
    /**
     * Method to read the contents from the file
     * 
     * @return A entire contents of the file represented as a single string. New lines are delimited with a \n
     */
    public String readFile()
    {
        fileName = ("multiples.txt");
        String input = "";
        if(fileName.trim().length() > 0)
        {
        try
        {
            FileReader fileReader = new FileReader(fileName);
            try
            {
                Scanner scanner = new Scanner(fileReader);
                while(scanner.hasNextLine())
                {
                input+=scanner.nextLine();
                input += "\n";
                }
            }
            finally
            {
                fileReader.close();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println(fileName+"Not found");
        }
        catch(IOException e)
        {
            System.out.println("I/O Exception");
        }
    }
        return input;
    }
    /**
     * Mutator Method to set the filename
     * 
     * @param newFileName Name of the file to be read or written to
     */
    public void setfileName(String newFileName)
    {
        fileName=newFileName;
    }
    /**
     * Method to write the contents to a file
     * 
     * @param contents Complete string which is to be written to the file. New lines need to be delimited with a \n
     */
    public void writeFile(String contents)
    {
        fileName = ("output.txt");
        try
        {
            PrintWriter printWriter = new PrintWriter(fileName);
            try
            {
                printWriter.println(contents);
            }
            finally
            {
                printWriter.close();
            }
        }
        catch(IOException e)
        {
            System.out.println("I/O Exception");
        }
    }
}

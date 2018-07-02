import java.util.*;//import the java.util package
import javax.swing.JOptionPane;//import the JOptionPane Class
import java.io.*;//import the java.io package
/*
 * Author: Sakin Haider
 * Due Date: May 26th, 2016
 * Purpose: Abstract class for other specific unit classes to extend
 */
public abstract class Unit
{
    static Scanner scan;//Scanner scan to take in user input
    static Scanner fileScan;//Scanner fileScan to read from a text file
    static ArrayList<Question> questions;//ArrayList of type Question called questions
    String NotesFile;//public String variable to hold the name of the file used for the ReadNotes() method
    String QuizFile;//public String variable to hold the name of the file used for the DoQuiz() method
    /*
     * The ReadNotes method is run when the user 
     * presses the button to read notes. It takes
     * in a String for the fileName. The fileName is
     * set to the correct file when a button is pressed.
     * It will then scan the text file and print it out
     */
    public void ReadNotes() throws FileNotFoundException
    {
        try//Creating the scanner object can throw an exception
        {
            fileScan = new Scanner(new File(NotesFile));//Create the Scanner with standard input from fileName
        }
        catch(FileNotFoundException FNFE)//Catch the possible FileNotFoundException thrown by the creation of the scanner
        {
            System.out.println("Something went wrong at: ");//Tell the user that something went wrong
            FNFE.printStackTrace();//Print the stacktrace to show the user where the exception occured
        }
        fileScan.useDelimiter("_");//set the delimiter of the Scanner to _
        String output = null;//Create value output and assign a value of null
        while(fileScan.hasNext())//While Not EOF
        {
            output = fileScan.next();//Set until the delimiter to the output variable
            if(output.trim().equalsIgnoreCase("END"))//if the variable contains END
            {
                break;//break from the loop
            }
            else//if the variable contains something other than END
            {
                System.out.println(output);//Print out the variable
            }
        }
    }

    public abstract void PlayGame();

    /*
     * The DoQuiz method is run when the user
     * clicks the button to do the quiz 
     * The correct fileName for the quiz is chosen
     * when the topic is chosen from the GUI
     * 
     * Creates the necessary Scanner objects
     * Fills the ArrayList with all of the Question objects
     * Prints the question and allows the user to answer
     * Prints out the users score as a percentage
     */
    public void DoQuiz() throws FileNotFoundException
    {
        scan = new Scanner(System.in);//Instantiate the Scanner scan object with System.in
        questions = new ArrayList<Question>();//Instantiate the ArrayList questions object 
        try//Creating the fileScan Scanner object can throw an exception
        {
            fileScan = new Scanner(new File(QuizFile));//Create the Scanner with standard input from fileName
        }
        catch(FileNotFoundException FNFE)//Catch the possible FileNotFoundException thrown by the creation of the scanner
        {
            System.out.println("Something went wrong at: ");//Tell the user that something went wrong
            FNFE.printStackTrace();//Print the stackTrace to show the user where the exception occured
        }

        fileScan.useDelimiter("_");//set the delimiter of the Scanner to _
        String q = null;//create String variable to hold the question and set to null
        String ans = null;//create String variable to hold the answer and set to null
        while(fileScan.hasNext())//while !EOF
        {
            q = fileScan.next();//assign the next delimiter as the question
            ans = fileScan.next();//assign the next delimiter as the answer
            questions.add(new Question(q,ans));//create the Question object with the question and the answer and add to the questions ArrayList
        }

        System.out.println("There are " + questions.size() + " questions for this topic.\n\n");
        String input = null;//create a variable to hold the user input and set to null
        double correct = 0;//create a variable to record the number of correct answers and set to 0
        Scanner scan2 = new Scanner(System.in);
        for(int i = 0; i < questions.size(); i++)//loop through the entire questions ArrayList
        {
            //System.out.println(questions.get(i).getQuestion());//Print out the question of the Question object in the ArrayList
            //input = scan2.nextInt();//Save the user input in the input variable
            input = JOptionPane.showInputDialog(questions.get(i).getQuestion());
            if(input == null)
            {
                break;
            }
            else if(questions.get(i).getAnswer().trim().equalsIgnoreCase(input.trim()))//if the answer to the question is the same as the user input
            {
                System.out.println("Correct!");//Tell the user they are right
                correct++;//increment correct answers
            }
            else//if the answer to the question is not the same as the user input
            {
                System.out.println("Wrong! Correct answer was: ");//Tell the user they are wrong and tell them the correct answer
                System.out.println(questions.get(i).getAnswer().trim());//Print the correct answer to the question
            }
        }

        System.out.println("Your score: " + (correct/questions.size())*100 + "%");//print out the users total score in percentage
    }
}
import java.util.*;//Import the java.util package
import java.io.*;//Import the java.io package
/*
 * Author: Sakin Haider
 * Date: May 26th, 2016
 * Purpose: Class to represent the Decision_Iterations Unit
 * This class has two variables, the fileNames for the readNotes and DoQuiz method implemented in Unit
 */
public class Decision_Iterations
extends Unit
{
    /*
     * Null constructor
     * Sets both instance variables to null 
     * Used to create null objects to test methods
     */
    public Decision_Iterations()
    {
        NotesFile = null;//set NotesFile instance variable as null
        QuizFile = null;//set QuizFile instance variable as null
    }

    /*
     * Real constructor
     * Sets both instance variables to the Strings put as the parameters
     * Objects of this class have the respective file names used in the readNotes and DoQuiz methodd
     */
    public Decision_Iterations(String NFileIn, String QFileIn)
    {
        NotesFile = NFileIn;//set NotesFile instance variable as NFileIn. This will be the name of the file used for the ReadNotes() method
        QuizFile = QFileIn;//set QuizFile instance variable as QFileIn. Thi will be the name of the file used for the doQuiz() method
    }

    public void PlayGame()
    {

    }

}
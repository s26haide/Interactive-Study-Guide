import java.util.*;//Import java.util package
import java.awt.*;//Import java.awt package
import javax.swing.*;//Import javax.swing package
import java.awt.event.*;//Import java.awt.event package
import java.io.*;//Import java.io package
/*
 * Author: Sakin Haider
 * Due Date: May 26
 * Purpose: Class for the GUI of the program
 * RUN THIS CLASS TO START THE PROGRAM
 */
public class GUI
{
    static ArrayList<JButton> buttons;//ArrayList of JButtons called buttons
    static JButton button;//JButton variable called button; used with polymorphism to create all of the JButtons
    static Scanner scan;//Scanner scan to take in user input
    static Scanner fileScan;//Scanner fileScan to read in from a textfile
    static JFrame frame;//JFrame frame to show the first panel
    static JFrame frame2;//JFrame frame2 to show the second panel
    static JPanel panel;//JPanel panel to hold all of the buttons for the first frame
    static JPanel panel2;//JPanel panel2 to hold all of the buttons for the second frame
    static Unit topic;//Unit object to create objects of Unit children
    static String noteFileName;//String noteFileName is assigned a value based on the button pressed and used in the ReadNotes() method
    static String quizFileName;//String quizFileName is assigned a value based on the button pressed and used in the PlayGame() method
    /*
     * Main method of the GUI class
     * Creates all of the necessary objects
     * Adds all of the buttons to their respective panel
     * Adds the panel to the respective frame
     * Throws FileNotFoundException for the fileScan Scanner reading the button labels
     * 
     */
    public static void main (String []args)
    {
        scan = new Scanner(System.in);//Create Scanner object scan
        try
        {
            fileScan = new Scanner(new File("ButtonLabels.txt"), "UTF-8");//Create Scanner object fileScan with new File
        }
        catch(FileNotFoundException FNFE)
        {
            FNFE.printStackTrace();
        }
        fileScan.useDelimiter("_");//Use delimiter on the fileScan Scanner
        buttons = new ArrayList<JButton>();//Create the ArrayList of JButtons to hold all of the buttons used
        ClickListener listener = new ClickListener();//Create a new ClickListener object to add to the buttons
        JPanel panel = new JPanel();//Create a new panel

        /*
         * Polymorphism in this for loop because the reference variable button
         * is used to refer to a new button every iteration of the loop
         */
        for(int i = 0; i < 12; i++)//Loop 12 times because we want to create the first 12 buttons
        {
            button = new JButton();//Create new JButton object
            button.setPreferredSize(new Dimension(250,100));
            buttons.add(button);//Add the JButton objet to the buttons ArrayList
            buttons.get(i).addActionListener(listener);//Add the ActionListener to each button when it is added
            buttons.get(i).setLabel(fileScan.next());//Set the label of the buttons from the textfile with fileScan
            panel.add(buttons.get(i));//add the buttons to the panel
        }

        frame = new JFrame("CHOOSE YOUR TOPIC");//Create JFrame object with a label
        frame.setSize(750,700);//Set the size of the frame
        frame.setLocationRelativeTo(null);///Set the location of the frame to the center of the screen
        frame.setVisible(true);//Set the frame to visible
        frame.setContentPane(panel);//set the panel onto the frame

        frame2 = new JFrame("CHOOSE HOW YOU WANT TO STUDY");//Create a second JFrame with a label
        frame2.setSize(750,400);//Set the size of second JFrame
        frame2.setLocationRelativeTo(null);//Set the location of the second JFrame to the center of the screen
        //*******FRAME2 IS NOT SET TO VISIBLE*********\\
        JPanel panel2 = new JPanel();//Create a second panel
        for(int i = 12; i < 14; i++)//Continue the loop from before from 12 and go 3 more to create the next 3 buttons
        {
            button = new JButton();//Create a new button object
            button.setPreferredSize(new Dimension(250,50));
            buttons.add(button);//add the button to the buttons ArrayList
            buttons.get(i).addActionListener(listener);//Add the ActionListener to the new button
            buttons.get(i).setLabel(fileScan.next());//set the Label of the button from the textfile
            panel2.add(buttons.get(i));//add the button to the second panel
        }
        frame2.setContentPane(panel2);//Show panel2 on frame2
    }

    /*
     * ClickListener class implements ActionListener
     * actionPerformed method runs whenever a button with a ClickListener is clicked
     */
    public static class ClickListener implements ActionListener
    {
        /*
         * Prints the label of the button clicked
         * Sets frame2 to visible
         * Sets frame to invisible after a button is clicked(after a topic is selected)
         */
        public void actionPerformed(ActionEvent action)
        {
            //System.out.println(action.getActionCommand());//Print the string of the button
            /*
             * Polymorphism in this if statement because topic is of type Unit which is the parent class of all these other classes
             * topic refers to different objects depending on what the user chooses to study
             */
            if(action.getSource() == buttons.get(0))//if the source of the action is the 1st button (Problem Solving)
            {
                noteFileName = "ProblemSolvingNotes.txt";//set noteFileName to the ProblemSolvingNotes text document
                quizFileName = "ProblemSolvingQuiz.txt";//set quizFileName to the ProblemSolvingQuiz text document
                topic = new ProblemSolving(noteFileName, quizFileName);//Create new ProblemSolving object if ProblemSolving is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(1))//if the source of the action is the 2nd button(Pseudocode)
            {
                noteFileName = "PseudocodeNotes.txt";//set noteFileName to the PseudocodeNotes text document
                quizFileName = "PseudocodeQuiz.txt";//set quizFileName to the PseudocodeQuiz text document
                topic = new Pseudocode(noteFileName, quizFileName);//Create new Pseudocode object if Pseudocode is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(2))//if the source of the action is the 3rd button(FlowCharts)
            {
                noteFileName = "FlowChartsNotes.txt";//set noteFileName to the FlowChartsNotes text document
                quizFileName = "FlowChartsQuiz.txt";//set quizFileName to the FlowChartsQuiz text document
                topic = new FlowCharts(noteFileName, quizFileName);//Create new FlowCharts object if FlowCharts is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(3))//if the source of the action is the 4th button (Introduction_JAVA)
            {
                noteFileName = "Introduction_JAVANotes.txt";//set noteFileName to the Introduction_JAVANotes text document
                quizFileName = "Introduction_JAVAQuiz.txt";//set quizFileName to the Introduction_JAVAQuiz text document
                topic = new Introduction_JAVA(noteFileName, quizFileName);//Create new Introduction_JAVA object if Introduction_JAVA is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(4))//if the source of the action is the 5th button (Variables_DataTypes)
            {
                noteFileName = "Variables_DataTypesNotes.txt";//set noteFileName to the Variables_DataTypesNotes text document
                quizFileName = "Variables_DataTypesQuiz.txt";//set quizFileName to the Variables_DataTypesQuiz text document
                topic = new Variables_DataTypes(noteFileName, quizFileName);//Create new Variables_DataTypes object if Variables_DataTypes is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(5))//if the source of the action is the 6th button(UserInputOutput)
            {
                noteFileName = "InputOutputNotes.txt";//set noteFileName to the InputOutputNotes text document
                quizFileName = "InputOutputQuiz.txt";//set quizFileName to the InputOutputQuiz text document
                topic = new UserInputOutput(noteFileName, quizFileName);//Create new UserInputOutput object if UserInputOutput is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(6))//if the source of the action is the 7th button(Decision_Iterations)
            {
                noteFileName = "Decision_IterationsNotes.txt";//set noteFileName to the Decision_IterationsNotes text document
                quizFileName = "Decision_IterationsQuiz.txt";//set quizFileName to the Decision_IterationsQuiz text document
                topic = new Decision_Iterations(noteFileName, quizFileName);//Create new Decision_Iterations object if Decision_Iteration is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(7))//if the source of the action is the 8th button(Methods)
            {
                noteFileName = "MethodsNotes.txt";//set noteFileName to the MethodsNotes text document
                quizFileName = "MethodsQuiz.txt";//set quizFileName to the MethodsQuiz text document
                topic = new Methods(noteFileName, quizFileName);//Create new Methods object if Methods is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(8))//if the source of the action is the 9th button(NestedLoops)
            {
                noteFileName = "NestedLoopsNotes.txt";//set noteFileName to the NestedLoopsNotes text document
                quizFileName = "NestedLoopsQuiz.txt";//set quizFileName to the NestedLoopsQuiz text document
                topic = new NestedLoops(noteFileName, quizFileName);//Create new NestedLoops object if NestedLoops is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(9))//if the source of the action is the 10th button(Classes_Objects)
            {
                noteFileName = "Classes_ObjectsNotes.txt";//set noteFileName to the Classes_ObjectsNotes text document
                quizFileName = "Classes_ObjectsQuiz.txt";//set quizFileName to the Classes_ObjectsQuiz text document
                topic = new Classes_Objects(noteFileName, quizFileName);//Create new Classes_Objects object if Classes_Objects is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(10))//if the source of the action is the 11th button(Object_Class_References)
            {
                noteFileName = "Object_Class_ReferencesNotes.txt";//set noteFileName to the Object_Class_ReferencesNotes text document
                quizFileName = "Object_Class_ReferencesQuiz.txt";//set quizFileName to the Object_Class_ReferencesQuiz text document
                topic = new Object_Class_References(noteFileName, quizFileName);//Create new Object_Class_References object if Object_Class_References is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(11))//if the source of the action is the 12th button(Arrays)
            {
                noteFileName = "ArraysNotes.txt";//set noteFileName to the ArraysNotes text document
                quizFileName = "ArraysQuiz.txt";//set quizFileName to the ArraysQuiz text document
                topic = new Arrays(noteFileName, quizFileName);//Create new Arrays object if Arrays is chosen
                System.out.print('\u000C');//Clear screen
                frame2.setVisible(true);//Open the second JFrame
                frame.setVisible(false);//Close the first JFrame
            }
            else if(action.getSource() == buttons.get(12))//if the source of the action is the 13th button(Read Notes)
            {
                try//try because this method might throw a FileNotFoundException
                {
                    topic.ReadNotes();//use the topic object to run the ReadNotes method using the noteFileName set based on the button pressed
                }
                catch(FileNotFoundException FNFE)//catch the possible FileNotFoundException
                {
                    System.out.println("Something went wrong at: ");//Tell the user that something went wrong
                    FNFE.printStackTrace();//show the user where the exception occured with a stackTrace
                }
                frame2.setVisible(false);//Close the second JFrame
                frame.setVisible(true);//Open the first JFrame
            }
            /*
            else if(action.getSource() == buttons.get(13))//if the source of the action is the 14th button(Play Game)
            {
            try
            {
            topic.PlayGame();//use the topic object to run the PlayGame method of the class of topic
            }
            catch(Exception exception)
            {
            System.out.println("Something went wrong at: ");//Tell the user that something went wrong
            exception.printStackTrace();//show the user where the exception occurred with a stackTrace
            }
            frame2.setVisible(false);//Close the second JFrame
            frame.setVisible(true);//Open the first JFrame
            }
             */
            else if(action.getSource() == buttons.get(13))//if the source of the action is the 15th button(Take Quiz)
            {
                try
                {
                    topic.DoQuiz();//use the topic object to run the DoQuiz method using the quizFileName text document
                }
                catch(FileNotFoundException FNFE)
                {
                    System.out.println("Something went wrong at: ");//Tell the user something went wrong
                    FNFE.printStackTrace();//show the user where the exception occured with a stackTrace
                }
                frame2.setVisible(false);//Close the second JFrame
                frame.setVisible(true);//Open the first JFrame
            }
        }
    }
}
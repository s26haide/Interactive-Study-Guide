/*
 * Author: Sakin Haider
 * Date: May 26th, 2016
 * Purpose: Concrete class for Questions
 * Questions have a question and an answer
 * Used in the DoQuiz() method
 */
public class Question
{
    /*
     * Null constructor
     * Sets the question and answer to null
     * Used to make null objects to test methods
     */
    public Question()
    {
        question = null;//set the question as null
        answer = null;//set the answer as null
    }

    /*
     * Real constructor
     * Takes in 2 Strings, and sets them
     * as the question and the answer respectively
     */
    public Question(String qIn, String ansIn)
    {
        question = qIn;//set the question as qIn;
        answer = ansIn;//set the answer as asnIn
    }

    /*
     * Simple accessor method
     * to return the question variable
     * Simple return statement
     */
    public String getQuestion()
    {
        return question;//return the question variable
    }

    /*
     * Simple accessor method
     * to return the answer variable
     * Simple return statement
     */
    public String getAnswer()
    {
        return answer;//return the answer variable
    }

    private String question;//Instance variable to hold the question
    private String answer;//Instance variable to hold the answer of the question
}
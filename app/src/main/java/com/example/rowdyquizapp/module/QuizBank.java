package com.example.rowdyquizapp.module;

import java.util.ArrayList;

public class QuizBank {
    private ArrayList<Question> questions;
    private int qIndex;
    private Question currentQuestion;

    public QuizBank()
    {
        questions = new ArrayList<Question>();
        qIndex = 0;
        currentQuestion=null;
    }

    public ArrayList<Question> getQuestions()
    {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions)
    {
        this.questions = questions;
    }

    public int getIndex()
    {
        return qIndex;
    }

    public void setIndex(int qIndex)
    {
        this.qIndex = qIndex;
    }

    public Question getCurrentQuestion()
    {
        int index = getIndex();
        if(index >= 0 && index < questions.size())
        {
            currentQuestion = questions.get(index);
            setIndex(index + 1);
        }else{
            setIndex(0);
            currentQuestion = questions.get(0);
        }
        return currentQuestion;
    }



    public void setCurrentQuestion(Question currentQuestion)
    {
        this.currentQuestion = currentQuestion;
    }

    public String getCurrentQuestionText()
    {
        return currentQuestion.getQuestion();
    }

    public boolean getCurrentQuestionAnswer()
    {
        return currentQuestion.getAnswer();
    }

    public void addQuestion(Question question)
    {
        if(question != null)
        {
            questions.add(question);
        }
    }

    public void loadQuestion()
    {
        addQuestion(new Question("Is our mascot a roadrunner", true));
        addQuestion(new Question( "Is water made of hydrogen and nitrogen", false));
        addQuestion(new Question("Is UTSA in San Antonio", true));
    }
}

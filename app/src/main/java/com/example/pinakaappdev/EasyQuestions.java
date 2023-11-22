package com.example.pinakaappdev;

public class EasyQuestions implements QuestionSet {
    public static String[] question ={
            "Smart",
            "Stupid",
            "Horrible",
            "Good",
            "Complete"
    };

    public static String answers [] = {
            "Bright",
            "Dumb",
            "Awful",
            "Excellent",
            "Accomplished"
    };

    public static String choices [][] = {
            {"Bright", "Perfect", "Specific", "Slow"},
            {"Good", "Dumb", "Clever", "Lazy"},
            {"Specific", "Show", "Curious", "Awful"},
            {"Excellent", "Bad", "Enjoy", "Mine"},
            {"Small", "Wrong", "Accomplished", "Still"}
    };

    @Override
    public String[] getQuestions() {
        return question;
    }

    @Override
    public String[][] getChoices() {
        return choices;
    }

    @Override
    public String[] getAnswers() {
        return answers;
    }

}

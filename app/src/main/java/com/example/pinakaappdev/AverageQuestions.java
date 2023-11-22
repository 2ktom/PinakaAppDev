package com.example.pinakaappdev;

public class AverageQuestions implements QuestionSet {
    public static String question[] ={
            "Irrevocable",
            "Accountability",
            "Ambiguous",
            "Gullible",
            "Skeptical",
            "Criticism",
            "Pretentious",
            "Adequate",
            "Circumstance",
            "Endeavor"
    };

    public static String answers [] = {
            "Final",
            "Responsibility",
            "Arguable",
            "Naive",
            "Doubtful",
            "Disapproval",
            "Showy",
            "Enough",
            "Situation",
            "Aspire"
    };

    public static String choices [][] = {
            {"Cautious", "Insufficient", "Final", "Praise"},
            {"Unalterable", "Trusting", "Responsibility", "Condition"},
            {"Arguable", "Abandon", "Situation", "Skeptical"},
            {"Genuine", "Naive", "Vague", "Liability"},
            {"Doubtful", "Approval", "Quit", "Clear"},
            {"Permanent", "Trusting", "Effort", "Disapproval"},
            {"Arrogant", "Suitable", "Showy", "Vague"},
            {"Uncertain", "Enough", "Abandon", "Reversible"},
            {"Irresponsibility", "Situation", "Gullible", "Rebuke"},
            {"Suspicious", "Cautious", "Aspire", "Situation"}
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

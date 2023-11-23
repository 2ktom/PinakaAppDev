package com.example.pinakaappdev;

public class DifficultQuestions implements QuestionSet {
    public static String question[] ={
            "Obfuscate",
            "Sycophant",
            "Pernicious",
            "Mellifluous",
            "Quixotic",
            "Ephemeral",
            "Ineffable",
            "Lugubrious",
            "Disparate",
            "Belligerent",
            "Recalcitrant",
            "Esoteric",
            "Pulchritudinous",
            "Insidious",
            "Nefarious"
    };

    public static String answers [] = {
            "Confuse",
            "Flatterer",
            "Harmful",
            "Harmonious",
            "Idealistic",
            "Momentary",
            "Indescribable",
            "Melancholy",
            "Different",
            "Hostile",
            "Stubborn",
            "Cryptic",
            "Attractive",
            "Sneaky",
            "Wicked"
    };

    public static String choices [][] = {
            {"Confuse", "Ugly", "Arcane", "Combative"},
            {"Everywhere", "Hostile", "Flatterer", "Defiant"},
            {"Plain", "Loyal", "Harmful", "Gorgeous"},
            {"Toady", "Harmonious", "Idealistic", "Unspeakable"},
            {"Critic", "Rebellious", "Honest", "Idealistic"},
            {"Momentary", "Simple", "Jarring", "Lasting"},
            {"Stimulating", "Indescribable", "Sedative", "Transient"},
            {"Melancholy", "Deceitful", "Trustworthy", "Cunning"},
            {"Different", "Stealthy", "Brief", "Pervasive"},
            {"Confuse", "Different", "Hostile", "Uncooperative"},
            {"Virtuous", "Stubborn", "Expressible", "Complex"},
            {"Stingy", "Loyal", "Brief", "Cryptic"},
            {"Attractive", "Quiet", "Energizing", "Generous"},
            {"Liberal", "Sneaky", "Honest", "Unattractive"},
            {"Flatterer", "Romantic", "Wicked", "Melodious"}
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

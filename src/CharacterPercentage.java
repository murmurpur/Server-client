public class CharacterPercentage {
    private String text;
    private double upperCasePercentage;
    private double lowerCasePercentage;

    public CharacterPercentage(String text) {
        this.text = text;
        calculatePercentages();
    }

    public CharacterPercentage() {
        this("");
    }

    private void calculatePercentages() {
        int length = text.length();
        int upperCaseCount = 0;
        int lowerCaseCount = 0;

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCaseCount++;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseCount++;
            }
        }

        upperCasePercentage = 100.0 * upperCaseCount / length;
        lowerCasePercentage = 100.0 * lowerCaseCount / length;
    }

    public double getUpperCasePercentage() {
        return upperCasePercentage;
    }

    public double getLowerCasePercentage() {
        return lowerCasePercentage;
    }

    public String getResult() {
        return "Text: " + text +
                "\nUppercase percentage: " + upperCasePercentage +
                "\nLowercase percentage: " + lowerCasePercentage;
    }

    public void setText(String text) {
        this.text = text;
        calculatePercentages();
    }
}

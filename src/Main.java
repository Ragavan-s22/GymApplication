import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Set the dark theme (if applicable, otherwise skip)
        DarkTheme.setDarkLaf();

        // Create and show the Gym GUI
        GymGUI gymGUI = new GymGUI();
        gymGUI.createAndShowGUI();
    }
}
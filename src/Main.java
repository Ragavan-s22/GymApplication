import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GymGUI gymGUI = new GymGUI();
            gymGUI.createAndShowGUI();
        });
    }
}

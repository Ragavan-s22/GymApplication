import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GymGUI {
    private Gym gym;

    public GymGUI() {
        gym = new Gym();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Gym Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(5, 1));

        JButton addUserButton = new JButton("Add a new user");
        JButton viewUserDetailsButton = new JButton("View user details");
        JButton saveDataButton = new JButton("Save data to file");
        JButton loadDataButton = new JButton("Load data from file");
        JButton exitButton = new JButton("Exit");

        contentPane.add(addUserButton);
        contentPane.add(viewUserDetailsButton);
        contentPane.add(saveDataButton);
        contentPane.add(loadDataButton);
        contentPane.add(exitButton);

        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });

        viewUserDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewUserDetails();
            }
        });

        saveDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveDataToFile();
            }
        });

        loadDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadDataFromFile();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    private void addUser() {
        String name = JOptionPane.showInputDialog("Enter user name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter user age:"));
        int height = Integer.parseInt(JOptionPane.showInputDialog("Enter user height (in cm):"));
        int weight = Integer.parseInt(JOptionPane.showInputDialog("Enter user weight (in kg):"));

        gym.addUser(new User(name, age, height, weight));
        JOptionPane.showMessageDialog(null, "User added successfully.");
    }

    private void viewUserDetails() {
        String name = JOptionPane.showInputDialog("Enter user name to view details:");
        User user = gym.getUser(name);
        if (user != null) {
            JOptionPane.showMessageDialog(null, user);
        } else {
            JOptionPane.showMessageDialog(null, "User not found.");
        }
    }

    private void saveDataToFile() {
        gym.saveDataToFile();
        JOptionPane.showMessageDialog(null, "Data saved successfully.");
    }

    private void loadDataFromFile() {
        gym.loadDataFromFile();
        JOptionPane.showMessageDialog(null, "Data loaded successfully.");
    }
}

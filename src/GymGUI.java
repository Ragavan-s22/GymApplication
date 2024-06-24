import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GymGUI {
    private final Gym gym;

    public GymGUI() {
        gym = new Gym();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Gym Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(mainPanel);

        JButton loginButton = new JButton("Login");
        JButton signUpButton = new JButton("Sign Up");

        mainPanel.add(loginButton);
        mainPanel.add(signUpButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoginScreen();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSignUpScreen();
            }
        });

        frame.add(scrollPane);
        frame.setVisible(true);
    }

    private void showLoginScreen() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                User user = gym.getUser(email);
                if (user != null && user.getPassword().equals(password)) {
                    showMainScreen(user);
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid email or password.");
                }
            }
        });

        loginFrame.add(panel);
        loginFrame.setVisible(true);
    }

    private void showSignUpScreen() {
        JFrame signUpFrame = new JFrame("Sign Up");
        signUpFrame.setSize(400, 400);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel heightLabel = new JLabel("Height (cm):");
        JTextField heightField = new JTextField();
        JLabel weightLabel = new JLabel("Weight (kg):");
        JTextField weightField = new JTextField();
        JLabel genderLabel = new JLabel("Gender (M/F):");
        JTextField genderField = new JTextField();
        JButton signUpButton = new JButton("Sign Up");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(genderLabel);
        panel.add(genderField);
        panel.add(signUpButton);

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                int age = Integer.parseInt(ageField.getText());
                int height = Integer.parseInt(heightField.getText());
                int weight = Integer.parseInt(weightField.getText());
                String gender = genderField.getText();

                User user = new User(name, email, age, height, weight, password, gender);
                gym.addUser(user);
                gym.saveDataToFile();
                JOptionPane.showMessageDialog(signUpFrame, "User signed up successfully.");
                showMainScreen(user);
            }
        });

        signUpFrame.add(panel);
        signUpFrame.setVisible(true);
    }

    private void showMainScreen(User user) {
        JFrame mainFrame = new JFrame("Gym Dashboard");
        mainFrame.setSize(800, 600);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Welcome, " + user.getName());
        mainPanel.add(welcomeLabel);

        JButton dailyGoalsButton = new JButton("Daily Goals");
        JButton weeklyGoalsButton = new JButton("Weekly Goals");
        JButton inBodyButton = new JButton("InBody Results");

        mainPanel.add(dailyGoalsButton);
        mainPanel.add(weeklyGoalsButton);
        mainPanel.add(inBodyButton);

        dailyGoalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDailyGoals(user);
            }
        });

        weeklyGoalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showWeeklyGoals(user);
            }
        });

        inBodyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showInBodyResults(user);
            }
        });

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private void showDailyGoals(User user) {
        JFrame dailyGoalsFrame = new JFrame("Daily Goals");
        dailyGoalsFrame.setSize(400, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add components for setting and tracking daily goals
        // Example: JTextField for entering daily calorie burn target, etc.

        dailyGoalsFrame.add(panel);
        dailyGoalsFrame.setVisible(true);
    }

    private void showWeeklyGoals(User user) {
        JFrame weeklyGoalsFrame = new JFrame("Weekly Goals");
        weeklyGoalsFrame.setSize(400, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add components for setting and tracking weekly goals
        // Example: Progress bar for showing weekly calorie burn progress, etc.

        weeklyGoalsFrame.add(panel);
        weeklyGoalsFrame.setVisible(true);
    }

    private void showInBodyResults(User user) {
        JFrame inBodyFrame = new JFrame("InBody Results");
        inBodyFrame.setSize(400, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Calculate InBody results using user details
        String inBodyResults = InBodyCalculator.calculateResults(user.getHeight(), user.getWeight(), user.getAge(), user.getGender());

        JTextArea resultsArea = new JTextArea(inBodyResults);
        panel.add(new JScrollPane(resultsArea));

        inBodyFrame.add(panel);
        inBodyFrame.setVisible(true);
    }
}
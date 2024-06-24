import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String email;
    private String password;
    private int age;
    private int height; // in centimeters
    private int weight; // in kilograms
    private String gender;

    // Constructor
    public User(String name, String email, int password, int age, int height, String weight, String gender) {
        this.name = name;
        this.email = email;
        this.password = String.valueOf(password);
        this.age = age;
        this.height = height;
        this.weight = Integer.parseInt(weight);
        this.gender = gender;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // toString method for displaying user details
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                '}';
    }
}
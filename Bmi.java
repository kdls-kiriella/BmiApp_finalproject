public class Bmi {

    private int id;
    private String name;
    private int yob;
    private int height;
    private int weight;
    private double bmi;
    private String category;

    // Constructor to initialize all properties
    public Bmi(int id, String name, int yob, int height, int weight) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.height = height;
        this.weight = weight;
        calculateBMI();
    }

    // Getter for the ID property
    public int getId() {
        return id;
    }

    public void calculateBMI() {
        // Convert height from cm to m
        double heightInMeters = height / 100.0;

        // Calculate BMI using the formula: weight / (height^2)
        bmi = weight / (heightInMeters * heightInMeters);

        // Determine BMI category
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal weight";
        } else if (bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yob);
        System.out.println("Height: " + height + "cm");
        System.out.println("Weight: " + weight + "kg");
        System.out.println("BMI: " + bmi);
        System.out.println("BMI Category: " + category);
    }

    // Newly added methods:

    public int calculateAge() {
        // Assuming year of birth is correct and current year is 2024
        int currentYear = 2024;
        int age = currentYear - yob;
        return age;
    }

    public String getCategory() {
        return category;
    }
}
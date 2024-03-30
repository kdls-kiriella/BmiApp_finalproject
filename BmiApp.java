import java.util.ArrayList;
import java.util.Scanner;

public class BmiApp {

    private ArrayList<Bmi> bmiRecords = new ArrayList<>();
    private static final int MAX_RECORDS = 5; // Maximum number of user records

    public static void main(String[] args) {
        BmiApp app = new BmiApp();
        app.run();
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            if (choice == 5) {
                break; // Exit loop on choice 5
            } else if (bmiRecords.size() >= MAX_RECORDS && choice != 4) {
                System.out.println("Maximum records reached. Please delete some before creating new ones.");
                continue; // Skip to next iteration if full and not deleting
            }
            executeAction(choice);
        }
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Create a record");
        System.out.println("2. Show BMI data for all users");
        System.out.println("3. Show BMI data for a selected user");
        System.out.println("4. Delete all records");
        System.out.println("5. Exit application");
    }

    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public void executeAction(int choice) {
        switch (choice) {
            case 1:
                create();
                break;
            case 2:
                index();
                break;
            case 3:
                int id = getUserChoice();
                view(id);
                break;
            case 4:
                delete();
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void create() {
        Scanner scanner = new Scanner(System.in);
        if (bmiRecords.size() >= MAX_RECORDS) {
            System.out.println("Maximum records reached. Please delete some before creating new ones.");
            return;
        }
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter year of birth: ");
        int yob = scanner.nextInt();
        System.out.print("Enter height (cm): ");
        int height = scanner.nextInt();
        System.out.print("Enter weight (kg): ");
        int weight = scanner.nextInt();

        // Validate input (add more validations as needed)
        if (height <= 0 || weight <= 0) {
            System.out.println("Height and weight must be positive values.");
            return;
        }

        Bmi bmi = new Bmi(id, name, yob, height, weight);
        bmiRecords.add(bmi);
        System.out.println("Record created successfully.");
    }

    public void index() {
        if (bmiRecords.isEmpty()) {
            System.out.println("No records found.");
        } else {
            System.out.println("BMI Records:");
            for (Bmi bmi : bmiRecords) {
                bmi.display();
            }
        }
    }

    public void view(int id) {
        for (Bmi bmi : bmiRecords) {
            if (bmi.getId() == id) {
                bmi.display();
                System.out.println("Age: " + bmi.calculateAge());
                String category = bmi.getCategory();
                if (category.equals("Underweight")) {
                    System.out.println("Recommendation: Increase calorie intake and focus on nutrient-rich foods.");
                } else if (category.equals("Overweight") || category.equals("Obese")) {
                    System.out.println("Recommendation: Consult a doctor or nutritionist for a personalized weight management plan.");
                }
                return;
            }
        }
        System.out.println("Record not found.");
    }

public void delete() {
    bmiRecords.clear();
    System.out.println("All records deleted.");
}

public void exit() {
    System.out.println("Exiting application.");
    System.exit(0);
}

    }
Menu-based Java application that allows you to add employee details, display all employees, and exit. The employee details will be stored in a file, and the program will
read the file to display the stored employee information.

//Code

package javaSem6;

import java.io.*;
import java.util.*;

// Employees class implementing Serializable
class Employees implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Employees(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    private static final String FILE_NAME = "employees.dat";

    // Method to add an employee
    public static void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        Employees employee = new Employees(id, name, designation, salary);
        saveEmployeeToFile(employee);
        System.out.println("Employee added successfully!\n");
    }

    // Method to save an employee to a file
    private static void saveEmployeeToFile(Employees employee) {
        List<Employees> employees = readEmployeesFromFile(); // Read existing employees
        employees.add(employee); // Add new employee

        // Write entire list back to the file (overwriting)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.err.println("Error saving employee: " + e.getMessage());
        }
    }

    // Method to display all employees
    public static void displayAllEmployees() {
        List<Employees> employees = readEmployeesFromFile();
        if (employees.isEmpty()) {
            System.out.println("No employees found.\n");
        } else {
            System.out.println("Employee List:");
            employees.forEach(System.out::println);
            System.out.println();
        }
    }

    // Method to read employees from file
    private static List<Employees> readEmployeesFromFile() {
        List<Employees> employees = new ArrayList<>();
        if (!new File(FILE_NAME).exists()) {
            return employees; // Return empty list if file does not exist
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                employees = (List<Employees>) obj; // Cast safely
            }
        } catch (EOFException ignored) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading employees: " + e.getMessage());
        }
        return employees;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayAllEmployees();
                case 3 -> {
                    System.out.println("Exiting program.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }
}



//OUTPUT

1. Add Employee
2. Display All Employees
3. Exit
Enter your choice: 1
Enter Employee ID: 17184
Enter Name: Dipendra
Enter Designation: Software engineer
Enter Salary: 15000
Employee added successfully!

1. Add Employee
2. Display All Employees
3. Exit
Enter your choice: 1
Enter Employee ID: 13906
Enter Name: Om
Enter Designation: Web developer
Enter Salary: 17000
Employee added successfully!

1. Add Employee
2. Display All Employees
3. Exit
Enter your choice: 1
Enter Employee ID: 10790
Enter Name: Sanjay
Enter Designation: Full stack developer
Enter Salary: 16000
Employee added successfully!

1. Add Employee
2. Display All Employees
3. Exit
Enter your choice: 1
Enter Employee ID: 50206
Enter Name: Sumantra
Enter Designation: Software developer
Enter Salary: 17000
Employee added successfully!

1. Add Employee
2. Display All Employees
3. Exit
Enter your choice: 2
Employee List:
Employee ID: 17184, Name: Dipendra, Designation: Software engineer, Salary: 15000.0
Employee ID: 13906, Name: Om, Designation: Web developer, Salary: 17000.0
Employee ID: 10790, Name: Sanjay, Designation: Full stack developer, Salary: 16000.0
Employee ID: 50206, Name: Sumantra, Designation: Software developer, Salary: 17000.0



Java program that serializes and deserializes a Student object. It saves the Student object to a file and then reads it back, displaying the student details.
The program handles exceptions like FileNotFoundException, IOException, and ClassNotFoundException.

//Code

import java.io.*;

// Student class implementing Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures version consistency
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}

public class StudentSerialization {
    private static final String FILE_NAME = "student.ser";

    // Method to serialize a Student object
    public static void serializeStudent(Student student) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(student);
            System.out.println("Student object has been serialized and saved to file.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize a Student object
    public static Student deserializeStudent() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Student) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        } catch (IOException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Class not found.");
        }
        return null;
    }

    public static void main(String[] args) {
        // Test Case 1: Serialize and Deserialize a valid student object
        Student student = new Student(1, "John Doe", 3.75);
        serializeStudent(student);
        
        Student deserializedStudent = deserializeStudent();
        if (deserializedStudent != null) {
            System.out.println("Student object has been deserialized.");
            System.out.println("Deserialized Student Details:\n" + deserializedStudent);
        }
    }
}



//OUTPUT

Test Case 1: No Cards Initially
No cards found.

Test Case 2: Adding Cards
Card added: Ace of Spades
Card added: King of Hearts
Card added: 10 of Diamonds
Card added: 5 of Clubs

Test Case 3: Finding Cards by Suit
King of Hearts

Test Case 4: Searching Suit with No Cards
10 of Diamonds

Test Case 5: Displaying All Cards
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

Test Case 6: Preventing Duplicate Cards
Error: Card "King of Hearts" already exists.

Test Case 7: Removing a Card
Card removed: 10 of Diamonds


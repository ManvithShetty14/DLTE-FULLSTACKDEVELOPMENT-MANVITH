package dlte.javajdc;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws SQLException, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        StudentOptions studentOptions = new StudentOptions();
        Student student = new Student();
        Address address = new Address();
        studentOptions.jdbcConnection();
        boolean flag=true;
        do {
            System.out.println("Enter the Operation to be Performed:\n 1. add new student details\n 2.Display the Students Details\n 3.Delete the student details \n 4.Exit");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Enter the Register Number");
                    student.setReg_no(scanner.nextInt());
                    System.out.println("Enter the name");
                    student.setName(scanner.next());
                    System.out.println("Enter the age");
                    student.setAge(scanner.nextInt());
                    System.out.println("Enter the email");
                    student.setEmail(scanner.next());
                    System.out.println("Enter the student Address:");
                    System.out.println("Door number");
                    address.setDoor(scanner.nextInt());
                    System.out.println("Street");
                    address.setStreet(scanner.next());
                    System.out.println("City");
                    address.setCity(scanner.next());
                    System.out.println("Pinode");
                    address.setPin(scanner.nextInt());

                    studentOptions.insertRecords(student, address);
                    break;
                case 2:
                    studentOptions.display();
                    break;
                case 3:
                    System.out.println("Enter the Student Register Number:");
                    studentOptions.delete(scanner.nextInt());
                    break;
                case 4:
                    flag=false;
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Invalid Input");
            }

        }while (flag);
    }
}

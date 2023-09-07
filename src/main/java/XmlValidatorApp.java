import java.util.Scanner;
import com.boostdraft.XMLValidator;

public class XmlValidatorApp {
    public static void main(String[] args) {
        // Create an object of Scanner class to read user input
        Scanner scanner = new Scanner(System.in);

        // Create an object of XMLValidator class to use its method
        XMLValidator validator = new XMLValidator();

        // Prompt the user to enter an XML string
        System.out.println("Enter an XML string to validate:");

        // Read the user input as a string
        String xmlString = scanner.nextLine();

        // Close the scanner object
        scanner.close();

        // Call the isValidXml method of the validator object and store the result
        boolean isValid = validator.isValidXml(xmlString);

        // Display the result
        if (isValid) {
            System.out.println("The XML string is valid.");
        } else {
            System.out.println("The XML string is invalid.");
        }
    }
}

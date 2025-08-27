import java.io.*;
import java.util.Scanner;

public class FileOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "example.txt"; // File name

        try {
            //Write to a file
            System.out.println("Enter text to write into the file:");
            String inputText = sc.nextLine();

            FileWriter writer = new FileWriter(fileName);
            writer.write(inputText + "\n");
            writer.close();
            System.out.println("Data written to " + fileName);

            //Read from the file
            System.out.println("\nReading file contents:");
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            //Keep appending until user says "no"
            String choice;
            do {
                System.out.println("\nEnter text to append to the file:");
                String appendText = sc.nextLine();

                FileWriter appendWriter = new FileWriter(fileName, true); // append mode
                appendWriter.write(appendText + "\n");
                appendWriter.close();
                System.out.println("Data appended to " + fileName);

                System.out.print("Do you want to append more? (yes/no): ");
                choice = sc.nextLine().trim().toLowerCase();
            } while (choice.equals("yes"));

            // Final read after appending
            System.out.println("\nFinal contents of the file:");
            reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

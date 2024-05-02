package emailApp;

import java.util.Random;
import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private String password;
    private final String department;
    private final String company = "company.com";
    private final String email;
    private int mailBoxCapacity = 500;
    private String alternateEmail;

    // Constructor to receive the first and last names

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // Call a method to ask for the department and return it
        this.department = setDepartment();
        // Call a method to generate a random password
        this.password = randomPassword(10);
        // Combine elements to generate the email
        this.email = generateEmail();

        this.debugEmail();
    }

    public void debugEmail() {
        System.out.println(
                "EMAIL ACCOUNT DATA: \n" +
                "First name: " + getFirstName() + "\n" +
                "Last name: " + getLastName() + "\n" +
                "Department: " + getDepartment() + "\n" +
                "Password: " + getPassword() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Capacity: " + getMailBoxCapacity() + "Mb" + "\n" +
                "Alternate email: " + getAlternateEmail()
        );
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\n");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        if (choice == 1) {
            return "sales";
        } else if (choice == 2) {
            return "dev";
        } else if (choice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        StringBuilder password = new StringBuilder(16);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int n = random.nextInt(passwordSet.length() - 1);
            password.append(passwordSet.charAt(n));
        }
        return password.toString();
    }

    // Set the full email with the collected data
    private String generateEmail() {
        String generatedEmail = "";
        generatedEmail += firstName.toLowerCase() + "." + lastName.toLowerCase() + "@";
        if (!department.isEmpty()) {
            generatedEmail += getDepartment();
            generatedEmail += ".";
        }
        generatedEmail += company;
        return generatedEmail;
    }

    // Set the mailbox capacity
    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
}

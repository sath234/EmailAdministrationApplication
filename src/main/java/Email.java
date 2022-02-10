import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int inboxCapacity = 500;
    private String alternateEmail;

    // Constructor to recieve the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created: "+this.firstName+" "+this.lastName+"\n");

        // Call method asking for the department - return department
        this.department = setDepartment();

        // Call method to return random password
        this.password = randomPassword(8);
        System.out.println("\nYour password is "+this.password);

        // Combine elements to generate company
        if (department == "") email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+"company.com";
        else email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+".company.com\n";
    }

    // Ask for the department
    private String setDepartment(){
        System.out.print("Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department Code:");

        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();

        if (departmentChoice == 1) return "sales";
        else if (departmentChoice == 2) return  "dev";
        else if (departmentChoice == 3) return "accounting";
        else return "";
    }

    // Generate a random password
    private String randomPassword(int length){
        StringBuilder password = new StringBuilder();
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@£$%&?";
        Random num = new Random();

        for (int i = 0; i < length; i++){
            password.append(passwordSet.charAt(num.nextInt(passwordSet.length() - 1)));
        }

        return password.toString();
    }

    // Set the mailbox capacity
    public void setInboxCapacity(int inboxCapacity) {
        this.inboxCapacity = inboxCapacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: "+firstName+" "+lastName+"\nCOMPANY EMAIL: "+email+"\nINBOX SIZE: "+inboxCapacity+"mb";
    }
}

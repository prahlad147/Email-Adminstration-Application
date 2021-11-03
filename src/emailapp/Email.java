package emailapp;

import java.util.*;
import java.io.*;

public class Email {
    public Scanner s = new Scanner(System.in); // Scanner class -> it is global

    // Setting Variables as private (access restriction)

    private String fname; // this fname is different from constructor fname
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    // Constructor to receive firstName, LastName for now (Class and Constructor
    // have same name)

    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee:" + this.fname + " " + this.lname);

        // Calling methods

        this.dept = this.setDept(); // Department
        int length = 8;
        this.password = this.generate_password(length); // Password
        this.email = this.generate_email(); // email generation

    }

    // Generate mail method
    private String generate_email() {
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase()
                + ".company.com";
    }

    // Asking for department
    private String setDept() {
        System.out.println("Department codes \n1 for sales \n2 for Development \n3 for Accounting \n4 for None");
        boolean flag = false;

        // do- while loop executes atleast for one time

        do {
            System.out.println("Enter Department code");
            int choice = s.nextInt();
            switch (choice) {
            case 1:
                return "Sales";
            case 2:
                return "Development";
            case 3:
                return "Accounting";
            case 0:
                return "None";
            default:
                System.out.println("Invalid Department Name please fill the right choice");

            }
        }

        while (!flag);
        return null;

    }

    // Generate Random Password Method

    private String generate_password(int length) {
        Random r = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&?";
        String values = Capital_chars + Small_chars + numbers + symbols;
        String password = "";

        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    // Change password method
    public void set_password() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password! (Y/N) ");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter Current Password:");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter New Password:");
                    this.password = s.next();
                    System.out.println("Password Changed Successfully");
                } else {
                    System.out.println("Incorrect Password");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password Changed Denied!!");
            } else {
                System.out.println("Enter Valid Choice");
            }
        } while (!flag);
    }

    // set mail box capacity method

    public void set_mailCap() {
        System.out.println("Current Capacity= " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    // set alternate mail

    public void alternate_mail() {
        System.out.println("Enter new alternate mail");
        this.alter_email = s.next();
        System.out.println("Alternate mail is set successfully");
    }

    // Display user information method

    public void getInfo() {
        System.out.println("New:" + this.fname + " " + this.lname);
        System.out.println("Department:" + this.dept);
        System.out.println("Email:" + this.email);
        System.out.println("Password:" + this.password);
        System.out.println("Mailbox Capacity:" + this.mailCapacity + "mb");
        System.out.println("Alternate mail:" + this.alter_email);

    }
    /*
     * // Store in file public void storefile(){ try{ FileWriter in = new
     * FileWriter(fileName "C:\Users\Prahlad Pallav\Desktop\info.txt"); in.write(str
     * "FirstName:" +this.fname); in.append("\nLastName:" +this.lname);
     * in.append("\nEmail:" +this.email); in.append("\nPassword:"+this.password);
     * in.append("\nCapacity:" +this.mailCapacity); in.append("\nAlternate mail:"
     * +this.alter_email); in.close; System.out.println("Data Stored");
     * 
     * } catch(Exception e){System.out.println(e);} }
     * 
     * // Reading file method
     * 
     * public void read_file(){ try{ FileReader f1 = new FileReader(fileName
     * "C:\Users\Prahlad Pallav\Desktop\info.txt"); int i; while((i = f1.read()) !=
     * -1){ System.out.print((char)i); }
     * 
     * f1.close();
     * 
     * } catch(Exception e){System.out.println(e);}
     */

}

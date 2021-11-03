package emailapp;

import java.util.*;
import java.io.*;

public class EmailApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // User Info
        System.out.println("Enter first name");
        String f_name = s.next();
        System.out.println("Enter last name");
        String l_name = s.next();

        // Creating object for Email Class
        Email em1 = new Email(f_name, l_name);
        int choice = -1;

        do {
            System.out.println(
                    "\n*******\n Enter your choice\n1.Show info\n2.Change Password\n3.Change mailboc capacity \n4.Set alternate mail \n5.Exit \n6. Store data in file \n7. Display data from file");
            choice = s.nextInt();
            switch (choice) {
            case 1:
                em1.getInfo();
                break;
            case 2:
                em1.set_password();
                break;
            case 3:
                em1.set_mailCap();
                break;
            case 4:
                em1.alternate_mail();
                break;
            case 5:
                System.out.println("Thanks for using application");
                break;
            /*
             * case 6: em1.storefile(); break; case 7: em1.read_file(); break;
             */
            default:
                System.out.println("Invalid Choice \nPlease! Enter a valid one");

            }
        } while (choice != 5);

        s.close();

    }
}

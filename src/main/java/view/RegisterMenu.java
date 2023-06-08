package view;

import controller.RegisterMenuController;
import model.Customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterMenu {
    private static RegisterMenuController registerMenuController;
    private LoginMenu loginMenu;
    private CostumerMenu costumerMenu;

    public RegisterMenu(RegisterMenuController registerMenuController) {
        this.registerMenuController = registerMenuController;
    }
public static void run()
{
    String r1 = "ADD ADMIN\\s+(?<nameAdmin>((\\w)|((\\s)|(\\W)))*)\\s+(?<passwordAdmin>((\\w)|((\\s)|(\\W)))*)\\s(?<node>(\\d)+)";
    Pattern p1 = Pattern.compile(r1);
    String r2 = "ADD USER\\s+(?<nameUser>((\\w)|((\\s)|(\\W)))*)\\s+(?<passwordUser>((\\w)|((\\s)|(\\W)))*)\\s(?<node1>(\\d)+)";
    Pattern p2 = Pattern.compile(r2);
    String r3 = "Back";
    Pattern p3 = Pattern.compile(r3);
    String command , result ;
    while (true) {
        command = Menu.getScanner().nextLine();
        command = command.trim();
        Matcher m1 = p1.matcher(command);
        Matcher m2 = p2.matcher(command);
        Matcher m3 = p3.matcher(command);
        if (m1.matches())
        {
            String name = m1.group("nameAdmin");
            String password = m1.group("passwordAdmin");
            int node = Integer.parseInt(m1.group("node"));
            if(Customer.printindexbycustomname(name)<0) {
                result = registerMenuController.setANewPassword(password);
                if(!result.equals("Your account has been successfully created"))
                    System.out.println(result);
                if (result.equals("Your account has been successfully created")) {
                    System.out.println("Security question: Write down your day, month, and year of birth, and remember how to write it.");
                    command = Menu.getScanner().nextLine();
                    registerMenuController.setnewResturantOwner(name, password, node,command);
                }
            }
            else {
                System.out.println("This name already exists");
            }
        }
        else if(m2.matches()){
            String name = m2.group("nameUser");
            String password = m2.group("passwordUser");
            int node = Integer.parseInt(m2.group("node1"));
            if(Customer.printindexbycustomname(name)<0) {
                result = registerMenuController.setANewPassword(password);
                if(!result.equals("Your account has been successfully created"))
                    System.out.println(result);
                if (result.equals("Your account has been successfully created")) {
                    System.out.println("Security question: Write down your day, month, and year of birth, and remember how to write it.");
                    command = Menu.getScanner().nextLine();
                    registerMenuController.setnewCustomer(name, password, node,command);
                }
            }
            else {
                System.out.println("This name already exists");
            }
        }
        else if(m3.matches()){
            System.out.println("Back to login menu!");
            return;
        }
        else{
            System.out.println("Invalid Command");
        }
    }

}



}

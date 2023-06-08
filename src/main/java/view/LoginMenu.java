package view;
import controller.LoginMenuController;
import controller.RegisterMenuController;
import model.Customer;
import model.FileManager;
import model.ResturantOwner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LoginMenu {
private LoginMenuController loginMenuController;
private CostumerMenu costumerMenu;
private RegisterMenuController registerMenuController = new RegisterMenuController();
private RegisterMenu registerMenu = new RegisterMenu(registerMenuController);
static int delayTime;
    public LoginMenu(LoginMenuController loginMenuController) {
        this.loginMenuController = loginMenuController;
    }
    static void delayForWrongPassword() {
        if(delayTime < 15000)
            delayTime += 5000;

        System.out.println("The system is locked for " + delayTime/1000 + " seconds. please don't type anything until the sleep time ends.");

        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

    }
    public void run()
{
    System.out.println("Don't have an account? Whenever you want, type  (create a new account)  to enter Signup Menu.");
    String r1 = "create a new account";
    Pattern p1 = Pattern.compile(r1);
    String r2 = "LOGIN ADMIN\\s+(?<nameAdmin>((\\w)|((\\s)|(\\W)))*)\\s+(?<passwordAdmin>((\\w)|((\\s)|(\\W)))*)\\s+";
    Pattern p2 = Pattern.compile(r2);
    String r3 = "LOGIN USER\\s+(?<nameUser>((\\w)|((\\s)|(\\W)))*)\\s+(?<passwordUser>((\\w)|((\\s)|(\\W)))*)";
    Pattern p3 = Pattern.compile(r3);
    String r4 = "exit";
    Pattern p4 = Pattern.compile(r4);
    String r5 = "Forgot password";
    Pattern p5 = Pattern.compile(r5);
    String r6 = "(?<nameAdmin1>((\\w)|((\\s)|(\\W)))*)\\s+ResturantOwner";
    Pattern p6 = Pattern.compile(r6);
    String r7 = "(?<nameCustomer1>((\\w)|((\\s)|(\\W)))*)\\s+Customer";
    Pattern p7 = Pattern.compile(r7);
    String command ,result;
    while (true){
        command = Menu.getScanner().nextLine();
        command = command.trim();
        Matcher m1 = p1.matcher(command);
        Matcher m2 = p2.matcher(command);
        Matcher m3 = p3.matcher(command);
        Matcher m4 = p4.matcher(command);
        Matcher m5 = p5.matcher(command);
        if (m1.matches())
        {
            System.out.println("Entered Sign up menu! (please enter name, password and node)");
            registerMenu.run();
        }
        else if(m2.matches()){
            String name = m2.group("nameAdmin");
            String password = m2.group("passwordAdmin");
            LoginMenuController.logginResturantOwner(name,password);
        }
        else if(m3.matches()){
            String name = m3.group("nameUser");
            String password = m3.group("passwordUser");
            LoginMenuController.logginCustomer(name,password);
        }
        else if(m4.matches()){
            FileManager.saveAllDatas();
            return;
        }
        else if(m5.matches()){
            System.out.println("please enter your name and your type (ResturantOwner or Customer)");
            command = Menu.getScanner().nextLine();
            Matcher m6 = p6.matcher(command);
            Matcher m7 = p7.matcher(command);
            if(!m6.matches()&&!m7.matches()){
                System.out.println("False Format Please be more careful with the spelling of words");
            }
            else{
                if(m6.matches()) {
                    String name = m6.group("nameAdmin1");
                    if (ResturantOwner.printindexbyResturantOwnername(name) > -1) {
                        System.out.println("Security question: Write down your day, month, and year of birth");
                        command = Menu.getScanner().nextLine();
                        if (!ResturantOwner.checksecurityquestion(name, command)) {
                            System.out.println("no match");
                        } else {
                            System.out.println("match! please enter new password");
                            while (true) {
                                command = Menu.getScanner().next();
                                result = loginMenuController.setANewPassword(command);
                                if (!result.equals("Your account has been successfully created")) {
                                    System.out.println(result);
                                } else {
                                    System.out.println("Your password has been changed successfully.");
                                    ResturantOwner.setnewpassword(command, Customer.printindexbycustomname(name));
                                    break;
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("There is no account with this name");
                    }
                }
                else {
                    String name = m7.group("nameCustomer1");
                    if (Customer.printindexbycustomname(name) > -1) {
                        System.out.println("Security question: Write down your day, month, and year of birth");
                        command = Menu.getScanner().nextLine();
                        if (!Customer.checksecurityquestion(name, command)) {
                            System.out.println("no match");
                        } else {
                            System.out.println("match! please enter new password");
                            while (true) {
                                command = Menu.getScanner().nextLine();
                                result = loginMenuController.setANewPassword(command);
                                if (!result.equals("Your account has been successfully created")) {
                                    System.out.println(result);
                                } else {
                                    System.out.println("Your password has been changed successfully.");
                                    Customer.setnewpassword(command, Customer.printindexbycustomname(name));
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("There is no account with this name");
                    }
                }
            }
        }
        else{
            System.out.println("Invalid Command");
        }
    }

}
}

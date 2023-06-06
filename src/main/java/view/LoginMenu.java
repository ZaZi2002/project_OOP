package view;
import controller.LoginMenuController;
import controller.RegisterMenuController;
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
    String r1 = "create new account";
    Pattern p1 = Pattern.compile(r1);
    String r2 = "LOGIN ADMIN\\s+(?<nameAdmin>((\\w)|((\\s)|(\\W)))*)\\s+(?<passwordAdmin>((\\w)|((\\s)|(\\W)))*)\\s+";
    Pattern p2 = Pattern.compile(r2);
    String r3 = "LOGIN USER\\s+(?<nameUser>((\\w)|((\\s)|(\\W)))*)\\s+(?<passwordUser>((\\w)|((\\s)|(\\W)))*)";
    Pattern p3 = Pattern.compile(r3);
    String r4 = "exit";
    Pattern p4 = Pattern.compile(r4);
    String command ,result;
    while (true){
        command = Menu.getScanner().nextLine();
        command = command.trim();
        Matcher m1 = p1.matcher(command);
        Matcher m2 = p2.matcher(command);
        Matcher m3 = p3.matcher(command);
        Matcher m4 = p4.matcher(command);
        if (m1.matches())
        {
            System.out.println("Entered Sign up menu!");
            registerMenu.run();
        }
        else if(m2.matches()){
            String name = m2.group("nameAdmin");
            String password = m2.group("passwordAdmin");
        }
        else if(m3.matches()){
            String name = m3.group("nameUser");
            String password = m3.group("passwordUser");
        }
        else if(m4.matches()){
            return;
        }
        else{
            System.out.println("Invalid Command");
        }
    }

}
}

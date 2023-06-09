package view;

import controller.CustomerMenuController;
import controller.LoginMenuController;
import model.Customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CostumerMenu {
    private CustomerMenuController customerMenuController;
    private Customer customer;
    public CostumerMenu(Customer loggedcustomer) {
        this.customerMenuController = new CustomerMenuController(this);
        this.customer=loggedcustomer;
    }
    public void run()
    {
        System.out.println("Entered Customer Menu");
        String r1 = "SEARCH RESTURANT (?<resturantname>((\\w)|((\\s)|(\\W)))*)";
        Pattern p1 = Pattern.compile(r1);
        String r2 = "SELECT (?<resturantid>(\\d)*)";
        Pattern p2 = Pattern.compile(r2);
        String r3 = "return";
        Pattern p3 = Pattern.compile(r3);
        String command ,result;
        while (true) {
           command = Menu.getScanner().nextLine();
           command = command.trim();
           Matcher m1 = p1.matcher(command);
           Matcher m2 = p2.matcher(command);
           Matcher m3 = p3.matcher(command);
           if(m1.matches()){
               String name = m1.group("resturantname");
               result = customerMenuController.SearchResturant(name);
               System.out.println(result);
           }
           else if(m2.matches()){
               int id = Integer.parseInt(m2.group("resturantid"));
               if(customerMenuController.returnindexbyid(id)<0){
                   System.out.println("There is no resturant with this id");
               }
               else {
                    customerMenuController.Select(customerMenuController.returnindexbyid(id));
               }
           }
           else if(m3.matches()){
               System.out.println("Entered login Menu");
               break;
           }
        }
        }
    }


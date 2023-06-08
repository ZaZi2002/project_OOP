package view;

import controller.CustomerMenuController;
import model.Customer;

public class CostumerMenu {
    private CustomerMenuController customerMenuController;
    private Customer customer;
    public CostumerMenu(Customer loggedcustomer) {
        this.customerMenuController = new CustomerMenuController(this);
        this.customer=loggedcustomer;
    }
    public void run()
    {
        System.out.println("HI");
    }
}

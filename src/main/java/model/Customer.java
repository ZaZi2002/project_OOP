package model;

import java.util.ArrayList;

public class Customer extends User{
    static private ArrayList<Customer> allcustomer = new ArrayList<>();
    private int node;

    public Customer(String name , String password)
    {
       super(name , password);
       allcustomer.add(this);
       Cart=new ArrayList<>();

    }

    private ArrayList<Food> Cart;

    public void addtoCart(Food food)
    {
        Cart.add(food);
    }

    public ArrayList<Food> getCart() {
        return Cart;
    }

    public ArrayList<Customer> getAllcustomer() {
        return allcustomer;
    }
}

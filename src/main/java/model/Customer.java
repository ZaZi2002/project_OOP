package model;

import java.util.ArrayList;

public class Customer extends User{

    public Customer(String name , String password)
    {
       super(name , password);
    }

    private ArrayList<Food> Cart;

    public void addtoCart(Food food)
    {
        Cart.add(food);
    }

    public ArrayList<Food> getCart() {
        return Cart;
    }
}

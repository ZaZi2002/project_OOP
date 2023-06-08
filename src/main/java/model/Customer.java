package model;

import java.util.ArrayList;

public class Customer extends User{
    static private ArrayList<Customer> allcustomer = FileManager.getFileManagerInstance().customers;
    public Customer(String name , String password,int node,String sequrityquestion)
    {
       super(name , password,node,sequrityquestion);
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

    public static void setAllcustomer(ArrayList<Customer> allcustomer) {
        Customer.allcustomer = allcustomer;
    }

    public void setCart(ArrayList<Food> cart) {
        Cart = cart;
    }

    public static ArrayList<Customer> getAllcustomer() {
        return allcustomer;
    }
    public static int printindexbycustomname(String name){
        for(int i=0;i<allcustomer.size();i++){
            if(allcustomer.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public static Customer returncustomerbyname(String name){
        return allcustomer.get(printindexbycustomname(name));
    }
    public static boolean checkpasswor(String password,int index){
        if(allcustomer.get(index).getPassword().equals(password)){
            return true;
        }
        return false;
    }
    public static boolean checksecurityquestion(String name,String question){
        if(allcustomer.get(printindexbycustomname(name)).getSecurityQuestion().equals(question)){
            return true;
        }
        return false;
    }
    public static void setnewpassword(String password,int index){
        allcustomer.get(index).setPassword(password);
    }

}


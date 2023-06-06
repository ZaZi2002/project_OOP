package model;

import java.util.ArrayList;

public class Order {


    private Customer owner;
    private Resturant resturant;
    private int id;

    //time field needed

    private String Status;
    private ArrayList<Food> orderedfoods = new ArrayList<>();

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public void setResturant(Resturant resturant) {
        this.resturant = resturant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderedfoods(ArrayList<Food> orderedfoods) {
        this.orderedfoods = orderedfoods;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }

    public void setOrderSituation(String orderSituation) {
        this.orderSituation = orderSituation;
    }

    public void setStatus(String status) {
        Status = status;
    }

    private double orderprice = 0;
    private String orderSituation;

    public Customer getOwner() {
        return owner;
    }

    public Resturant getResturant() {
        return resturant;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Food> getOrderedfoods() {
        return orderedfoods;
    }

    public double getOrderprice() {
        return orderprice;
    }

    public String getOrderSituation() {
        return orderSituation;
    }

    public String getStatus() {
        return Status;
    }
}

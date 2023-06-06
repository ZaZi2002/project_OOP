package model;

import java.util.ArrayList;
import java.util.Map;

public class Resturant {

    private String name;
    private int id;
    private ResturantOwner resturantOwner;
    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private static ArrayList<Resturant> Allresturants = new ArrayList<>();

    //ArrayList<FoodType> foodTypes = new ArrayList<FoodType>();
    private Map Location;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ResturantOwner getResturantOwner() {
        return resturantOwner;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public static ArrayList<Resturant> getAllresturants() {
        return Allresturants;
    }

    public Map getLocation() {
        return Location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setResturantOwner(ResturantOwner resturantOwner) {
        this.resturantOwner = resturantOwner;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public static void setAllresturants(ArrayList<Resturant> allresturants) {
        Allresturants = allresturants;
    }

    public void setLocation(Map location) {
        Location = location;
    }
}



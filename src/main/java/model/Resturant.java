package model;

import java.util.ArrayList;
import java.util.Map;

public class Resturant {

    private String name;
    private int id;
    private ResturantOwner resturantOwner;
    private Map Location;
    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    static private ArrayList<Resturant> Allresturants = new ArrayList<>();
    public Resturant(String name,int id ,Map location){
        this.name = name;
        this.id = id;
        this.Location=location;
        foods = new ArrayList<>();
        orders = new ArrayList<>();
        Allresturants.add(this);
    }

    //ArrayList<FoodType> foodTypes = new ArrayList<FoodType>();
    public static String searchResturant(String name){
        String list="";
        for(int i=0;i<Allresturants.size();i++){
            if(Allresturants.get(i).name.equals(name)){
                list = list + Allresturants.get(i).name +"  Id= "+Allresturants.get(i).id+"\n";
            }
        }
        return list;
    }
    public static int returnindexbyname(int id){
        boolean check = true;
        String list="";
        for(int i=0;i<Allresturants.size();i++){
            if(Allresturants.get(i).id == id){
                return id;
            }
        }
        return -1;
    }
    public static Resturant returnResturantByIndex(int index){
        return Allresturants.get(index);
    }
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



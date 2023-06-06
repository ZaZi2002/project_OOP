package model;

import java.util.ArrayList;

public class ResturantOwner extends User{
    private ArrayList<ResturantOwner> allResturantOwner = new ArrayList<>();
    private ArrayList<Resturant> Resturants = new ArrayList<>();
    public ResturantOwner(String name, String password) {
        super(name, password);
        allResturantOwner.add(this);
    }

    public ArrayList<Resturant> getResturants() {
        return Resturants;
    }

    public void AddToResturants(Resturant resturants) {
        Resturants.add(resturants);
    }


}

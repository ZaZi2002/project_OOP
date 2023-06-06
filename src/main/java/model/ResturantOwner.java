package model;

import java.util.ArrayList;

public class ResturantOwner extends User{

    private ArrayList<Resturant> Resturants = new ArrayList<>();
    public ResturantOwner(String name, String password) {
        super(name, password);
    }

    public ArrayList<Resturant> getResturants() {
        return Resturants;
    }

    public void AddToResturants(Resturant resturants) {
        Resturants.add(resturants);
    }


}

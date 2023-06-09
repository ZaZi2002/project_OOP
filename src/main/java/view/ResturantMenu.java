package view;

import controller.CustomerMenuController;
import controller.ResturantMenuController;
import model.Resturant;

public class ResturantMenu {

    private ResturantMenuController resturantMenuController;

    private Resturant resturant;

    public ResturantMenu(Resturant resturant)
    {
        this.resturantMenuController = new ResturantMenuController(this);
        this.resturant = resturant;
    }
    public void run()
    {

    }
}

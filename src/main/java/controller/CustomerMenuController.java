package controller;


import view.CostumerMenu;
import model.Resturant;
import view.Menu;
import view.RegisterMenu;
import view.ResturantMenu;

public class CustomerMenuController {

    private CostumerMenu CostomerMenu;

    public CustomerMenuController(CostumerMenu costumerMenu) {
        this.CostomerMenu=costumerMenu;
    }

    public String SearchResturant(String name)
{
    String list;
    list = Resturant.searchResturant(name);
   if(list.equals("")){
       return "there is no resturant with this name";
   }
   else{
       return list;
   }
}
    public int returnindexbyid(int id){
        int result;
        result = Resturant.returnindexbyname(id);
        return result;
    }

public void Select(int index)
{
    Resturant resturant;
    resturant = Resturant.returnResturantByIndex(index);
    ResturantMenu resturantMenu = new ResturantMenu(resturant);
    resturantMenu.run();
}

public String AccessOrderHistory()
{
    return "";
}

public String SelectOrder()
{
    return "";
}

public String DisplayCartStatus()
{
    return "";
}

public String ConfirmOrder()
{
    return "";
}

//ShowEstimatesdeliveryTime

    public String ChargeAccount()
    {
        return "";
    }

    public String DisPlayAccountCharge()
    {
        return "";
    }




}

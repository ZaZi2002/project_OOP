package model;

import java.util.ArrayList;

public class ResturantOwner extends User{
    static  private ArrayList<ResturantOwner> allResturantOwner = new ArrayList<>();
    private ArrayList<Resturant> Resturants = new ArrayList<>();
    public ResturantOwner(String name, String password,int node,String securityquestion) {
        super(name, password,node,securityquestion);
        allResturantOwner.add(this);
    }

    public static void setAllResturantOwner(ArrayList<ResturantOwner> allResturantOwner) {
        ResturantOwner.allResturantOwner = allResturantOwner;
    }

    public void setResturants(ArrayList<Resturant> resturants) {
        Resturants = resturants;
    }

    public static ArrayList<ResturantOwner> getAllResturantOwner() {
        return allResturantOwner;
    }

    public ArrayList<Resturant> getResturants() {
        return Resturants;
    }

    public void AddToResturants(Resturant resturants) {
        Resturants.add(resturants);
    }
    public static int printindexbyResturantOwnername(String name){
        for(int i=0;i<allResturantOwner.size();i++){
            if(allResturantOwner.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public static ResturantOwner returnResturantOwnerbyname(String name){
        return allResturantOwner.get(printindexbyResturantOwnername(name));
    }
    public static boolean checkpasswor(String password,int index){
        if(allResturantOwner.get(index).getPassword().equals(password)){
            return true;
        }
        return false;
    }
    public static boolean checksecurityquestion(String name,String question){
        if(allResturantOwner.get(printindexbyResturantOwnername(name)).getSecurityQuestion().equals(question)){
            return true;
        }
        return false;
    }
    public static void setnewpassword(String password,int index){
        allResturantOwner.get(index).setPassword(password);
    }
}

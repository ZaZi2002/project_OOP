package model;

import java.util.ArrayList;

public class FileManager {
    private static FileManager fileManagerInstance;
    public ArrayList<Customer> customers ;
    public ArrayList<ResturantOwner> resturantOwners;
    public FileManager(){
        customers=new ArrayList<>();
        resturantOwners=new ArrayList<>();
    }
    public static FileManager getFileManagerInstance(){
        if(fileManagerInstance==null){
            fileManagerInstance= new FileManager();
        }
        return fileManagerInstance;
    }
    public static void setFileManagerInstance(FileManager a){
        fileManagerInstance=a;
    }
}

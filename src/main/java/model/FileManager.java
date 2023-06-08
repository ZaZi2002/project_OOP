package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {
    private static FileManager fileManagerInstance;
    public ArrayList<Customer> customers ;
    public ArrayList<ResturantOwner> resturantOwners;
    public FileManager(){
        customers=Customer.getAllcustomer();
        resturantOwners=ResturantOwner.getAllResturantOwner();
    }
    public static FileManager getFileManagerInstance(){
        if(fileManagerInstance==null){
            fileManagerInstance= new FileManager();
        }
        return fileManagerInstance;
    }
    public static void setFileManagerInstance(FileManager a){
        fileManagerInstance=a;
        Customer.setAllcustomer(fileManagerInstance.customers);
        ResturantOwner.setAllResturantOwner(fileManagerInstance.resturantOwners);
    }
    public static void saveAllDatas(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("miow.txt");
        Scanner scanner;
        try {
            FileWriter fileWriter = new FileWriter(file);
            String text = gson.toJson(FileManager.getFileManagerInstance());
            fileWriter.write(text);
            fileWriter.close();
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static void loadAllDatas(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("miow.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            StringBuilder data = new StringBuilder("");
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
                data.append("\n");
            }
            if(data.equals("")==false)
                FileManager.setFileManagerInstance(gson.fromJson(data.toString(), FileManager.class));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<String> getMapStringArray(){
        File file = new File("graph.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            ArrayList<String> MapS = new ArrayList<>();
            while (scanner.hasNextLine()){
                MapS.add(scanner.nextLine().trim());
            }
            MapS.remove(0);
            return MapS;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

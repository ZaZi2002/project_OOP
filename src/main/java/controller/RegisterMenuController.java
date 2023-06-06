package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Customer;
import model.FileManager;
import view.Main;
import view.Menu;
import view.RegisterMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class RegisterMenuController {
    private RegisterMenu registerMenu;

    public RegisterMenuController() {
        registerMenu = new RegisterMenu(this);
    }

    public String setANewPassword(String newPassword) {
        newPassword = newPassword.trim();
        if (newPassword.length() < 6 || !newPassword.matches(".*[a-z].*") || !newPassword.matches(".*[A-Z].*") || !newPassword.matches(".*[0-9].*") || !newPassword.matches(".*[^a-zA-Z0-9|_].*"))
            return handlePasswordErrors(newPassword);
        System.out.println("Please re-enter your password");
        String checkpassword = Menu.getScanner().nextLine();
        if (!checkpassword.equals(newPassword)) {
            return "Your password does not match";
        }
        return "Your account has been successfully created";
    }

    public String handlePasswordErrors(String password) {
        if (password.length() < 6)
            return "Weak password! Password length should be more than 5.";

        if (!password.matches(".*[a-z].*"))
            return "Weak password! Password should have at least one small English letter.";

        if (!password.matches(".*[A-Z].*"))
            return "Weak password! Password should have at least one capital English letter.";

        if (!password.matches(".*[0-9].*"))
            return "Weak password! Password should have at least one digit.";

        if (!password.matches(".*[^a-zA-Z0-9|_].*"))
            return "Weak password! Password should have at least one character except english letters and digits.";

        else return "";
    }

    public void setnewCustomer(String name, String password) {
        Customer customer;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File("customer.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            StringBuilder data = new StringBuilder("");
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
                data.append("\n");
            }
            FileManager.setFileManagerInstance(gson.fromJson(data.toString(), FileManager.class));
            boolean checker = true;
            scanner.close();
            if (checker) {
                Customer newcustomer = new Customer(name, password);
                FileWriter fileWriter = new FileWriter(file);
                FileManager.getFileManagerInstance().customers.add(newcustomer);
                String write = gson.toJson(FileManager.getFileManagerInstance());
                fileWriter.write(write);
                fileWriter.close();
                System.out.println("Registration was successful");
            } else {
                System.out.println("This name already exists");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


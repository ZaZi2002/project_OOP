package model;

import java.util.ArrayList;

public class Food {
    private String name;
    private int id;
    private double price;
    private double discount;
    private boolean Activated;
    private double rating;
    private ArrayList<Comment> comments = new ArrayList<>();
    public Food(String name, int id, double price, double discount) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.discount = discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setActivated(boolean activated) {
        Activated = activated;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public boolean isActivated() {
        return Activated;
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
}

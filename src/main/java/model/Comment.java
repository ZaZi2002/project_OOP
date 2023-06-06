package model;

public class Comment {
    private Customer customer;
    private double rating;
    private String content;
    private boolean isAnswered;
    private String response;
    public Comment(Customer customer, double rating, String content) {
        this.customer = customer;
        this.rating = rating;
        this.content = content;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public String getResponse() {
        return response;
    }
}

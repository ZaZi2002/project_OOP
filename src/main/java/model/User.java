package model;

public class User {

    private String name;
    private int node;

    private String password;
    private String SecurityQuestion;
    public User(String name , String password,int node,String SecurityQuestion)
    {
        this.name = name;
        this.password = password;
        this.node = node;
        this.SecurityQuestion=SecurityQuestion;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public String getSecurityQuestion() {
        return SecurityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        SecurityQuestion = securityQuestion;
    }
}

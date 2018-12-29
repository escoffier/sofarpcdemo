package com.example.Model;

public class Order {
    String user = "robbie";
    String id = "12222";
    int number = 0;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + id +
                ", user=" + user +
                ", number='" + number + '\'' +
                '}';
    }
}

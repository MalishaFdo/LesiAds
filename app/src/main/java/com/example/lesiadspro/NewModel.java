package com.example.lesiadspro;

public class NewModel {

    String id, name,  email, feed;
    public NewModel(){}

    //Add constructor

    public NewModel(String id, String name, String email, String feed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.feed = feed;
    }

    //Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }
}

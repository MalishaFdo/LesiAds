package com.example.lesiadspro;

public class Payment {
    private String p_name;
    private String p_email;
    private String crdName;
    private String crdNumber;
    private String cvv;
    private String expireDate;
    private String position;

    //Default constructor
    public Payment() {}

    public Payment(String p_name, String position) {
        this.p_name = p_name;
        this.position = position;
    }

    //Create Getters and Setters
    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public String getCrdName() {
        return crdName;
    }

    public void setCrdName(String crdName) {
        this.crdName = crdName;
    }

    public String getCrdNumber() {
        return crdNumber;
    }

    public void setCrdNumber(String crdNumber) {
        this.crdNumber = crdNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
}

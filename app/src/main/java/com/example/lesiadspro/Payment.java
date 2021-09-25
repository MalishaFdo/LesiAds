package com.example.lesiadspro;

public class Payment {
    private String p_name;
    private String p_email;
    private String crdName;
    private Integer crdNumber;
    private Integer cvv;
    private String expireDate;

    //Default constructor
    public Payment() {}

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

    public Integer getCrdNumber() {
        return crdNumber;
    }

    public void setCrdNumber(Integer crdNumber) {
        this.crdNumber = crdNumber;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
}

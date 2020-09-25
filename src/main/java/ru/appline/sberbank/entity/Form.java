package ru.appline.sberbank.entity;

public class Form {

    private static Form form = new Form();

    private String price = "5180000";
    private String anInitialFee = "3058000";
    private String  creditTerm = "30";
    private String lifeInsurance = "false";
    private String youngFamily = "true";

    private Form() {
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAnInitialFee() {
        return anInitialFee;
    }

    public void setAnInitialFee(String anInitialFee) {
        this.anInitialFee = anInitialFee;
    }

    public String getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(String creditTerm) {
        this.creditTerm = creditTerm;
    }

    public String getLifeInsurance() {
        return lifeInsurance;
    }

    public void setLifeInsurance(String lifeInsurance) {
        this.lifeInsurance = lifeInsurance;
    }

    public String getYoungFamily() {
        return youngFamily;
    }

    public void setYoungFamily(String youngFamily) {
        this.youngFamily = youngFamily;
    }

    public static Form getForm(){
        if (form == null){
            form = new Form();
        }
        return form;
    }
}

package com.example.notebookwebproject.SQLTEST;

public class infoTEST {
    private int ID, Price, Weight;
    private String Model, ImgURLf, ImgURLb;

    public String getModel(){
        return Model;
    }
    public void setModel(String Model){
        this.Model = Model;
    }

    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public String getInfoURL(){
        String homepageURL = "http://comalmot.com/notebookinfo/";
        homepageURL = homepageURL + String.valueOf(ID);
        return homepageURL;
    }

    public int getPrice(){
        return Price;
    }
    public void setPrice(int Price){
        this.Price = Price;
    }
    public String getPriceString(){ //1000단위로 콤마
        int Qprice;
        int threecomma = 1000;
        String PriceString ="";

        Qprice = Price;
        while(Qprice>0){
            if(Qprice != Price)
                PriceString = "," + PriceString;
            if(Qprice%threecomma == 0)
                PriceString = "000" + PriceString;
            else
                PriceString = String.valueOf(Qprice%threecomma) + PriceString;
            System.out.println(PriceString + " / " + Qprice);
            Qprice  = Qprice/threecomma;
        }
        return PriceString;
    }

    public int getWeight(){
        return Weight;
    }
    public void setWeight(int Weight){
        this.Weight = Weight;
    }

    public String getImgURLf(){
        return ImgURLf;
    }
    public void setImgURLf(String ImgURLf){
        this.ImgURLf = ImgURLf;
    }

    public String getImgURLb(){
        return ImgURLb;
    }
    public void setImgURLb(String ImgURLb){
        this.ImgURLb = ImgURLb;
    }



}

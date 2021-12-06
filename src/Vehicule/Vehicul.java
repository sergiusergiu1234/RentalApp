package Vehicule;

public class Vehicul {
    //campuri
    String model;
    String culoare;
    public double pret;
    int locuri;


   public Vehicul(String model,String culoare, double pret , int locuri){ //constructor
        this.model=model;
        this.culoare=culoare;
        this.pret=pret;
        this.locuri=locuri;
    }

//metode get si set
    public String getCuloare(){
        return this.culoare;
    }
    public String getModel(){
        return model;
    }
    public int getLocuri(){
        return locuri;
    }
    public double getPret(){
        return pret;
    }

    }





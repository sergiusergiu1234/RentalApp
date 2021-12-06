package Vehicule;

public class Motocicleta extends Vehicul implements IMotocicleta, IVehicul {

    //camp
    private boolean isElectric;
    //constructor prin mostenire (Vehicul)
    public Motocicleta(String model, String culoare,double pret, int locuri, boolean isElectric){  //constructor
        super(model,culoare, pret, locuri);
        this.isElectric=isElectric;
    }
    public Motocicleta(String culoare, String model,double pret, int locuri){   //constructor fara isElectric
        super(culoare,model,pret,locuri);
        this.isElectric=false;
    }
    //metode get si set
    public void setCuloare(String a){
        culoare=a;
    }
    public void setModel(String a){
        model=a;
    }
    public void setPret(double a){
        pret=a;
    }
    public  void setLocuri(int a){
        locuri=a;
    }
    public void setElectric(boolean a){
        isElectric=a;
    }
    public boolean isElectric(){
        return this.isElectric;
    }
    public String getModel(){
        return this.model;
    }
    public double getPret(){
        return this.pret;
    }
    public int getLocuri(){
        return this.locuri;
    }
    public String getCuloare(){
        return this.culoare;
    }
    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append("(Motocicleta) ");
        s.append("Model: ");
        s.append(getModel());
        s.append("  Pret: ");
        s.append(getPret()+" lei");
        s.append("  Electrinc: ");
        s.append(isElectric());
        s.append("  Nr Locuri: ");
        s.append(getLocuri());
        s.append("  Culoare: ");
        s.append(getCuloare());
        return s.toString();
    }
}

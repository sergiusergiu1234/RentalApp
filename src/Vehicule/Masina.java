package Vehicule;

public class Masina extends Vehicul implements IMasina,IVehicul {
    //campuri
  private final boolean isConvertible;
  private final boolean isElectric;
    //constructor prin mostenire (Vehicul)
    public Masina(String model,String culoare, double pret,int locuri){   //constructor fara campurile isConvertible si  isElectric
        super(model,culoare,pret,locuri);
        this.isConvertible=false;
        this.isElectric=false;
    }

    public Masina(String model,String culoare, double pret,int locuri,boolean isConvertible,boolean isElectric)    //constructor
    {
        super(model, culoare, pret, locuri);
        this.isConvertible=isConvertible;
        this.isElectric=isElectric;
    }

    //metode get si set

    public boolean isConvertible() {
        return this.isConvertible;
    }
    public boolean isElectric() {
        return this.isElectric;
    }
    public void setPret(double pret){
        this.pret=pret;
    }
    public void setLocuri(int locuri){
        this.locuri=locuri;
    }
    public void setModel(String model){
        this.model=model;
    }
    public void setCuloare(String culoare){
        this.culoare=culoare;
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
        StringBuffer s = new StringBuffer("(Masina) ");
        s.append("Model : ");
        s.append(this.getModel());
        s.append("  Pret: ");
        s.append(this.getPret()+" lei");
        s.append("  Decapotabil: ");
        s.append(isConvertible());
        s.append("  Electric: ");
        s.append(isElectric());
        s.append("  Nr Locuri: ");
        s.append(this.getLocuri());
        s.append("  Culoare: ");
        s.append(this.getCuloare());
        return s.toString();
    }
}

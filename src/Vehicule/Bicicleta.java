package Vehicule;

public class Bicicleta extends Vehicul implements IBicicleta,IVehicul{

    //campuri
    boolean areSchimbator;
    int nrViteze;

    //constructor prin mostenire (Vehicul)
    public Bicicleta(String model, String culoare,double pret, int locuri, boolean areSchimbator, int nrViteze){   //constructor
        super(model, culoare, pret, locuri);
        this.areSchimbator=areSchimbator;
        this.nrViteze=nrViteze;
    }
    public Bicicleta(String model, String culoare,double pret, int locuri){       //constructor fara camp "are schimbator" si nrViteze
        super(model,culoare,pret,locuri);
        this.areSchimbator=false;
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
    public  void setNrViteze(int a){
        nrViteze=a;
    }
    public  boolean areSchimbator(){
        return areSchimbator;
    }
    public int getnrViteze(){return this.nrViteze;}
    public String getModel(){
        return this.model;
    }
    public double getPret(){
        return this.pret;
    }
    public boolean getareSchimbator(){
        return this.areSchimbator;
    }
    public int getLocuri(){
        return this.locuri;
    }
    public String getCuloare(){
        return this.culoare;
    }


    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append("(Bicicleta) ");
        s.append("Model: ");
        s.append(getModel());
        s.append("  Pret: ");
        s.append(getPret()+" lei");
        s.append("  Schimbator: ");
        s.append(getareSchimbator());
        s.append("  Numar Viteze: ");
        s.append(getnrViteze());
        s.append("  Nr Locuri: ");
        s.append(getLocuri());
        s.append("  Culoare: ");
        s.append(getCuloare());
        return s.toString();
    }
}

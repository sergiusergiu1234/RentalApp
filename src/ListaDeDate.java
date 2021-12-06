import java.util.ArrayList;
import Vehicule.*;

public  class ListaDeDate extends ArrayList {

    private ArrayList listaS;    //arrayList

    //singleton***
    private static ListaDeDate instance;

    private ListaDeDate(){
        listaS= new ArrayList();
    }
    public  static ListaDeDate getInstance(){
        if (instance==null){
            instance=new ListaDeDate();
        }
        return instance;
    }
    //***

    public void addVehicul(Vehicul  vehicul){
        listaS.add(vehicul);
    } //adaugare vehicul in lista
    public int getSize(){
        return listaS.size();
    }  //returneaza marimea listei
    @Override
    public Object[] toArray(){
        return listaS.toArray();
    } //convert toArray
    public void removeVehicul(int i){
        listaS.remove(i);
    } //sterge obiectul in functie de index
}

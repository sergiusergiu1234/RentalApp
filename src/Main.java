import Vehicule.Bicicleta;
import Vehicule.Masina;
import Vehicule.Motocicleta;



public class Main {
    public static void main(String[] args) {

        LoginForm startFrame= new LoginForm();  //form de inceput


        //obiecte Vehicul***
        Bicicleta b1 = new Bicicleta("BMX 9","Albastru",10000,1,false,0);
        Bicicleta b2 = new Bicicleta("SSM","Verde",5000,2,true,4);
        Masina m1 = new Masina("BMW m3","Negru",150000,4,false,false);
        Masina m2 = new Masina("BMW i3","Alb",100000,5,true,true);
        Motocicleta mm2 = new Motocicleta("FFo","Alb",40000,2,true);
        Motocicleta mm1= new Motocicleta("FFo","Rosu",60000,1,true);
        //***

        ListaDeDate a = ListaDeDate.getInstance(); //apeleaza lista singleton

        Client c1 = new Client("Aladin","Ahal",10000);  //client

        //add vehicule in ListaDeDate***
        a.addVehicul(b1);
        a.addVehicul(b2);
        a.addVehicul(m1);
        a.addVehicul(m2);
        a.addVehicul(mm1);
        a.addVehicul(mm2);
        //***

    }
}

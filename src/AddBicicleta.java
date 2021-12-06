import Vehicule.Bicicleta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBicicleta extends JFrame{
    private JTextField txtModelB;
    private JTextField txtPretB;
    private JTextField txtLocuriB;
    private JComboBox txtCuloareB;
    private JPanel formAddBicicleta;
    private JButton AddBici;
    private JRadioButton txtSchimbator;
    private JTextField txtVitezeB;
    private JButton btnBackB;


    public AddBicicleta(){
        this.setContentPane(formAddBicicleta);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500,300);
        this.setVisible(false);


        btnBackB.addActionListener(new ActionListener() {      //inchide fereastra AddBicicleta si deschide AdminForm
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminForm frame = new AdminForm();
                frame.setVisible(true);
            }
        });
        AddBici.addActionListener(new ActionListener() {    //adauga obiect Bicicleta in ListaDeData
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean pornit = true;
                while(pornit) {


                    //creeaza obiect Bicicleta
                    Bicicleta b= new Bicicleta("","",0,0,txtSchimbator.isSelected(),0);



                    String model = txtModelB.getText(); //salveaza text din JTextField in String

                    if (model.equals("")) {         //verifica daca stringul e gol
                        JOptionPane.showConfirmDialog(null, "Text lipsa la model", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                    }else{
                        b.setModel(model);   //seteaza campul model din Bicicleta
                    }

                    double pret;
                    try {
                        String stringPret = txtPretB.getText(); //salveaza text din JTextField
                        pret = Double.valueOf(stringPret);      //Schimba Stringul salvat in Double
                        b.setPret(pret);                        //daca nu da exceptie seteaa pretul obietului
                    } catch (NumberFormatException exception) {
                        JOptionPane.showConfirmDialog(null, "Text lipsa/Format invalid", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                    }
                    int locuri;
                    try{
                        String stringLocuri = txtLocuriB.getText(); //salveaza text din JTextField
                        locuri = Integer.valueOf(stringLocuri);     //Schimba Stringul salvat in int
                        b.setLocuri(locuri);                        //daca nu da exceptie seteaa pretul obietului
                    }catch(NumberFormatException exception){
                        JOptionPane.showConfirmDialog(null, "Text lipsa/Format invalid", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                    }

                    b.setCuloare((String) txtCuloareB.getSelectedItem());   //seteaza culoarea in fucntie de optiune


                    int viteze;
                    String stringViteze = txtVitezeB.getText();
                    if(txtSchimbator.isSelected()==false){      //daca bicicleta nu are schimbator, campul viteze =0
                        stringViteze ="";

                    }
                    try{
                        if (stringViteze.equals("")) {
                            viteze = 0;
                            b.setNrViteze(viteze);
                        } else {
                            viteze = Integer.valueOf(stringViteze);   //converteste  stringul in int
                            b.setNrViteze(viteze);          //daca nu da exceptie seteaza nt de viteze
                        }
                        ListaDeDate.getInstance().addVehicul(b);        //adauga vehicul in lista
                        break;
                    }catch(NumberFormatException exception){
                        JOptionPane.showConfirmDialog(null, "Format invalid", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                    }

                }
            }
        });
        txtSchimbator.addActionListener(new ActionListener() {      //modifica starea obiecului txtVitezeB
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtSchimbator.isSelected()){
                    txtVitezeB.setEnabled(true);
                }
                else{
                    txtVitezeB.setEnabled(false);
                }
            }
        });
    }
}

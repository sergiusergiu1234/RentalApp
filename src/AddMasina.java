import Vehicule.Masina;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMasina extends JFrame{
    private JTextField txtModelM;
    private JTextField txtPretM;
    private JTextField txtLocuriM;
    private JComboBox txtCuloareM;
    private JRadioButton txtElectricMa;
    private JRadioButton txtDecapotabil;
    private JButton AddMasina;
    private JButton btnBackMa;
    private JPanel addMasinaForm;

    public AddMasina() {
        this.setContentPane(addMasinaForm);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500,300);
        this.setVisible(false);
        btnBackMa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminForm frame = new AdminForm();
                frame.setVisible(true);
            }
        });


        AddMasina.addActionListener(new ActionListener() {  //adauga obiect masina in ListaDeDate
            @Override
           public void actionPerformed(ActionEvent e) {

                boolean pornit = true;
                while(pornit) {

                    //creeaza un obiect de tip Masina
                    Masina mm = new Masina("","",0,0,txtDecapotabil.isSelected(),txtElectricMa.isSelected()); //masina basic

                    String model = txtModelM.getText(); //preia text din JtextField si il salveaza intr-un string

                    if (model.equals("")) {         //daca se introduce string gol
                        JOptionPane.showConfirmDialog(null, "Text lipsa la model", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                    }else{
                        mm.setModel(model); //seteaza campul model
                    }
                    double pret;
                    try {
                        String prett = txtPretM.getText();      //preia text din JtextField si il salveaza intr-un string
                        pret = Double.valueOf(prett);   //transforma String in dounle
                        mm.setPret(pret);   //daca nu apare exceptie, seteaza campul pret
                    } catch (NumberFormatException exception) {
                        JOptionPane.showConfirmDialog(null, "Text lipsa/Format invalid", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                    }
                    int locuri ;
                    try{
                        String locurii = txtLocuriM.getText();      //preia text din JtextField si il salveaza intr-un string
                        locuri = Integer.valueOf(locurii);      //transforma din String in int
                        mm.setLocuri(locuri);       //daca nu apare exceptie, seteaza campul locuri
                    }catch(NumberFormatException exception){
                        JOptionPane.showConfirmDialog(null, "Text lipsa/Format invalid", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                    }

                    String culoare=(String) txtCuloareM.getSelectedItem();      //preia text din JtextField si il salveaza intr-un string
                    mm.setCuloare(culoare);     //seteaza campul culoare
                    ListaDeDate.getInstance().addVehicul(mm);
                    break;
                }
            }
        });
    }
}

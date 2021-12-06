import Vehicule.Motocicleta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMotocicleta extends JFrame{
    private JButton btnAddMoto;
    private JTextField txtModelM;
    private JTextField txtPretM;
    private JTextField txtLocuriM;
    private JComboBox txtCuloareM;
    private JButton btnBackM;
    private JRadioButton txtElectricM;
    private JPanel addMotocicletaForm;

    public AddMotocicleta(){
        this.setContentPane(addMotocicletaForm);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500,300);
        this.setVisible(false);
        btnBackM.addActionListener(new ActionListener() {   //inchide interfata curenta si deschide AdminForm
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminForm frame = new AdminForm();
                frame.setVisible(true);
            }
        });
        btnAddMoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean pornit = true;
                while(pornit) {
                    Motocicleta m=new Motocicleta("","",0,0);


                    //seteaza campul isElectric in functie de starea JRadioButton
                    m.setElectric(txtElectricM.isSelected());


                    //preia text din JtextField si il salveaza intr-un string
                    String stringModel = txtModelM.getText();


                    if (stringModel.equals("")) {   //daca stringul este gol
                        JOptionPane.showConfirmDialog(null, "Text lipsa la model", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                    }
                    m.setModel(stringModel);    //seteaza campul model
                    double pret;
                    try {
                        String stringPret = txtPretM.getText();      //preia text din JtextField si il salveaza intr-un string
                        pret = Double.valueOf(stringPret);      //transforma string in double
                        m.setPret(pret);        //seteaza camp pret
                    } catch (NumberFormatException exception) {
                        JOptionPane.showConfirmDialog(null, "Text lipsa/Format invalid", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                    }
                    int locuri;
                    try{
                        String stringLocuri = txtLocuriM.getText(); //salveaza taxt din JTextField intr-un string
                        locuri = Integer.valueOf(stringLocuri);     //transforma String in int
                        m.setLocuri(locuri);        //seteaza camp locuri
                    }catch(NumberFormatException exception){
                        JOptionPane.showConfirmDialog(null, "Text lipsa/Format invalid", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                    }
                    String culoare =(String) txtCuloareM.getSelectedItem(); //seteaza culoare in functie de optiunea aleasa
                    if(culoare.equals("")){
                        JOptionPane.showConfirmDialog(null, "Text lipsa", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        break;
                    }else{
                        m.setCuloare(culoare); //seteaza culoarea
                    }
                    ListaDeDate.getInstance().addVehicul(m); // adauga obiecul in lista
                    break;
                }
            }
        });
     }
}

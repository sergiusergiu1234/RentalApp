
import Vehicule.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InchiriereForm extends JFrame {
    private JButton inchiriereVehiculButton;
    private JList userList;
    private JButton btnBack;
    private JPanel form4;

    public InchiriereForm() {
        this.setContentPane(form4);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(600,200);
        this.setVisible(false);
        this.userList.setListData(ListaDeDate.getInstance().toArray());

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UserForm frame = new UserForm();
                frame.setVisible(true);
            }
        });

        inchiriereVehiculButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

           //     System.out.println(userList.getSelectedValue());


                try{ Vehicul selected =(Vehicul) userList.getSelectedValue();   //returneaza obiectul(Vehicul) selectat
                    if(Client.sold>=selected.getPret()){                //daca sold>pretul obiecutlui selectat

                        Client.sold=Client.sold-selected.getPret();//se scade din soldul clientului

                        ListaDeDate a= ListaDeDate.getInstance();       //se apeleaza lista

                        a.removeVehicul(userList.getSelectedIndex());     //se sterge obiectul selectat

                        userList.setListData(a.toArray());                 //se updateaza Jlist
                    }
                    else
                    {
                        JOptionPane.showConfirmDialog(null, "Insuficiente money bori!", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);

                    }
                }catch(NullPointerException exception){
                    JOptionPane.showConfirmDialog(null, "Nu ai selectat nimic!", "ERROR",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                }
            }
        });
    }
}

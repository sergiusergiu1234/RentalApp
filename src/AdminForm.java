import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminForm extends JFrame{
    private JButton addButton;
    private JButton deleteButton;
    private JList adminList;
    private JButton adminOut;
    private JPanel form3;
    private JRadioButton radioButtonMotor;
    private JRadioButton radioButtonMasina;
    private JRadioButton radioButtonBicicleta;

    public AdminForm(){
       this.setContentPane(form3);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.pack();
       this.setSize(900,300);
       this.setVisible(false);
       this.adminList.setListData(ListaDeDate.getInstance().toArray());


       adminOut.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               LoginForm frame= new LoginForm();
               dispose();
               frame.setVisible(true);
           }
       });


        addButton.addActionListener(new ActionListener() {      //inchide interfata curenta si deschide alta interfata:
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButtonMotor.isSelected()){          //pt motocicleta
                    dispose();
                    AddMotocicleta frame = new AddMotocicleta();
                    frame.setVisible(true);
                }
                if(radioButtonBicicleta.isSelected()){      //pt bicicleta
                    dispose();
                    AddBicicleta frame = new AddBicicleta();
                    frame.setVisible(true);
                }
                if(radioButtonMasina.isSelected()){         //pt masina
                    dispose();
                    AddMasina frame = new AddMasina();
                    frame.setVisible(true);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {   //sterge obiectul selectat in JList

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                  ListaDeDate a=  ListaDeDate.getInstance();       //acceseaza lista singleton
                int temp=adminList.getSelectedIndex();              //salveaza indexul itemului selectat
                a.removeVehicul(temp);                              //sterge itemul la indexul resprectiv
                adminList.setListData(a.toArray());                 //update Jlist dupa stergerea obiecutlui
                }catch(IndexOutOfBoundsException exception){
                    JOptionPane.showConfirmDialog(null, "Nu ai selectat nimic!", "ERROR",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                }
            }
        });
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class UserForm extends JFrame {
    private JPanel form2;
    private JButton inchiriazaVehiculButton;
    private JButton addSoldButton;
    private JLabel lblNumeClient;
    private JLabel lblSold;
    private JButton logOutButton;
    private JLabel lblPrenumeClient;

    public UserForm(){

        //interfata vizuala client
        this.setContentPane(form2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(300,200);
        this.setVisible(false);

        lblSold.setText(Client.sold+ "");  //afiseaza sold-ul clientului in label
        lblNumeClient.setText(Client.nume);  //afisarea numelui clientului in label
        lblPrenumeClient.setText(Client.prenume); //afisarea prenumelui clientului in label

        logOutButton.addActionListener(new ActionListener() { //inchide fromul si deschide intergata de logare
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm frame= new LoginForm();
                frame.setVisible(true);

            }
        });
        inchiriazaVehiculButton.addActionListener(new ActionListener() { //inchide UserForm si deschide InchiriereForm
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ListaDeDate.getInstance().getSize()<=0){ //erroare daca nu sunt vehicule in lista
                    JOptionPane.showConfirmDialog(null, "Nu sunt vehicule disponibile momentan...", "ERROR",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                }else{
                    dispose();
                    InchiriereForm frame = new InchiriereForm();
                    frame.setVisible(true);
                }
            }

        });
        addSoldButton.addActionListener(new ActionListener() {  //deschide AdaugareSold si inchide UserForm
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdaugareSold frame = new AdaugareSold();
                frame.setVisible(true);
            }
        });
    }
}
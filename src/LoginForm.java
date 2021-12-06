import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class LoginForm extends JFrame {

    private JButton button1;
    private JPasswordField txtPass;
    private JTextField txtUser;
    private JPanel form1;
    //constante
    public final String ADMIN="Admin";
        public final String ADMINP="123";

    public LoginForm() {

        //interfata vizuala de logare
        this.setContentPane(form1);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(300,200);
        this.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user= txtUser.getText();    //salvam textul din JTextField
                String pass=txtPass.getText();     //salvam textul din JPasswordField

                if(user.equals("Aladin")&&pass.equals("123")){  //verificare user
                    dispose(); //inchide frame
                    UserForm frame2= new UserForm();
                    frame2.setVisible(true);

                }
                else if(user.equals(ADMIN)&&pass.equals(ADMINP)){   //verificare admin
                    dispose();  //inchide frame
                    AdminForm frame3 = new AdminForm();
                    frame3.setVisible(true);

                }
                else{         //creem o fereastra modala daca username-ul si parola sunt incorecte
                    JOptionPane.showConfirmDialog(null,"username sau parola incorecta","ERROR",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );
                }
            }
        });


    }
}
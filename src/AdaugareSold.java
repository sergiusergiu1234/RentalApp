
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaugareSold extends JFrame {
    private JPanel adaugaresold;
    private JTextField txtsold;
    private JButton confirmadaugaresold;
    private JButton canceladaugaresold;

    public AdaugareSold() {
        //Interfata vizuala AdaugareSold
        this.setContentPane(adaugaresold);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(250, 150);
        this.setVisible(false);
        confirmadaugaresold.addActionListener(new ActionListener() { //Adauga Sold dupa verificari
            @Override
            public void actionPerformed(ActionEvent e) {

                //verificare
                try{
                    int a=Integer.parseInt(txtsold.getText());
                    if(a<0){
                        a=0;
                        JOptionPane.showConfirmDialog(null, "Suma invalida", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                    }
                    else
                    if(a<10000){
                        a=0;
                        JOptionPane.showConfirmDialog(null, "Suma prea mica (minim 10.000 lei)", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                    }
                    while(a>100000){
                        a=0;
                                JOptionPane.showConfirmDialog(null, "Ati introdus o suma prea mare(maxim 100.000 lei)", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                    }
                    Client.sold=Client.sold+a;
                    if(Client.sold>200000){
                        Client.sold=Client.sold-a;
                                JOptionPane.showConfirmDialog(null, "Contul depaseste suma maxima da 200.000 lei", "ERROR",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                    }
                }catch(NumberFormatException exception){
                    JOptionPane.showConfirmDialog(null, "Format invalid!", "ERROR",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                }finally{
                    dispose();
                    UserForm frame=new UserForm();
                    frame.setVisible(true);
                }

            }
        });
        canceladaugaresold.addActionListener(new ActionListener() { //inchide AdaugareSold si deschide UserForm
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UserForm frame2= new UserForm();
                frame2.setVisible(true);

            }
        });
    }
}
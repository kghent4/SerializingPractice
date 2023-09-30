import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javax.swing.*;
import javafx.stage.WindowEvent;
import java.util.ArrayList;
import java.awt.Color;
 
public class AccountsGUI {

    //Create components of the graphics interface
    JFrame frame;
    JButton CHbutton;
    JButton SAbutton;
    JButton saveButton;
    JTextArea CHLabel;
    JTextArea SALabel;
    JTextArea CHBalance;
    JTextArea SABalance;
    JTextArea ErrLabel;
    JTextArea INLabel;
    JTextField moneyField;
    ArrayList<User> users;
    User user;
  
    public AccountsGUI(ArrayList<User> u) {

        //Custom class variables
        users = u;

        //Frame
        frame = new JFrame("My Accounts");
        frame.setBounds(0, 0, 300, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(118, 140, 181));

        //Change checking button
        CHbutton = new JButton("Add to checking");
        CHbutton.setBounds(50, 200, 200, 30);
        frame.add(CHbutton);

        //Change savings button
        SAbutton = new JButton("Add to savings");
        SAbutton.setBounds(50, 230, 200, 30);
        frame.add(SAbutton);

        //Save and Exit button
        saveButton = new JButton("Save and Close");
        saveButton.setBounds(165, 0, 125, 30);
        frame.add(saveButton);

        //Checking label
        CHLabel = new JTextArea("Checking balance: ");
        CHLabel.setBounds(50, 50, 100, 20);
        frame.add(CHLabel);
        CHLabel.setBackground(new Color(118, 140, 181));
        CHLabel.setEditable(false);

        //Savings label
        SALabel = new JTextArea("Savings balance: ");
        SALabel.setBounds(50, 70, 100, 20);
        frame.add(SALabel);
        SALabel.setBackground(new Color(118, 140, 181));
        SALabel.setEditable(false);

        //Checking balance
        CHBalance = new JTextArea("$0.00");
        CHBalance.setBounds(150, 50, 100, 20);
        frame.add(CHBalance);
        CHBalance.setBackground(new Color(118, 140, 181));
        CHBalance.setEditable(false);

        //Savings balance
        SABalance = new JTextArea("$0.00");
        SABalance.setBounds(150, 70, 100, 20);
        frame.add(SABalance);
        SABalance.setBackground(new Color(118, 140, 181));
        SABalance.setEditable(false);

        //Instructions label
        INLabel = new JTextArea("Enter the amount you would like to deposit/withdraw, then press the appripropriate button.");
        INLabel.setBounds(50, 100, 200, 60);
        frame.add(INLabel);
        INLabel.setBackground(new Color(118, 140, 181));
        INLabel.setLineWrap(true);
        INLabel.setEditable(false);

        //Field to change account balances
        moneyField = new JTextField("");
        moneyField.setBounds(50, 160, 200, 20);
        frame.add(moneyField);

        //Error label
        ErrLabel = new JTextArea();
        ErrLabel.setBounds(50, 280, 200, 60);
        frame.add(ErrLabel);
        ErrLabel.setBackground(new Color(118, 140, 181));
        ErrLabel.setLineWrap(true);

        //Add action listeners
        CHbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            try{
                double c = Double.parseDouble(moneyField.getText());
                ErrLabel.setText(user.setCheckingBalance(c));
                CHBalance.setText("$" + user.getCheckingBalance());
            }

            catch(Exception ex){
                ErrLabel.setText("Something went wrong. Make sure your number is formatted as: ##.##");
            }

        }});

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            System.out.println("SERIALIZE DATA HERE");
            System.exit(0);

        }});

        SAbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            try{
                double c = Double.parseDouble(moneyField.getText());
                ErrLabel.setText(user.setSavingsBalance(c));
                SABalance.setText("$" + user.getSavingsBalance());
            }

            catch(Exception ex){
                ErrLabel.setText("Something went wrong. Make sure your number is formatted as: ##.##");
            }
                
        }});

    }

    public void setVisible(boolean b){
        frame.setVisible(b);
    }

    public void setUser(User u){
        user = u;
    }
}
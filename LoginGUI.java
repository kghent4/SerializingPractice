import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
 
public class LoginGUI {

    //Create components of the graphics interface
    JFrame frame;
    JButton LIbutton;
    JButton SUbutton;
    JTextArea UNLabel;
    JTextArea PWLabel;
    JTextField UNField;
    JPasswordField PWField;
    JTextArea ErrLabel;
    ArrayList<User> users;
    AccountsGUI accountsScreen;
  
    public LoginGUI(ArrayList<User> u, AccountsGUI a) {

        //Custom class variables
        users = u;
        accountsScreen = a;

        //Frame
        frame = new JFrame("Generic Bank App");
        frame.setBounds(0, 0, 300, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(118, 140, 181));

        //Log in button
        LIbutton = new JButton("Log In");
        LIbutton.setBounds(50, 150, 100, 30);
        frame.add(LIbutton);

        //Sign up button
        SUbutton = new JButton("Sign up");
        SUbutton.setBounds(150, 150, 100, 30);
        frame.add(SUbutton);

        //Username label
        UNLabel = new JTextArea("Username: ");
        UNLabel.setBounds(50, 50, 100, 20);
        frame.add(UNLabel);
        UNLabel.setBackground(new Color(118, 140, 181));
        UNLabel.setEditable(false);

        //Password label
        PWLabel = new JTextArea("Password: ");
        PWLabel.setBounds(50, 100, 100, 20);
        frame.add(PWLabel);
        PWLabel.setBackground(new Color(118, 140, 181));
        PWLabel.setEditable(false);

        //Username field
        UNField = new JTextField("");
        UNField.setBounds(150, 50, 100, 20);
        frame.add(UNField);

        //Password field
        PWField = new JPasswordField("");
        PWField.setBounds(150, 100, 100, 20);
        frame.add(PWField);

        //Error label
        ErrLabel = new JTextArea();
        ErrLabel.setBounds(50, 200, 200, 60);
        frame.add(ErrLabel);
        ErrLabel.setBackground(new Color(118, 140, 181));
        ErrLabel.setLineWrap(true);

        //Set frame to visible
        frame.setVisible(true);

        //Add action listeners
        LIbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String un = UNField.getText();
                String pw = new String(PWField.getPassword());

                for(User u: users){
                    if(u.getUsername().equals(un) && u.getPassword().equals(pw)){
                        ErrLabel.setText("Login successful");
                        accountsScreen.setVisible(true);
                        accountsScreen.setUser(u);
                        frame.dispose();
                        return;
                    }
                }     
                ErrLabel.setText("Username not found. Did you make an account?");
            }
        });

        SUbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String un = UNField.getText();

                for(User u: users){
                    if(u.getUsername().equals(un)){
                        ErrLabel.setText("Account already exists.");
                        return;
                    }
                }

                String pw = new String(PWField.getPassword());
                users.add(new User(un, pw));      
                ErrLabel.setText("Account successfully created. Log in to access your bank account info.");
            }
        });

    }

    public void setVisible(boolean b){
        frame.setVisible(b);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author nishan
 */
public class LibrarianLogin extends JFrame{
    
    //Initializing required labels, text area and buttons
    private JPanel panel;
    private JLabel loginInfo;
    private JLabel lblName;
    private JLabel lblPassword;
    private JTextField jtaName;
    private JPasswordField jtaPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    
    private LineBorder lineBorder;
    
    public LibrarianLogin() {
        super("Library System");//title for our frame
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);//centering frame in window
        
        initComponents();
    }
    
    private void createLibrarianData() {
        //create file
        File fileName = new File("LibrarianLogin.txt");
                
        try {
            PrintWriter output = new PrintWriter(fileName);
            //adding text to file     
            output.write("Bob,1234 \nAlice,abcd \nAli,ab1234");
            output.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private boolean accessLogin(String name, String pass) throws IOException, Exception {
        String line;
        ArrayList arr = new ArrayList();
        
        try {
            //read data from file
            FileReader fileReader = new FileReader("LibrarianLogin.txt");
            BufferedReader input = new BufferedReader(fileReader);
            
            if(!input.ready()) {
                throw new Exception();
            }
            
            while ((line = input.readLine()) != null) {
                //adding each lines of 'LibrarianLogin.txt' to the arraylist
                arr.add(line);
            }
            
            String first = arr.get(0).toString();
            String second = arr.get(1).toString();
            String third = arr.get(2).toString();
            
            //splits string against given regular expression and returns a char array.
            String[] parts1 = first.split(",");
            String userName1 = parts1[0];
            String password1 = parts1[1];
            
            String[] parts2 = second.split(",");
            String userName2 = parts2[0];
            String password2 = parts2[1];
            
            String[] parts3 = third.split(",");
            String userName3 = parts3[0];
            String password3 = parts3[1];
            
            
            if (name.equals(userName1) && pass.equals("1234")) {
                return true;
            } else if(name.equals(userName2) && pass.equals("abcd")) {
                return true;
            } else if(name.equals(userName3) && pass.equals("ab1234")) {
                return true;
            } else {
                return false;
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return false;
    }
    
    private void initComponents() {
        panel = new JPanel();
        this.setContentPane(panel);
        panel.setLayout(null);
        panel.setBackground(Color.white);
        lineBorder = new LineBorder(Color.black, 2, true);
        
        loginInfo = new JLabel("----- Login here -----");
        lblName = new JLabel("Name");
        lblPassword = new JLabel("Password");
        
        jtaName = new JTextField();
        jtaPassword = new JPasswordField();
        
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");
        
        //adding componets to panel
        panel.add(loginInfo);
        panel.add(lblName);
        panel.add(lblPassword);
        panel.add(jtaName);
        panel.add(jtaPassword);
        panel.add(btnLogin);
        panel.add(btnCancel);
        
        loginInfo.setBounds(350, 50, 300, 50);
        loginInfo.setFont(new Font("Sarif", Font.BOLD, 25));
        
        lblName.setBounds(300, 200, 250, 50);
        lblName.setFont(new Font("Sarif", Font.PLAIN, 15));
        
        lblPassword.setBounds(300, 300, 250, 50);
        lblPassword.setFont(new Font("Sarif", Font.PLAIN, 15));
        
        jtaName.setBounds(500, 200, 250, 50);
        jtaName.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaName.setBorder(lineBorder);
        
        jtaPassword.setBounds(500, 300, 250, 50);
        jtaPassword.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaPassword.setBorder(lineBorder);
        
        btnLogin.setBounds(300, 400, 200, 50);
        btnLogin.setFont(new Font("Sarif", Font.PLAIN, 20));
        btnLogin.setBackground(Color.white);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                createLibrarianData();
                
                String name = jtaName.getText();
                String password = new String(jtaPassword.getPassword());
                
                try {
                    if(!accessLogin(name, password)) {
                        JOptionPane.showMessageDialog(null, "Either name or password is wrong");
                    } else {
                        new AddBook().setVisible(true);
                        dispose();
                    }
                    
                } catch (Exception ex) {
                    Logger.getLogger(LibrarianLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        btnCancel.setBounds(550, 400, 200, 50);
        btnCancel.setFont(new Font("Sarif", Font.PLAIN, 20));
        btnCancel.setBackground(Color.white);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Welcome().setVisible(true);
                dispose();
            }
        });
    }
}

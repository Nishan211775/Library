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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nishan
 */
public class Welcome extends JFrame {
    
    private Container container;
    private JLabel lblWelcomeText;
    private JButton btnUserAccess;
    private JButton btnLibrarianAccess;
    private JPanel panel; 
    public static boolean res = false;
    
    public Welcome() {
        super("Library System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
    }
    
    private void initComponents() {
        panel = new JPanel();
        this.setContentPane(panel);
        panel.setLayout(null);
        panel.setBackground(Color.white);
        
        lblWelcomeText = new JLabel("Welcome to Library System");
        btnUserAccess = new JButton("User Access");
        btnLibrarianAccess = new JButton("Librarian Access");
        
        panel.add(lblWelcomeText);
        panel.add(btnUserAccess);
        panel.add(btnLibrarianAccess);
        
        lblWelcomeText.setBounds(110,50,500,100);
        lblWelcomeText.setFont(new Font("Sarif", Font.BOLD, 22));
        
        btnUserAccess.setBounds(40,250,250,50);
        btnUserAccess.setFont(new Font("Sarif", Font.BOLD, 16));
        btnUserAccess.setBackground(Color.white);
        btnUserAccess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ShowBooks().setVisible(true);
                dispose();
            }
        });
        
        btnLibrarianAccess.setBounds(310,250,250,50);
        btnLibrarianAccess.setFont(new Font("Sarif", Font.BOLD, 16));
        btnLibrarianAccess.setBackground(Color.white);
        btnLibrarianAccess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new LibrarianLogin().setVisible(true);
                dispose();
            }
        });
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }
    
}

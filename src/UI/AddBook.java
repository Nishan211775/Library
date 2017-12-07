/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author nishan
 */
public class AddBook extends JFrame{
    
    private LineBorder lineBorder;
    
    private JPanel panel;
    private JLabel lblDisplay;
    private JLabel lblBookTitle;
    private JLabel lblBookAuthor;
    private JLabel lblPublisher;
    private JLabel lblPublishedYear;
    private JLabel lblEdition;
    private JLabel lbllNoOfCopies;
    private JLabel lblBookNumber;
    
    private JTextField jtaBookTitle;
    private JTextField jtaBookAuthor;
    private JTextField jtaPublisher;
    private JTextField jtaPublishedYear;
    private JTextField jtaEdition;
    private JTextField jtaNoOfCopies;
    private JTextField jtaBookNumber;
    
    private JButton btnSave;
    private JButton btnCancel;
    
    public AddBook() {
        super("Library System");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        
    }
    
    
    private void onlyNumber(JTextField fieldName) {
        fieldName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char value = e.getKeyChar();
                if((value < '0' || value > '9') && value != '\b') {
                    e.consume();
                }
            }
        });
    }
    
    private void values() {
        String bookTitle = jtaBookTitle.getText();
        String bookAuthor = jtaBookAuthor.getText();
        String publisher = jtaPublisher.getText();
        int publishedYear = 0;
        int edition = 0;
        int noOfCopies = 0;
        int bookNumber = 0;
        
        try {
            publishedYear = Integer.parseInt(jtaPublishedYear.getText());
            edition = Integer.parseInt(jtaEdition.getText());
            noOfCopies = Integer.parseInt(jtaNoOfCopies.getText());
            bookNumber = Integer.parseInt(jtaBookNumber.getText());
        
        } catch(NumberFormatException e) {
            System.out.println(e);
        }
        
        
        if (bookTitle.equals("") || bookAuthor.equals("") || publisher.equals("") 
                || publishedYear == 0 || edition == 0 || noOfCopies == 0 || bookNumber == 0) {
            
            JOptionPane.showMessageDialog(null, "Please fill up form properly");
        } else {
            
            File fileName = new File("bookDB.txt");
            try {
                PrintWriter output = new PrintWriter(new FileWriter(fileName, true));
                
                output.write(bookTitle+","+bookAuthor+","+publisher+","+publishedYear+","+edition+","+noOfCopies+","+bookNumber+"\n");
                output.close();
                
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
            
            JOptionPane.showMessageDialog(null, "Book Saved");
            jtaBookTitle.setText("");
            jtaBookAuthor.setText("");
            jtaPublisher.setText("");
            jtaPublishedYear.setText("");
            jtaEdition.setText("");
            jtaNoOfCopies.setText("");
            jtaBookNumber.setText("");
                    
        }
        
    }
    
    private void initComponents() {
        panel = new JPanel();
        this.setContentPane(panel);
        panel.setLayout(new GridLayout(9,2,10,10));
        panel.setBackground(Color.white);
        lineBorder = new LineBorder(Color.black, 2, true);
        
        lblDisplay = new JLabel("<html><u>Enter book information</u></html>");
        lblBookTitle = new JLabel("Book Title");
        lblBookAuthor = new JLabel("Book Author(s)");
        lblPublisher = new JLabel("Name of the Publisher");
        lblPublishedYear = new JLabel("Publshed Year");
        lblEdition = new JLabel("Edition");
        lbllNoOfCopies = new JLabel("Number of Edition");
        lblBookNumber = new JLabel("Book Number");
        
        jtaBookTitle = new JTextField();
        jtaBookAuthor = new JTextField();
        jtaPublisher = new JTextField();
        jtaPublishedYear = new JTextField();
        jtaEdition = new JTextField();
        jtaNoOfCopies = new JTextField();
        jtaBookNumber = new JTextField();
                
        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");
        
        panel.add(lblDisplay);
        panel.add(new JLabel());
        panel.add(lblBookTitle);
        panel.add(jtaBookTitle);
        panel.add(lblBookAuthor);
        panel.add(jtaBookAuthor);
        panel.add(lblPublisher);
        panel.add(jtaPublisher);
        panel.add(lblPublishedYear);
        panel.add(jtaPublishedYear);
        panel.add(lblEdition);
        panel.add(jtaEdition);
        panel.add(lbllNoOfCopies);
        panel.add(jtaNoOfCopies);
        panel.add(lblBookNumber);
        panel.add(jtaBookNumber);
        panel.add(btnSave);
        panel.add(btnCancel);
        
        
        //formatting all labels
        lblDisplay.setFont(new Font("Sarif", Font.BOLD, 20));
        lblDisplay.setVerticalAlignment(SwingConstants.CENTER);
        
        lblBookTitle.setFont(new Font("Sarif", Font.PLAIN, 15));
        lblBookTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblBookAuthor.setFont(new Font("Sarif", Font.PLAIN, 15));
        lblBookAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblPublisher.setFont(new Font("Sarif", Font.PLAIN, 15));
        lblPublisher.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblPublishedYear.setFont(new Font("Sarif", Font.PLAIN, 15));
        lblPublishedYear.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblEdition.setFont(new Font("Sarif", Font.PLAIN, 15));
        lblEdition.setHorizontalAlignment(SwingConstants.CENTER);
        
        lbllNoOfCopies.setFont(new Font("Sarif", Font.PLAIN, 15));
        lbllNoOfCopies.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblBookNumber.setFont(new Font("Sarif", Font.PLAIN, 15));
        lblBookNumber.setHorizontalAlignment(SwingConstants.CENTER);
        
        //formatting all textarea
        jtaBookTitle.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaBookTitle.setBorder(lineBorder);
        
        
        jtaBookAuthor.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaBookAuthor.setBorder(lineBorder);
        
        jtaPublisher.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaPublisher.setBorder(lineBorder);
        
        jtaPublishedYear.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaPublishedYear.setBorder(lineBorder);
        onlyNumber(jtaPublishedYear);
        
        jtaEdition.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaEdition.setBorder(lineBorder);
        onlyNumber(jtaEdition);
        
        jtaNoOfCopies.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaNoOfCopies.setBorder(lineBorder);
        onlyNumber(jtaNoOfCopies);
        
        jtaBookNumber.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaBookNumber.setBorder(lineBorder);
        onlyNumber(jtaBookNumber);
        
        //formatting all buttons
        btnSave.setFont(new Font("Sarif", Font.PLAIN, 20));
        btnSave.setBackground(Color.white);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                values();
            }
        });
        
        btnCancel.setFont(new Font("Sarif", Font.PLAIN, 20));
        btnCancel.setBackground(Color.white);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 new LibrarianLogin().setVisible(true);
                 dispose();
            }
        });
        
    }
    
}

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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author nishan
 */
public class ShowBooks extends JFrame{
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
    
    private JButton btnPrevious;
    private JButton btnNext;
    
    private int i = 0;
    private int size = 0;
    
    public ShowBooks() {
        super("Library System");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        try {
            showBooks(0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void showBooks(int i) throws Exception {
        String line;
        ArrayList arr = new ArrayList();
        
        //Read a line of text into ArrayList
        try {
            FileReader fileReader = new FileReader("bookDB.txt");
            BufferedReader input = new BufferedReader(fileReader);
            
            //check whether file can be read
            if(!input.ready()) {
                throw new Exception();
            }
            
            while ((line = input.readLine()) != null) {
                //adding each lines of 'boodDB.txt' to the arraylist
                arr.add(line);
            }
           
            size = arr.size();
            String booksDetail = arr.get(i).toString();
            
            //splitting an array to string
            String[] parts = booksDetail.split(",");
            String bookTitle = parts[0];
            String bookAuthor = parts[1];
            String publisher = parts[2];
            String publishedYear = parts[3];
            String edition = parts[4];
            String noOfCopies = parts[5];
            String bookNumber = parts[6];
            
            jtaBookTitle.setText(bookTitle);
            jtaBookAuthor.setText(bookAuthor);
            jtaPublisher.setText(publisher);
            jtaPublishedYear.setText(publishedYear);
            jtaEdition.setText(edition);
            jtaNoOfCopies.setText(noOfCopies);
            jtaBookNumber.setText(bookNumber);
            
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
     }
    
    private void initComponents() {
        panel = new JPanel();
        this.setContentPane(panel);
        panel.setLayout(new GridLayout(9,2,10,10));
        panel.setBackground(Color.white);
        
        lineBorder = new LineBorder(Color.black, 2, true);
        
        lblDisplay = new JLabel("<html><u>Book information:</u></html>");
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
                
        btnPrevious = new JButton("Previous");
        btnNext = new JButton("Next");
        
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
        panel.add(btnPrevious);
        panel.add(btnNext);
        
        
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
        
        jtaEdition.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaEdition.setBorder(lineBorder);
        
        jtaNoOfCopies.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaNoOfCopies.setBorder(lineBorder);
        
        jtaBookNumber.setFont(new Font("Sarif", Font.PLAIN, 15));
        jtaBookNumber.setBorder(lineBorder);
        
        //formatting all buttons
        btnPrevious.setFont(new Font("Sarif", Font.PLAIN, 20));
        btnPrevious.setBackground(Color.white);
        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                i--;
                
                if (i >= 0) {
                    btnNext.setEnabled(true);
                    try {
                        showBooks(i);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }else {
                    btnPrevious.setEnabled(false);
                }
            }
        });
        
        btnNext.setFont(new Font("Sarif", Font.PLAIN, 20));
        btnNext.setBackground(Color.white);
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                i++;
                
                if (size != i) {
                    btnPrevious.setEnabled(true);
                    try {
                        showBooks(i);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }else {
                    btnNext.setEnabled(false);
                }
            }
        });
    }
}

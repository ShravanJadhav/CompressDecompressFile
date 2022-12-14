/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import codeFile.Compress;
import codeFile.Decompress;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Shrenik
 */
public class View extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
   
    View(){
         this.setTitle("lets Save Your Space");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setSize(900,400);
        
        this.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Shrenik\\Documents\\NetBeansProjects\\CompressDecompressProject\\src\\bacgroundIMG.jpg")));
        this.pack();
       
        compressButton = new JButton("Select File to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(95,500,250,30);
        
        decompressButton = new JButton("Select File to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(662,500, 250, 30);
        
        this.add(compressButton);
        this.add(decompressButton);
          
    }
    
   public static void main(String[]args) throws IOException{
       View view = new View();
       view.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                     Compress.compressFunction(file);
                }
                catch(IOException excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        
        if(e.getSource()==decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Decompress.decompressorFunction(file);
                   
                }
                catch(IOException excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }   
    }
}

package GUI;

import Comp_Decomp.Compress_Operation;
import Comp_Decomp.Decompression_Operation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ApplicationMenu implements ActionListener {
    JFrame frame;
    JButton Compress_Button;
    JButton Decompress_Button;
    Panel menue;

    ApplicationMenu(){

        frame = new JFrame("File_Reducer");
       // frame.getContentPane().setBackground(Color.green);
        frame.setVisible(true);

        frame.setSize(1000,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        Compress_Button = new JButton("Compress_File");
        Compress_Button.setBounds(125,300,200,40);
        frame.add(Compress_Button);
        Compress_Button.setVisible(true);
        Compress_Button.addActionListener(this);


        Decompress_Button = new JButton("Decompress_File");
        Decompress_Button.setBounds(625,300,200,40);
        frame.add(Decompress_Button);
        Decompress_Button.setVisible(true);
        Decompress_Button.addActionListener(this);

        menue = new Panel();
        menue.setSize(300,500);
        menue.setLocation(350,300);
        menue.setBackground(Color.green);
        menue.setVisible(true);
        frame.add(menue);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Compress_Button){
            JFileChooser Choose_File = new JFileChooser();

            int response = Choose_File.showSaveDialog(null);

            if(response ==  JFileChooser.APPROVE_OPTION){
                File file = new File(Choose_File.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compress_Operation.File_Read(file);
                }
                catch(Exception aa){
                    JOptionPane.showMessageDialog(null,aa.toString());
                }
            }

        }

        if(e.getSource() == Decompress_Button){
            JFileChooser Choose_File = new JFileChooser();

            int response = Choose_File.showSaveDialog(null);

            if(response ==  JFileChooser.APPROVE_OPTION){
                File file = new File(Choose_File.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompression_Operation.File_Read(file);
                }
                catch(Exception aa){
                    JOptionPane.showMessageDialog(null,aa.toString());
                }
            }

        }
    }
}

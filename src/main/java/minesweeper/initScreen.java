package minesweeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class initScreen extends JFrame implements ActionListener, MouseListener{
    public initScreen(){
            JPanel jp = new JPanel(new GridLayout());
            jp.setLayout(new GridLayout(11, 11));
            JFrame screen = new JFrame("Welcome to the Minesweeper game! Developed by BrunoDev2003");
            JMenuBar jmb = new JMenuBar();
            JMenu jm = new JMenu("Game");
            JMenuItem jmi = new JMenuItem("Item menu");
            jm.add(jmi);
            setExtendedState(MAXIMIZED_BOTH);
            setVisible(true);
            screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}

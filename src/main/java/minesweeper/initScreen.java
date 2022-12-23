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
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class initScreen extends JFrame implements ActionListener, MouseListener{
    private JDesktopPane jdp = new JDesktopPane();
    private JMenuBar jmb = new JMenuBar();
    private JMenuItem jmiGame = new JMenuItem("Minesweeper");
    private JMenuItem jmiAboutGame = new JMenuItem("About The Game");

    public initScreen(String titulo){
            setTitle(titulo);
            getContentPane().add(jdp);
            jdp.setBackground(Color.CYAN);
            JFrame screen = new JFrame("Welcome to the Minesweeper game! Developed by BrunoDev2003");
            JMenu gameMenu = new JMenu ("Game");
            JMenu helpMenu = new JMenu ("Help");
            addMenuItems(gameMenu, jmiAboutGame);
            addMenuItems(gameMenu, jmiGame);
            setJMenuBar(jmb);
            jmb.add(gameMenu);
            jmb.add(helpMenu);
            setExtendedState(MAXIMIZED_BOTH);
            setVisible(true);
            screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





    }

    private void addMenuItems(JMenu gameMenu, JMenuItem menuItem) {
        gameMenu.add(menuItem);
        menuItem.addActionListener(this);
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
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == jmiAboutGame) {
            InfoAboutGameScreen infoAboutGameScreen = 
                new InfoAboutGameScreen();
                jdp.add(infoAboutGameScreen);
        } else if (ae.getSource() == jmiGame) {
            GameScreen gameScreen = 
                new GameScreen();
                jdp.add(gameScreen);
        }
        
    }
}

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
    private JMenuItem jmiAboutGame = new JMenuItem("About the game");

            ImageIcon smileyImageIcon = null;
            ImageIcon tImageIcon = null;
            ImageIcon pitImageIcon = null;
            ImageIcon lossImageIcon = null;
            ImageIcon cryImageIcon = null;
            ImageIcon oneImageIcon = null;
            ImageIcon twoImageIcon = null;
            ImageIcon threeImageIcon = null;
            ImageIcon fourImageIcon = null;
            ImageIcon fiveImageIcon = null;

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
            loadMinesweeperImages();
            setExtendedState(MAXIMIZED_BOTH);
            setVisible(true);
            screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





    }

    private void addMenuItems(JMenu gameMenu, JMenuItem menuItem) {
        gameMenu.add(menuItem);
        menuItem.addActionListener(this);
    }

    public void loadMinesweeperImages() {
            smileyImageIcon = getScaledImage("C:\\Users\\wwwbr\\minesweeper_game\\Minesweper\\src\\img\\smiley.png");
            tImageIcon = getScaledImage("C:\\Users\\wwwbr\\minesweeper_game\\Minesweper\\src\\img\\t.png");
            pitImageIcon = getScaledImage("C:\\Users\\wwwbr\\minesweeper_game\\Minesweper\\src\\img\\pit.png");
            lossImageIcon = getScaledImage("C:\\Users\\wwwbr\\minesweeper_game\\Minesweper\\src\\img\\2.png");
            cryImageIcon = getScaledImage("C:\\Users\\wwwbr\\minesweeper_game\\Minesweper\\src\\img\\cry.png");
            oneImageIcon = getScaledImage("C:\\Users\\wwwbr\\minesweeper_game\\Minesweper\\src\\img\\1.png");
            twoImageIcon = getScaledImage("C:\\Users\\wwwbr\\minesweeper_game\\Minesweper\\src\\img\\2.png");
            threeImageIcon = getScaledImage("C:\\Users\\wwwbr\\minesweeper_game\\Minesweper\\src\\img\\3.png");
            fourImageIcon = getScaledImage("C:\\Users\\wwwbr\\minesweeper_game\\Minesweper\\src\\img\\4.png");
            fiveImageIcon = getScaledImage("C:\\Users\\wwwbr\\minesweeper_game\\Minesweper\\src\\img\\5.png");
    }


    private ImageIcon getScaledImage(String string) {
        ImageIcon imageIcon = new ImageIcon(string);
        Image img = imageIcon.getImage();
        Image newimg = img.getScaledInstance( 30,30, java.awt.Image.SCALE_SMOOTH );
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
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
        if(e.getSource() == jmiAboutGame) {
            InfoAboutGameScreen InfoAboutGameScreen = 
                new InfoAboutGameScreen();
        } else if (e.getSource() == jmiGame) {
            GameScreen GameScreen = 
                new GameScreen();
        }
        
    }
}

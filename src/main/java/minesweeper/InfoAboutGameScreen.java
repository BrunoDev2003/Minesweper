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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class InfoAboutGameScreen extends TelaMenu{
    protected JTextField textField;
    protected JTextArea textArea;


    public InfoAboutGameScreen() {
        super("Info About the Minesweeper");
        InfoScreen();
        pack();
        setVisible(true);
    }

    public void InfoScreen() {
        textArea = new JTextArea(5, 20);
        String textoLabel = "<html>Placeholder Information on MineSweeper<body>";
        JLabel jl = new JLabel(textoLabel);
        painelComponentes.add(jl);
        setVisible(true);
    }

    @Override
    public boolean gameinfo() {
        
        return false;
    }
    @Override
    public boolean startgame() {
        
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}

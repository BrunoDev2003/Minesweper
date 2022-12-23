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
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;


public abstract class TelaMenu extends JInternalFrame implements ActionListener {

    protected final int PADRAO = 0;
    protected final int GAMEINFO = 2;
    protected final int STARTGAME = 3;
    protected JPanel painelComponentes = new JPanel();
    private JPanel painelBotoes = new JPanel();
    protected int estadoTela = PADRAO;
    
    public TelaMenu(String titulo) {
        super(titulo, true, true, true, true);
        setSize(300, 300);
        getContentPane().add("West",
        painelComponentes);
        getContentPane().add("South",
        painelBotoes);
        painelBotoes.setLayout(
                new GridLayout(1, 2));
        painelComponentes.setLayout(new GridBagLayout());
    }

    abstract public boolean gameinfo();

    abstract public boolean startgame();
}

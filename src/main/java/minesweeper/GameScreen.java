package minesweeper;

import java.awt.event.ActionEvent;
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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameScreen extends TelaMenu implements MouseListener {

    private JPanel composite = new JPanel();

    private JPanel topPanel = new JPanel();

    private JButton smiley = new JButton("");

    private int btnwdth = 10;

    private int btnhgt = 10;


    private int mines = 8;

    int mineArray[][];
    JButton button[][];
    JPanel minespan = null;

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

    public GameScreen() {
        super("MineSweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        loadMinesweeperImages();
        composite.setLayout(new BorderLayout());
        smiley.setPreferredSize(new Dimension(25, 25));
        smiley.setIcon(smileyImageIcon);
        topPanel.add(smiley);
        composite.add(topPanel, BorderLayout.NORTH);
        smiley.addActionListener(this);
        smiley.addMouseListener(this);
        arrangeButtons();
        add(composite);
        pack();
        setVisible(true);
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

    public void arrangeButtons() {
        mineArray = new int[btnwdth][btnhgt];
            button = new JButton[btnwdth][btnhgt];
            boolean starting = true;
            if (minespan != null) {
                    composite.remove(minespan);
                    minespan = null;
                    starting = false;

    }
    minespan = new JPanel();
    minespan.setLayout(new GridLayout(btnwdth, btnhgt));

    for (int i = 0; i < btnwdth; i++) {
        for (int j = 0; j < btnhgt; j++) {
            mineArray[i][j] = 0;
            button[i][j] = new JButton("");
            button[i][j].setBackground(Color.WHITE);
            button[i][j].setPreferredSize(new Dimension(16, 16));
            button[i][j].addActionListener(this);
            button[i][j].addMouseListener(this);
            minespan.add(button[i][j]);
        }
    }

    minespan.setVisible(true);
            composite.add(minespan, BorderLayout.CENTER);
            if (starting) {
                    minesFormat(button);
            }
                pack();
}

public void reset() {
    smiley.setIcon(smileyImageIcon);
    arrangeButtons();
            for (int i = 0; i < btnwdth; i++) {
                    for (int j = 0; j < btnhgt; j++) {
                        mineArray[i][j] = 0;
                        button[i][j].addActionListener(this);
                        button[i][j].addMouseListener(this);
                        button[i][j].setText("");
                        button[i][j].setBackground(Color.WHITE);

                    }
            }
            minesFormat(button);
            System.out.println("");
            System.out.println("");
}

public void minesFormat(JButton button[][]) {
    int mine[] = getRndmNos(btnwdth, btnhgt, mines);
    int count = 1;
    for (int i = 0; i < mine.length; i++) {
        for (int j = 0; j < count; j++) {
            for (int k = 0; k < mine.length && mine[k] != 0; k++) {
                if (count == mine[k]) {
                    mineArray[i][j] = 9;
                }
        }
        }
        count++;
    }

int boxcount = 0;
for (int i = 0; i < btnwdth; i++) {
    for (int j = 0; j < btnhgt; j++) {
        boxcount = 0;
        if (mineArray[i][j] != 9) {
            if (i > 0 && j > 0) {
                if (mineArray[i - 1][j - 1] == 9)
                    boxcount++;
            }

            if (i > 0) {
                if (mineArray[i - 1][j] == 9)
                    boxcount++;
            }

            if (i > 0 && j < btnhgt - 1) {
                if (mineArray[i - 1][j + 1] == 9)
                    boxcount++;
            }

            if (i < btnwdth - 1 && j > 0) {
                if (mineArray[i + 1][j - 1] == 9)
                    boxcount++;
            }
            if (i < btnwdth - 1) {
                if (mineArray[i + 1][j] == 9)
                    boxcount++;
            }

            if (i < btnwdth - 1 && j < btnhgt - 1) {
                if (mineArray[i + 1][j + 1] == 9)
                    boxcount++;
            }

            if (j > 0) {
                if (mineArray[i][j - 1] == 9)
                    boxcount++;
            }
            if (j < btnhgt - 1) {
                if (mineArray[i][j + 1] == 9)
                        boxcount++;
            }
            mineArray[i][j] = boxcount;
    }

    }
}

for (int i = 0; i < btnwdth; i++) {
    for (int j = 0; j < btnhgt; j++) {
        System.out.print(" " + mineArray[i][j]);
    }
    System.out.println("");
}


}

public int[] getRndmNos(int btnwdth, int btnhgt, int mines) {

    Random rand = new Random();
              int rndmines[] = new int[btnwdth * btnhgt];
            boolean in = false;
            int count = 0;
            while (count < mines) {
                     int rndno = (int) ((btnwdth * btnhgt) * (rand.nextDouble())) + 1;
                    in = false;
                    for (int i = 0; i < count; i++) {
                        if (rndmines[i] == rndno) {
                                in = true;
                                break;
                        }
                    }
                    if (!in) {
                        rndmines[count++] = rndno;
                    }
            }
            return rndmines;
}







    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == smiley) {
            reset();
    } else {
            for (int i = 0; i < btnwdth; i++)
                for (int j = 0; j < btnhgt; j++) {
                        if (button[i][j] == ae.getSource()) {
                                if (mineArray[i][j] == 9) {
                                    for (int k = 0; k < btnwdth; k++) {
                                            for (int l = 0; l < btnhgt; l++) {

                                                    if (mineArray[k][l] == 9) {
                                                            button[k][l].setIcon(pitImageIcon);
                                                    }

                                                    button[k][l].removeActionListener(this);
                                                    button[k][l].removeMouseListener(this);

                                            }
                                    }

                                }
                                if (mineArray[i][j] == 1) {
                                    button[i][j].setIcon(oneImageIcon);
                                }
                                if (mineArray[i][j] == 2) {
                                    button[i][j].setIcon(twoImageIcon);
                                }
                                if (mineArray[i][j] == 3) {
                                    button[i][j].setIcon(threeImageIcon);
                                }
                                if (mineArray[i][j] == 4) {
                                    button[i][j].setIcon(fourImageIcon);
                                }
                                if (mineArray[i][j] == 5) {
                                    button[i][j].setIcon(fiveImageIcon);
                                }
                                if (mineArray[i][j] == 0) {
                                    findAllEmpty(i, j);
                                }
                        }
                }
    }
}


public void findAllEmpty(int boxX, int boxY) {
    int arrX[] = new int[(btnwdth) * (btnhgt)];
    int arrY[] = new int[(btnwdth) * (btnhgt)];
    int cntEmpty = 0;
    for (int i = 0; i < ((btnwdth) * (btnhgt)); i++) {
        arrX[i] = -1;
        arrY[i] = -1;
    }
    arrX[cntEmpty] = boxX;
    arrY[cntEmpty] = boxY;
    cntEmpty++;

    for (int i = 0; i < cntEmpty; i++) {
        if (arrX[i] > 0) {
                int xxX = arrX[i] - 1;
                int yyY = arrY[i];
                if (mineArray[xxX][yyY] == 0) {
                        if (!findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                            arrX[cntEmpty] = xxX;
                            arrY[cntEmpty] = yyY;
                            cntEmpty++;
                        }
                }
        }

        if (arrX[i] < (btnwdth - 1)) {
                int xxX = arrX[i] + 1;
                int yyY = arrY[i];
                if (mineArray[xxX][yyY] == 0) {
                        if (!findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                            arrX[cntEmpty] = xxX;
                            arrY[cntEmpty] = yyY;
                            cntEmpty++;
                        }
                }
        }

        if (arrY[i] > 0) {
                int xxX = arrX[i];
                int yyY = arrY[i] - 1;
                if (mineArray[xxX][yyY] == 0) {
                        if (!findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                            arrX[cntEmpty] = xxX;
                            arrY[cntEmpty] = yyY;
                            cntEmpty++;
                        }
                }
        }

        if (arrY[i] < (btnhgt - 1)) {
                int xxX = arrX[i];
                int yyY = arrY[i] + 1;
                if (mineArray[xxX][yyY] == 0) {
                        if (!findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                            arrX[cntEmpty] = xxX;
                            arrY[cntEmpty] = yyY;
                            cntEmpty++;
                        }
                }
        }
    }

    for (int k = 0; k < cntEmpty; k++) {
        button[arrX[k]][arrY[k]].setBackground(new Color(200, 200, 250));
    }
}

public boolean findIn(int[] arrX, int[] arrY, int cntEmpty, int xxX, int yyY) {
    int j = 0;
    for (j = 0; j < cntEmpty; j++) {
        if ((arrX[j] == (xxX)) && (arrY[j] == (yyY))) {
                return true;
        }
    }
    return false;
}

    @Override
    public boolean gameinfo() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean startgame() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        for (int i = 0; i < btnwdth; i++)
                    for (int j = 0; j < btnhgt; j++) {
                        if (button[i][j] == me.getSource()) {
                                smiley.setIcon(cryImageIcon);
                        }
                    }

            if (me.getSource() == smiley) {
                    smiley.setIcon(cryImageIcon);
            }
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == smiley) {
            smiley.setIcon(smileyImageIcon);
    }
    for (int i = 0; i < btnwdth; i++)
            for (int j = 0; j < btnhgt; j++) {
                if (button[i][j] == me.getSource()) {
                        if (mineArray[i][j] == 9) {
                                smiley.setIcon(lossImageIcon);
                        } else {
                                smiley.setIcon(smileyImageIcon);
                        }
                }

            }
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        // TODO Auto-generated method stub
        
    }
    
}

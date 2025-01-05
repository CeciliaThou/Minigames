package minigames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener{

    private JPanel initial;
    private JPanel tictactoePanel;
    private int player;
    private JLabel message;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnRestart;
    private int[] grid;
    private int moves;

    public GUI(){
        Font font = new Font("Ariel", Font.PLAIN, 22);
        setSize(800, 580);
        setTitle("Minigames");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        JMenu menu = new JMenu("Menu");
        JMenuItem tttChoice = new JMenuItem("TicTacToe");
        tttChoice.addActionListener(this);
        menu.add(tttChoice);

        JMenuBar bar = new JMenuBar();
        bar.add(menu);
        setJMenuBar(bar);

        /*initial interface*/
        initial = new JPanel();
        initial.setVisible(true);
        initial.setLayout(new BorderLayout());
        JTextArea initialMessage = new JTextArea("Select a game from the Menu Bar");
        initialMessage.setLineWrap(true);
        initialMessage.setFont(font);
        initialMessage.setEditable(false);
        initial.add(initialMessage, BorderLayout.CENTER);

        add(initial);

        /*tictactoe interface*/
        player = 0;
        moves = 0;
        grid = new int[9];
        for(int i = 0; i < 9; i++){
            grid[i] = -1;
        }

        tictactoePanel = new JPanel();
        tictactoePanel.setVisible(false);
        tictactoePanel.setLayout(new BorderLayout());
        JPanel tttTop = new JPanel(), tttBottom = new JPanel(), tttMessage = new JPanel();

        tttTop.setLayout(new GridLayout(3,3));

        JPanel ttt1 = new JPanel(), ttt2 = new JPanel(), ttt3 = new JPanel(), ttt4 = new JPanel(), ttt5 = new JPanel(), ttt6 = new JPanel(), ttt7 = new JPanel(), ttt8 = new JPanel(), ttt9 = new JPanel();

        ttt1.setLayout(new GridLayout(1,1));
        ttt2.setLayout(new GridLayout(1,1));
        ttt3.setLayout(new GridLayout(1,1));
        ttt4.setLayout(new GridLayout(1,1));
        ttt5.setLayout(new GridLayout(1,1));
        ttt6.setLayout(new GridLayout(1,1));
        ttt7.setLayout(new GridLayout(1,1));
        ttt8.setLayout(new GridLayout(1,1));
        ttt9.setLayout(new GridLayout(1,1));

        tttTop.add(ttt1);
        tttTop.add(ttt2);
        tttTop.add(ttt3);
        tttTop.add(ttt4);
        tttTop.add(ttt5);
        tttTop.add(ttt6);
        tttTop.add(ttt7);
        tttTop.add(ttt8);
        tttTop.add(ttt9);

        btn1 = new JButton("1");
        btn1.addActionListener(this);
        btn2 = new JButton("2");
        btn2.addActionListener(this);
        btn3 = new JButton("3");
        btn3.addActionListener(this);
        btn4 = new JButton("4");
        btn4.addActionListener(this);
        btn5 = new JButton("5");
        btn5.addActionListener(this);
        btn6 = new JButton("6");
        btn6.addActionListener(this);
        btn7 = new JButton("7");
        btn7.addActionListener(this);
        btn8 = new JButton("8");
        btn8.addActionListener(this);
        btn9 = new JButton("9");
        btn9.addActionListener(this);
        btnRestart = new JButton("Restart");
        btnRestart.addActionListener(this);

        ttt1.add(btn1);
        ttt2.add(btn2);
        ttt3.add(btn3);
        ttt4.add(btn4);
        ttt5.add(btn5);
        ttt6.add(btn6);
        ttt7.add(btn7);
        ttt8.add(btn8);
        ttt9.add(btn9);
        tttBottom.add(btnRestart);

        tttBottom.setBackground(Color.BLACK);

        message = new JLabel(getSymbol(player) + " turn");
        tttMessage.add(message);

        tictactoePanel.add(tttMessage, BorderLayout.NORTH);
        tictactoePanel.add(tttTop, BorderLayout.CENTER);
        tictactoePanel.add(tttBottom, BorderLayout.SOUTH);

        add(tictactoePanel);
    }

    private void tttWin(){
        if(grid[0] == grid[1] && grid[0] == grid[2] && grid[0] != -1){
            disableButtons();
            message.setText(getSymbol(grid[0]) + " wins!");
        }
        else if(grid[0] == grid[4] && grid[0] == grid[8] && grid[0] != -1){
            disableButtons();
            message.setText(getSymbol(grid[0]) + " wins!");
        }
        else if(grid[0] == grid[3] && grid[0] == grid[6] && grid[0] != -1){
            disableButtons();
            message.setText(getSymbol(grid[0]) + " wins!");
        }
        else if(grid[1] == grid[4] && grid[1] == grid[7] && grid[1] != -1){
            disableButtons();
            message.setText(getSymbol(grid[1]) + " wins!");
        }
        else if(grid[2] == grid[5] && grid[2] == grid[8] && grid[2] != -1){
            disableButtons();
            message.setText(getSymbol(grid[2]) + " wins!");
        }
        else if(grid[2] == grid[4] && grid[2] == grid[6] && grid[2] != -1){
            disableButtons();
            message.setText(getSymbol(grid[2]) + " wins!");
        }
        else if(grid[3] == grid[4] && grid[3] == grid[5] && grid[3] != -1){
            disableButtons();
            message.setText(getSymbol(grid[3]) + " wins!");
        }
        else if(grid[6] == grid[7] && grid[6] == grid[8] && grid[6] != -1){
            disableButtons();
            message.setText(getSymbol(grid[6]) + " wins!");
        }
        else if(moves == 9){
            message.setText("Tie!");
        }
    }

    private void disableButtons(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    private String getSymbol(int num){
        if(num == 1){
            return "o";
        }
        else{
            return "x";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        int num;

        if(s.equals("TicTacToe")){
            initial.setVisible(false);
            tictactoePanel.setVisible(true);
        }
        else if(s.equals("1")){
            btn1.setText(getSymbol(player));
            grid[0] = player;
            player = (player+1)%2;
            message.setText(getSymbol(player) + " turn");
            moves++;
            btn1.setEnabled(false);
            tttWin();
        }
        else if(s.equals("2")){
            btn2.setText(getSymbol(player));
            grid[1] = player;
            player = (player+1)%2;
            message.setText(getSymbol(player) + " turn");
            moves++;
            btn2.setEnabled(false);
            tttWin();
        }
        else if(s.equals("3")){
            btn3.setText(getSymbol(player));
            grid[2] = player;
            player = (player+1)%2;
            message.setText(getSymbol(player) + " turn");
            moves++;
            btn3.setEnabled(false);
            tttWin();
        }
        else if(s.equals("4")){
            btn4.setText(getSymbol(player));
            grid[3] = player;
            player = (player+1)%2;
            message.setText(getSymbol(player) + " turn");
            moves++;
            btn4.setEnabled(false);
            tttWin();
        }
        else if(s.equals("5")){
            btn5.setText(getSymbol(player));
            grid[4] = player;
            player = (player+1)%2;
            message.setText(getSymbol(player) + " turn");
            moves++;
            btn5.setEnabled(false);
            tttWin();
        }
        else if(s.equals("6")){
            btn6.setText(getSymbol(player));
            grid[5] = player;
            player = (player+1)%2;
            message.setText(getSymbol(player) + " turn");
            moves++;
            btn6.setEnabled(false);
            tttWin();
        }
        else if(s.equals("7")){
            btn7.setText(getSymbol(player));
            grid[6] = player;
            player = (player+1)%2;
            message.setText(getSymbol(player) + " turn");
            moves++;
            btn7.setEnabled(false);
            tttWin();
        }
        else if(s.equals("8")){
            btn8.setText(getSymbol(player));
            grid[7] = player;
            player = (player+1)%2;
            message.setText(getSymbol(player) + " turn");
            moves++;
            btn8.setEnabled(false);
            tttWin();
        }
        else if(s.equals("9")){
            btn9.setText(getSymbol(player));
            grid[8] = player;
            player = (player+1)%2;
            message.setText(getSymbol(player) + " turn");
            moves++;
            btn9.setEnabled(false);
            tttWin();
        }
        else if(s.equals("Restart")){
            moves = 0;
            btn1.setText("1");
            btn2.setText("2");
            btn3.setText("3");
            btn4.setText("4");
            btn5.setText("5");
            btn6.setText("6");
            btn7.setText("7");
            btn8.setText("8");
            btn9.setText("9");
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);
            for(int i = 0; i < 9; i++){
                grid[i] = -1;
            }
            message.setText(getSymbol(player) + " turn");
        }
    }

    public static void main(String[] args){
        GUI gui = new GUI();
        gui.setVisible(true);
    }

}

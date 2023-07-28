import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class GameMethods2 extends JFrame implements ActionListener {
    int counter=0;
    boolean player1=true;
    Random generator=new Random();
    JFrame frame=new JFrame();
    JPanel title_panel=new JPanel();
    JPanel board=new JPanel();
    JLabel label=new JLabel();
    JButton button1=new JButton("Play");
    JButton[] buttons=new JButton[9];

    public GameMethods2(){
        initialize();
    }
    public void initialize(){
        button1.setSize(10,10);
        frame.setTitle("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        label.setText("Welcome! Choose one:");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.add(label);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.setLayout(new GridLayout(3, 3));
                frame.remove(button1);
                button1.invalidate();
                frame.add(board);
                turn();
            }





        });
    }
    public void turn(){
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            board.add(buttons[i]);
            player1=true;
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i=0;i<9;i++){
                        if(e.getSource()==buttons[i]){
                            if(player1){
                                if(buttons[i].getText()=="") {
                                    buttons[i].setText("X");
                                    player1=false;
                                    label.setText("O Turn");
                                    checker();
                                    counter++;
                                }
                            }

                            else{
                                if(buttons[i].getText()==""){
                                    buttons[i].setText("O");
                                    player1=true;
                                    label.setText("X Turn");
                                    checker();
                                    counter++;
                                }
                            }
                        }
                    }}


            });
        }
        if(generator.nextInt(2)==0){
            player1=true;
            label.setText("X Turn");
            counter++;
        }
        else{
            player1=false;
            label.setText("O Turn");
            counter++;
        }
    }
    public void checker() {
        if(
        (buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X")
        ){
            xWinner(0,1,2);
        }
        if(
                (buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")
        ){
            xWinner(3,4,5);
        }
        if(
                (buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X")
        ){
            xWinner(6,7,8);
        }
        if(
                (buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X")
        ){
            xWinner(0,3,6);
        }
        if(
                (buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X")
        ){
            xWinner(1,4,7);
        }
        if(
                (buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X")
        ){
            xWinner(2,5,8);
        }
        if(
                (buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X")
        ){
            xWinner(0,4,8);
        }
        if(
                (buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X")
        ){
            xWinner(2,4,6);
        }///
        if(
                (buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()=="O")
        ){
            oWinner(0,1,2);
        }
        if(
                (buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O")
        ){
            oWinner(3,4,5);
        }
        if(
                (buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O")
        ){
            oWinner(6,7,8);
        }
        if(
                (buttons[0].getText()=="O")&&(buttons[3].getText()=="O")&&(buttons[6].getText()=="O")
        ){
            oWinner(0,3,6);
        }
        if(
                (buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O")
        ){
            oWinner(1,4,7);
        }
        if(
                (buttons[2].getText()=="O")&&(buttons[5].getText()=="O")&&(buttons[8].getText()=="O")
        ){
            oWinner(2,5,8);
        }
        if(
                (buttons[0].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[8].getText()=="O")
        ){
            oWinner(0,4,8);
        }
        if(
                (buttons[2].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[6].getText()=="O")
        ){
            oWinner(2,4,6);
        }
        if(counter>=9){
            tie();
        }



    }
    public void xWinner(int a,int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        label.setText("X WINS!!!!!!");
        label.setBackground(Color.GREEN);

    }
    public void oWinner(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        board.updateUI();
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        label.setText("O WINS!!!!!!");
        label.setBackground(Color.GREEN);

    }
    public void tie(){
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        label.setText("Tie!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

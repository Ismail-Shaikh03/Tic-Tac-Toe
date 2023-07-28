import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class GameMethods extends JFrame implements ActionListener {
    int counter=1;
    boolean player1=true;
    Random generator=new Random();
    JFrame frame=new JFrame();
    JPanel title_panel=new JPanel();
    JPanel board=new JPanel();
    JLabel label=new JLabel();
    JButton button1=new JButton("Play");
    JButton[] buttons=new JButton[9];

public GameMethods(){
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
                JButton[] buttons = new JButton[9];
                for (int i = 0; i < 9; i++) {
                    buttons[i] = new JButton();
                    board.add(buttons[i]);
                    buttons[i].setFocusable(false);
                    buttons[i].addActionListener(this);
                    frame.revalidate();

                }
            turn();
        }





});
}
public void turn(){
    if(generator.nextInt(2)==0){
        player1=true;
        label.setText("X Turn");
    }
    else{
        player1=false;
        label.setText("O Turn");
    }
}
    @Override
    public void actionPerformed(ActionEvent e){
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
public void checker(){

}
}

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class tangga extends JFrame{
    
    JPanel panel;
    JLabel nom,dnum;
    JButton dadu,p1,p2;
    Server sv;
    
    int turn1 = 0 , turn2 = 0, gilir = 1, locx1 = 0 , locx2 = 0, locy1 = 0, locy2 = 0 ;
    
    public tangga(){
        
    this.setDefaultCloseOperation(3);
    this.setSize(1000,800);
    this.setLayout(null);
    this.setVisible(true);
    this.setTitle("Client");
    
    int angk, x = 10, y = 10 ;
    String aaa;
    sv = new Server();
    
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                panel = new JPanel();
                this.add(panel);
                panel.setBorder(new LineBorder(Color.BLACK, 1));
                panel.setVisible(true);
                panel.setOpaque(false);
                panel.setBounds(x + (j*70), y+(i*70), 70, 70);
                
                if ( i == 0)
                {
                    angk = j+1;
                    aaa = Integer.toString(angk);
                    nom = new JLabel(aaa);
                    panel.add(nom);
                }
                if (i==1) {
                    angk = 20 - j ;
                    aaa = Integer.toString(angk);
                    nom = new JLabel(aaa);
                    panel.add(nom);
                }
                if (i==2) {
                    angk = j + 21;
                    aaa = Integer.toString(angk);
                    nom = new JLabel(aaa);
                    panel.add(nom);
                }
                if (i==3) {
                    angk = 40- j;
                    aaa = Integer.toString(angk);
                    nom = new JLabel(aaa);
                    panel.add(nom);
                }
                if (i==4) {
                    angk = j+ 41 ;
                    aaa = Integer.toString(angk);
                    nom = new JLabel(aaa);
                    panel.add(nom);
                }
                if( i == 5){
                    angk = 60 - j ;
                    aaa = Integer.toString(angk);
                    nom = new JLabel(aaa);
                    panel.add(nom);
                }
                if (i==6) {
                    angk = j+61;
                    aaa = Integer.toString(angk);
                    nom = new JLabel(aaa);
                    panel.add(nom);
                }
                if(i==7){
                    angk = 80-j ;
                    aaa = Integer.toString(angk);
                    nom = new JLabel(aaa);
                    panel.add(nom);
                }
                if(i==8){
                    angk = j+81;
                   aaa = Integer.toString(angk);
                    nom = new JLabel(aaa);
                    panel.add(nom);
                }
                if( i== 9 ){
                    angk = 100 - j;
                    aaa = Integer.toString(angk);
                    nom = new JLabel(aaa);
                    panel.add(nom);
                }
            }
        }
           
        dadu = new JButton("Acak");
        this.add(dadu);
        dadu.setVisible(true);
        dadu.setBounds(810, 350, 100, 50);
        
        
        turn1 = 1 ;
        turn2 = 2 ;
        
        
        
        ImageIcon player1 = new ImageIcon("D:\\downloads\\reddot.png");
        JLabel play1 = new JLabel();
        play1.setIcon(player1);
        this.add(play1);
        play1.setVisible(true);
        play1.setBounds(10, 10, 25, 25);
        
        ImageIcon player2 = new ImageIcon("D:\\downloads\\bluedot.png");
        JLabel play2 = new JLabel();
        play2.setIcon(player2);
        this.add(play2);
        play2.setVisible(true);
        play2.setBounds(10, 40, 25, 25);
        
        dnum = new JLabel();
        this.add(dnum);
        dnum.setBorder(new LineBorder(Color.BLACK, 1));
        dnum.getBorder();
        dnum.setVisible(true);
        dnum.setBounds(800, 215, 114, 113);
        
        JLabel urut = new JLabel();
        this.add(urut);
        urut.setVisible(true);
        urut.setBounds(820, 165, 100, 30);
        urut.setText("Giliran Merah");
       
        dadu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int a = (int)(Math.random() * 6 +1) ;
            String dd = Integer.toString(a);
            int pos1 =0, pos2 = 0;
            
            switch (a){
                    case 1 : {
                        ImageIcon dice1 = new ImageIcon("D:\\downloads\\Alea_1.png");
                        dnum.setIcon(dice1);
                        break;
                    }
                    case 2 : {
                        ImageIcon dice1 = new ImageIcon("D:\\downloads\\Alea_2.png");
                        dnum.setIcon(dice1);
                        break;
                    }
                    case 3 : {
                        ImageIcon dice1 = new ImageIcon("D:\\downloads\\Alea_3.png");
                        dnum.setIcon(dice1);
                        break;
                    }
                    case 4 : {
                        ImageIcon dice1 = new ImageIcon("D:\\downloads\\Alea_4.png");
                        dnum.setIcon(dice1);
                        break;
                    }
                    case 5 : {
                        ImageIcon dice1 = new ImageIcon("D:\\downloads\\Alea_5.png");
                        dnum.setIcon(dice1);
                        break;
                    }
                    case 6 : {
                        ImageIcon dice1 = new ImageIcon("D:\\downloads\\Alea_6.png");
                        dnum.setIcon(dice1);
                        break;
                    }
            }
            
            if(gilir == turn1){
                
                urut.setText("Giliran Biru");
                
                locx1 = locx1 + a;
                if(locx1>9 && locy1==9){
                    int loc = locx1 % 9;
                    locx1 = 9-loc;
                }else if (locx1 > 9){
                   locy1 +=1;
                    locx1%=9;
                    locx1 --;
                }
                
                if(locy1 %2 ==1)
                {
                    pos1 = 9 - locx1;
                }
                
                if(pos1 ==0 && locy1 == 9)
                {
                    play1.setLocation(10 + (70*pos1), 40+ (locy1* 70));
                    urut.setText("Merah Menang");
                    gilir = 0 ;
                    
                }else if (locy1%2 == 1){
                    play1.setLocation(10+ (pos1 *70),10+(locy1*70));
                    gilir = turn2;
                }else{
                    
                    play1.setLocation(10+ (locx1*70),10+(locy1*70));
                    gilir = turn2;
                }
                
            }else if( gilir == turn2 ){
                
                urut.setText("Giliran Merah");
                
                locx2 = locx2 + a;
                if(locx2>9 && locy2==9){
                    int loc = locx2 % 9;
                    locx2 = 9-loc;
                }else if (locx2 > 9){
                    locy2+=1;
                    locx2%=9;
                    locx2 --;
                }
                
                if( locy2 %2 ==1)
                {
                    pos2 = 9 - locx2;
                }
                
                if(pos2 ==0 && locy2 == 9)
                {
                    play2.setLocation(10 + (70*pos2), 40+ (locy2* 70));
                    urut.setText("Biru Menang");
                    gilir = 0 ;
                    
                }else if (locy2%2 == 1){
                    play2.setLocation(10+ (pos2 *70),10+(locy2*70));
                    gilir = turn1;
                }else{
                    play2.setLocation(10+ (locx2*70),10+(locy2*70));
                    gilir = turn1;
                }
                
            }else{
                
            }
            
            
        }
    });
    
    }
    
    
    public static void main(String[] args) throws IOException{
        
       try{
        String serverAddress = JOptionPane.showInputDialog(
                "Masukkan IP address server\n"
                + "yang berjalan pada port 9090:");
        Socket s = new Socket(serverAddress, 9090); // IP server 127.0.0.1
        new tangga();
       }catch(IOException e){
           JOptionPane.showMessageDialog(null, "IP Address yang Dimasukkan Salah");
       }
                
                
                
       
}
}

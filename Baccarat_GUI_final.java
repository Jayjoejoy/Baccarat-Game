//@Author Joe

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.util.Scanner;

public class Baccarat_GUI_final extends JFrame {
	
    int rounds = 0;
	int purse = 50;
	JPanel p0 = new JPanel();
	JPanel p01 = new JPanel();
	JPanel p02 = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p12 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p21 = new JPanel();
	JPanel p211 = new JPanel();
	JPanel p22 = new JPanel();
	JPanel p222 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p32 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JLabel l1 = new JLabel();
	JLabel l21 = new JLabel();
	JLabel l22 = new JLabel();
	JLabel[] icons1 = new JLabel[10];
	JLabel[] icons2 = new JLabel[10];
	int bet = 0;
	JLabel l41 = new JLabel();
	JButton b41 = new JButton("$1");
	JButton b42 = new JButton("$2");
	JButton b43 = new JButton("$3");
	JButton b44 = new JButton("$4");
	JButton b45 = new JButton("$5");
	JLabel l42 = new JLabel();
	JLabel l5 = new JLabel();
	JButton b51 = new JButton("Continue");
	JButton b52 = new JButton("Start");
	JLabel l6 = new JLabel();
	JButton b6 = new JButton("Next");
	// cards
	int[][] previous_cards = new int[50][2];
	int nop = 0;
	int[][] hand1 = new int[10][2]; // human hand
	int no1 = 0;
	int[][] hand2 = new int[10][2]; // computer
	int no2 = 0;
	int sum1 = 0;
	int sum2 = 0;
	// Constructor
	Baccarat_GUI_final(){
		this.setTitle("CSE114-Fall 2013-Baccarat Game");
		this.setSize(1000, 800);
		this.setLayout(new GridLayout(2,1));
		this.add(p2); this.add(p3);
		p3.setLayout(new GridLayout(5,1));
		p3.add(p0); p3.add(p1); p3.add(p4); p3.add(p5); p3.add(p6); 
		//j11.setIcon(card_to_ImageIcon(sorted1[0]));
		rounds = 1;
		p0.setLayout(new GridLayout(1,2));
		p0.add(p01); p0.add(p02);
		p01.add(l21); p02.add(l22);
		p01.setBorder(new LineBorder(new Color(0,0,0),2));
		p02.setBorder(new LineBorder(new Color(0,0,0),2));
		p1.add(l1);
		p2.setLayout(new GridLayout(1,2));
		p2.add(p211); p2.add(p222);
		p211.setBorder(new LineBorder(new Color(0,0,0),2));
		p222.setBorder(new LineBorder(new Color(0,0,0),2));
		p211.setLayout(new GridLayout(1,5));
		p222.setLayout(new GridLayout(1,5));
		p4.add(l41);
		p4.add(b41);
		p4.add(b42);
		p4.add(b43);
		p4.add(b44);
		p4.add(b45);
		p4.add(l42);
		l41.setText("Bet: ");
		p5.add(l5);
		l5.setText("Action: ");
		p5.add(b52);
		p5.add(b51);
		p6.add(l6);
		p6.add(b6);
		l1.setText("Round "+rounds+"          "+"Action: ");
		l6.setText("Result:        => New purse: $   ");
		l21.setText("User - purse="+purse+"; sum=");
		l22.setText("Computer - sum=");
		b41.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b41");b41.setEnabled(false); b42.setEnabled(false);b43.setEnabled(false);b44.setEnabled(false);b45.setEnabled(false);} } );
		b42.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b42");b41.setEnabled(false); b42.setEnabled(false);b43.setEnabled(false);b44.setEnabled(false);b45.setEnabled(false); } } );
		b43.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b43");b41.setEnabled(false); b42.setEnabled(false);b43.setEnabled(false);b44.setEnabled(false);b45.setEnabled(false); } } );
		b44.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b44");b41.setEnabled(false); b42.setEnabled(false);b43.setEnabled(false);b44.setEnabled(false);b45.setEnabled(false); } } );
		b45.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b45");b41.setEnabled(false); b42.setEnabled(false);b43.setEnabled(false);b44.setEnabled(false);b45.setEnabled(false); } } );
		b51.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b51");b51.setEnabled(false); b6.setEnabled(true);} } );
		b52.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b52");b52.setEnabled(false);b51.setEnabled(true);b6.setEnabled(false); } } );
		b6.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b6");b51.setEnabled(true);b52.setEnabled(true);b41.setEnabled(true); b42.setEnabled(true);b43.setEnabled(true);b44.setEnabled(true);b45.setEnabled(true); } } );
		// ACTIONS

		//bet = 0;
		//l42.setText("Bet: $"+bet);
		
		
		
		//b51.disable();//continue button
		//b6.disable();// next button
		setVisible(true);
		repaint();
	}
	
	public static void main(String[] args) throws IOException {
		Baccarat_GUI_final pg = new Baccarat_GUI_final();
	}
	
	public void refreshDisplay(String option){
		System.out.println("Option: "+option);
		if( option.equals("b41") || option.equals("b42")  || option.equals("b43")  || option.equals("b44")  || option.equals("b45") ){
			l1.setText("Round "+rounds+"          "+"Action: continue");
			if( option.equals("b41") ){
				bet = 1;
				//l1.setText("Round "+rounds+"          "+"Action: bet $1");

			}else if( option.equals("b42") ){
				bet = 2;
				//l1.setText("Round "+rounds+"          "+"Action: bet $2");
			}else if( option.equals("b43") ){
				bet = 3;
				//l1.setText("Round "+rounds+"          "+"Action: bet $3");
			}else if( option.equals("b44") ){
				bet = 4;				
				//l1.setText("Round "+rounds+"          "+"Action: bet $4");
			}else 
				{bet = 5;
				}
			l1.setText("Round "+rounds+"          "+"Action: bet $"+bet);

			l42.setText("Bet: $"+bet);
			
			b41.disable();
			b42.disable();
			b52.enable();
			b51.disable();
			b6.disable();
		} else if(option.equals("b52")){
			// b52 is "Start"
			
			l1.setText("Round "+rounds+"          "+"Action: Continue");
            // generate one card
			hand1[no1] = generate_card();// original text was "previous_card, nop"
			previous_cards[nop][0] = hand1[no1][0];
			previous_cards[nop][1] = hand1[no1][1];
			nop++;
			no1++;
			// generate one card (should be second card)
			hand1[no1] = generate_card(previous_cards,nop);
			previous_cards[nop][0] = hand1[no1][0];
			previous_cards[nop][1] = hand1[no1][1];
			nop++;
			no1++;
			// generate computer hard
			hand2[no2] = generate_card(previous_cards,nop);
			previous_cards[nop][0] = hand2[no2][0];
			previous_cards[nop][1] = hand2[no2][1];
			nop++;
			no2++;
			// generate computer second card
			hand2[no2] = generate_card(previous_cards,nop);
			previous_cards[nop][0] = hand2[no2][0];
			previous_cards[nop][1] = hand2[no2][1];
			nop++;
			no2++;
			for(int i=0; i<no1; i++){
				icons1[i] = new JLabel();
				icons1[i].setIcon(card_to_ImageIcon(hand1[i]));
				icons1[i].setSize(30,30);
				p211.add(icons1[i]);
			}
			for(int i=0; i<no2; i++){
				icons2[i] = new JLabel();
				icons2[i].setIcon(card_to_ImageIcon(hand2[i]));
				p222.add(icons2[i]);
			}
			sum1 = sum_hand(hand1,no1);
			sum2 = sum_hand(hand2,no2);
			l21.setText("User - purse="+purse+"; sum="+ (sum1%10));
			l22.setText("Computer - sum="+ (sum2%10));
			
		} else if(option.equals("b51")){
         // b51 is continue, 
	        
			if(sum1%10<8&&sum2%10<8){
			   if(sum1%10>=6&&sum1%10<=7){
				  if(sum2%10>=0&&sum2%10<=5){
					hand2[no2]=generate_card(previous_cards,nop);
					previous_cards[nop][0] = hand2[no2][0];
					previous_cards[nop][1] = hand2[no2][1];
	                nop++;
	                no2++;
	                sum2= sum_hand(hand2,no2);
	                icons2[2]= new JLabel();
	                icons2[2].setIcon(card_to_ImageIcon(hand2[2]));
	                icons2[2].setSize(30,30);
	                p222.add(icons2[2]);
				  }
			   }
			  if(sum1%10>=0&&sum1%10<=5){
            	hand1[no1] = generate_card(previous_cards,nop);
      			previous_cards[nop][0] = hand1[no1][0];
      			previous_cards[nop][1] = hand1[no1][1];
      			nop++;
      			no1++;	
      			sum1 = sum_hand(hand1,no1);
      			icons1[2]= new JLabel();
                icons1[2].setIcon(card_to_ImageIcon(hand1[2]));
                icons1[2].setSize(30,30);
                p211.add(icons1[2]);
            	  if(hand1[no1][0]>=2&&hand1[no1][0]<=3)  {
            		  if(sum2%10>=0&&sum2%10<=4){
            			hand2[no2]=generate_card(previous_cards,nop);
            			previous_cards[nop][0] = hand2[no2][0];
            			previous_cards[nop][1] = hand2[no2][1];
      	                nop++;
      	                no2++;
      	                sum2= sum_hand(hand2,no2); 
      	                icons2[2]= new JLabel();
  	                    icons2[2].setIcon(card_to_ImageIcon(hand2[2]));
  		                icons2[2].setSize(30,30);
  	                    p222.add(icons2[2]);
            		  }
            		 		  
                    }
            	  else if(hand1[no1][0]>=4&&hand1[no1][0]<=5){
            		  if(sum2%10>=0&&sum2%10<=5){
              			hand2[no2]=generate_card(previous_cards,nop);
              			previous_cards[nop][0] = hand2[no2][0];
              			previous_cards[nop][1] = hand2[no2][1];
        	                nop++;
        	                no2++;
        	                sum2= sum_hand(hand2,no2);  
        	                icons2[2]= new JLabel();
        	                icons2[2].setIcon(card_to_ImageIcon(hand2[2]));
        	                icons2[2].setSize(30,30);
                            p222.add(icons2[2]);
              		  }
            	  }
            	  else if(hand1[no1][0]>=6&&hand1[no1][0]<=7){
            		  if(sum2%10>=0&&sum2%10<=6){
              			hand2[no2]=generate_card(previous_cards,nop);
              			previous_cards[nop][0] = hand2[no2][0];
              			previous_cards[nop][1] = hand2[no2][1];
        	                nop++;
        	                no2++;
        	                sum2= sum_hand(hand2,no2);
        	                icons2[2]= new JLabel();
        	                icons2[2].setIcon(card_to_ImageIcon(hand2[2]));
        	                icons2[2].setSize(30,30);
                            p222.add(icons2[2]);
              		  }
            	  }
            	  else if(hand1[no1][0]==8){
            		  if(sum2%10>=0&&sum2%10<=2){
                			hand2[no2]=generate_card(previous_cards,nop);
                			previous_cards[nop][0] = hand2[no2][0];
                			previous_cards[nop][1] = hand2[no2][1];
          	                nop++;
          	                no2++;
          	                sum2= sum_hand(hand2,no2); 
          	                icons2[2]= new JLabel();
      	                    icons2[2].setIcon(card_to_ImageIcon(hand2[2]));
      		                icons2[2].setSize(30,30);
                            p222.add(icons2[2]);
                		  }
            	  }
            	  else{
            		  if(sum2%10>=0&&sum2%10<=3){
                			hand2[no2]=generate_card(previous_cards,nop);
                			previous_cards[nop][0] = hand2[no2][0];
                			previous_cards[nop][1] = hand2[no2][1];
          	                nop++;
          	                no2++;
          	                sum2= sum_hand(hand2,no2);  
          	                icons2[2]= new JLabel();
      	                    icons2[2].setIcon(card_to_ImageIcon(hand2[2]));
      		                icons2[2].setSize(30,30);
      	                    p222.add(icons2[2]);
                		  }
            	  }
			   }
			}	
			
		if(result(sum1, sum2).equals("Player Win")){
			purse = purse + bet;
		}	
		if(result(sum1, sum2).equals("Banker Win")){
			purse = purse - bet;
		}	
		l21.setText("User - purse="+purse+"; sum="+ (sum1%10));
		l22.setText("Computer - sum="+ (sum2%10));
		l6.setText("Result: "+ result(sum1, sum2)+" New purse: $"+purse);	
		b51.disable();
		} else if(option.equals("b6")){
			// b6 is next: restart
			for(int i=0; i<no1; i++){
				p211.remove(icons1[i]);
			}
			for(int i=0; i<no2; i++){
				p222.remove(icons2[i]);
			}
			 previous_cards = new int[50][2];
			 nop = 0;
		     hand1 = new int[10][2]; 
			 no1 = 0;
			 hand2 = new int[10][2]; 
			 no2 = 0;
			 sum1 = 0;
			 sum2 = 0;
			 bet=0;
			 
			 
		} else System.out.println("Invalid option: "+option);
		repaint();
		
	}

	public static ImageIcon card_to_ImageIcon(int[] c){
		String fileString = "C:\\Users\\Zhe Wang\\workspace\\HomeWork\\playing_cards_images\\Playing_card_";//String fileString = "images/Playing_card_";
		if(c[1]==1) fileString += "heart";
		else if(c[1]==2) fileString += "diamond";
		else if(c[1]==2) fileString += "club";
		else fileString += "spade";
		fileString += "_";
		if(2<=c[0] && c[0]<=10) fileString += c[0];
		else if(c[0]==11) fileString += "J";
		else if(c[0]==12) fileString += "Q";
		else if(c[0]==13) fileString += "K";
		else fileString += "A";
		fileString += ".jpg";
		return new ImageIcon(fileString);
	}

	
	public static int sum_hand(int[][] hand1,int no1){
		int sum = 0;
		for(int i=0; i<no1;i++){
			if(hand1[i][0]<=10)
				sum += hand1[i][0];
			else sum += 0; // these cards are 0 -- implement the Ace treatment
		}
		return sum;
	}
	
	public static int[] generate_card(int[][] previous_cards,int nop){
		boolean duplicate = false;
		int[] card = new int[2];
		do{
			duplicate = false;
			card[0] = (int) (Math.random()*13 + 2);
			card[1] = (int) (Math.random()*4 + 1);
			// compare all the previous hands with the current hand
			for(int i=0; i<nop;i++){
				if(card[0]==previous_cards[i][0] && card[1]==previous_cards[i][1]) duplicate = true;
			}
		}while(duplicate);
		return card;
	}
	public static int[] generate_card(){
		int[] card = new int[2];
		card[0] = (int) (Math.random()*13 + 2);
		card[1] = (int) (Math.random()*4 + 1);
		return card;
	}
	public static String card_to_String(int[] c){
		String card = "";
		if(2<=c[0] && c[0]<=10) 
			card += c[0];
		else if(c[0]==11) card += "Jack";
		else if(c[0]==12) card += "Queen";
		else if(c[0]==13) card += "king";
		else if(c[0]==14) card += "Ace";
		else card += "card_to_String error: card number="+c[0];
		card += " of ";
		if(c[1]==1) card += "hearts";
		else if(c[1]==2) card += "diamonds";
		else if(c[1]==2) card += "clubs";
		else card += "spades";
		return card;
	}
	public static String result(int sum1, int sum2){
		if(sum1%10>sum2%10){
			return "Player Win";
			//bet
		}
		else if(sum1%10==sum2%10){
			
			return   "Tie";
		}
		else{
			
			return  "Banker Win";
			
		}
	}
}

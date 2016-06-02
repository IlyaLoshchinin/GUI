/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad3;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.WindowConstants;


public class Main {

  public static void main(String[] args) {
	  
	  JFrame frame = new JFrame("Zad 3");
	  
	 
	  
	 
	  
	  JButton button = new JButton("Nie klikac!");
	  button.setForeground(Color.WHITE);
	  button.setFont(new Font("TimesRoman", Font.BOLD, 40));

	  frame.add(button);
	 
	  button.addActionListener(new ActionListener() {
		
		  Color []color = {Color.BLACK,Color.BLUE,Color.CYAN,Color.GRAY,Color.MAGENTA,Color.ORANGE,Color.RED};
		  int i = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			if(color.length == i)
				i = 0;
			
			button.setBackground(color[i]);
			i++;
		}
	});
	 
	  
	  frame.pack();
	  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	  frame.setLocationRelativeTo(null);
	  frame.setVisible(true);
  }
}

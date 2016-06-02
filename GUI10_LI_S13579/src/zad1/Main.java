/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;




public class Main {

  public static void main(String[] args) {
	  
	  JFrame frame = new JFrame("Zad1");
	 
	  JPanel panel = new JPanel();
	  
	  JLabel label1 = new JLabel("Label 1 - lalala");
	  JLabel label2 = new JLabel("Label 2 - asdsads");
	  JLabel label3 = new JLabel("<html>Label 3 - sadsd</html>");
	  JLabel label4 = new JLabel("Label 4 - sadsdsdasd");
	  JLabel label5 = new JLabel("Label 5 - asdsadsds");
	  
	  
	  label1.setBackground(Color.YELLOW); 
	  label2.setBackground(Color.BLUE);
	  label3.setBackground(Color.CYAN);
	  label4.setBackground(Color.GRAY);
	  label5.setBackground(Color.GREEN);
	  
	  label1.setOpaque(true);
	  label2.setOpaque(true);
	  label3.setOpaque(true);
	  label4.setOpaque(true);
	  label5.setOpaque(true);
	  
	
	  Font[] fontName = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
	  
	  label1.setFont(new Font(fontName[0].getFontName(),fontName[0].getStyle(), 20));
	  label2.setFont(new Font(fontName[1].getFontName(),fontName[1].getStyle(), 30));
	  label3.setFont(new Font(fontName[2].getFontName(),fontName[2].getStyle(), 40));
	  label4.setFont(new Font(fontName[3].getFontName(),fontName[3].getStyle(), 25));
	  label5.setFont(new Font(fontName[4].getFontName(),fontName[4].getStyle(), 15));
	  
	  label1.setForeground(Color.BLUE);
	  label2.setForeground(Color.WHITE);
	  label3.setForeground(Color.GRAY);
	  label4.setForeground(Color.CYAN);
	  label5.setForeground(Color.RED);
	  
	   label1.setToolTipText("Zrob to raz!");
	   label2.setToolTipText("Zrob to dwa!");
	   label3.setToolTipText("Zrob to trzy!");
	   label4.setToolTipText("Zrob to cztery!");
	   label5.setToolTipText("Zrob to piec!");
	   
	 label1.setHorizontalAlignment(SwingConstants.CENTER);
	 label2.setHorizontalAlignment(SwingConstants.CENTER);
	 label3.setHorizontalAlignment(SwingConstants.CENTER);
	 label4.setHorizontalAlignment(SwingConstants.CENTER);
	 label5.setHorizontalAlignment(SwingConstants.CENTER);
	 
	   
	   label1.setBorder(BorderFactory.createLineBorder(Color.PINK));
	   label2.setBorder(BorderFactory.createEtchedBorder(Color.GRAY,Color.BLACK));
	   label3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	   label5.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED));
	   label4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.YELLOW),
			   												BorderFactory.createRaisedBevelBorder()));
	   
	   panel.setLayout(new BorderLayout(5,5));
	   
	   panel.add(label1,BorderLayout.PAGE_START);
	   panel.add(label2,BorderLayout.LINE_START);
	   panel.add(label3,BorderLayout.CENTER);
	   panel.add(label4,BorderLayout.LINE_END);
	   panel.add(label5,BorderLayout.PAGE_END);
	   
	   
	   
	  panel.setPreferredSize(new Dimension(750, 600));
	  
	  frame.getContentPane().add(panel);
	 
	  frame.pack();

	  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	  frame.setLocationRelativeTo(null);
	  frame.setVisible(true);
	  
  }
}

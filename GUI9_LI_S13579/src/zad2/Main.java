/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Zad_2");
		
		frame.setSize(new Dimension(600, 100));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();

		frame.getContentPane().add(panel);

		
		

	
		String[] letters = { "A - BorderLayou ", "B - FlowLayout ",
				"C - FlowLayoutLeft", "D - FlowLayoutRight",
				"E - GridLayoutRow", "F - GridLayoutColumn",
				"G -  GridLayout(3,2)" };
		
		String value = (String) JOptionPane.showInputDialog(panel,
				"Choose Layout", "SetLayoutManadger",
				JOptionPane.QUESTION_MESSAGE, null, letters, letters[0]);
		
		
		
		
		if (value != null) {
			
			if(!value.substring(0, 1).equals("A")){
				panel.add(new JButton("Przycisk 1"));
				panel.add(new JButton("P 2"));
				panel.add(new JButton("Większy przycisk numer 3"));
				panel.add(new JButton("Przycisk 4"));
				panel.add(new JButton("P5"));
			}
			

			switch (value.substring(0, 1)) {
			case "A":
				frame.setSize(500, 500);
				panel.setLayout(new BorderLayout());
				panel.add(new JButton("Przycisk 1"), BorderLayout.PAGE_START);
				panel.add(new JButton("P 2"),BorderLayout.WEST);
				panel.add(new JButton("Większy przycisk numer 3"),BorderLayout.CENTER);
				panel.add(new JButton("Przycisk 4"),BorderLayout.EAST);
				panel.add(new JButton("P5"),BorderLayout.PAGE_END);
				break;
			case "B":
				panel.setLayout(new FlowLayout());
				break;
			case "C":
				panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				break;
			case "D":
				panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
				break;
			case "E":
				panel.setLayout(new GridLayout(1, 0));
				frame.setSize(400, 400);
				break;
			case "F":
				panel.setLayout(new GridLayout(0, 1));
				frame.setSize(400, 600);
				break;
			case "G":
				panel.setLayout(new GridLayout(3, 2));
				frame.setSize(400, 600);
				break;

			default:
				break;
			}
			
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);

		}else{
			JOptionPane.showMessageDialog(frame, "Do widzenia! Miłego dnia!");
			System.exit(0);
		}
	}
}

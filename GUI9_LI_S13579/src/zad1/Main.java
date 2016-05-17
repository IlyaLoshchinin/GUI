/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad1;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Zad_1");
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		Font font = new Font(Font.SERIF, Font.ITALIC, 20);

		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(font);
		textArea.setLineWrap(true);

		frame.getContentPane().add(scrollPane);

		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}

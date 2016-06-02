/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 500));
		frame.setMinimumSize(new Dimension(360, 250));
		frame.setLayout(new BorderLayout());

		JPanel panelTop = new JPanel();
		panelTop.setLayout(new GridLayout(1, 2));
		frame.add(panelTop, BorderLayout.NORTH);

		JPanel buttonsRight = new JPanel();

		buttonsRight.setLayout(new FlowLayout(FlowLayout.RIGHT));

		buttonsRight.add(new JButton("B1"));
		buttonsRight.add(new JButton("B2"));
		buttonsRight.add(new JButton("B3"));

		JPanel buttonsLeft = new JPanel();
		buttonsLeft.setLayout(new FlowLayout(FlowLayout.LEFT));

		buttonsLeft.add(new JButton("A1"));
		buttonsLeft.add(new JButton("A2"));
		buttonsLeft.add(new JButton("A3"));

		panelTop.add(buttonsLeft);
		panelTop.add(buttonsRight);
		panelTop.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(0, 7, 0, 7),
				panelTop.getBorder()));

		JTextArea textArea = new JTextArea("To jest JTextArea");
		textArea.setColumns(100);
		textArea.setRows(50);
		// kak nie raszyrat szyre zadanogo?

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(0, 3, 0, 3),
				scrollPane.getBorder()));
		

		frame.add(scrollPane, BorderLayout.CENTER);

		JPanel panelFooter = new JPanel(new GridLayout(1, 2));

		JPanel panelButtonsToLeft = new JPanel(new FlowLayout(FlowLayout.LEFT,
				0, 0));

		JPanel buttonsOnFooter = new JPanel(new GridLayout(3, 3, 1, 1));

		for (int i = 1; i < 10; i++) {
			buttonsOnFooter.add(new JButton(String.valueOf(i)));
		}

		panelButtonsToLeft.add(buttonsOnFooter);
		panelButtonsToLeft.setBorder(BorderFactory.createCompoundBorder(
				panelButtonsToLeft.getBorder(),
				BorderFactory.createEmptyBorder(0, 3, 0, 0)));
		JPanel panelForTextField = new JPanel(new GridLayout(3, 1, 0, 5));

		for (int i = 0; i < 3; i++) {
			JTextField textField = new JTextField("To jest JTextField");
			textField.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(Color.RED),
					BorderFactory.createLineBorder(Color.YELLOW)));
			panelForTextField.add(textField);
		}
		panelForTextField.setBorder(BorderFactory.createCompoundBorder(
				panelForTextField.getBorder(),
				BorderFactory.createEmptyBorder(3, 0, 10, 30)));

		panelFooter.add(panelButtonsToLeft);
		panelFooter.add(panelForTextField);

		frame.add(panelFooter, BorderLayout.SOUTH);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

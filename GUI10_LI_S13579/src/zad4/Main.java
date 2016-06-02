/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(500, 500);

		JMenuBar menubar = new JMenuBar();

		String[] menuNameArray = { "File", "Edit", "Options" };
		JMenu[] menu = new myJMenu[menuNameArray.length];

		for (int i = 0; i < menuNameArray.length; i++) {
			menu[i] = new myJMenu(menuNameArray[i]);
			menubar.add(menu[i]);
		}

		String[][] menuNameItem1 = { { "Open", "o", "control O" },
				{ "Save", "s", "control S" },
				{ "Save as...", "a", "control A" }, { "separator" },
				{ "Exit", "x", "control X" }

		};

		JMenuItem[] menuItem1 = addItemsToMenu(menuNameItem1, menu[0]);

		/*
		 * JMenu fileMenu = new myJMenu("File");
		 * 
		 * JMenuItem open = new myMenuItem("Open", 'o', "control O");
		 * fileMenu.add(open);
		 * 
		 * JMenuItem save = new myMenuItem("Save", 's', "control S");
		 * fileMenu.add(save);
		 * 
		 * JMenuItem saveAs = new myMenuItem("Save as...", 'a', "control A");
		 * fileMenu.add(saveAs);
		 * 
		 * JMenuItem exit = new myMenuItem("Exit", 'x', "control X");
		 */

		/*
		 * JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		 * separator.setPreferredSize(new Dimension(0, 4));
		 * separator.setBorder(BorderFactory
		 * .createLineBorder(Color.RED.darker()));
		 * separator.setBorder(BorderFactory.createCompoundBorder(
		 * BorderFactory.createMatteBorder(1, 4, 1, 4, Color.WHITE),
		 * separator.getBorder()));
		 */

		/*
		 * fileMenu.add(makeSeparator()); fileMenu.add(exit);
		 */

		// menubar.add(fileMenu);

		// JMenu editMenu = new myJMenu("Edit");

		JMenu adresyMenu = new myJMenu("Adresy");
		menu[1].add(adresyMenu);

		String[][] menuNameItem2 = { { "Praca", "p", "control shift P" },
				{ "Szkola", "s", "control shift S" },
				{ "Dom", "d", "control shift D" }, };
		
		JMenuItem[] menuItem2 = addItemsToMenu(menuNameItem2, adresyMenu);

		/*
		 * myMenuItem[] menuItemList2 = new myMenuItem[menuNameItem1.length];
		 * 
		 * 
		 * JMenuItem praca = new myMenuItem("Praca", 'p', "control shift P");
		 * JMenuItem szkola = new myMenuItem("Szkola", 's', "control shift S");
		 * JMenuItem dom = new myMenuItem("Dom", 'd', "control shift D");
		 * 
		 * adresyMenu.add(praca); adresyMenu.add(szkola); adresyMenu.add(dom);
		 */

		// menubar.add(editMenu);

		// JMenu optionsMenu = new myJMenu("Options");
		// menubar.add(optionsMenu);

		String[] nameIncludeMenuItem = { "Foreground", "Background",
				"Font size" };
		
		JMenu[] menuItemsIn = addItemsToMenu(nameIncludeMenuItem, menu[2]);

		// JMenu foreground = new myJMenu("Foreground");
		// optionsMenu.add(foreground);

		String[] menuNameItem3 = { "Blue", "Yellow", "Orange", "Red", "White",
				"Black", "Green" };

		JMenuItem[] menuItemsForeground = addItemsToMenuIcon(menuItemsIn[0], menuNameItem3);
		JMenuItem[] menuItemsBackground = addItemsToMenuIcon(menuItemsIn[1], menuNameItem3);
		JMenuItem[] menuItemsFontSize = addItemsToMenuIcon(menuItemsIn[2],9);
		
	/*	menuItemsIn[0].add(new myMenuItem("Blue", Color.BLUE));
		foreground.add(new myMenuItem("Yellow", Color.YELLOW));
		foreground.add(new myMenuItem("Orange", Color.ORANGE));
		foreground.add(new myMenuItem("Red", Color.RED));
		foreground.add(new myMenuItem("White", Color.WHITE));
		foreground.add(new myMenuItem("Black", Color.BLACK));
		foreground.add(new myMenuItem("Green", Color.GREEN));*/

		/*JMenu background = new myJMenu("Background");
		// optionsMenu.add(background);

		background.add(new myMenuItem("Blue", Color.BLUE));
		background.add(new myMenuItem("Yellow", Color.YELLOW));
		background.add(new myMenuItem("Orange", Color.ORANGE));
		background.add(new myMenuItem("Red", Color.RED));
		background.add(new myMenuItem("White", Color.WHITE));
		background.add(new myMenuItem("Black", Color.BLACK));
		background.add(new myMenuItem("Green", Color.GREEN));*/

		/*JMenu fontSize = new myJMenu("Font size");
		// optionsMenu.add(fontSize);

		fontSize.add(new myMenuItem("8 pts"));
		fontSize.add(new myMenuItem("10 pts"));
		fontSize.add(new myMenuItem("12 pts"));
		fontSize.add(new myMenuItem("14 pts"));
		fontSize.add(new myMenuItem("16 pts"));
		fontSize.add(new myMenuItem("18 pts"));
		fontSize.add(new myMenuItem("20 pts"));
		fontSize.add(new myMenuItem("22 pts"));
		fontSize.add(new myMenuItem("24 pts"));*/

		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);

		frame.getContentPane().add(scrollPane);

		// Proszę Pana dać mi jeszcze czas... do końca tygodnia. Bo nie miałem
		// możliwości to zrobić do końca. Dziękuję.

		frame.setJMenuBar(menubar);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	private static JMenuItem[] addItemsToMenuIcon(JMenu jMenu,int value) {
		JMenuItem[] menuItem = new myMenuItem[value];
		int pts = 8;
		for (int i = 0; i < value; i++) {
			menuItem[i] = new myMenuItem(pts + " pts");
			jMenu.add(menuItem[i]);
			pts+=2;
		}
		return menuItem;
	}

	public static JSeparator addSeparator() {
		JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setPreferredSize(new Dimension(0, 4));
		separator.setBorder(BorderFactory.createLineBorder(Color.RED.darker()));
		separator.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(1, 4, 1, 4, Color.WHITE),
				separator.getBorder()));
		return separator;
	}

	public static JMenuItem[] addItemsToMenu(String[][] menuNameItem1, JMenu menuArray) {

		JMenuItem[] menuItemList1 = new myMenuItem[menuNameItem1.length];
		for (int i = 0; i < menuNameItem1.length; i++) {
			if (menuNameItem1[i][0].equals("separator")) {
				menuArray.add(addSeparator());
				continue;
			}
			menuItemList1[i] = new myMenuItem(menuNameItem1[i][0],
					menuNameItem1[i][1].charAt(0), menuNameItem1[i][2]);
			menuArray.add(menuItemList1[i]);
		}
		return menuItemList1;
	}

	public static JMenu[] addItemsToMenu(String[] menuNameItem, JMenu menu) {

		JMenu[] menuItemList = new myJMenu[menuNameItem.length];

		for (int i = 0; i < menuNameItem.length; i++) {
			if (menuNameItem[i].equals("separator")) {
				menu.add(addSeparator());
				continue;
			}
			menuItemList[i] = new myJMenu(menuNameItem[i]);
			menu.add(menuItemList[i]);
		}
		return menuItemList;
	}

	public static JMenuItem[] addItemsToMenuIcon(JMenu menu, String[] nameItems) {
		JMenuItem[] menuItem = new myMenuItem[nameItems.length];
		Color color = Color.black;

		for (int i = 0; i < menuItem.length; i++) {
			
			switch (nameItems[i].toString()) {
			case "Blue":
				color = Color.BLUE;
				break;
			case "Yellow":
				color = Color.YELLOW;
				break;
			case "Orange":
				color = Color.ORANGE;
				break;
			case "Red":
				color = Color.RED;
				break;
			case "White":
				color = Color.WHITE;
				break;
			case "Black":
				color = Color.BLACK;
				break;
			case "Green":
				color = Color.GREEN;
				break;
			
			default:
				color = Color.BLACK;
				break;
			}

			menuItem[i] = new myMenuItem(nameItems[i], color);
			menu.add(menuItem[i]);
		}
		return menuItem;
	}
}

class myMenuItem extends JMenuItem {

	public myMenuItem(String name, char mnem, String key) {
		setText(name);
		setFont(new Font(getName(), Font.BOLD, 13));
		setBorder(BorderFactory.createRaisedBevelBorder());
		setMnemonic(mnem);
		setAccelerator(KeyStroke.getKeyStroke(key));
	}

	public myMenuItem(String name, Color color) {
		setText(name);
		setIcon(new myIcon(color));
		// setPreferredSize(new Dimension(60, 20));
		setFont(new Font(getName(), Font.BOLD, 13));
		setBorder(BorderFactory.createRaisedBevelBorder());
	}

	public myMenuItem(String name) {
		setText(name);
		setFont(new Font(getName(), Font.BOLD, 13));
		setBorder(BorderFactory.createRaisedBevelBorder());
	}

}

class myJMenu extends JMenu {
	public myJMenu(String name) {
		setText(name);
		setFont(new Font(getName(), Font.BOLD, 13));
	}

}

class myIcon implements Icon {

	private Color color;
	private int size = 13;

	public myIcon(Color color) {
		this.color = color;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);
		size = ((JComponent) c).getHeight() / 2;
		int p = size / 4, d = size / 2;
		g2d.fillOval(p + y - 2, d, size, size);
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return size;
	}

}

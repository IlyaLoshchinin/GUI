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

	private static JScrollPane scrollPane;

	static JFrame frame;

	public static void main(String[] args) {

		frame = new JFrame();
		frame.setSize(600, 500);
		frame.setTitle("Bez tytułu");
		JTextArea textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		frame.getContentPane().add(scrollPane);

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

		addItemsToMenu(menuNameItem1, menu[0]);

		JMenu adresyMenu = new myJMenu("Adresy");
		menu[1].add(adresyMenu);

		String[][] menuNameItem2 = {
				{ "Praca", "p", "control shift P", "Praca: ul.Punkry 100" },
				{ "Szkola", "s", "control shift S", "Szkola: ul.Koszykowa 86" },
				{ "Dom", "d", "control shift D", "Dom: ul.Amsteram 30" }, };

		addItemsToMenu(menuNameItem2, adresyMenu);

		String[] nameIncludeMenuItem = { "Foreground", "Background",
				"Font size" };

		JMenu[] menuItemsIn = addItemsToMenu(nameIncludeMenuItem, menu[2]);

		String[] menuNameItem3 = { "Blue", "Yellow", "Orange", "Red", "White",
				"Black", "Green" };

		addItemsToMenuIcon(menuItemsIn[0], menuNameItem3);
		addItemsToMenuIcon(menuItemsIn[1], menuNameItem3);
		addItemsToMenuIcon(menuItemsIn[2], 8);

		frame.setJMenuBar(menubar);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	private static JMenuItem[] addItemsToMenuIcon(JMenu jMenu, int startFrom) { // add
																				// @Font
																				// size@
																				// to
																				// JMenu
		startFrom++;
		JMenuItem[] menuItem = new myMenuItem[startFrom];
		BtnItemsListeners bl = new BtnItemsListeners(getScrollPane());
		int pts = startFrom - 1;
		for (int i = 0; i < startFrom; i++) {
			menuItem[i] = new myMenuItem(pts + " pts");
			menuItem[i].addActionListener(bl);
			jMenu.add(menuItem[i]);
			pts += 2;
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

	public static JMenuItem[] addItemsToMenu(String[][] menuNameItem1,
			JMenu menuArray) { // add JMenuItem to JMenu
		BtnItemsListeners bl = new BtnItemsListeners(getScrollPane()); // Praca,Szkola,Dom

		JMenuItem[] menuItemList1 = new myMenuItem[menuNameItem1.length];
		for (int i = 0; i < menuNameItem1.length; i++) {
			if (menuNameItem1[i][0].equals("separator")) {
				menuArray.add(addSeparator());
				continue;
			}
			if (menuNameItem1[i].length == 4) {
				menuItemList1[i] = new myMenuItem(menuNameItem1[i][0],
						menuNameItem1[i][1].charAt(0), menuNameItem1[i][2],
						menuNameItem1[i][3]);
			} else {
				menuItemList1[i] = new myMenuItem(menuNameItem1[i][0],
						menuNameItem1[i][1].charAt(0), menuNameItem1[i][2],
						null);
			}
			menuItemList1[i].addActionListener(bl);
			menuArray.add(menuItemList1[i]);
		}
		return menuItemList1;
	}

	public static JMenu[] addItemsToMenu(String[] menuNameItem, JMenu menu) { // add
																				// JMenu
																				// to
																				// JMenuBar

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

	public static JMenuItem[] addItemsToMenuIcon(JMenu menu, String[] nameItems) { // add
																					// JMenuItem
																					// with
																					// Icon
		JMenuItem[] menuItem = new myMenuItem[nameItems.length];
		Color color = Color.black;
		BtnItemsListeners bl = new BtnItemsListeners(getScrollPane());
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
			menuItem[i].addActionListener(bl);
			menu.add(menuItem[i]);
		}
		return menuItem;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static JScrollPane getScrollPane() {
		return scrollPane;
	}
}

class myMenuItem extends JMenuItem {

	private static final long serialVersionUID = 1L;
	public static Font font = new Font(null, Font.BOLD, 13);

	public myMenuItem(String name, char mnem, String key, String textWstawiania) { // for
																					// normal
																					// items
																					// with
																					// name
																					// mnemonic
																					// and
																					// accelerator
		setText(name);
		setFont(font);
		if (textWstawiania != null) {
			setName(textWstawiania);
		}
		setBorder(BorderFactory.createRaisedBevelBorder());
		setMnemonic(mnem);
		setAccelerator(KeyStroke.getKeyStroke(key));
	}

	public myMenuItem(String name, Color color) { // for foreground and
													// background
		setText(name);
		setIcon(new myIcon(color));
		putClientProperty(name, color);
		setFont(font);
		setBorder(BorderFactory.createRaisedBevelBorder());
	}

	public myMenuItem(String name) { // for Font size
		setText(name);
		setFont(font);
		setBorder(BorderFactory.createRaisedBevelBorder());
	}

}

class myJMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	public myJMenu(String name) {
		setText(name);
		setFont(myMenuItem.font);
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
		return size;
	}

	@Override
	public int getIconHeight() {
		return size;
	}

}

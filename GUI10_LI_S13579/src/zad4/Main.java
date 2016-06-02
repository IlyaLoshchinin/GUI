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
	  
	  JMenu fileMenu = new myJMenu("File");
	  
	  
	  JMenuItem open = new myMenuItem("Open",'o',"control O");
	  fileMenu.add(open);
	  
	  JMenuItem save = new myMenuItem("Save",'s',"control S");
	  fileMenu.add(save);
	 
	  
	  JMenuItem saveAs = new myMenuItem("Save as...",'a',"control A");
	  fileMenu.add(saveAs);
	  
	  JMenuItem exit = new myMenuItem("Exit",'x',"control X");
	  
	 
	  JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
	  separator.setPreferredSize(new Dimension(0, 4));
	  separator.setBorder(BorderFactory.createLineBorder(Color.RED.darker()));
	  separator.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 4, 1, 4, Color.WHITE),separator.getBorder()));
	  
	  fileMenu.add(separator);
	  fileMenu.add(exit);
	 
	  menubar.add(fileMenu);
	  
	  JMenu editMenu = new myJMenu("Edit");
	
	  JMenu adresyMenu = new myJMenu("Adresy");
	  
	  editMenu.add(adresyMenu);
	  
	  JMenuItem praca = new myMenuItem("Praca",'p',"control shift P");	
	  JMenuItem szkola = new myMenuItem("Szkola",'s',"control shift S");
	  JMenuItem dom = new myMenuItem("Dom",'d',"control shift D");
	  
	  adresyMenu.add(praca);
	  adresyMenu.add(szkola);
	  adresyMenu.add(dom);
	  
      menubar.add(editMenu);
	  
	  
	  JMenu optionsMenu = new myJMenu("Options");
	  menubar.add(optionsMenu);
	  
	  JMenu foreground = new myJMenu("Foreground");
	  optionsMenu.add(foreground);
	  
	  foreground.add(new myMenuItem("Blue",Color.BLUE));
	  foreground.add(new myMenuItem("Yellow",Color.YELLOW));
	  foreground.add(new myMenuItem("Orange",Color.ORANGE));
	  foreground.add(new myMenuItem("Red",Color.RED));
	  foreground.add(new myMenuItem("White",Color.WHITE));
	  foreground.add(new myMenuItem("Black",Color.BLACK));
	  foreground.add(new myMenuItem("Green",Color.GREEN));
	  
	  JMenu background = new myJMenu("Background");
	  optionsMenu.add(background);
	  
	  background.add(new myMenuItem("Blue",Color.BLUE));
	  background.add(new myMenuItem("Yellow",Color.YELLOW));
	  background.add(new myMenuItem("Orange",Color.ORANGE));
	  background.add(new myMenuItem("Red",Color.RED));
	  background.add(new myMenuItem("White",Color.WHITE));
	  background.add(new myMenuItem("Black",Color.BLACK));
	  background.add(new myMenuItem("Green",Color.GREEN));
	  
	  JMenu fontSize = new myJMenu("Font size");
	  optionsMenu.add(fontSize);
	  
	  fontSize.add(new myMenuItem("8 pts"));
	  fontSize.add(new myMenuItem("10 pts"));
	  fontSize.add(new myMenuItem("12 pts"));
	  fontSize.add(new myMenuItem("14 pts"));
	  fontSize.add(new myMenuItem("16 pts"));
	  fontSize.add(new myMenuItem("18 pts"));
	  fontSize.add(new myMenuItem("20 pts"));
	  fontSize.add(new myMenuItem("22 pts"));
	  fontSize.add(new myMenuItem("24 pts"));
	  
	  
	  JTextArea textArea = new JTextArea();
	  JScrollPane scrollPane = new JScrollPane(textArea);
	  
	  frame.getContentPane().add(scrollPane);
	  
	  // Proszę Pana dać mi jeszcze czas... do końca tygodnia. Bo nie miałem możliwości to zrobić do końca. Dziękuję.
	  
	  frame.setJMenuBar(menubar);
	  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	  frame.setLocationRelativeTo(null);
	  frame.setVisible(true);
	  
  }	
  
}

class myMenuItem extends JMenuItem{
	 
	 public myMenuItem(String name,char mnem,String key) {
		setText(name);
		setFont(new Font(getName(), Font.BOLD, 13));
		setBorder(BorderFactory.createRaisedBevelBorder());
		setMnemonic(mnem);
		setAccelerator(KeyStroke.getKeyStroke(key));
	} 
	 public myMenuItem(String name,Color color) {
			setText(name);
			setIcon(new myIcon(color));
			//setPreferredSize(new Dimension(60, 20));
			setFont(new Font(getName(), Font.BOLD, 13));
			setBorder(BorderFactory.createRaisedBevelBorder());
		} 
	 public myMenuItem(String name) {
			setText(name);
			setFont(new Font(getName(), Font.BOLD, 13));
			setBorder(BorderFactory.createRaisedBevelBorder());
		} 
	 
}

class myJMenu extends JMenu{
	public myJMenu(String name) {
		setText(name);
		setFont(new Font(getName(), Font.BOLD, 13));
	}
	
	
}

class myIcon implements Icon{
	
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
	    g2d.fillOval(p+y-2, d, size, size);
	    
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

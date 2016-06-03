package zad4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class BtnItemsListeners implements ActionListener {

	private JScrollPane scrollPane;

	public BtnItemsListeners(JScrollPane scrollPane) {
		if (scrollPane != null) {
			this.scrollPane = scrollPane;
		} else {
			System.out.println("scrollPane is null!");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof JMenuItem) {
			JMenuItem btn = (JMenuItem) e.getSource();

			if (btn.getText().substring(0, 1).matches("\\d")) { // Font size

				scrollPane
						.getViewport()
						.getView()
						.setFont(
								new Font(null, Font.PLAIN, Integer.parseInt(btn
										.getText().substring(0, 2).trim())));
			} else {
				JPopupMenu popBtn = (JPopupMenu) btn.getParent();
				JMenu menu = (JMenu) popBtn.getInvoker();

				if (menu.getText().equals("Adresy")) {
					actionPerformedForEdit(e, btn);
				}

				if (menu.getText().equals("File")) {
					try {
						actionPerformedForFile(e, btn);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (menu.getText().equals("Background")) { // Background
					scrollPane
							.getViewport()
							.getView()
							.setBackground(
									(Color) btn.getClientProperty(btn.getText()));
				} else if (menu.getText().equals("Foreground")) { // Foreground
					scrollPane
							.getViewport()
							.getView()
							.setForeground(
									(Color) btn.getClientProperty(btn.getText()));
				}
			}

		}
	}

	String directory = ".";
	File file = null;
	boolean flag = false;
	FileWriter fileWriter;

	public void actionPerformedForFile(ActionEvent e, JMenuItem btn) throws IOException {
		JFileChooser fileChooser = new JFileChooser(directory);
		JTextArea area = (JTextArea) scrollPane.getViewport().getView();

		switch (btn.getText()) {
		case "Open":
			area.setLineWrap(false);
			int returnVal = fileChooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				flag = file.isFile();
				directory = file.getAbsolutePath();
				try {

					area.read(new FileReader(file.getAbsolutePath()), null);
					Main.getFrame().setTitle(file.getAbsolutePath());
				} catch (IOException ex) {
					System.out.println(" Error:  " + file.getAbsolutePath());
				}
			} else {
				file = fileChooser.getCurrentDirectory();
				directory = file.getPath();
				System.out.println("Nic nie bylo wybrane!");
			}

			break;
		case "Save":
			if (flag) {
				try {
					fileWriter = new FileWriter(file.getAbsolutePath());
					fileWriter.write(area.getText());
					fileWriter.close();
					System.out.println("Save as file: "
							+ file.getAbsolutePath());
				} catch (IOException e1) {
					System.out.println("Error writing!");
					e1.printStackTrace();
				}
			} else {
				returnVal = fileChooser.showSaveDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
					Main.getFrame().setTitle(file.getAbsolutePath());
					System.out.println("Save file: "
							+ file.getAbsolutePath());
					fileWriter = new FileWriter(file.getAbsolutePath());
					fileWriter.write(area.getText());
					fileWriter.close();
					flag = true;

				}

			}

			break;
		case "Save as...":
			returnVal = fileChooser.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				System.out.println("Save file: "
						+ file.getAbsolutePath());
				fileWriter = new FileWriter(file.getAbsolutePath());
				fileWriter.write(area.getText());
				fileWriter.close();
				flag = true;
				Main.getFrame().setTitle(file.getAbsolutePath());

			}
			break;
		case "Exit":
			Main.getFrame().setVisible(false);
			Main.getFrame().dispose();
			break;

		default:
			break;
		}
	}

	public void actionPerformedForEdit(ActionEvent e, JMenuItem btn) {
		JTextArea area = (JTextArea) scrollPane.getViewport().getView();
		area.insert(btn.getName(), area.getCaretPosition());
	}

}

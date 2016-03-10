/**
 *
 *  @author Loshchinin Illia S13579
 *
 */

package zad1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String fname = System.getProperty("user.home") + "/tab" + ".txt";
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fname));
			String tmp;

			Pattern p = Pattern.compile("-?\\d+");
			Pattern p2 = Pattern.compile("[^\\d\\s\\-]+?|-( |$)|\\d+-\\d+");
			Matcher m, m2;
			ArrayList<String> list = new ArrayList<String>();
			while ((tmp = reader.readLine()) != null) {
				m = p.matcher(tmp);
				m2 = p2.matcher(tmp);
				if (!m2.find()) {

					while (m.find()) {
						list.add(m.group());
					}

				} else {
					reader.close();
					throw new IOException();
				}
			}
			reader.close();

			if (!list.isEmpty()) {

				// System.out.println(list.toString());
				int max;
				int[] tablica = new int[list.size()];

				for (int i = 0; i < tablica.length; i++) {
					tablica[i] = Integer.parseInt(list.get(i));
					System.out.print(tablica[i] + " ");
				}
				System.out.println();
				// System.out.println(Arrays.toString(tablica));
				max = tablica[0];
				for (int j = 1; j < tablica.length; j++) {
					if (max < tablica[j]) {
						max = tablica[j];
					}
				}

				System.out.println(max);

				for (int i = 0; i < tablica.length; i++) {
					if (max == tablica[i])
						System.out.print(i + " ");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("***");
		} catch (IOException e) {
			System.out.println("***");
		}

	}
}

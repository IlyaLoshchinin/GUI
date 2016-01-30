import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        File file = new File("D:\\Desktop\\serverLog.txt");
        String line;
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuffer stringBuffer = new StringBuffer();

            String[][] arrayString = new String[100][3];

            while((line =  buffer.readLine()) != null){
                stringBuffer.append(line+"\n");
            }
            buffer.close();

            Pattern[] arrayPattern = { Pattern.compile("\\d{2}\\.\\d\\.\\d\\.\\d{1,3}"),Pattern.compile("\\d?\\/\\d{2}\\/\\d{4}"), Pattern.compile("(?=> )(.+)")  };
            for (int j = 0; j <arrayPattern.length ; j++) {
                Matcher m = arrayPattern[j].matcher(stringBuffer);
                for (int i = 0; i <arrayString.length ; i++) {
                    if(m.find())
                        arrayString[i][j] = new String(m.group());

            }}

            for (int i = 0; i < arrayString.length; i++) {
                   System.out.println("Data: " +arrayString[i][0] + " IP: " + arrayString[i][1] + " Text: " + arrayString[i][2].substring(2));
                }











        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();

        }
    }

}

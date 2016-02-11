import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parsing {

    public static void parseFile(String fileName) {
        int lineNum = 1;
        int whNum = 0;
        int orderNum = 0;
        List<String> whList = new ArrayList<String>();
        List<String> orderList = new ArrayList<String>();
        boolean numOrdersReceived = false;
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            String multiLines = "";

            while ((text = reader.readLine()) != null) {
                String[] textParsed = text.split(" ");
                if (lineNum == 1){
                    int rows = Integer.parseInt(textParsed[0]);
                    int columns = Integer.parseInt(textParsed[1]);
                    int numDrones = Integer.parseInt(textParsed[2]);
                    int deadline = Integer.parseInt(textParsed[3]);
                    int mzfw = Integer.parseInt(textParsed[4]);
                    System.out.println(
                            "Rows: " + rows +
                            " Col: " + columns +
                            " numDrones: " + numDrones +
                            " deadline: " + deadline +
                            " mzfw: " + mzfw);
                }
                else if (lineNum == 2){
                    int numProducts = Integer.parseInt(textParsed[0]);
                    System.out.println(
                            "numProducts: " + numProducts);
                }
                else if (lineNum == 3){
                    System.out.println("-------------");
                    System.out.println("WEIGHTS");
                    for(int i = 0; i < textParsed.length; i++){
                        //add weights in list
                        System.out.print(textParsed[i] + " ");
                    }
                    System.out.println();
                }
                else if (lineNum == 4) {
                    whNum = (Integer.parseInt(textParsed[0]));
                    whNum *= 2;
                }
                else if (whNum > 0 && (whNum % 2) == 0){
                    multiLines += text + " ";
                    whNum--;
                }
                else if( whNum > 0 && (whNum % 2) == 1){
                    multiLines += text;
                    whList.add(multiLines);
                    System.out.println(
                            "Warehouse: " + multiLines);
                    whNum--;
                    multiLines = "";
                }
                else if (!numOrdersReceived) {
                    orderNum = Integer.parseInt(textParsed[0]);
                    numOrdersReceived = true;
                    orderNum *= 3;
                }
                else if (orderNum > 0 && (orderNum % 3) == 0){
                    multiLines += text + " ";
                    orderNum--;
                }
                else if( orderNum > 0 && (orderNum % 3) == 1){
                    multiLines += text + " ";
                    orderNum--;
                }
                else if( orderNum > 0 && (orderNum % 3) == 2){
                    multiLines += text;
                    orderList.add(multiLines);
                    System.out.println(
                            "Order: " + multiLines);
                    orderNum--;
                    multiLines = "";
                }
                
                lineNum++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }

    }
    
    public static void main(String[] args){
        parseFile("D:\\Downloads\\test.in");
    }

}

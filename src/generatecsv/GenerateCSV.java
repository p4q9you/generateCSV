package generatecsv;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author U9 for java 6
 */
public class GenerateCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int fileOfNumber = 10;

        // initial value
        String csvInitValue1st = "001";
        String csvInitValue2nd = "0000000001";
        String csvInitValue3rd = "00000001";

        // content value
        String[] fixedValueList = {"001",
            "CSV", "0"};

        String[] variableValueList = {csvInitValue1st,
            csvInitValue2nd,
            csvInitValue3rd};

        for (int counter = 0; counter < fileOfNumber; counter++) {

            // filename
            String prefix = "001_";
            String contents = "00000001";
            contents = contents + counter;
            String extention = ".csv";
            String filename = prefix + contents + extention;

            // generate csv
            exportCsv(variableValueList, fixedValueList, filename);
        }
    }

    /**
     * @param variableValueList
     * @param fixedValueList
     * @param fileFullPath
     */
    public static void exportCsv(String[] variableValueList,
            String[] fixedValueList,
            String fileFullPath) {

        try {

            // 出力ファイルの作成
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileFullPath), "Shift-Jis")));

            // 内容をセットする
            for (int counter = 0; counter < fixedValueList.length; counter++) {
                printWriter.print(fixedValueList[counter]);
                printWriter.print(",");
            }

            // ファイルに書き出し閉じる
            printWriter.close();

            System.out.println("csv generated！");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}

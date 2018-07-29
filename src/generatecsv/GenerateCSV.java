package generatecsv;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

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
        int initialValue = 50;

        // variable value
        DecimalFormat digits_3 = new DecimalFormat("000");
        DecimalFormat digits_8 = new DecimalFormat("00000000");
        DecimalFormat digits_10 = new DecimalFormat("0000000000");

        // fixed value
        String[] fixedValueList = {"001", "CSV", "0"};

        for (int counter = 0; counter < fileOfNumber; counter++) {

            String[] variableValueList = {digits_3.format(initialValue),
                digits_8.format(initialValue),
                digits_10.format(initialValue)};

            // filename
            String prefix = "001_";
            String contents = digits_8.format(initialValue);
            String extention = ".csv";
            String filename = prefix + contents + extention;

            // generate csv
            exportCsv(variableValueList, fixedValueList, filename);

            initialValue++;
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
            printWriter.print(fixedValueList[0]);
            printWriter.print(",");
            printWriter.print(fixedValueList[1]);
            printWriter.print(",");
            printWriter.print(fixedValueList[2]);
            printWriter.print(",");

            printWriter.print(variableValueList[0]);
            printWriter.print(",");
            printWriter.print(variableValueList[1]);
            printWriter.print(",");
            printWriter.print(variableValueList[2]);

            // ファイルに書き出し閉じる
            printWriter.close();

            System.out.println("csv generated！");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}

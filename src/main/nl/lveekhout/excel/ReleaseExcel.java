package nl.lveekhout.excel;

import nl.lveekhout.matrix.StringMatrix;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Creates a new workbook with a sheet that's been explicitly defined.
 *
 * @author Glen Stampoultzis (glens at apache.org)
 */

public class ReleaseExcel {
    public StringMatrix stringMatrix = new StringMatrix();
    private JTextArea textArea;

    private void appendTextArea(String s) {
        if (textArea!=null) {
            textArea.append(s);
        } else {
            System.out.println(s);
        }
    }

    public ReleaseExcel(String pTeam, String pRelease, String pInvoerFile) throws IOException {
        this(pTeam, pRelease, pInvoerFile, null);
    }

    public ReleaseExcel(String pTeam, String pRelease, String pInvoerFile, JTextArea textArea) throws IOException {
        this.textArea = textArea;

        RandomAccessFile randomAccessFile = new RandomAccessFile(pInvoerFile, "rw");

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(pInvoerFile);
        } catch (FileNotFoundException e) {
            appendTextArea(e.getStackTrace().toString());
            return;
        }

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet hssfSheet = hssfWorkbook.getSheet("Sheet1");

        {
            Row row = hssfSheet.createRow(hssfSheet.getLastRowNum()+1);
            Cell cell = row.createCell(0);
            cell.setCellValue("Nieuw");
        }

        for (Row row : hssfSheet) {
            String s = "";
            if (row.getCell(0)!=null && row.getCell(0).toString().equals(pTeam)) {
                if (row.getCell(1)!=null && row.getCell(1).toString().equals(pRelease)) {
                    for (Cell cell : row ) {
                        s += " | " + cell.toString() + "(" + cell.getRowIndex() + ", " + cell.getColumnIndex() + ")";
                    }
                }
            }

            if (s.length()>0) appendTextArea("Row: " + s.substring(3) + "\n");
        }

//        FileOutputStream fileOutputStream = new FileOutputStream("workbook.xls");
//        hssfWorkbook.write(fileOutputStream);
        hssfWorkbook.close();
    }
}
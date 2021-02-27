package edu.neu.csye6200;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ooxml.*;
import org.apache.poi.xssf.usermodel.*;

public class TesterClass {
    public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("out.txt");

		for (int i = 0; i < 10; i++) {
			fw.write("something");
			fw.write("\n");
		}

		fw.close();

        

    }
}

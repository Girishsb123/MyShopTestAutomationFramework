package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {

		File xssfFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);

		// XLSX
		XSSFWorkbook xssfWorkBook = null;
		List<User> userList = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		try {
			xssfWorkBook = new XSSFWorkbook(xssfFile);
			userList = new ArrayList<User>();
			Row row;
			Cell emailAddressCell;
			Cell PasswordCell;
			User user;
			xssfSheet = xssfWorkBook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();// skipping header cloum names
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				PasswordCell = row.getCell(1);
				user = new User(emailAddressCell.toString(), PasswordCell.toString());
				userList.add(user);
				xssfWorkBook.close();
			}

		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return userList.iterator();

	}

}

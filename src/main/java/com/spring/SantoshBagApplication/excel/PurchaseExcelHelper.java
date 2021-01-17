package com.spring.SantoshBagApplication.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.spring.SantoshBagApplication.entity.Purchase;

public class PurchaseExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "id", "category", "modelNumber", "color", "size", "brandName", "quantity", "price",
			"totalPrice", "vendorName", "discount" };
	static String SHEET = "Purchase";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Purchase> excelToTutorials(InputStream is) {
		System.out.println("excelToTutorials=> reading the " + is);
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Purchase> purchaseList = new ArrayList<Purchase>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				if (!checkIfRowIsEmpty(currentRow)) {
					// skip header
					if (rowNumber == 0) {
						rowNumber++;
						continue;
					}

					Iterator<Cell> cellsInRow = currentRow.iterator();

					Purchase purchase = new Purchase();

					int cellIdx = 0;
					while (cellsInRow.hasNext()) {
						Cell currentCell = cellsInRow.next();
						if (currentCell.getCellType() != CellType.BLANK) {
							switch (cellIdx) {
							/*
							 * case 0: brand.setId((int) currentCell.getNumericCellValue()); break;
							 */

							case 0:
								purchase.setCategory(currentCell.getStringCellValue());
								break;
							case 1:
								String modelNumber = String.valueOf(currentCell.getNumericCellValue());
								purchase.setModelNumber(modelNumber);
								break;
							case 2:
								purchase.setColor(currentCell.getStringCellValue());
								break;
							case 3:
								purchase.setSize(currentCell.getStringCellValue());
								break;
							case 4:
								purchase.setBrandName(currentCell.getStringCellValue());
								break;
							case 5:
								String quantity = String.valueOf(currentCell.getNumericCellValue());
								purchase.setQuantity(quantity);
								break;
							case 6:
								String price = String.valueOf(currentCell.getNumericCellValue());
								purchase.setPrice(price);
								break;
							case 7:
								String totalPrice = String.valueOf(currentCell.getNumericCellValue());
								purchase.setTotalPrice(totalPrice);
								break;
							case 8:
								purchase.setVendorName(currentCell.getStringCellValue());
								break;
							case 9:
								String discount = String.valueOf(currentCell.getNumericCellValue());
								purchase.setDiscount(discount);
								break;

							default:
								break;
							}
						}

						cellIdx++;
					}

					purchaseList.add(purchase);

				}
			}

			workbook.close();

			return purchaseList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param row
	 * @return
	 */
	private static boolean checkIfRowIsEmpty(Row row) {
		if (row == null) {
			return true;
		}
		if (row.getLastCellNum() <= 0) {
			return true;
		}
		for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
			Cell cell = row.getCell(cellNum);
			if (cell != null && cell.getCellTypeEnum() != CellType.BLANK && !StringUtils.isEmpty(cell.toString())) {
				return false;
			}
		}
		return true;
	}
}

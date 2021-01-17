package com.spring.SantoshBagApplication.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring.SantoshBagApplication.dao.BarcodeRepository;
import com.spring.SantoshBagApplication.entity.Barcode;

@Service
public class BarcodeServiceImpl implements BarcodeService{
	
	@Autowired
	public BarcodeRepository barcodeRepository;
	
	public BarcodeServiceImpl(BarcodeRepository barcodeRepository) {
		this.barcodeRepository=barcodeRepository;
	}
	@Override
	public List<Barcode> findAll() {
		List<Barcode> barcodeList=barcodeRepository.findAll();
		if(!barcodeList.isEmpty()) {
			return barcodeList;
		}else {
			return null;
		}
	}

	@Override
	public Barcode findById(int id) {
		Optional<Barcode> barcodeResult=barcodeRepository.findById(id);
		Barcode barcode=null;
		if(barcodeResult.isPresent()) {
			barcode=barcodeResult.get();
		}else {
			throw new RuntimeException("Did not find barcode id - " + id);
		}
		return barcode;
	}

	@Override
	public void save(Barcode barcode) {
		if(barcode!=null) {
			barcodeRepository.save(barcode);
		}else {
			throw new RuntimeException("Did not barcode Object is null- " + barcode);
		}
	}

	@Override
	public void deleteByAll() {
		barcodeRepository.deleteAll();
	}
	
	@Override
	public void generateBarcodeService()
			throws FileNotFoundException, DocumentException {
		Document document = new Document(new Rectangle(PageSize.A4));
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream("D:\\DataStructure\\DataStructures\\BarCode_Pdf.pdf"));
		document.open();
		PdfPTable table = getPdfTable();
		List<Barcode> barcodeList = barcodeRepository.findAll();
		if (!barcodeList.isEmpty()) {
			for (int i = 0; i < barcodeList.size(); i++) {
				Barcode barcodeObject = barcodeList.get(i);
				String barcode = barcodeObject.getBrandName() + barcodeObject.getModelNumber()
						+ barcodeObject.getColor() + barcodeObject.getSize();
				int noOfBarcode = Integer.parseInt(barcodeObject.getNumberOfBarcode());
				// String barcode=brandName+modelNumber+color+size;
				table = createBarcode(writer, barcode, table, noOfBarcode);
			}

		}
		document.add(table);
		document.close();
	}
	
	/**
	 * 
	 * @param writer
	 * @param barcode
	 * @param table
	 */
	private PdfPTable createBarcode(PdfWriter writer, String barcode, PdfPTable table, int noOfBarcode) {
		for (int i = 0; i < noOfBarcode; i++) {
			Barcode128 code128 = new Barcode128();
			code128.setGenerateChecksum(true);
			code128.setCode(barcode);
			code128.setBarHeight(30);
			code128.setTextAlignment(Element.ALIGN_LEFT);

			PdfPCell pdfCell = getPdfCell();

			Paragraph p = new Paragraph(new Chunk("SantoshBag",
					FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
			pdfCell.addElement(p);

			Paragraph p1 = new Paragraph("");
			p1.setFont(FontFactory.getFont(null, 5, Font.BOLD, BaseColor.WHITE));
			pdfCell.addElement(p1);

			pdfCell.addElement(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
			table.addCell(pdfCell);
		}
		return table;
	}

	/**
	 * 
	 * @return
	 * @throws DocumentException
	 */
	private PdfPTable getPdfTable() throws DocumentException {
		PdfPTable table = new PdfPTable(3); // 3 columns.
		table.setWidthPercentage(100); // Width 100%
		table.setSpacingBefore(10); // Space before table
		table.setSpacingAfter(10); // Space after table
		table.setWidths(new int[] { 1000, 1000, 1000 });
		return table;
	}

	/**
	 * 
	 * @return
	 */
	private PdfPCell getPdfCell() {
		PdfPCell pdfCell = new PdfPCell();
		pdfCell.setBorderColor(BaseColor.BLACK);
		pdfCell.setPaddingLeft(10);
		pdfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		pdfCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		pdfCell.setPaddingLeft(20);
		pdfCell.setPaddingRight(20);
		pdfCell.setPaddingTop(20);
		pdfCell.setPaddingBottom(20);
		return pdfCell;
	}

}

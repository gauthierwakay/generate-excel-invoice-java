package io.nspai;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class InvoiceCreation {

    public static void main(String[] args) {
        try{
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Invoices");
            String[] columnHeadings = {"Item id ","Item Name","Qty","Item Price","Sold Date"};
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerFont.setColor(IndexedColors.BLACK.getIndex());

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columnHeadings.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnHeadings[i]);
                cell.setCellStyle(headerStyle);
            }
            sheet.createFreezePane(0,1);

            //Fill Data
            ArrayList<Invoices> invoices = createData();
            CreationHelper creationHelper = workbook.getCreationHelper();
            CellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("MM/YY/yyyy"));
            int rowNumber = 1;

            for (Invoices invoice: invoices) {
                Row row = sheet.createRow(rowNumber++);
                row.createCell(0).setCellValue(invoice.getItemId());
                row.createCell(1).setCellValue(invoice.getItemName());
                row.createCell(2).setCellValue(invoice.getItemQuantity());
                row.createCell(3).setCellValue(invoice.getTotalPrice());
                Cell dateCell = row.createCell(4);
                dateCell.setCellValue(invoice.getItemSoldDate());
                dateCell.setCellStyle(dateStyle);
            }

            for(int i =0; i<columnHeadings.length;i++){
                sheet.autoSizeColumn(i);
            }

            Sheet sheet1 = workbook.createSheet("Second Sheet");

            FileOutputStream fileOutputStream = new FileOutputStream("invoices.xlsx");
            workbook.write(fileOutputStream);
            workbook.close();


        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private static ArrayList<Invoices> createData() throws ParseException {
        ArrayList<Invoices> a = new ArrayList<>();
        a.add(new Invoices(1, "Book", 2, 10.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020")));
        a.add(new Invoices(2, "Table", 1, 50.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/02/2020")));
        a.add(new Invoices(3, "Lamp", 5, 100.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020")));
        a.add(new Invoices(4, "Pen", 100, 20.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/02/2020")));
        a.add(new Invoices(5, "Book", 2, 10.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020")));
        a.add(new Invoices(6, "Table", 1, 50.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/02/2020")));
        a.add(new Invoices(7, "Lamp", 5, 100.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020")));
        a.add(new Invoices(8, "Pen", 100, 20.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/02/2020")));
        a.add(new Invoices(9, "Book", 2, 10.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020")));
        a.add(new Invoices(10, "Table", 1, 50.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/02/2020")));
        a.add(new Invoices(11, "Lamp", 5, 100.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020")));
        a.add(new Invoices(12, "Pen", 100, 20.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/02/2020")));
        a.add(new Invoices(13, "Book", 2, 10.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020")));
        a.add(new Invoices(14, "Table", 1, 50.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/02/2020")));
        a.add(new Invoices(15, "Lamp", 5, 100.0, new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2020")));
        return a;
    }
}

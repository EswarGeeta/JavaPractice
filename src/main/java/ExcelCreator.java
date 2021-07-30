//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import jxl.Workbook;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import jxl.write.biff.RowsExceededException;
//
//public class ExcelCreator {
//
//	private static List<String> rowList = new ArrayList<String>();
//	private static final String prod = "C:\\Anantha\\Tools by Anantha\\ExcelBranding\\src\\input.txt";
//	private static final String preprod = "C:\\Anantha\\Tools by Anantha\\ExcelBranding\\src\\token.txt";
//	private static WritableSheet sheet = null;
//	private static WritableWorkbook workbook = null;
//
//	public static void main(String[] args) throws IOException {
//		try {
//			workbook = Workbook.createWorkbook(new File("ProdNewQuery2.xls"));
//			sheet = workbook.createSheet("results", 0);
//			populateData();
//
//			for (int i = 0; i < rowList.size(); i++) {
//				String[] record = rowList.get(i).split("####");
//				for (int j = 0; j < record.length; j++) {
//					addCell(i, j, record[j].trim());
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			workbook.write();
//			try {
//				if (null != workbook) {
//					workbook.close();
//				}
//			} catch (WriteException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("Done with the execution");
//	}
//
//	private static void addCell(int i, int j, String text) {
//		Label label = null;
//		label = new Label(j,i,text);
//		try {
//			sheet.addCell(label);
//		} catch (RowsExceededException e) {
//			e.printStackTrace();
//		} catch (WriteException e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	private static void populateData() throws IOException {
//		BufferedReader reader = null;
//		int lineCount = 0;
//		try {
//			File src = new File(prod);
//			reader = new BufferedReader(new FileReader(src));
//			String sCurrentLine = null;
//			StringBuffer buffer = new StringBuffer();
//			//Read one record
//			while ((sCurrentLine = reader.readLine()) != null) {
//				if (sCurrentLine.contains("~~~~~")) {
//					buffer.append(sCurrentLine.replaceFirst("~~~~~", "\n").trim());
//					rowList.add(buffer.toString());
//					buffer = new StringBuffer();
//				} else {
//					buffer.append(sCurrentLine.trim());
//				}
//			}
//			System.out.println("rowList size after loading data:" + rowList.size());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			if (reader != null) {
//				reader.close();
//			}
//		}
//		System.out.println("Number of rows is:" + lineCount);
//	}
//}

package Utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataReading {
	
	
	public  FileInputStream fi;
	public  FileOutputStream fo;
	public  XSSFWorkbook wb;
	public  XSSFSheet   ws;
	public  XSSFRow  row;
	public  XSSFCell  cell;
	String path;
	
	ExcelDataReading(String path)
	{
		 this.path=path;
	}
	
	
	public  int getrowCount(String xlsheet) throws IOException {
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		
		ws=wb.getSheet(xlsheet);
		 int rowscount=ws.getLastRowNum();
		 wb.close();
		 fi.close();
		 
		 return rowscount;
		 
		
		
		
	}
	public  int getcellCount(String xlsheet,int rownun) throws IOException {
		
		
		fi=new FileInputStream(path);
		 wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row=ws.getRow(rownun);
		 int cellcount=row.getLastCellNum();
		 wb.close();
		 fi.close();
		return cellcount;
	}
	public  String getcellData(String xlsheet,int rownun,int colnum) throws IOException
	{
		
		fi= new FileInputStream(path);
		
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row=ws.getRow(rownun);
		cell=row.getCell(colnum);

		
		
		
		
		
		String  celldata;
		try
		
		{
			//celldata=cell.toString(); //both we can use 
			DataFormatter formatter=new DataFormatter();
		celldata=formatter.formatCellValue(cell);
			
		}
		catch(Exception e)
		{
			celldata="";
		}
		wb.close();
		fi.close();
		return celldata;
		
		
	}
public  void setcelldata(String xlsheet,int rownum,int colnum,String celldata) throws IOException {
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		
		ws=wb.getSheet(xlsheet);
		cell=row.createCell(colnum);
		cell.setCellValue(celldata);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		
		
		
		 fi.close();
		 fo.close();
		 
	
		 
		
		
		
	}
	
	
	
	
}


				
				
			
			 
		
		
		

	



package tool;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;  
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bean.Student;  
  

@SuppressWarnings({ "deprecation", "deprecation", "deprecation", "deprecation" })
public class ExcelReadTool {
	public ExcelReadTool() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Student> readExcel(File file,String examNumber){  
	    List<Student> list = new ArrayList<Student>();  
	        try {    
	            InputStream inputStream = new FileInputStream(file);    
	            String fileName = file.getName();    
	            Workbook wb = null;    
	            if(fileName.endsWith("xls")){    
	            //����xls��ʽ    
	            	wb = new XSSFWorkbook(inputStream); 
	            }else if(fileName.endsWith("xlsx")){    
	            //����xlsx��ʽ    
	            	//wb = new XSSFWorkbook(inputStream); 
	            	try {
	            		wb = new HSSFWorkbook(inputStream);
					} catch (Exception e) {
						// TODO: handle exception
						wb = new HSSFWorkbook(inputStream);
					}
	            	
	            }
	            
	            //��һ��������    
	            Sheet sheet = wb.getSheetAt(0);  
	            //��һ�е��к�   
	            int firstRowIndex = sheet.getFirstRowNum();   
	            //���һ�е��к�  
	            int lastRowIndex = sheet.getLastRowNum();
	            
	            //���ҵ�ѧ�ź�������Ӧ������һ�У��Ҵ���һ�п�ʼ
	            int StuNumberIndex = 1111111111;
	            int StuNameIndex = 1111111111;
	            int rowStartIndex = 1111111111;
	            
	            for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex ++){    
	            //��ȡÿһ��    
	            Row row = sheet.getRow(rIndex);  
	            //Student student = new Student();  
	                if(row != null){   
	                //��ȡ��һ��  
	                    int firstCellIndex = row.getFirstCellNum();    
	                    int lastCellIndex = row.getLastCellNum();    
	                    for(int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex ++){    
		                    System.out.println(row.getCell(cIndex).toString()+"  "+cIndex);
		                    switch (row.getCell(cIndex).toString()) {
							case "ѧ��":
								StuNumberIndex=cIndex;
								rowStartIndex=rIndex+1;
								System.out.println("StuNumberIndex:"+StuNumberIndex);
								System.out.println("rowStartIndex:"+StuNumberIndex);
								break;
							case "����":
								StuNameIndex=cIndex;
								rowStartIndex=rIndex+1;
								System.out.println("StuNameIndex:"+StuNameIndex);
								System.out.println("rowStartIndex:"+StuNumberIndex);
								break;
							default:
								System.out.println("row:"+rIndex+"Cell:"+cIndex+"is nothing");
								break;
							}
		                    if(StuNameIndex!=1111111111&&StuNumberIndex!=1111111111&&rowStartIndex!=1111111111) {
		                    	break;
		                    }
	                    }    
	                }  
	                //list.add(student);  
	            }    
	            //���϶�StuNumberIndex,StuNameIndex,rowStartIndex��ֵ���,��ʼ��ȡָ�����к���
	            for(int rIndex = rowStartIndex; rIndex <= lastRowIndex; rIndex ++){    
		            //��ȡÿһ��    
		            Row row = sheet.getRow(rIndex);  
		            Student student = new Student();  
		                if(row != null&&row.getCell(StuNameIndex).toString()!=null&&row.getCell(StuNumberIndex).toString()!=null){   
		                //��ȡ��һ��  
		                   student.setStudentname(row.getCell(StuNameIndex).toString());
		                   student.setStudentnumber(row.getCell(StuNumberIndex).toString());
		                   student.setStatus("����");
		                   student.setIpAdress("ip");
		                   student.setStudenttag(examNumber);
		                   System.out.println("StudentName:"+row.getCell(StuNameIndex).toString()+"StudentNumber:"+row.getCell(StuNumberIndex));
		                   list.add(student);  
		                }  
		                
		            }  
	            
	        } catch (FileNotFoundException e) {    
	            e.printStackTrace();    
	        } catch (IOException e) {    
	            e.printStackTrace();    
	        }  
	        return list;    
	    }    
}


package com.google.com.DemoCart;

import java.util.ArrayList;

import xlsReader.XlsReader;

public class EmpData {
	static XlsReader reader;
	public static void main(String[] args) {
		try {
			reader = new XlsReader("C:\\Users\\user\\eclipse-workspace\\DemoCart\\OHRM_Data.xlsx");
		}catch (Exception e) {
			e.printStackTrace();
		}
		String fname = reader.getCellData("OHRM_Data", "Email".trim(), 5);
		System.out.println(fname.toString());
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void getDataFromXl() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new XlsReader("C:\\Users\\user\\eclipse-workspace\\DemoCart\\OHRM_Data.xlsx");
		}catch (Exception e) {
			e.printStackTrace();
		}
		for (int rowNum =2; rowNum <= reader.getRowCount("OHRM_Data"); rowNum++) {
			String fname = reader.getCellData("OHRM_Data", "First Name", rowNum);
			String mname = reader.getCellData("OHRM_Data", "Middle Name", rowNum);
			String lname = reader.getCellData("OHRM_Data", "Last Name", rowNum);
			String mailId = reader.getCellData("OHRM_Data", "Email", rowNum);
			String jobRole = reader.getCellData("OHRM_Data", "Job Role", rowNum);			
			String kWrd = reader.getCellData("OHRM_Data", "KeySkills", rowNum);
			String cmt = reader.getCellData("OHRM_Data", "comment", rowNum);
			String DOA = reader.getCellData("OHRM_Data", "Date of Application", rowNum);
			
					
			Object ob[] = {fname, mname, lname, mailId, jobRole, kWrd, cmt, DOA};
			myData.add(ob);
		}

	}
	

}

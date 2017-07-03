package com.sampleExcelReadingFillo;

import java.util.ArrayList;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReading {
	
	static String clsName = "com.sampleExcelReadingFillo.MethodInvoke";
	public static void main(String[] args) throws FilloException, ClassNotFoundException, IllegalAccessException, ReflectiveOperationException {
		// TODO Auto-generated method stub
		Fillo fillo=new Fillo();
		//Connection connection=fillo.getConnection("C:\\Users\\varunsivaramk\\Desktop\\TestData.xlsx");
		Connection connection1=fillo.getConnection("C:\\Users\\varunsivaramk\\Desktop\\FunctionalDriver.xlsx");
		//String strQuery="Select * from TestData";
		String strQuery = "select * from TCDriver";
		Recordset recordset=connection1.executeQuery(strQuery);
		while(recordset.next()){			
		System.out.println("Row Count : " +recordset.getCount());
		ArrayList<String> dataColl = recordset.getFieldNames();
		System.out.println("Column Count : " + dataColl.size());
		//System.out.println(dataColl.get(3));
	    for (int i = 2; i < dataColl.size(); i++) {
	    	String value  = dataColl.get(i);
	    	//System.out.println(recordset.getField(value));
	    	MethodCall.methodInvoke(clsName,recordset.getField(value));
		}
		}
		recordset.close();
		connection1.close();

	}

}

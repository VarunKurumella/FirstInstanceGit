package com.sampleExcelReadingFillo;

import java.lang.reflect.Method;

public class MethodCall {
	public static void methodInvoke(String clsName,String methodName) throws ClassNotFoundException, ReflectiveOperationException, IllegalAccessException{
		@SuppressWarnings("rawtypes")
		Class c = Class.forName(clsName);
		Object o = c.newInstance();
		try {
			//Method Invoke
			Method m = MethodInvoke.class.getMethod(methodName, null);
			m.invoke(o,null);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

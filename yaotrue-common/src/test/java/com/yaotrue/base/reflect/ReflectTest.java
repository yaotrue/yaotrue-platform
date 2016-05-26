/**
 * Copyright (c) 2012 Baozun All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Baozun.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Baozun.
 *
 * BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
package com.yaotrue.base.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年5月25日 下午1:10:22
 */
public class ReflectTest {

	private static final Logger logger = LoggerFactory.getLogger(ReflectTest.class);
	
	@Test
	public void testNewInstance(){
		Class<?> test = null;
		try {
			test = Class.forName("com.yaotrue.base.reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Person person = null;
		
		try {
			//如果该类取消了无参的构造函数时，此处会抛出java.lang.InstantiationException
			//所以编写使用Class实列化其他类的对象时，一定要有无参的构造函数
			person = (Person)test.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		person.setName("yaotrue");
		person.setAge(25);
		logger.info(person.toString());
	}
	
	@Test
	public void testNewInstance2(){
		Class<?> test = null;
		try {
			test = Class.forName("com.yaotrue.base.reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Person person1 = null;
		Person person2 = null;
		Constructor<?> cons[] = test.getConstructors();
		for (int i = 0; i < cons.length; i++) {
			Class<?> params[] = cons[i].getParameterTypes();
			int mo = cons[i].getModifiers();
			
			StringBuilder sb = new StringBuilder();
			sb.append(Modifier.toString(mo)).append(" ");
			sb.append(cons[i].getName());
			sb.append("(");
			
			for (int j = 0; j < params.length; j++) {
				sb.append(params[j].getName()+" arg"+j);
				if(j<params.length-1){ 
					sb.append(","); 
                } 
			}
			sb.append("){}");
			logger.info("constructor name:{}",sb.toString());
		}
		
		try {
			person1 = (Person)cons[2].newInstance();
			person2 = (Person)cons[1].newInstance("zhangsan");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		logger.info("person1:{}",person1.toString());
		logger.info("person2:{}",person2.toString());
	}
	
	@Test
	public void testReflect(){
		ReflectTest reflectTest = new ReflectTest();
		logger.info("this class name is:{}",reflectTest.getClass().getName());
		
		Class<?> test1 = null;
		Class<?> test2 = null;
		Class<?> test3 = null;
		
		try {
			test1 = Class.forName("com.yaotrue.base.reflect.ReflectTest");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		test2 = new ReflectTest().getClass();
		test3 = ReflectTest.class;
		logger.info("test1:{},test2:{},test3:{}",test1.getName(),test2.getName(),test3.getName());
	}
	
	@Test
	public void testGetInterfaces(){
		Class<?> test = null;
		
		try {
			test = Class.forName("com.yaotrue.base.reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		logger.info("super class is:{}",test.getSuperclass().getName());
		Class<?> inters[] = test.getInterfaces();
		for (int i = 0; i < inters.length; i++) {
			logger.info("实现的接口：{}",inters[i].getName());
		}
	}
	
	@Test
	public void testMethod(){
		Class<?> test = null;
		
		try {
			test = Class.forName("com.yaotrue.base.reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Method[] methods = test.getMethods();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			Class<?> returnType = method.getReturnType();
			Class<?> params[] = method.getParameterTypes();
			int temp = method.getModifiers();
			sb.append(Modifier.toString(temp) + " ");
			sb.append(returnType.getName() + "  ");
			sb.append(method.getName() + " ");
			sb.append("(");
			for (int j = 0; j < params.length; ++j) {
				sb.append(params[j].getName() + " " + "arg" + j);
				if (j < params.length - 1) {
					sb.append(",");
				}
			}
			Class<?> exce[] = method.getExceptionTypes();
			if (exce.length > 0) {
				sb.append(") throws ");
				for (int k = 0; k < exce.length; ++k) {
					sb.append(exce[k].getName() + " ");
					if (k < exce.length - 1) {
						sb.append(",");
					}
				}
			} else {
				sb.append(")");
			}
			logger.info("method name is:{}",sb.toString());
			sb = sb.delete(0, sb.length());
		}
		
		logger.info("----------------Fileds--------------------------");
		
		// 取得本类的全部属性
		Field[] field = test.getDeclaredFields();
		sb = sb.delete(0, sb.length());
		for (int i = 0; i < field.length; i++) {
			// 权限修饰符
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
			// 属性类型
			Class<?> type = field[i].getType();
			sb.append(priv + " " + type.getName() + " " + field[i].getName() + ";");
			logger.info("declared fields:{}",sb.toString());
			sb = sb.delete(0, sb.length());
		}
		logger.info("===============实现的接口或者父类的属性========================");
		// 取得实现的接口或者父类的属性
		Field[] filed1 = test.getFields();
		for (int j = 0; j < filed1.length; j++) {
			// 权限修饰符
			int mo = filed1[j].getModifiers();
			String priv = Modifier.toString(mo);
			// 属性类型
			Class<?> type = filed1[j].getType();
			sb.append(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
			logger.info("fields:{}",sb.toString());
			sb = sb.delete(0, sb.length());
		}
	}
	
	@Test
	public void testInvokeMethod(){
		Class<?> test = null;
		
		try {
			test = Class.forName("com.yaotrue.base.reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Person person = (Person)test.newInstance();
			Method sayHello = test.getMethod("sayHello");
			sayHello.invoke(person);
			
			Method setName = test.getMethod("setName", String.class);
			setName.invoke(person, "李四");
			
			Method getName = test.getMethod("getName");
			logger.info("person name is:{}",getName.invoke(person));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOperateFiled() throws Exception{
		Class<?> test = null;
		
		try {
			test = Class.forName("com.yaotrue.base.reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Object object = test.newInstance();
		Field name = test.getDeclaredField("name");
		//当字段为private时，需要调用此方法设置参数为true，取消Java语言访问检查
		name.setAccessible(true);
		name.set(object	, "apple");
		
		logger.info((String)name.get(object));
	}
	
	@Test
	public void testArray(){
		int[] temp = {1,2,3,4,5,6,7,8,9};
		Class<?> arrclas = temp.getClass().getComponentType();
		Object arrObj = Array.newInstance(arrclas, 15);
		
		int co=Array.getLength(temp); 
		System.arraycopy(temp, 0, arrObj, 0, co);
		
		for (int i = 0; i < Array.getLength(arrObj); i++) { 
            logger.info(Array.get(arrObj, i)+" "); 
        }
	}
	
	@Test
	public void testClassLoader() throws FileNotFoundException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		 Properties pro=new Properties(); 
	     File f=new File("E:/Me/code/git/yaotrue-platform/yaotrue-common/src/main/resources/fruit.properties"); 
	     if(f.exists()){
	    	 pro.load(new FileInputStream(f)); 
	     }
	     
	     Fruit fruit = (Fruit)Class.forName(pro.getProperty("apple")).newInstance();
	     
	     if (null != fruit) {
			fruit.eat();
		}
	}
}

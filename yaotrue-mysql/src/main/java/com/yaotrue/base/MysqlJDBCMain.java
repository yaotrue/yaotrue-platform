/*
 * Copyright 1999-2017 YaoTrue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yaotrue.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2017年3月15日 下午4:40:36
 */
public class MysqlJDBCMain {

	public static void main(String[] args) {
		try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
        }catch(ClassNotFoundException e1){
            System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
        }
        
        String url="jdbc:mysql://localhost:3306/yaotrue?user=yaotrue&password=421524&useUnicode=true&characterEncoding=UTF8";    //JDBC的URL    
        //调用DriverManager对象的getConnection()方法，获得一个Connection对象
        Connection conn;
        try {
            conn = DriverManager.getConnection(url);
            //创建一个Statement对象
            Statement stmt = conn.createStatement(); //创建Statement对象
            
            int result = stmt.executeUpdate("insert into t_la_member(user_name,password,real_name,gender) values('wangwu','123456','王五',2)");
            System.out.println(result);
            
            ResultSet resultSet = stmt.executeQuery("select * from t_la_member");
            
            System.out.println("用户名\t密码\t真实姓名\t性别");
            while (resultSet.next()) {
				System.out.println(resultSet.getString("user_name")+"\t"+
            resultSet.getString("password")+"\t"+
						resultSet.getString("real_name")+"\t"+
            resultSet.getString("gender"));
			}
            
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
	}
}

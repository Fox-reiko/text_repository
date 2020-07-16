package com.fox.day03;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class t_01_Druid {
	public static void main(String[] args) throws Exception {
		//加载配置文件
		Properties pro = new Properties();
		//加载器
		InputStream ips = t_01_Druid.class.getClassLoader().getResourceAsStream("src_jdbc_properties");
		//load
		pro.load(ips);
				
		String property = pro.getProperty("name");
		String password = pro.getProperty("password");
		System.out.println(property);
		System.out.println(password);
		
		//数据库连接池对象
		DataSource datasource = DruidDataSourceFactory.createDataSource(pro);
		//数据库连接
		System.out.println(datasource.getConnection());
		
		//获取链接
		Connection connection = datasource.getConnection();
		System.out.println("获取链接"+connection);
		
		//执行SQL对象
		Statement cresta = connection.createStatement();
		
		//声明sql
		String sql = "select * from t_user  ";
		
		//执行查询
		ResultSet rs = cresta.executeQuery(sql);
		
		//遍历结果
		while(rs.next()) {
			String name = rs.getString("name");
			String addres = rs.getString("address");
			System.out.println(name +"->"+ addres);
		}
		
		//归还链接
		connection.close();
	}

}

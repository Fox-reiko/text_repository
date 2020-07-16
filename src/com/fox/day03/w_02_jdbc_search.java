package com.fox.day03;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class w_02_jdbc_search {

	// id,name,username,password,age,news,height
	// 添加 修改 删除(id and name) 查询(id and all 所有 单个)
	public static void main(String[] args) {
//		addHero();	
//		updateHero();
//		idSearchHero();
		allSearchHero();// xxxxx
//		idDelHero();
//		nameDelHero();
	}

	// all 查询
	private static void allSearchHero() {
		JdbcTemplate jt = new JdbcTemplate(fromTeacher_JDBCUtils.getDataSource());

		List list = jt.queryForList(" select * from person ");
		System.out.println(list);	
//		for (Object object : list) {
//			w_00_person person = (w_00_person)object;
//			System.out.println(person);
//		}
	}

	// name 删除
	private static void nameDelHero() {
		JdbcTemplate jt = new JdbcTemplate(fromTeacher_JDBCUtils.getDataSource());

		int success = jt.update(" delete from person where name=? ", "达尔");
		System.out.println(success);
	}

	// id 删除
	private static void idDelHero() {
		JdbcTemplate jt = new JdbcTemplate(fromTeacher_JDBCUtils.getDataSource());

		int success = jt.update(" delete from person where id=? ", 1001);
		System.out.println(success);
	}

	// id 查询
	private static void idSearchHero() {
		JdbcTemplate jt = new JdbcTemplate(fromTeacher_JDBCUtils.getDataSource());

		w_00_person person = jt.queryForObject(" select * from person where id=? ",
				new BeanPropertyRowMapper<>(w_00_person.class), 1001);
		System.out.println(person);
	}

	// 修改
	private static void updateHero() {
		JdbcTemplate jt = new JdbcTemplate(fromTeacher_JDBCUtils.getDataSource());

		String sql = " update person set name=?,username=?,age=?,news=?,height=? where name=? ";
		int success = jt.update(sql, "达尔", "daer", 30, "是个王子", 1.84, "卡罗特");
		System.out.println(success);
	}

	// 添加
	private static void addHero() {
		JdbcTemplate jt = new JdbcTemplate(fromTeacher_JDBCUtils.getDataSource());

		String sql = " insert into person(name,username,password,age,news,height) values(?,?,?,?,?,?)";
//		int success = jt.update(sql, "卡卡罗特", "kakaluote", "123456", 20, "武道天才", 1.78);
		int success = jt.update(sql, "卡罗特", "kaluote", "123456", 40, "战斗狂人", 1.94);
		System.out.println(success);
	}
}

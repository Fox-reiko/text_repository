package com.fox.day03;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class w_01_jdbcTemplate {
	public static void main(String[] args) {

		JdbcTemplate jt = new JdbcTemplate(fromTeacher_JDBCUtils.getDataSource());

		String sql = " select * from t_user";
		List<w_00_User> list = jt.query(sql, new BeanPropertyRowMapper<w_00_User>(w_00_User.class));

		for (w_00_User user : list) {
			System.out.println(user);
		}

	}
}

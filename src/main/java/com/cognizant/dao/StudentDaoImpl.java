package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
//@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> findAll() {
		String query = "select * from student";
		return jdbcTemplate.query(query, (rs, rowNum) -> new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));

	}

	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countStudent() {
		// TODO Auto-generated method stub
		return 0;
	}

}

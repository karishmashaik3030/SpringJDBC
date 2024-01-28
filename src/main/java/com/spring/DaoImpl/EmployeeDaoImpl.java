package com.spring.DaoImpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.Dao.EmployeeDao;
import com.spring.daorowMapper.EmployeeRowMapper;
import com.spring.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}

public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
//insert
	@Override
	public int create(Employee employee) {
		// TODO Auto-generated method stub
		String query="insert into employee values(?,?,?)";
		int result=jdbcTemplate.update(query, employee.getId(),employee.getFirstName(),employee.getLastName());
		return result;
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		String query="update employee set id=?,firstname=?,lastname=?";
		int u_results=jdbcTemplate.update(query, employee.getId(),employee.getFirstName(),employee.getLastName());
		return u_results;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String query="delete from employee where id=?";
		int dele_results=jdbcTemplate.update(query, id);
		return dele_results;
	}

	@Override
	public Employee read(int id) {
		// TODO Auto-generated method stub
		String query="select * from employee where id=?";
		EmployeeRowMapper rowMapper=new EmployeeRowMapper();
		Employee employee=jdbcTemplate.queryForObject(query, rowMapper, id);
		return employee;
	}

	@Override
	public List<Employee> allEmployee() {
		// TODO Auto-generated method stub
		String query="select * from employee";
		EmployeeRowMapper rowMapper=new EmployeeRowMapper();
		List<Employee> employee=jdbcTemplate.query(query, rowMapper);
		return employee;
	}

}

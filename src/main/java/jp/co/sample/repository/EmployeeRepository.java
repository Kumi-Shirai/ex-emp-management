package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER =
			new BeanPropertyRowMapper<>(Employee.class);
	
	public List<Employee> findAll(){
		String sql = "select * from employees order by hire_date desc";
		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
		return employeeList;
	}
	
	public Employee load(Integer id) {
		String sql ="select * from employees where id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		return employee;
	}
	
	public void update(Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		String sql ="UPDATE employees SET "
				+ "name=:name,gender=:gender,hire_date=:hireDate,"
				+ "mail_address=:mailAddress,zip_code=:zipCode,address=:address,"
				+ "telephone=:telephone,salary=:salary,characteristics=:characteristics,"
				+ "dependents_count=:dependentsCount"
				+ " WHERE id=:id";
		template.update(sql, param);
	}

}

package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final org.springframework.jdbc.core.RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mail_address"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};
	
	public void insert(Administrator administrator) {
		String sql = "insert into administrators (name,mail_address,password) values(:name, :mailAddress, :password)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		template.update(sql, param);
	}
	
	public Administrator findByMailAddressAndPassword(String mailAddress,String password) {
		String sql = "select id,name,mail_address,password from administrators "
					+ "where mail_address=:mailAddress and password=:password";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("mailAddress", mailAddress).addValue("password", password);
		
		List<Administrator> administratorList = template.query(sql, param,ADMINISTRATOR_ROW_MAPPER);
		if(administratorList.size() == 0) {
			return null;
		}
		return administratorList.get(0);
	}

}

/**
 * 
 */
package com.erp.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.erp.base.CommonDao;

/**
 * @author jason_000
 *
 */
@Repository("commonDao")
public class CommonDaoImpl extends JdbcDaoSupport implements CommonDao {

	@Resource(name = "dataSource")
	public void setDatasource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public List<Map<String, Object>> queryToList(String querySql) {

		return this.getJdbcTemplate().queryForList(querySql);

	}

	@Override
	public List<Map<String, Object>> queryToList(String querySql, Object object) {
		return this.getJdbcTemplate().queryForList(querySql, object);
	}

	@Override
	public List<Map<String, Object>> queryToList(String querySql, Object[] object) {

		return this.getJdbcTemplate().queryForList(querySql, object);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int queryToint(String querySql) {
		return this.getJdbcTemplate().queryForInt(querySql);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int queryToint(String querySql, Object object) {
		return this.getJdbcTemplate().queryForInt(querySql, object);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int queryToint(String querySql, Object[] object) {
		return this.getJdbcTemplate().queryForInt(querySql, object);
	}

	@Override
	public int update(String sql) {
		return this.getJdbcTemplate().update(sql);
	}

	@Override
	public int update(String sql, Object object) {
		return this.getJdbcTemplate().update(sql, object);
	}

	@Override
	public int update(String sql, Object[] object) {
		return this.getJdbcTemplate().update(sql, object);
	}

	@Override
	public int[] batchUpdate(String sql, List<Object[]> batchArgs) {
		return this.getJdbcTemplate().batchUpdate(sql, batchArgs);
	}

	@Override
	public <T> T queryToObject(String querySql, Class<T> t) {
		return (T) this.getJdbcTemplate().queryForObject(querySql, t);
	}
	
	
}

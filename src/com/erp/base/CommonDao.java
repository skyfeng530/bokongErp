/**
 * 
 */
package com.erp.base;

import java.util.List;
import java.util.Map;

/**
 * @author jason_000
 *
 */
public interface CommonDao {

	public List<Map<String, Object>> queryToList(String querySql);

	public List<Map<String, Object>> queryToList(String querySql, Object object);

	public List<Map<String, Object>> queryToList(String querySql, Object[] object);

	public int queryToint(String querySql);

	public int queryToint(String querySql, Object object);

	public int queryToint(String querySql, Object[] object);

	public int update(String sql);

	public int update(String sql, Object object);

	public int update(String sql, Object[] object);

	public int[] batchUpdate(String sql, List<Object[]> objectList);
}

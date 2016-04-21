package data;

import java.util.List;

public interface SQLDao {
	public List<List<String>> getQueryResults(String sql);
	public List<String> getHeaders(String sql);
}

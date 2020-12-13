package com.inven.service.inter;

import java.util.List;
import java.util.Map;

public interface ProductService {
	public List<Map<String, Object>> selectAll(Map<String, Object> map);
}

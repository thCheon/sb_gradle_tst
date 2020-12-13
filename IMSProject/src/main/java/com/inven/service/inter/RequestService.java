package com.inven.service.inter;

import java.util.List;
import java.util.Map;

public interface RequestService {
	public List<Map<String, Object>> selectAll(Map<String, Object> map);
}

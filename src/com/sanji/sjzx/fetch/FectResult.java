package com.sanji.sjzx.fetch;

import java.util.HashMap;
import java.util.Map;

/**
 * 抓取结果
 * 
 * @ClassName: FectResult
 * @author WuJiming wzslw_163_com
 * @date 2014年12月20日 上午11:22:11
 */
public class FectResult {
	private String name;
	private Map<String, Map<String, String>> params = new HashMap<String, Map<String, String>>();

	public FectResult(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Map<String, String>> getParams() {
		return params;
	}

	public void setParams(String firstLeve, String secendLeve, String value) {
		Map<String, String> map = this.params.get(firstLeve);
		if (map == null) {
			map = new HashMap<String, String>();
		}
		map.put(secendLeve, value);
		this.params.put(firstLeve, map);
	}

	@Override
	public String toString() {
		return "FectResult [name=" + name + ", params=" + params + "]";
	}
	
	
}

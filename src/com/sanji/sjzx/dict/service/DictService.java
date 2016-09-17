package com.sanji.sjzx.dict.service;

import java.util.List;

import com.sanji.sjzx.model.Dict;

public interface DictService {

	/**
	 * 获取所有的字典表信息
	 * @return
	 */
	public List<Dict> gainDictList();
	/**
	 * 获取制式下拉框
	 * @Title:gainStandardList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<Dict> 返回类型
	 * @throws
	 * @return
	 */
	public List<Dict> gainStandardList();
	/**
	 * 获取适用网络类型下拉框
	 * @Title:gainNetSuitList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<Dict> 返回类型
	 * @throws
	 * @return
	 */
	public List<Dict> gainNetSuitList();

}

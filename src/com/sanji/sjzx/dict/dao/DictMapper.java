package com.sanji.sjzx.dict.dao;

import java.util.List;

import com.sanji.sjzx.model.Dict;

public interface DictMapper {
	/**
	 * 获取所有选项
	 * @Title:gainDictList
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return List<Dict> 返回类型
	 * @throws
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
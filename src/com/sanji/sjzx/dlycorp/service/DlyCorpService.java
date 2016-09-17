package com.sanji.sjzx.dlycorp.service;

import java.util.List;

import com.sanji.sjzx.model.DlyCorp;
import com.sanji.sjzx.pojo.DataGrid;

/**
 * @ClassName: DlyCorpService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author songbaozhen
 * @date 2014-9-6 下午14:44
 */
public interface DlyCorpService {
	
	/**
	 * 获取物流公司列表
	 * @Title: gainDlyCorpList
	 * @Description: TODO(获取物流公司列表)
	 * @param dlycorp
	 * @return    设定文件
	 * @return DataGrid    返回类型
	 */
	public DataGrid gainDlyCorpList(DlyCorp dlyCorp);
	/**
	 * 增加物流公司
	 * @Title: addDlyCorp
	 * @Description: TODO(增加物流公司)
	 * @param dlycorp
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void addDlyCorp(DlyCorp dlyCorp);
	/**
	 * 根据主键id单条或批量删除物流公司(逻辑删除，此处为物理删除)
	 * @Title: deleteDlyCorp
	 * @Description: TODO(根据主键id单条或批量删除物流公司(逻辑删除))
	 * @param ids
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void deleteDlyCorpById(List<String> ids);
	/**
	 * 根据主键id单条或批量删除物流公司(物理删除)
	 * @Title: dropDlyCorpById
	 * @Description: TODO(根据主键id单条或批量删除物流公司)
	 * @param ids
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void dropDlyCorpById(List<String> ids);
	/**
	 * 修改物流公司
	 * @Title: modifyDlyCorp
	 * @Description: TODO(修改物流公司)
	 * @param  dlyCorp
	 * @return    设定文件
	 * @return void    返回类型
	 */
	public void modifyDlyCorp(DlyCorp dlyCorp);
	/**
	 * 根据名称和主键验证物流公司是否存在
	 * @Title:gainIsExistName
	 * @Description: TODO(根据名称和主键验证物流公司是否存在)
	 * @param name and id
	 * @return boolean
	 */
	public boolean gainIsExistName(String name , String id);
	/**
	 * 查找物流公司最大排序号
	 * @Title:gainIsExistName
	 * @Description: TODO(查找物流公司最大排序号)
	 * @param name
	 * @return boolean
	 */
	public int getMaxOrderNum();
	/**
	 * 禁用物流公司
	 * @Title:danDlyCorpById
	 * @Description: TODO(禁用物流公司)
	 * @param ids
	 * @return void
	 */
	public void danDlyCorpById(List<String> ids);
	
	/**
	 * 启用物流公司
	 * @Title:openDlyCorpById
	 * @Description: TODO(启用物流公司)
	 * @param ids
	 * @return void
	 */
	public void openDlyCorpById(List<String> ids);
	/**
	 * 获取物流公司
	 * @Title:gainDlyCorpListAll
	 * @Description: TODO(启用物流公司)
	 * @param dlyCorp
	 * @return List<DlyCorp>
	 */
	public List<DlyCorp> gainDlyCorpListAll(DlyCorp dlyCorp);
}

package com.sanji.sjzx.dlycorp.dao;

import java.util.List;
import java.util.Map;

import com.sanji.sjzx.model.DlyCorp;


public interface DlyCorpMapper {
	/**
	 *根据主键删物流公司
	* @Title: deleteByPrimaryKey
	* @Description: TODO(根据主键删除快速公司)
	* @param @param id
	* @param @return    设定文件
	* @return int    返回类型
	* @author ZhouZhangbao
	 */
   // public int deleteByPrimaryKey(String id);
    /**
	 * 插入一条新数据
	* @Title: insert
	* @Description: TODO(插入一条新数据)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
   // public int insert(DlyCorp record);
    /**
	 * 插入一条新数据
	* @Title: insertSelective
	* @Description: TODO(插入一条新数据)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    public int insertSelective(DlyCorp record);
    /**
	 * 根据主键查询
	* @Title: insertSelective
	* @Description: TODO(插入一条新数据)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
   // public DlyCorp selectByPrimaryKey(String id);
    /**
	 * 选择性更新<br>实体中有值得的更新，为空的保持原有值
	* @Title: updateByPrimaryKeySelective
	* @Description: TODO(选择性更新<br>实体中有值得的更新，为空的保持原有值)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    public int updateByPrimaryKeySelective(DlyCorp record);
    /**
	 * 全部更新成为实体中的数据
	* @Title: updateByPrimaryKey
	* @Description: TODO(全部更新成为实体中的数据)
	* @param @param record
	* @param @return    设定文件
	* @return int    返回类型
	* @author songbaozhen
	 */
    public int updateByPrimaryKey(DlyCorp record);
    
    /**
	 * 查询物流公司列表
	* @Title: gainDlyCorpList
	* @Description: TODO(查询物流公司列表)
	* @param @param dlyCorp
	* @param @return    设定文件
	* @return List    返回类型
	* @author songbaozhen
	 */
    public List gainDlyCorpList(DlyCorp dlyCorp);

    /**
	 * 根据id删除一条或批量删除物流公司(逻辑删除，此处为物理删除)
	* @Title: deleteDlyCorpByIds
	* @Description: TODO(根据id删除一条或批量删除物流公司)
	* @param @param dlyCorp
	* @param @return    设定文件
	* @return void    返回类型
	* @author songbaozhen
	 */
    public void deleteDlyCorpByIds(List<String> ids);
    /**
	 * 根据id删除一条或批量删除物流公司(物理删除)
	* @Title: dropDlyCorpByIds
	* @Description: TODO(根据id删除一条或批量删除物流公司)
	* @param @param dlyCorp
	* @param @return    设定文件
	* @return void  返回类型
	* @author songbaozhen
	 */
    public void dropDlyCorpByIds(List<String> ids);
    /**
   	 * 查询总条数
   	* @Title: gainDlyCorpCount
   	* @Description: TODO(查询总条数)
   	* @param @param dlyCorp
   	* @param @return    设定文件
   	* @return Long    返回类型
   	* @author songbaozhen
   	 */
    public Long gainDlyCorpCount(DlyCorp dlyCorp);
    /**
   	 * 验证物流公司是否存在
   	* @Title: existDlyCorpByMap
   	* @Description: TODO(验证物流公司是否存在)
   	* @param @param map
   	* @param @return    设定文件
   	* @return Long   返回类型
   	* @author songbaozhen
   	 */
	public Long existDlyCorpByMap(Map<String, String> map);
	/**
   	 * 获取排名最后的物流公司的排序号
   	* @Title: gainLastDlyCorp
   	* @Description: TODO(获取排名最后的物流公司的排序号)
   	* @param @param name
   	* @param @return    设定文件
   	* @return int    返回类型
   	* @author songbaozhen
   	 */
	public int gainLastDlyCorp();
	
	/**
   	 * 修改物流公司
   	* @Title: gainLastDlyCorp
   	* @Description: TODO(修改物流公司)
   	* @param @param name
   	* @param @return    设定文件
   	* @return viod    返回类型
   	* @author songbaozhen
   	 */
	public void modifyDlyCorp(DlyCorp dlyCorp);
	/**
   	 * 禁用物流公司
   	* @Title: danDlyCorpById
   	* @Description: TODO(禁用物流公司)
   	* @param @param ids
   	* @param @return    设定文件
   	* @return void    返回类型
   	* @author songbaozhen
   	 */
	public void danDlyCorpById(List<String> ids);
	/**
   	 * 启用物流公司
   	* @Title: danDlyCorpById
   	* @Description: TODO(启用物流公司)
   	* @param @param ids
   	* @param @return    设定文件
   	* @return void    返回类型
   	* @author songbaozhen
   	 */
	public void openDlyCorpById(List<String> ids);
	
}
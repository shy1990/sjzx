/**  
 * @Title: TreeNode.java 
 * @Package com.gx.pojo 
 * @Description: TODO(这里用一句话描述这个方法的作用)
 * @author wangmei  
 * @date 2013-4-15 下午3:08:47
 * @version V1.0  
 */
package com.sanji.sjzx.pojo;

import java.util.List;
import java.util.Map;

public class TreeNode implements java.io.Serializable {
    private String menuid;
    private String icon;// 前面的小图标样式
    private String menuname;// 树节点名称
    private List<TreeNode> menus;// 子节点
    private String url;
    private String imType = "href";
    
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public List<TreeNode> getMenus() {
		return menus;
	}
	public void setMenus(List<TreeNode> menus) {
		this.menus = menus;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImType() {
		return imType;
	}
	public void setImType(String imType) {
		this.imType = imType;
	}

}
package com.sanji.sjzx.common.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("basePackage")// 这里是package的name
@Namespace("/")//命名空间
public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6230751116897773145L;
	protected Map<String, Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	//将对象写成json扔到前台
	public void writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
		ResourceUtil.setSession(session);
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletResponse getResopnse() {
		return response;
	}

}

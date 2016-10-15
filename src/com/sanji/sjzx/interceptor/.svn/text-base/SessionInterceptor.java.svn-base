package com.sanji.sjzx.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.pojo.SessionInfo;

/**
 * session拦截�?
* @ClassName: SessionInterceptor
* @Description: TODO(这里用一句话描述这个类的作用)
* @author ZhouZhangbao
* @date 2014-7-15 下午3:24:15
 */
public class SessionInterceptor extends MethodFilterInterceptor {

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SessionInterceptor.class);
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		SessionInfo sessionInfo = (SessionInfo) ServletActionContext.getRequest().getSession().getAttribute(ResourceUtil.getSessionInfoName());
		HttpSession hSession= ServletActionContext.getRequest().getSession();
		String actionName=actionInvocation.getInvocationContext().getName();
		
		if (sessionInfo == null) {
			if (null != hSession && "imagesAction".equals(actionName)) {
				return actionInvocation.invoke();
			} else {
				ServletActionContext.getRequest().setAttribute("msg", "您还没有登录或登录已超时，请重新登录！");
				return "noSession";
			}
			
		}
		return actionInvocation.invoke();
	}
}

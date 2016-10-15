package com.sanji.sjzx.interceptor;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.pojo.SessionInfo;

/**
 * 权限拦截�?
* @ClassName: AuthInterceptor
* @Description: TODO(这里用一句话描述这个类的作用)
* @author ZhouZhangbao
* @date 2014-7-15 下午3:12:48
 */
public class AuthInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AuthInterceptor.class);

	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		ActionContext actionContext = actionInvocation.getInvocationContext();
		SessionInfo sessionInfo = (SessionInfo) ServletActionContext.getRequest().getSession().getAttribute(ResourceUtil.getSessionInfoName());
//		if (sessionInfo.getLoginName().equals("admin")) {// admin用户不需要验证权�?
			return actionInvocation.invoke();
//		}
//		String requestPath = RequestUtil.getRequestPath(ServletActionContext.getRequest());
//		String authUrls = sessionInfo.getAuthUrls();
//		boolean b = false;
//		for (String url : authUrls.split(",")) {
//			if (requestPath.equals(url)) {
//				b = true;
//				break;
//			}
//		}
//		if (b) {
//			return actionInvocation.invoke();
//		}
//		ServletActionContext.getRequest().setAttribute("msg", "您没有访问此功能的权限！权限路径为[" + requestPath + "]请联系管理员给你赋予相应权限�?);
//		return "noAuth";
	}

}

package com.sanji.sjzx.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.sanji.sjzx.common.util.BaseAction;
import com.sanji.sjzx.common.util.ResourceUtil;
import com.sanji.sjzx.common.util.ToolsUtil;
import com.sanji.sjzx.goods.service.GoodsService;
import com.sanji.sjzx.goodssku.service.GoodsskuService;
import com.sanji.sjzx.model.Goods;
import com.sanji.sjzx.model.GoodsSku;
import com.sanji.sjzx.model.OperateLog;
import com.sanji.sjzx.operatelog.service.OperateLogService;
import com.sanji.sjzx.pojo.SessionInfo;
/**
 * @ClassName: SystemOperateLogAspect
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author SongBaoZhen
 * @date 2016-2-15 下午6:16:35
 */
@Aspect
public class SystemOperateLogAspect extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//注入Service用于把日志保存数据库
	@Resource
	private OperateLogService operateLogService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private GoodsskuService goodsskuService;
	
	private SessionInfo sInfo=null;
	
	private String beforeUpdate = "";
	private String afterUpdate = "";
	private String record = "";
	//本地异常记录
	private static final Logger logger = Logger.getLogger(SystemOperateLogAspect.class);
	
	 //Service层切点    
    @Pointcut(value = "execution(* com.sanji.sjzx.goods.service.impl.GoodsServiceImpl.gain*(..)) && @annotation(com.sanji.sjzx.annotation.SystemServiceLog)")    
     public  void serviceGainAspect() {    
    } 
    @Pointcut(value = "execution(* com.sanji.sjzx.goods.service.impl.GoodsServiceImpl.update*(..)) && @annotation(com.sanji.sjzx.annotation.SystemServiceLog)")    
    public  void serviceUpdateAspect() {    
   } 
    
    
    
    //Controller层切点    
    @Pointcut(value = "execution(* com.sanji.sjzx.goods.service.impl.GoodsServiceImpl.*(..)) && @annotation(com.sanji.sjzx.annotation.SystemControllerLog)")    
     public  void controllerAspect() {    
    }  
    
    
    
    /**  
     * 前置通知 用于拦截Controller层记录用户的操作  
     *  
     * @param joinPoint 切点  
     * @throws Throwable 
     */    
    @Before("controllerAspect() && args(id)")
     public  void doBefore(JoinPoint joinPoint, String id) throws Throwable {    
    	 System.out.println("=====前置通知开始=====");    
    	System.out.println("=====前置通知开始=====");    
        System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
        System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
        System.out.println("=====前置通知结束=====");    
        
        
    }
     @Around("serviceUpdateAspect()")
    public void doBeforeService(ProceedingJoinPoint  joinPoint) throws Throwable{
    	 sInfo = (SessionInfo) ResourceUtil.getSession().get(ResourceUtil.getSessionInfoName());
     	 Object[] param = joinPoint.getArgs();
     	 for(int i=0;i<param.length;i++){
     		 
     		 boolean bl = param[i].getClass().getName().equals("com.sanji.sjzx.model.Goods");
     		 
     		 if(!bl){
     			ArrayList<Object> l = (ArrayList<Object>)param[i];
	     		 
	     		 for (int j = 0; j < l.size(); j++) {
	     			
					GoodsSku gs = (GoodsSku) l.get(j);
					GoodsSku g = goodsskuService.gainSkuByIdAndSkuNum(gs.getId(), gs.getSkuNum());
					if(g != null){
						if(!gs.getPrice().equals(g.getPrice())){
			     			
			     			record += "商品代码"+gs.getSkuNum()+" "+"修改前价格"+g.getPrice()+ " "+"修改后价格"+gs.getPrice()+" ";
						}
					}
					
	     			
	     		 }
     		 }
     	 }
     	
     	joinPoint.proceed();
     	
     	if(record != null && !"".equals(record)){
     		OperateLog operateLog = new OperateLog();
            operateLog.setId(ToolsUtil.getUUID());
            operateLog.setName(sInfo.getUserName());
            operateLog.setAdminId(sInfo.getUserId());
            operateLog.setContent("操作描述:" + getServiceMthodDescription(joinPoint)+ " "+record);
            operateLog.setOperateDate(new Date());
            operateLogService.addOperateLog(operateLog);
            record = "";
     	}
    }
     
    
    /**  
     * 异常通知 用于拦截service层记录异常日志  
     *  
     * @param joinPoint  
     * @param e  
     */    
   /* @AfterThrowing(pointcut = "serviceUpdateAspect()", throwing = "e")    
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {}*/
    
    /**  
     * 获取注解中对方法的描述信息 用于service层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getServiceMthodDescription(JoinPoint joinPoint)    
             throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(SystemServiceLog. class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    }    
    
    /**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(SystemControllerLog. class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    }    

}

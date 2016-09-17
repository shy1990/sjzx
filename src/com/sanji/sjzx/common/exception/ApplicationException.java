/**
 * 定义应用信息的检查例�?
 * @author 周张�?
 * @version 1.0
 */
package com.sanji.sjzx.common.exception;

import org.apache.log4j.Logger;

public class ApplicationException extends Exception {
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger("");
	/**
	 * 
	 */
	public ApplicationException() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param arg0
	 */
	public ApplicationException(String mesg) {
		super(mesg);
	}
	
	/**
	 * @param arg0
	 */
	public ApplicationException(Throwable thrab) {
		super(thrab);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ApplicationException(String mesg, Throwable thrab) {
		super(mesg, thrab);
		// TODO Auto-generated constructor stub
	}

}

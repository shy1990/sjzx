package com.sanji.sjzx.fetch;


public abstract class FecthHandler {
	protected FecthHandler nextHandler;
	public FecthHandler(FecthHandler nextHandler) {
		super();
		this.setNextHandler(nextHandler);
	}
	/**
	 * 抓取
	* @Title: fecth
	* @param url
	* @return    设定文件
	* FectResult    返回类型
	* @throws
	 */
	public abstract FectResult fecth(String url);

	
	public FecthHandler getNextHandler() {
		return nextHandler;
	}

	public void setNextHandler(FecthHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
}

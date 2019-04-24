package com.curou.oa.utils.Exception;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * ajax出错接口类
 * @author keyongzhui
 * @date 2017年10月10日 上午9:56:56
 * @email 475608396@qq.com
 * @version v0.01
 * 
 */
public class AjaxException extends RuntimeException {
	private static final long serialVersionUID = -8798278124229763202L;
	private static Log log = LogFactory.getLog(AjaxException.class);
	
	private int errorCode = 0;
	
	public AjaxException(String errorString) {
		this(ErrorCode.OTHER_ERROR, errorString);
	}
	
	public AjaxException(int errorCode, String errorString) {
		super(errorString);
		this.errorCode = errorCode;
		
		log.error("ServiceException: errorCode=" + errorCode + ", errorMessage=" + errorString, this);
	}
	
	public AjaxException(String errorString, Throwable cause) {
		this(ErrorCode.OTHER_ERROR, errorString, cause);
	}
	public AjaxException(int errorCode, String errorString, Throwable cause) {
		super(errorString, cause);
		this.errorCode = errorCode;
		
		log.error("ServiceException: errorCode=" + errorCode + ", errorMessage=" + errorString, this);
	}

	public int getErrorCode() {
		return this.errorCode;
	}

	public String getErrorMessage() {
		return this.getMessage();
	}
}

package com.curou.oa.utils.Exception;

/**
 *	错误码定义
 * @author keyongzhui
 * @date 2017年10月10日 上午9:56:56
 * @email 475608396@qq.com
 * @version v0.01
 * 
 */
public final class ErrorCode {	
	
	/**成功*/
	public static final int SUCCESS= 200;
	
	/**默认失败代码*/
	public static final int OTHER_ERROR = 500;
	
	/**用户错误：session过期*/
	public static final int USER_SESSION_EXCEPTION= 401;
	
	/**请求的格式不受请求页面的支持。**/
	public static final int TYPE_EXCEPTION=415;
	
	/**如果页面无法提供请求的范围，则服务器会返回此状态代码。**/
	public static final int NOT_RANGE_EXCEPTION=416;
	
	/**服务器未满足”期望”请求标头字段的要求**/
	public static final int Failed_EXCEPTION= 417;
	
	/**网络连接超时**/
	public static final int GATEWAY_TIMEOUT_EXCEPTION=504;
}

package cn.tedu.store.service.ex;

/**
 * 用户名冲突异常,不允许注册,抛出异常
 * @author soft01
 *
 */
public class UsernameDuplicateException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3164055183124220212L;

	public UsernameDuplicateException() {
		super();
		
	}

	public UsernameDuplicateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UsernameDuplicateException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UsernameDuplicateException(String message) {
		super(message);
		
	}

	public UsernameDuplicateException(Throwable cause) {
		super(cause);
		
	}
	
	

}

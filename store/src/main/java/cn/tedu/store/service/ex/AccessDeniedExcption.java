package cn.tedu.store.service.ex;

/**
 * 非法访问异常
 * @author soft01
 *
 */
public class AccessDeniedExcption extends ServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5165102850150856587L;

	public AccessDeniedExcption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedExcption(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedExcption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedExcption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedExcption(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

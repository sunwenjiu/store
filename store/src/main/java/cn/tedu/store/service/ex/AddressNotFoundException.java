package cn.tedu.store.service.ex;

/**
 * 添加收货地址异常
 * @author soft01
 *
 */
public class AddressNotFoundException  extends ServiceException{

	public AddressNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AddressNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AddressNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

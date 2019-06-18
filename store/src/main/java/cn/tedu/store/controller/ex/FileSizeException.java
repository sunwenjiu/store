package cn.tedu.store.controller.ex;

/**
 * 上传文件的大小超出了限制
 * @author soft01
 *
 */
public class FileSizeException extends FileUploadException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5085341119910729153L;

	public FileSizeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FileSizeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileSizeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileSizeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

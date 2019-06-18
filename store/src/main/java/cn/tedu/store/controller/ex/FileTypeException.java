package cn.tedu.store.controller.ex;

/**
 * 文件类型异常,尝试上传了不支持的文件类型
 * @author soft01
 *
 */
public class FileTypeException extends FileUploadException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3445011099733074915L;

	public FileTypeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FileTypeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileTypeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileTypeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

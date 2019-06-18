package cn.tedu.boot.demo.util;

public class ResponseResult {

	private Integer state;
	private String message;



	public ResponseResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseResult(Integer state) {
		super();
		this.state = state;
	}

	public ResponseResult(Integer state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + "]";
	}


}

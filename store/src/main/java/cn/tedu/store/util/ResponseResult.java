package cn.tedu.store.util;

import java.io.Serializable;

/**
 * 控制器向客户端响应结果的数据类型
 * @author soft01
 *
 * @param <T> 如果控制器会向客户端响应某些数据,表示响应的数据的类型
 */
public class ResponseResult<T> implements Serializable{
	
	private static final long serialVersionUID = 227769174747637247L;
	
	private Integer state;
	private String message;
	private T data;
	public ResponseResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResponseResult(Integer state) {
		super();
		this.state = state;
	}
	
	public ResponseResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}

	public ResponseResult(Integer state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	public ResponseResult(Integer state, String message, T data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
	

}

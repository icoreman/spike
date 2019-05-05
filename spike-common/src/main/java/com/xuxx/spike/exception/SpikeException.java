package com.xuxx.spike.exception;

/**
 * 
 * @ClassName: SpikeException
 *
 * @author xuxx
 * @date 2019-05-05 21:04:27
 * @since  JDK 1.8
 *
 */
public class SpikeException extends Exception {
	private static final long serialVersionUID = -3211464352200132760L;

	private String key;

	public SpikeException(String message) {
		super(message);
		this.key = message;
	}

	public SpikeException() {
		super();
	}

	public SpikeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SpikeException(Throwable cause) {
		super(cause);
	}

	public String getErrorMessage() {
		return key;
	}

	public String getMessageKey() {
		return key;
	}

}

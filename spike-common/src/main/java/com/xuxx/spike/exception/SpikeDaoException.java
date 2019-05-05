package com.xuxx.spike.exception;

/**
 * 
 * @ClassName: SpikeDaoException
 *
 * @author xuxx
 * @date 2019-05-05 21:02:36
 * @since  JDK 1.8
 *
 */
public class SpikeDaoException extends SpikeException{
	private static final long serialVersionUID = 2455495142443611470L;

	public SpikeDaoException(String message) {
		super("DAO:" + message);
	}

	public SpikeDaoException() {
		super();
	}

	public SpikeDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public SpikeDaoException(Throwable cause) {
		super(cause);
	}
}

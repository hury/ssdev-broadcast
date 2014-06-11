package ctd.net.broadcast.exception;

import ctd.util.exception.CodedBaseException;

public class BroadException extends CodedBaseException {	
	private static final long serialVersionUID = 8364626071787450848L;
	public static final int CONNECT_FALIED = 501;
	public static final int CONNECT_NOT_READY = 502;

	public static final int CODEC_FAILED = 515;
	public static final int WRITE_FAILED = 516;
	public static final int READ_FAILED = 517;
	
	public BroadException() {
		super();
	}

	public BroadException(String message) {
		super(message);
	}

	public BroadException(Throwable cause) {
		super(cause);
	}

	public BroadException(int code) {
		super(code);
	}



	public BroadException(int code, String message) {
		super(code, message);
	}

	public BroadException(Throwable cause,int code) {
		super(cause,code);
	}

}

package model.exception;

import javax.swing.JOptionPane;

public class Exception extends RuntimeException{
	
    public Exception() {
        super();
    }

    public Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Exception(String message, Throwable cause) {
        super(message, cause);
        JOptionPane.showMessageDialog(null, message + "\n" + cause);
    }

    public Exception(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message);
    }

    public Exception(Throwable cause) {
        super(cause);
        JOptionPane.showMessageDialog(null, cause);
    }

}

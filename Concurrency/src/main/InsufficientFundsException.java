package main;

/**
 * Created by forando on 26.08.15.
 */
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        super();
    }

    public InsufficientFundsException(String er) {
        super(er);
    }
}

package skypro.skyshop.exception;

public class BestResultNotFoundException extends Exception {

    public BestResultNotFoundException() {
        super();
    }

    public BestResultNotFoundException(String message) {
        super(message);
    }

    public BestResultNotFoundException(String message, Throwable t) {
        super(message, t);
    }

    public BestResultNotFoundException(Throwable t) {
        super(t);
    }
}

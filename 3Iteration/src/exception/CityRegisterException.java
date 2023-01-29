package exception;

public class CityRegisterException extends Throwable{

    public CityRegisterException() {
    }

    public CityRegisterException(String message) {
        super(message);
    }

    public CityRegisterException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

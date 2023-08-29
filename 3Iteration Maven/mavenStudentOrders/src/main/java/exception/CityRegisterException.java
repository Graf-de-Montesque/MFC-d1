package exception;

public class CityRegisterException extends Exception{
    
    private String code;

    public CityRegisterException() {
    }

    public CityRegisterException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CityRegisterException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public CityRegisterException(String fake_ERROR) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCode() {
        return code;
    }
    
}

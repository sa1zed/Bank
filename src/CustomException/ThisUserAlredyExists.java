package CustomException;

public class ThisUserAlredyExists extends Exception {
    public ThisUserAlredyExists(String message) {
        super(message);
    }
}

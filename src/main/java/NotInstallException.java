public class NotInstallException extends RuntimeException {

    public NotInstallException(String game) {
        super("Game " + game + " is not installed");
    }
}
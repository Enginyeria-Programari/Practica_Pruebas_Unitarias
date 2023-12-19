package Controller.Exceptions;

public class BiometricVerificationFailedException extends Exception {
    public BiometricVerificationFailedException(String msg) {
        super(msg);
    }
}
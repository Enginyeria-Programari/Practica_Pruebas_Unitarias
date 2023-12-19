package Evoting.BiometricDataPeripheral;

import Controller.Exceptions.NotValidPassportException;
import Controller.Exceptions.PassportBiometricReadingException;
import Data.Nif;

public interface PassportBiometricReader {
    void validatePassport () throws NotValidPassportException;
    Nif getNifWithOCR ();
    BiometricData getPassportBiometricData ()
            throws PassportBiometricReadingException;
}

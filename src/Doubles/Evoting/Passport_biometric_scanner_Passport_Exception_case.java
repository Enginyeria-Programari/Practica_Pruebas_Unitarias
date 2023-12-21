package Doubles.Evoting;

import Controller.Exceptions.NotValidPassportException;
import Controller.Exceptions.PassportBiometricReadingException;
import Data.Nif;
import Evoting.BiometricDataPeripheral.BiometricData;
import Evoting.BiometricDataPeripheral.PassportBiometricReader;

public class Passport_biometric_scanner_Passport_Exception_case implements PassportBiometricReader {
    @Override
    public void validatePassport() throws NotValidPassportException {
        throw new NotValidPassportException("Passaporte no valido");
    }

    @Override
    public Nif getNifWithOCR() {
        return null;
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        return null;
    }
}

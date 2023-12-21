package Doubles.Evoting;

import Controller.Exceptions.NotValidPassportException;
import Controller.Exceptions.PassportBiometricReadingException;
import Data.Nif;
import Evoting.BiometricDataPeripheral.BiometricData;
import Evoting.BiometricDataPeripheral.PassportBiometricReader;

public class Passport_biometric_scanner_Biometric_exception_case implements PassportBiometricReader {
    @Override
    public void validatePassport() throws NotValidPassportException {

    }

    @Override
    public Nif getNifWithOCR() {
        return null;
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {
        throw new PassportBiometricReadingException("No se ha podido obtener los datos biometricos de su passaporte");
    }
}

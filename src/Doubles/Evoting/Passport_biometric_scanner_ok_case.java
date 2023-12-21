package Doubles.Evoting;

import Controller.Exceptions.NotValidPassportException;
import Controller.Exceptions.PassportBiometricReadingException;
import Data.Nif;
import Evoting.BiometricDataPeripheral.BiometricData;
import Evoting.BiometricDataPeripheral.PassportBiometricReader;
import Evoting.BiometricDataPeripheral.SingleBiometricData;

public class Passport_biometric_scanner_ok_case implements PassportBiometricReader {
    @Override
    public void validatePassport() throws NotValidPassportException {
        System.out.println("Passport ok");
    }

    @Override
    public Nif getNifWithOCR() {
        return new Nif("55555555B");
    }

    @Override
    public BiometricData getPassportBiometricData() throws PassportBiometricReadingException {


        byte[] facial_data= "Datos faciales correctos".getBytes();
        byte[] fingerprint_data= "Datos dactilares correctos".getBytes();
        SingleBiometricData Passport_face_data =new SingleBiometricData(facial_data);
        SingleBiometricData Passport_fingerprint_data = new SingleBiometricData(fingerprint_data);
        return new BiometricData(Passport_face_data,Passport_fingerprint_data);
    }
}

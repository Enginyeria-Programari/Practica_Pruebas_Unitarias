package Doubles.Evoting;

import Controller.Exceptions.HumanBiometricScanningException;
import Evoting.BiometricDataPeripheral.HumanBiometricScanner;
import Evoting.BiometricDataPeripheral.SingleBiometricData;

public class Human_biometric_Scanner_Incorrect_case implements HumanBiometricScanner {
    @Override
    public SingleBiometricData scanFaceBiometrics() throws HumanBiometricScanningException {
        byte[] facial_data= "Datos faciales incorrectos".getBytes();
        return new SingleBiometricData(facial_data);
    }

    @Override
    public SingleBiometricData scanFingerprintBiometrics() throws HumanBiometricScanningException {
        byte[] finger_print_data= "Datos dactilares incorrectos".getBytes();
        return new SingleBiometricData(finger_print_data);
    }
}

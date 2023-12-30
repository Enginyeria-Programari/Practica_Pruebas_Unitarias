package Doubles.Evoting;

import Controller.Exceptions.HumanBiometricScanningException;
import Evoting.BiometricDataPeripheral.HumanBiometricScanner;
import Evoting.BiometricDataPeripheral.SingleBiometricData;

public class Human_biometric_Scanner_Exception_case implements HumanBiometricScanner {
    @Override
    public SingleBiometricData scanFaceBiometrics() throws HumanBiometricScanningException {
        throw new HumanBiometricScanningException("No se ha podido escanear tu cara");

    }

    @Override
    public SingleBiometricData scanFingerprintBiometrics() throws HumanBiometricScanningException {
        throw new HumanBiometricScanningException("No se ha podido escanear tu huella dactilar");
    }
}

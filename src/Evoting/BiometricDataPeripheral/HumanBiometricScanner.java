package Evoting.BiometricDataPeripheral;

import Controller.Exceptions.HumanBiometricScanningException;

public interface HumanBiometricScanner {
    SingleBiometricData scanFaceBiometrics ()
            throws HumanBiometricScanningException;
    SingleBiometricData scanFingerprintBiometrics ()
            throws HumanBiometricScanningException;
}

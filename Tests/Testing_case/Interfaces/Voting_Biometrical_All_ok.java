package Testing_case.Interfaces;

import Controller.Exceptions.HumanBiometricScanningException;
import Controller.Exceptions.NotValidPassportException;
import org.junit.jupiter.api.Test;

public interface Biometrical_test {

    @Test
    void read_facial_id() throws HumanBiometricScanningException;

    @Test
    void read_finger_id_test() throws HumanBiometricScanningException;

    @Test
    void validate_Passport_test() throws NotValidPassportException;

    @Test
    void




}

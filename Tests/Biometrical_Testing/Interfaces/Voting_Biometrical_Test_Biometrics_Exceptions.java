package Biometrical_Testing.Interfaces;

import Controller.Exceptions.*;
import org.junit.jupiter.api.Test;

public interface Voting_Biometrical_Test_Biometrics_Exceptions {

    @Test
    void read_facial_id() throws HumanBiometricScanningException;
    @Test
    void read_fingerprint_id_test() throws HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException;

    @Test
    void read_Passport_test() throws NotValidPassportException, PassportBiometricReadingException;

}

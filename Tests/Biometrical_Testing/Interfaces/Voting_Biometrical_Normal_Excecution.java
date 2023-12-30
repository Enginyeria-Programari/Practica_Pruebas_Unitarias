package Biometrical_Testing.Interfaces;

import Controller.Exceptions.*;
import org.junit.jupiter.api.Test;

public interface Voting_Biometrical_Normal_Excecution {

    @Test
    void select_document();
    @Test
    void get_explicit_consent();

    @Test
    void read_facial_id() throws HumanBiometricScanningException;

    @Test
    void read_fingerprint_id_test() throws HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException;

    @Test
    void read_Passport_test() throws NotValidPassportException, PassportBiometricReadingException;

    @Test
    void verify_identity_test() throws BiometricVerificationFailedException, HumanBiometricScanningException, NotEnabledException, ConnectException, PassportBiometricReadingException, NotValidPassportException;

    @Test
    void remove_biometric_data_test();

    @Test
    void Can_vote_test() throws NotEnabledException, ConnectException;


    @Test
    void Consult_and_confirm_voting_option() throws ConnectException;






}

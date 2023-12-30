package Biometrical_Testing;

import Biometrical_Testing.Interfaces.Voting_Biometrical_Test_Biometrics_Exceptions;
import Controller.Exceptions.*;
import Data.Nif;
import Data.VotingOption;
import Doubles.Evoting.Human_biometric_Scanner_Exception_case;
import Doubles.Evoting.Passport_biometric_scanner_Biometric_exception_case;
import Doubles.Evoting.Passport_biometric_scanner_Passport_Exception_case;
import Doubles.Evoting.Passport_biometric_scanner_ok_case;
import Doubles.Services.Electoral_Organism_case_ok;
import Doubles.Services.LocalService_login_case;
import Doubles.Services.Scrutiny_ok;
import Evoting.BiometricDataPeripheral.HumanBiometricScanner;
import Evoting.BiometricDataPeripheral.PassportBiometricReader;
import Evoting.BiometricDataPeripheral.SingleBiometricData;
import Evoting.votingKiosk;
import Services.ElectoralOrganism;
import Services.LocalService;
import Services.Scrutiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Biometric_Failed_Biometric_Scanner implements Voting_Biometrical_Test_Biometrics_Exceptions {

    private ElectoralOrganism electoralOrganism;
    private HumanBiometricScanner human_scan;
    private PassportBiometricReader passport_scan;
    private PassportBiometricReader passport_scan2;
    private Scrutiny scrutiny;
    private LocalService localService;
    private Nif Voter;
    private votingKiosk Voting;
    private votingKiosk Voting2;


    private SingleBiometricData Known_Fingerprint;
    private SingleBiometricData Known_Face;
    private VotingOption vopt;

    @BeforeEach
    public void Setup() throws HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException, PassportBiometricReadingException, NotValidPassportException {
        electoralOrganism = new Electoral_Organism_case_ok();
        human_scan = new Human_biometric_Scanner_Exception_case();
        passport_scan = new Passport_biometric_scanner_Biometric_exception_case();
        passport_scan2 = new Passport_biometric_scanner_Passport_Exception_case();

        scrutiny = new Scrutiny_ok();
        localService = new LocalService_login_case();
        Voter = new Nif("55555555B");
        Voting = new votingKiosk(electoralOrganism,scrutiny,passport_scan,human_scan,localService);
        Voting2 = new votingKiosk(electoralOrganism,scrutiny,passport_scan2,human_scan,localService);
        byte[] fingerpritn_data= "Datos dactilares correctos".getBytes();
        Known_Fingerprint = new SingleBiometricData(fingerpritn_data);
        byte[] facial_data= "Datos faciales correctos".getBytes();
        Known_Face = new SingleBiometricData(facial_data);
        vopt = new VotingOption("Partido Democrata");
        Voting.setDocument('P');
        Voting.grantExplicitConsent('S');




    }
    @Test
    @Override
    public void read_facial_id() throws HumanBiometricScanningException {
        assertThrows(HumanBiometricScanningException.class,()->Voting.readFaceBiometrics());
        assertThrows(HumanBiometricScanningException.class,()->Voting2.readFaceBiometrics());
    }
    @Test
    @Override
    public void read_fingerprint_id_test() throws HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException {
        assertThrows(HumanBiometricScanningException.class,()->Voting.readFingerPrintBiometrics());
        assertThrows(HumanBiometricScanningException.class,()->Voting2.readFingerPrintBiometrics());
    }
    @Test
    @Override
    public void read_Passport_test() throws NotValidPassportException, PassportBiometricReadingException {
        assertThrows(PassportBiometricReadingException.class,()->Voting.readPassport());
        assertThrows(NotValidPassportException.class,()->Voting2.readPassport());
    }
}

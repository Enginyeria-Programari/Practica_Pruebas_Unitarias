package Biometrical_Testing;

import Biometrical_Testing.Interfaces.Voting_Biometrical_Normal_Excecution;
import Controller.Exceptions.*;
import Data.Nif;
import Data.VotingOption;
import Doubles.Evoting.Human_biometric_Scanner_ok_case;
import Doubles.Evoting.Passport_biometric_scanner_ok_case;
import Doubles.Services.ElectoralOrganism_cannot_vote;
import Doubles.Services.LocalService_login_case;
import Doubles.Services.Scrutiny_ok;
import Evoting.BiometricDataPeripheral.BiometricData;
import Evoting.BiometricDataPeripheral.HumanBiometricScanner;
import Evoting.BiometricDataPeripheral.PassportBiometricReader;
import Evoting.BiometricDataPeripheral.SingleBiometricData;
import Evoting.votingKiosk;
import Services.ElectoralOrganism;
import Services.LocalService;
import Services.Scrutiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Biometrical_cannot_vote implements Voting_Biometrical_Normal_Excecution {

    private ElectoralOrganism electoralOrganism;
    private HumanBiometricScanner human_scan;
    private PassportBiometricReader passport_scan;
    private Scrutiny scrutiny;
    private LocalService localService;
    private Nif Voter;
    private votingKiosk Voting;

    private SingleBiometricData Known_Fingerprint;
    private SingleBiometricData Known_Face;
    private VotingOption vopt;

    @BeforeEach
    public void Setup() throws HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException, PassportBiometricReadingException, NotValidPassportException {
        electoralOrganism = new ElectoralOrganism_cannot_vote();
        human_scan = new Human_biometric_Scanner_ok_case();
        passport_scan = new Passport_biometric_scanner_ok_case();
        scrutiny = new Scrutiny_ok();
        localService = new LocalService_login_case();
        Voter = new Nif("55555555B");
        Voting = new votingKiosk(electoralOrganism,scrutiny,passport_scan,human_scan,localService);
        byte[] fingerpritn_data= "Datos dactilares correctos".getBytes();
        Known_Fingerprint = new SingleBiometricData(fingerpritn_data);
        byte[] facial_data= "Datos faciales correctos".getBytes();
        Known_Face = new SingleBiometricData(facial_data);
        vopt = new VotingOption("Partido Democrata");
        Voting.setDocument('P');
        Voting.grantExplicitConsent('S');
        Voting.readPassport();
        Voting.readFaceBiometrics();
        Voting.readFingerPrintBiometrics();

    }

    @Override
    @Test
    public void select_document() {
        assertEquals('P',Voting.getSelectedDocumentType());
    }

    @Override
    @Test
    public void get_explicit_consent() {

        assertEquals('S',Voting.getExplicit_consent());

    }

    @Override
    @Test
    public void read_facial_id() throws HumanBiometricScanningException {

        assertEquals(Known_Face,Voting.getFace_scan());
    }

    @Override
    @Test
    public void read_fingerprint_id_test() throws HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException {


        assertEquals(Known_Face,Voting.getFace_scan());
        assertEquals(Known_Fingerprint,Voting.getFinger_print());
    }

    @Override
    @Test
    public void read_Passport_test() throws NotValidPassportException, PassportBiometricReadingException {

        assertEquals(Voter,Voting.getVoterNif());
        assertEquals(new BiometricData(Known_Face,Known_Fingerprint),Voting.getPassport_data());



    }

    @Override
    @Test
    public void verify_identity_test() throws BiometricVerificationFailedException, HumanBiometricScanningException, NotEnabledException, ConnectException, PassportBiometricReadingException, NotValidPassportException {
        assertTrue(Voting.isVerified_biometric_Data());

    }

    @Override
    @Test
    public void remove_biometric_data_test() {
        Voting.removeBiometricData();
        assertNull(Voting.getPassport_data());
        assertNull(Voting.getUser_data());
        assertNull(Voting.getFinger_print());
        assertNull(Voting.getFace_scan());

    }

    @Override
    @Test
    public void Can_vote_test() throws NotEnabledException, ConnectException {

        assertThrows(NotEnabledException.class,()->Voting.Can_Vote());
        assertFalse(Voting.isCan_vote());
    }

    @Override
    public void Consult_and_confirm_voting_option() throws ConnectException {

    }
}

package ManualTesting;

import Controller.Exceptions.*;
import Data.Nif;
import Data.Password;
import Data.VotingOption;
import Doubles.Evoting.Human_biometric_Scanner_ok_case;
import Doubles.Evoting.Passport_biometric_scanner_ok_case;
import Doubles.Services.*;
import Evoting.BiometricDataPeripheral.HumanBiometricScanner;
import Evoting.BiometricDataPeripheral.PassportBiometricReader;
import Evoting.votingKiosk;
import ManualTesting.Intefaces.Voting_Manual_All_Ok;
import Services.ElectoralOrganism;
import Services.LocalService;
import Services.Scrutiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Manual_cannot_vote implements Voting_Manual_All_Ok {
    private ElectoralOrganism electoralOrganism;
    private HumanBiometricScanner human_scan;
    private PassportBiometricReader passport_scan;
    private Scrutiny scrutiny;
    private LocalService localService;
    private Password password;
    private String personal_login = "12345678";
    private Nif Voter;
    private votingKiosk Voting;
    private VotingOption vopt;

    @BeforeEach
    public void Setup() throws HumanBiometricScanningException, BiometricVerificationFailedException, NotEnabledException, ConnectException, PassportBiometricReadingException, NotValidPassportException, InvalidAccountException, InvalidDNIDocumException {
        electoralOrganism = new ElectoralOrganism_cannot_vote();
        human_scan = new Human_biometric_Scanner_ok_case();
        passport_scan = new Passport_biometric_scanner_ok_case();
        scrutiny = new Scrutiny_ok();
        localService = new LocalService_login_case();
        Voter = new Nif("55555555B");
        Voting = new votingKiosk(electoralOrganism,scrutiny,passport_scan,human_scan,localService);
        vopt = new VotingOption("Partido Democrata");
        password = new Password("12345678");
        Voting.setDocument('D');
        Voting.enterAccount(personal_login, password);
        Voting.enterNif(Voter);
        Voting.confirmIdentif('S');


    }
    @Override
    @Test
    public void select_document() {
        assertEquals('D',Voting.getSelectedDocumentType());
    }

    @Override
    @Test
    public void personal_worker_login() {
        assertTrue(Voting.isPersonal_login_confirmed());
    }

    @Override
    @Test
    public void enter_Nif() {
        assertEquals(Voter, Voting.getVoterNif());
    }

    @Override
    @Test
    public void confirm_identity() {
        assertEquals('S', Voting.getConfirmedIdentity());
    }

    @Override
    @Test
    public void Can_vote_test() throws NotEnabledException, ConnectException{
        assertThrows(NotEnabledException.class,()->Voting.Can_Vote());
        assertFalse(Voting.isCan_vote());
    }

    @Test
    public void Consult_and_confirm_voting_option() throws ConnectException {
    }
}

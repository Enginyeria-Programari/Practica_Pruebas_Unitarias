package Evoting;

import Controller.Exceptions.*;
import Data.Nif;
import Data.Password;
import Data.VotingOption;
import Evoting.BiometricDataPeripheral.BiometricData;

public class votingKiosk {
    // The class members
    // The constructor/s
    // Input events
    public void initVoting () {}
    public void setDocument (char opt) {}
    public void enterAccount (String login, Password pssw)
            throws InvalidAccountException {}
    public void confirmIdentif (char conf) throws InvalidDNIDocumException
    {}
    public void enterNif (Nif nif) throws NotEnabledException, ConnectException
    {}
    public void initOptionsNavigation () {}
    public void consultVotingOption (VotingOption vopt) {}
    public void vote () {}

    public void confirmVotingOption (char conf) throws ConnectException {}
    // Internal operation, not required
    private void finalizeSession () {}
    // Setter methods for injecting dependences and additional methods

    private void verifiyBiometricData
            (BiometricData humanBioD, BiometricData passpBioD)
            throws BiometricVerificationFailedException {}
    private void removeBiometricData () {}

    public void grantExplicitConsent (char cons) {}
    public void readPassport ()
            throws NotValidPassportException, PassportBiometricReadingException
    {}
    public void readFaceBiometrics () throws HumanBiometricScanningException
    {}
    public void readFingerPrintBiometrics ()
            throws NotEnabledException, HumanBiometricScanningException,
            BiometricVerificationFailedException, ConnectException
    {}



}


package Evoting;

import Controller.Exceptions.*;
import Data.Nif;
import Data.Password;
import Data.VotingOption;
import Evoting.BiometricDataPeripheral.BiometricData;
import Services.ElectoralOrganism;
import Services.LocalService;
import Services.Scrutiny;

public class votingKiosk {

    private char selectedDocumentType;
    private Nif voterNif;
    private VotingOption selectedVotingOption;

    private final ElectoralOrganism electoralOrganism;
    private final LocalService localService;
    private final Scrutiny scrutiny;

    public votingKiosk(ElectoralOrganism electoralOrganism, LocalService localService, Scrutiny scrutiny) {
        this.electoralOrganism = electoralOrganism;
        this.localService = localService;
        this.scrutiny = scrutiny;
    }

    public void initVoting() {
        System.out.println("Bienvenido al sistema Evoting!");
        System.out.println("Porfavor escoge una opción de verificación:");
        System.out.println("1. Passaporte electronico");
        System.out.println("2. DNI");
    }
    public void setDocument(char opt){
        this.selectedDocumentType = opt;
    }
    public void enterAccount(String login, Password pssw) throws InvalidAccountException{
        localService.verifyAccount(login,pssw);
    }
    public void confirmIdentif(char conf) throws InvalidDNIDocumException
    {
        if(conf =='S'){
            System.out.println("Su identidad ha sido identificada, proceda con su voto");
        }else if(conf == 'N'){
            System.out.println("Su identidad no ha sido identificada ");
            throw new InvalidDNIDocumException("Documento Invalido");

        }else{
            System.out.println("Confirmación Invalida");
            throw new InvalidDNIDocumException("ConfirmaciónInvalida");
        }
    }
    public void enterNif(Nif nif) throws NotEnabledException, ConnectException {
        this.nif = nif;
    }
    public void initOptionsNavigation(){
        System.out.println("Inicio de la Navegación de Opciones");
        System.out.println("1. Ver Opciones de Voto");
        System.out.println("2. Ir a Información del Partido");
    }
    public void consultVotingOption(VotingOption vopt){
        System.out.println("Consultando información para la opción de voto: " + vopt.getParty());
        System.out.println("Usted tiene seleccionado esta opción de voto:" + vopt.getParty());
        this.selectedVotingOption = vopt;
    }
    public void vote() {
        scrutiny.
    }

    public void confirmVotingOption(char conf) throws ConnectException {

        if(conf == 'S'){
            System.out.println("Usted ha confirmado esta opción de voto:" + selectedVotingOption.getParty());
        }else{
            System.out.println("Usted no ha confirmado esta opción de voto, porfabor escoja opcion de voto");
        }
    }
    // Internal operation, not required
    private void finalizeSession() {}
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
    public void readFingerPrintBiometrics() throws NotEnabledException, HumanBiometricScanningException, BiometricVerificationFailedException, ConnectException
    {}



}


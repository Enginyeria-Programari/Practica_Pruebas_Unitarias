package Evoting;

import Controller.Exceptions.*;
import Data.Nif;
import Data.Password;
import Data.VotingOption;
import Evoting.BiometricDataPeripheral.BiometricData;
import Evoting.BiometricDataPeripheral.HumanBiometricScanner;
import Evoting.BiometricDataPeripheral.PassportBiometricReader;
import Evoting.BiometricDataPeripheral.SingleBiometricData;
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

    public boolean isVerified_biometric_Data() {
        return verified_biometric_Data;
    }

    private boolean verified_biometric_Data = false;
    private BiometricData Passport_data;
    private BiometricData User_data;

    public BiometricData getPassport_data() {
        return Passport_data;
    }

    public BiometricData getUser_data() {
        return User_data;
    }

    public SingleBiometricData getFinger_print() {
        return finger_print;
    }

    public SingleBiometricData getFace_scan() {
        return face_scan;
    }

    private SingleBiometricData finger_print;
    private SingleBiometricData face_scan;

    private PassportBiometricReader passportBiometricReader;
    private HumanBiometricScanner humanBiometricScanner;

    public char getSelectedDocumentType() {
        return selectedDocumentType;
    }

    public Nif getVoterNif() {
        return voterNif;
    }

    public VotingOption getSelectedVotingOption() {
        return selectedVotingOption;
    }

    public char getExplicit_consent() {
        return explicit_consent;
    }

    private char explicit_consent;




    public votingKiosk(ElectoralOrganism electoralOrganism,Scrutiny scrutiny,PassportBiometricReader passportBiometricReader,HumanBiometricScanner humanBiometricScanner,LocalService localService){

        this.scrutiny = scrutiny;
        this.humanBiometricScanner=humanBiometricScanner;
        this.passportBiometricReader = passportBiometricReader;
        this.electoralOrganism = electoralOrganism;
        this.localService = localService;

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
        this.voterNif = nif;
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
        System.out.println("Usted ha escogido esta opcion de voto:" + selectedVotingOption.getParty());
        System.out.println("Usted confirma la opción de voto?");

    }

    public void confirmVotingOption(char conf) throws ConnectException {

        if(conf == 'S'){
            System.out.println("Usted ha confirmado esta opción de voto:" + selectedVotingOption.getParty());
            scrutiny.scrutinize(selectedVotingOption);
            electoralOrganism.disableVoter(this.voterNif);
        }else{
            System.out.println("Usted no ha confirmado esta opción de voto, porfabor escoja opcion de voto");
        }
    }
    // Internal operation, not required
    private void finalizeSession(){
    }
    // Setter methods for injecting dependences and additional methods

    public void  verifyBiometricData() throws BiometricVerificationFailedException {
        BiometricData User_data = new BiometricData(face_scan,finger_print);
        verifiyBiometricData(User_data,Passport_data);
    }

    private void verifiyBiometricData(BiometricData humanBioD, BiometricData passpBioD) throws BiometricVerificationFailedException {
            if(humanBioD.equals(passpBioD)){
                System.out.println("Su identidad ha sido verificada");
                verified_biometric_Data = true;

            }else{
                verified_biometric_Data = false;
                throw new BiometricVerificationFailedException("Failed Verfication");

            }
    }

    public void removeBiometricData (){
        this.Passport_data = null;
        this.User_data=null;
        this.finger_print = null;
        this.face_scan=null;
        System.out.println("Datos biométricos del pasaporte eliminados.");
    }

    public void grantExplicitConsent (char cons) {
        if(cons == 'S'){
            System.out.println("Usted ha dado su consentimiento");

        }else{
            System.out.println("Usted no ha dado su consentimiento");
        }
        this.explicit_consent = cons;
    }
    public void readPassport () throws NotValidPassportException, PassportBiometricReadingException
    {
        BiometricData bio = passportBiometricReader.getPassportBiometricData();
        passportBiometricReader.validatePassport();
        this.Passport_data = bio;
        this.voterNif = passportBiometricReader.getNifWithOCR();


    }
    public void readFaceBiometrics() throws HumanBiometricScanningException
    {
        this.face_scan = humanBiometricScanner.scanFaceBiometrics();
    }
    public void readFingerPrintBiometrics() throws NotEnabledException, HumanBiometricScanningException, BiometricVerificationFailedException, ConnectException
    {
        this.finger_print = humanBiometricScanner.scanFingerprintBiometrics();
        this.User_data = new BiometricData(this.face_scan,this.finger_print);
        verifyBiometricData();
        electoralOrganism.canVote(this.voterNif);





    }



}


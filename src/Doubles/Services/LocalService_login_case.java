package Doubles.Services;

import Controller.Exceptions.InvalidAccountException;
import Data.Password;
import Services.LocalService;

import java.util.Objects;

public class LocalService_login_case implements LocalService {
    @Override
    public void verifyAccount(String login, Password pssw) throws InvalidAccountException {
        Password pass = new Password("1234");
        if(Objects.equals(login, "1234")&& pass.equals(pssw)){
            System.out.println("Passport ok");
        }else{
            throw new InvalidAccountException("Cuenta Incorrecta");
        }
    }
}

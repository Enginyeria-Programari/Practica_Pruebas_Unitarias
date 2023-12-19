package Services;

import Controller.Exceptions.InvalidAccountException;
import Data.Password;

public interface LocalService {

    void verifyAccount (String login, Password pssw)
            throws InvalidAccountException;

}

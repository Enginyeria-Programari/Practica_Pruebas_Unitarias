package Services;

import Controller.Exceptions.ConnectException;
import Controller.Exceptions.NotEnabledException;
import Data.Nif;

public interface ElectoralOrganism {
    void canVote(Nif nif) throws NotEnabledException, ConnectException;
    void disableVoter(Nif nif) throws ConnectException;
}

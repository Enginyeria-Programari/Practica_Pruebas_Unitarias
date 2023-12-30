package Doubles.Services;

import Controller.Exceptions.ConnectException;
import Controller.Exceptions.NotEnabledException;
import Data.Nif;
import Services.ElectoralOrganism;

public class ElectoralOrganism_cannot_vote implements ElectoralOrganism {
    @Override
    public void canVote(Nif nif) throws NotEnabledException, ConnectException {
        throw new NotEnabledException("You can't vote");
    }

    @Override
    public void disableVoter(Nif nif) throws ConnectException {

    }
}

package Doubles.Services;

import Controller.Exceptions.ConnectException;
import Controller.Exceptions.NotEnabledException;
import Data.Nif;
import Services.ElectoralOrganism;

public class Electoral_Organism_failed_connection implements ElectoralOrganism {
    @Override
    public void canVote(Nif nif) throws NotEnabledException, ConnectException {
        throw new ConnectException("Error de conexion");
    }

    @Override
    public void disableVoter(Nif nif) throws ConnectException {

    }
}

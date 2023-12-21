package Doubles.Services;

import Controller.Exceptions.ConnectException;
import Controller.Exceptions.NotEnabledException;
import Data.Nif;
import Services.ElectoralOrganism;

public class Electoral_Organism_failed_connection_disable implements ElectoralOrganism {
    @Override
    public void canVote(Nif nif) throws NotEnabledException, ConnectException {
        Nif wanted_nif = new Nif("55555555B");
        if(nif.equals(wanted_nif)){
            System.out.println("Canvote ok");
        }else{
            throw new NotEnabledException("Nif Incorrecto");
        }
    }

    @Override
    public void disableVoter(Nif nif) throws ConnectException {
        throw new ConnectException("Error de conexion");
    }
}

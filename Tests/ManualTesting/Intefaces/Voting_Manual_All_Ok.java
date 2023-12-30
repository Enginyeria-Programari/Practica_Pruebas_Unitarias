package ManualTesting.Intefaces;

import Controller.Exceptions.ConnectException;
import Controller.Exceptions.InvalidAccountException;
import Controller.Exceptions.NotEnabledException;
import org.junit.jupiter.api.Test;

public interface Voting_Manual_All_Ok {
    @Test
    void select_document();
    @Test
    void personal_worker_login()throws InvalidAccountException;
    @Test
    void enter_Nif();
    @Test
    void confirm_identity();
    @Test
    void Can_vote_test() throws NotEnabledException, ConnectException;
    @Test
    void Consult_and_confirm_voting_option() throws ConnectException;


}

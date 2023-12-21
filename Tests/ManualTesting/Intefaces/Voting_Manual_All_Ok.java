package ManualTesting.Intefaces;

import Controller.Exceptions.ConnectException;
import org.junit.jupiter.api.Test;

public interface Voting_Manual_All_Ok {
    @Test
    void select_document();
    @Test
    void personal_worker_login();
    @Test
    void enter_Nif();
    @Test
    void confirm_identity();
    @Test
    void Can_vote_test();
    @Test
    void Consult_and_confirm_voting_option() throws ConnectException;


}

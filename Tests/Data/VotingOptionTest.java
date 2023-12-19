package Data;

import Data.Interfaces.VotingOptionTestInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class VotingOptionTest implements VotingOptionTestInterface {

    VotingOption votingOption;

    @BeforeEach
    public void setUp() {
        String party = "SampleParty";
        votingOption = new VotingOption(party);
    }

    @Test
    @Override
    public void getPartyTest() {
        String expectedParty = "SampleParty";
        assertEquals(expectedParty, votingOption.getParty());
    }

    @Test
    @Override
    public void equalsSameObjectTest() {
        assertEquals(votingOption, votingOption);
    }

    @Test
    @Override
    public void equalsEqualObjectsTest() {
        VotingOption anotherOption = new VotingOption("SampleParty");
        assertEquals(votingOption, anotherOption);
    }

    @Test
    @Override
    public void equalsDifferentObjectsTest() {
        VotingOption differentOption = new VotingOption("AnotherParty");
        assertNotEquals(votingOption, differentOption);
    }

    @Test
    @Override
    public void hashCodeEqualObjectsTest() {
        VotingOption anotherOption = new VotingOption("SampleParty");
        assertEquals(votingOption.hashCode(), anotherOption.hashCode());
    }

    @Test
    @Override
    public void hashCodeDifferentObjectsTest() {
        VotingOption differentOption = new VotingOption("AnotherParty");
        assertNotEquals(votingOption.hashCode(), differentOption.hashCode());
    }

    @Test
    @Override
    public void toStringTest() {
        String expectedToString = "Vote option {party='SampleParty'}";
        assertEquals(expectedToString, votingOption.toString());
    }
}


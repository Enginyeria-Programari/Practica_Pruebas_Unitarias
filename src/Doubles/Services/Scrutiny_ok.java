package Doubles.Services;

import Data.VotingOption;
import Services.Scrutiny;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scrutiny_ok implements Scrutiny {
    private final Map<VotingOption, Integer> voteCounts;
    private int nullVotes;
    private int blankVotes;

    public Scrutiny_ok() {
        this.voteCounts = new HashMap<>();
        this.nullVotes = 0;
        this.blankVotes = 0;
    }

    @Override
    public void initVoteCount(List<VotingOption> validParties) {

    }

    @Override
    public void scrutinize(VotingOption vopt) {
        System.out.println("Scrutining ok");
    }

    @Override
    public int getVotesFor(VotingOption vopt) {
        return voteCounts.getOrDefault(vopt, 0);
    }

    @Override
    public int getTotal() {
        return voteCounts.values().stream().mapToInt(Integer::intValue).sum() + nullVotes + blankVotes;
    }

    @Override
    public int getNulls() {
        return nullVotes;
    }

    @Override
    public int getBlanks() {
        return blankVotes;
    }

    @Override
    public void getScrutinyResults() {
        System.out.println("Scrutiny Results:");
        for (Map.Entry<VotingOption, Integer> entry : voteCounts.entrySet()) {
            System.out.println(entry.getKey().getParty() + ": " + entry.getValue() + " votes");
        }
        System.out.println("Null Votes: " + nullVotes);
        System.out.println("Blank Votes: " + blankVotes);
    }
}

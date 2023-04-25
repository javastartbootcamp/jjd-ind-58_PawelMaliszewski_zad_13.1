package pl.javastart.voting;

import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {

    private final List<Vote> votes;

    public VotingResult(List<Vote> votes) {
        this.votes = votes;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        int yes = 0;
        int no = 0;
        for (Vote vote : votes) {
            if (vote.getVote() != null) {
                if (vote.getVote()) {
                    yes++;
                } else {
                    no++;
                }
            }
        }
        System.out.printf("%s%.2f%s", "Głosów za: ", getYesVotesPercentage(yes), "%\n");
        System.out.printf("%s%.2f%s", "Głosów przeciw: ", getNoVotesPercentage(no), "%\n");
        System.out.printf("%s%.2f%s", "Wstrzymało się: ", getAbstentionVotesPercentage(yes, no), "%\n");
        // metoda powinna drukować wyniki głosowania
    }

    private double getAbstentionVotesPercentage(int yes, int no) {
        return (double) (votes.size() - (yes + no)) / votes.size() * 100;
    }

    private double getNoVotesPercentage(double no) {
        return no / votes.size() * 100;
    }

    private double getYesVotesPercentage(double yes) {
        return yes / votes.size() * 100;
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */

    private String printVoteScore(Vote vote) {
        if (vote.getVote() != null) {
            if (vote.getVote()) {
                return "ZA";
            } else {
                return "PRZECIW";
            }
        }
        return "WSTRZYMAŁ SIĘ";
    }

    public void printVoteForVoter(String voterName) {
        for (Vote vote : votes) {
            if (vote.getVoter().equals(voterName)) {
                System.out.println(voterName + ": " + printVoteScore(vote));
            }
        }

    }
}

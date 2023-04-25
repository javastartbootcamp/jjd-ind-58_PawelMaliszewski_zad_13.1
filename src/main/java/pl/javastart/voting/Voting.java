package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {
    private static final String YES = "z";
    private static final String NO = "p";
    private static final String ABSTENTION = "w";

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Jan Kowalski");
        votingResult.printVoteForVoter("Zigniew Siobro");
        votingResult.printVoteForVoter("Zbyszek Stonoga");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        List<Vote> votes = new ArrayList<>();
        for (String voter : voters) {
            System.out.println("Jak głosuje " + voter + "? (z - za, p - przeciw, w - wstrzymanie się)");
            String vote = scanner.nextLine();
            if (vote.equalsIgnoreCase(YES)) {
                votes.add(new Vote(voter, true));
            } else if (vote.equalsIgnoreCase(NO)) {
                votes.add(new Vote(voter, false));
            } else if (vote.equalsIgnoreCase(ABSTENTION)) {
                votes.add(new Vote(voter, null));
            } else {
                System.err.println("Błędny wybór głos nieważny");
            }
        }
        return new VotingResult(votes);
    }
}

package ViewModel;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderboardLogic {
    private static LeaderboardLogic leaderboard;
    private static final SimpleDateFormat S = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    private List<List<String>> winners;
    private LeaderboardLogic() {
        winners = new ArrayList<>();
    }
    public static LeaderboardLogic getInstance() {
        if (leaderboard == null) {
            leaderboard = new LeaderboardLogic();
        }
        return leaderboard;
    }
    public List<List<String>> getSortedWinners() {
        Collections.sort(winners, (a, b) ->
                Integer.parseInt(b.get(1)) - Integer.parseInt(a.get(1)));
        return winners;
    }
    public List<String> addWinner(String name, String score, Timestamp ts) {
        List<String> temp = new ArrayList<>();
        temp.add(name);
        temp.add(score);
        temp.add(S.format(ts));
        winners.add(temp);
        return temp;
    }
}

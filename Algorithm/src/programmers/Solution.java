package programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        Map<String, Integer> rankByPlayer = new HashMap<>();
        Map<Integer, String> playerByRank = new HashMap<>();

        for(int i=0;i<players.length;i++){
            rankByPlayer.put(players[i],i);
            playerByRank.put(i,players[i]);
        }

        for(int i=0; i<callings.length;i++){

            // 부른 선수의 현재 등수
            int rank = rankByPlayer.get(callings[i]);

            // 앞지를 선수 찾기
            String p = playerByRank.get(rank-1);

            // 부른 선수의 등수 바꾸기
            rankByPlayer.put(callings[i], rank-1);
            playerByRank.put(rank-1, callings[i]);

            // 앞질러진 선수 등수 바꾸기
            rankByPlayer.put(p, rank);
            playerByRank.put(rank, p);

        }

        for(int i=0;i<players.length;i++){
            answer[i] = playerByRank.get(i);
        }

        return answer;
    }
}

package swea.Pro병사관리_13072;

import java.util.ArrayList;
import java.util.List;

class UserSolution
{
	static int[][] soldierInfo;
	static Soldier[] soldiers;
	static Team[] teams;
	
	public void init()
	{
		// 0은 팀, 1이 평판
//		soldierInfo = new int[100001][2];
		soldiers = new Soldier[100001];
		teams = new Team[6];
		for (int i = 1; i <= 5; i++) {
			teams[i] = new Team();
		}
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
//		soldierInfo[mID][0] = mTeam;
//		soldierInfo[mID][1] = mScore;
		
		teams[mTeam].insertSoldier(mID, mTeam, mScore);
	}
	
	public void fire(int mID)
	{
		soldiers[mID].fire();
		
//		System.out.println(teams[soldierInfo[mID][0]].head.getId());
	}

	public void updateSoldier(int mID, int mScore)
	{
		
		soldiers[mID].fire();
		int team = soldiers[mID].team;
		teams[team].insertSoldier(mID, team, mScore);
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		teams[mTeam].updateTeam(mChangeScore);
	}
	
	public int bestSoldier(int mTeam)
	{
//		System.out.println(teams[mTeam].getBestId());
		return teams[mTeam].getBestId();
	}
	
	
	static class Soldier{
		int soldierId;
		int team;
		Soldier next;
		Soldier pre;
		
		public Soldier(int id) {
			this.soldierId = id;
			this.next = null;
			this.pre = null;
		}
		
		public Soldier(int id, Soldier next) {
			this.soldierId = id;
			this.next = next;
			this.pre = null;
			
		}
		
		public Soldier(int id, Soldier next, Soldier pre) {
			this.soldierId = id;
			this.next = next;
			this.pre = pre;
			
		}
		
		public int getId() {
			return this.soldierId;
		}
		
		public void fire() {
			this.pre.next = this.next;
			this.next.pre = this.pre;
		}
		
	}
	
	static class Team{
		Score[] scores;
		
		public Team() {
			scores = new Score[6];
			for (int i = 1; i <= 5; i++) {
				scores[i] = new Score();
			}
		}
		
		public void insertSoldier(int id, int team, int score) {
			scores[score].hireSoldier(id);
			soldiers[id].team = team;
		}
		
//		public void deleteSoldier(int id, int score) {
//			scores[score].fireSoldier(id);
//		}
		
		public void updateTeam(int changeScore) {
			
			Score[] tmp = new Score[6];
			for (int i = 1; i <= 5; i++) {
				tmp[i] = new Score();
			}
			
			for (int i = 1; i <= 5; i++) {
				int score = i + changeScore;
				if(score < 1) score = 1;
				else if(score > 5) score = 5;
				if(score == 5 || score == 1) {
					tmp[score].hireSoldier(scores[i]);
				}else {
					tmp[score] = scores[i];
					
				}
			}
			scores = tmp;
		}
		
		public int getBestId() {
			int id = 0;
			for (int i = 5; i > 0; i--) {
				id = scores[i].getBestId();
				if(id != 0) break;
			}
			return id;
		}
	}
	
	static class Score{
		Soldier head;
		Soldier end;
		
		public Score() {
			this.head = new Soldier(0);
			this.end = new Soldier(-1);
			this.head.next = this.end;
			this.end.pre = this.head;
		}
		
		public void hireSoldier(int id) {
			Soldier s = new Soldier(id);
			
			s.pre = end.pre;
			end.pre.next = s;
			
			s.next = end;
			end.pre = s;
			
			soldiers[id] = s;
		}
		
		public void hireSoldier(Score score) {
			if(score.head != null) {
				end.pre.next = score.head.next;
				score.head.next.pre = end.pre;
				
				score.end.pre.next = end;
				end.pre = score.end.pre;
				
			}	
		}
		
//		public void fireSoldier(int id) {
//			
//			Soldier soldier = soldiers[id];
//			
//			
//			
////			Soldier pre = head;
////			Soldier tmp = head.next;
////			if(pre.soldierId == id) {
////				head = pre.next;
////				pre.next = null;
////			}else {
////				// 중간
////				while(tmp != null) {
////					
////					if(tmp.soldierId == id) {
////						// 다음 노드가 마지막노드 였을 경우
////						if(tmp.next == null) {
////							pre.next = null;
////							end = pre;
////						}else {
////							pre.next = tmp.next;
////							tmp.next = null;
////						}
////						break;
////					}else {
////						pre = tmp;
////						tmp = tmp.next;
////					}
////					
////				}
////			}
//			
//		}
		
		public int getBestId() {
			Soldier tmp = head;
			int id = 0;
			while(tmp != null) {
				id = Math.max(id, tmp.getId());
				tmp = tmp.next;
			}
			return id;
		}
	}
}
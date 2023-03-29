package swea.Pro병사관리_13072;

import java.util.ArrayList;
import java.util.List;

class UserSolution
{
	static int[][] soldierInfo;
	static Team[] teams;
	
	public void init()
	{
		// 0은 팀, 1이 평판
		soldierInfo = new int[100001][2];
		teams = new Team[6];
		for (int i = 1; i <= 5; i++) {
			teams[i] = new Team();
		}
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		soldierInfo[mID][0] = mTeam;
		soldierInfo[mID][1] = mScore;
		
		teams[mTeam].hireSoldier(mID);
	}
	
	public void fire(int mID)
	{
		teams[soldierInfo[mID][0]].fireSoldier(mID);
//		System.out.println(teams[soldierInfo[mID][0]].head.getId());
	}

	public void updateSoldier(int mID, int mScore)
	{
		soldierInfo[mID][1] = mScore;
		teams[soldierInfo[mID][0]].fireSoldier(mID);
		teams[soldierInfo[mID][0]].hireSoldier(mID);
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		List<Integer> ids = new ArrayList<>(); 
		Soldier tmp = teams[mTeam].head;
		while(tmp != null) {
			ids.add(tmp.getId());
			tmp = tmp.next;
		}
		
		for (Integer id : ids) {
			if(soldierInfo[id][1] + mChangeScore > 5) soldierInfo[id][1] = 5;
			else if(soldierInfo[id][1] + mChangeScore < 1) soldierInfo[id][1] = 1;
			else soldierInfo[id][1] += mChangeScore;
			teams[mTeam].fireSoldier(id);
			teams[mTeam].hireSoldier(id);
		}
	}
	
	public int bestSoldier(int mTeam)
	{
//		System.out.println(teams[mTeam].head.getId());
		return teams[mTeam].head.getId();
	}
	
	
	static class Soldier{
		int soldierId;
		Soldier next;
		
		public Soldier(int id) {
			this.soldierId = id;
			this.next = null;
		}
		
		public Soldier(int id, Soldier next) {
			this.soldierId = id;
			this.next = next;
			
		}
		
		public int getId() {
			return this.soldierId;
		}
	}
	
	static class Team{
		Soldier head;
		
		public Team() {
			head = null;
		}
		
		public void hireSoldier(int id) {
			if(head == null) {
				head = new Soldier(id);
				return;
			}else {
				// 평판이 큰 순서 대로 넣기
				if(soldierInfo[id][1] > soldierInfo[head.soldierId][1]) {
					Soldier s = new Soldier(id, head);
					head = s;
					return;
				}else if(soldierInfo[id][1] == soldierInfo[head.soldierId][1]){
					// 평판이 같다면 id 순서대로
					if(id > head.soldierId) {
						Soldier s = new Soldier(id, head);
						head = s;
						return;
					}else {
						if(head.next == null) {
							Soldier s = new Soldier(id);
							head.next = s;
							return;
						}else {
							Soldier pre = head;
							Soldier tmp = head.next;
							while(tmp != null) {
								
								if(soldierInfo[id][1] > soldierInfo[tmp.soldierId][1]) {
									Soldier s = new Soldier(id, tmp);
									pre.next = s;
									return;
								}else if(soldierInfo[id][1] == soldierInfo[tmp.soldierId][1]){ // 
									if(id > tmp.soldierId) {
										Soldier s = new Soldier(id, tmp);
										pre.next = s;
										return;
									}
								}
								pre = tmp;
								tmp = tmp.next;
							}
							Soldier s = new Soldier(id);
							pre.next = s;
						}
					}
				}else { // 작을 때
					Soldier pre = head;
					Soldier tmp = head.next;
					while(tmp != null) {
						
						if(soldierInfo[id][1] > soldierInfo[tmp.soldierId][1]) {
							Soldier s = new Soldier(id, tmp);
							pre.next = s;
							return;
						}else if(soldierInfo[id][1] == soldierInfo[tmp.soldierId][1]) { // soldierInfo[id][1] == soldierInfo[tmp.soldierId][1]
							if(id > tmp.soldierId) {
								Soldier s = new Soldier(id, tmp);
								pre.next = s;
								return;
							}
						}
						pre = tmp;
						tmp = tmp.next;
					}
					Soldier s = new Soldier(id);
					pre.next = s;
				}
				
			}
		}
		
		public void fireSoldier(int id) {
			Soldier pre = head;
			Soldier tmp = head.next;
			if(pre.soldierId == id) {
				head = pre.next;
				pre.next = null;
			}else {
				// 중간
				while(tmp != null) {
					
					if(tmp.soldierId == id) {
						// 다음 노드가 마지막노드 였을 경우
						if(tmp.next == null) {
							pre.next = null;
						}else {
							pre.next = tmp.next;
							tmp.next = null;
						}
						break;
					}else {
						pre = tmp;
						tmp = tmp.next;
					}
					
				}
			}
		}
	}
}
package softeer.garagegame_2차;

import java.util.*;
import java.io.*;

public class Main
{
    static int N, minX, minY, maxX, maxY, ans, cnt;
    static int[][] map;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[3*N][N];
        
        ans = 0;
        
        StringTokenizer st;
        
        for(int i=0; i<N*3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        game(0,0);
        
        System.out.println(ans);

    }
    
    static void game(int sum, int depth) {
    	int[][] copyMap = new int[3*N][N];
        boolean[][] visit = new boolean[N][N];
    	for (int i = 0; i < 3*N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
    	
    	for (int i = 2*N; i < 3*N; i++) {
			for (int j = 0; j < N; j++) {
				int car = copyMap[i][j];
				if(car == 0 || visit[i-2*N][j]) continue;
//				System.out.println("depth : " + depth + " car: " + car);
				for (int a = 0; a < 3*N; a++) {
					for (int b = 0; b < N; b++) {
						map[a][b] = copyMap[a][b];
					}
				}
				
				// min이 기준
				minX = j;
				maxX = j+1;
				minY = i;
				maxY = i+1;
				
				Queue<Node> q = new ArrayDeque<>();
				
				q.add(new Node(i,j));
				visit[i-2*N][j] = true;
				map[i][j] = 0;
				cnt = 1;
				
				while(!q.isEmpty()) {
					Node n = q.poll();
					if(maxX <= n.x) maxX = n.x+1;
					if(maxY <= n.y) maxY = n.y+1;
					if(minX > n.x) minX = n.x;
					if(minY > n.y) minY = n.y;
					
					for (int d = 0; d < 4; d++) {
						int ny = n.y + dy[d];
						int nx = n.x + dx[d];
						
						if(ny < N*2 || nx < 0 || ny >= N*3 || nx >= N || visit[ny-2*N][nx]) continue;
						if(map[ny][nx] == car) {
							map[ny][nx] = 0;
							visit[ny-2*N][nx] = true;
							q.add(new Node(ny,nx));
							cnt++;
						}
					}
					
				}
				int sumSqul = (maxX-minX) * (maxY-minY);
				if(depth != 2 ) {
					gravity(minX, minY, maxX, maxY);
					game(sum + sumSqul + cnt, depth + 1);
				}else {
					ans = Math.max(ans, sum + cnt + sumSqul);
//					System.out.println("car : " + car + " ans : " + ans);
				}
				
				
			}
		}
    }
    
    static void gravity(int minX, int minY, int maxX, int maxY) {
    	
    	for(int i=minX;i<maxX;i++){
            for(int j=maxY-1;j>=minY;j--){
                if(map[j][i]!=0) continue;
                int jump=0;
                //jump칸씩 내림
                for(int l=j-1;l>=0;l--){
                    if(map[l][i] > 0){
                        jump=j-l;
                        break;
                    }
                }
                if(jump > 0){
                    for(int l=j;l>=jump;l--){
                        map[l][i]=map[l-jump][i];
                        map[l-jump][i]=0;
                    }
                }
            }
        }
    	
    	for (int i = 0; i < N; i++) {
			int n1 = 3*N - 1; // 값이 없는 곳 찾기
    		while(map[n1][i] != 0) {
    			if(n1 == 0) break;
    			n1--;
    		}
    		if(n1 == 0) continue;
    		int n2 = n1; // 값이 있는 곳 까지
    		while(map[n2][i] == 0) {
    			if(n2 == 0) break;
    			n2--;
    		}
    		if(n2 == 0) continue;
    		int diff = n1-n2;
    		for (int j = n2; j >= 0 ; j--) {
    			if(map[j][i] == 0) break;
				map[j+diff][i] = map[j][i];
				map[j][i] = 0;
			}
    		
		}
    }
    
    static class Node{
    	int y,x;
    	
    	public Node(int y, int x) {
    		this.y = y;
    		this.x = x;
    	}
    }
}
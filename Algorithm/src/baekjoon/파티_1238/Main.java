package baekjoon.파티_1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드 와샬
public class Main {
   
   static int N, M, X;
   static final int INF = 99999999;
   
   static int[] dist;
   static int[][] map;
   
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      X = Integer.parseInt(st.nextToken());
      
      dist = new int[N];
      map = new int[N][N];
      
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            if(i==j) map[i][j] = 0;
            else map[i][j] = INF;
         }
      }
      
      for (int i = 0; i < M; i++) {
         st = new StringTokenizer(br.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         int c = Integer.parseInt(st.nextToken());
         map[a-1][b-1] = c;
      }
      
      for (int k = 0; k < N; k++) {
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               if(map[i][k] + map[k][j] < map[i][j]) {
                  map[i][j] = map[i][k] + map[k][j]; 
               }
            }
         }
      }
      
      int maxDist = 0;
      for (int i = 0; i < N; i++) {
         dist[i] = map[i][X-1] + map[X-1][i];
         if(dist[i] > maxDist) {
            maxDist = dist[i];
         }
      }
      
      System.out.println(maxDist);
      
   }
}
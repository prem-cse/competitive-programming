package contest.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Blackrock_E {

  static BufferedReader br;
  static PrintWriter out;
  static StringTokenizer st;

  static int N;
  static ArrayList<ArrayList<Integer>> adj;
  static int[] rating, min;
  static boolean[] vis;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(new OutputStreamWriter(System.out));
    //br = new BufferedReader(new FileReader("in.txt"));
    //out = new PrintWriter(new FileWriter("out.txt"));

    N = readInt();

    adj = new ArrayList<ArrayList<Integer>>(N);
    rating = new int[N];
    min = new int[N];
    vis = new boolean[N];

    for (int i = 0; i < N; i++) {
      rating[i] = readInt();
      adj.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < N; i++)
      min[i] = readInt();

    for (int i = 0; i < N; i++) {
      for (int j = i - 10; j <= i + 10; j++) {
        if (0 <= j && j < N) {
          if (rating[i] < rating[j]) {
            adj.get(j).add(i);
          }
        }
      }
    }

    for (int i = 0; i < N; i++)
      if (!vis[i])
        dfs(i);

    long ans = 0;
    for (int i = 0; i < N; i++)
      ans += min[i];

    out.println(ans);
    out.close();
  }

  static void dfs(int u) {
    vis[u] = true;
    for (int v : adj.get(u)) {
      if (!vis[v])
        dfs(v);
      min[u] = Math.max(min[u], min[v] + 1);
    }
  }

  static String next() throws IOException {
    while (st == null || !st.hasMoreTokens())
      st = new StringTokenizer(br.readLine().trim());
    return st.nextToken();
  }

  static long readLong() throws IOException {
    return Long.parseLong(next());
  }

  static int readInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double readDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static char readCharacter() throws IOException {
    return next().charAt(0);
  }

  static String readLine() throws IOException {
    return br.readLine().trim();
  }
}

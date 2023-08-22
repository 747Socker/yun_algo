package �������ְ�޺ؾ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("./src/�������ְ�޺ؾ/input.txt"));
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {
			// �Է�
			int N = sc.nextInt(); // �ڰ��� ���� ��� ��
			int M = sc.nextInt(); // �ؾ�� ����� �ð�(��)
			int K = sc.nextInt(); // M�� ���� ����� �ؾ ����
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			for(int i = 0; i < N; i++) {
				queue.add(sc.nextInt());
			}
			// ���
			int p = queue.size();
			for(int i = 0; i < p; i++) {
				int ppl = queue.peek();
				int b = ppl/M * K - i;
				if(b < 1) break;
				queue.poll();
			}
			// ���
			if(queue.size() > 0) {
				System.out.printf("#%d Impossible\n", test);
			}else {
				System.out.printf("#%d Possible\n", test);
			}
		}
		sc.close();
	}
}

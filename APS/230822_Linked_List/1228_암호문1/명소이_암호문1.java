package ��ȣ��1;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test = 1; test <= 10; test++) {
			// �Է�
			int N = sc.nextInt(); // ���� ��ȣ���� ����
			LinkedList<Integer> cipher = new LinkedList<>();// ���� ��ȣ��
			for(int i = 0; i < N; i++) {
				cipher.add(sc.nextInt());
			}
			int M = sc.nextInt();// ��ɾ��� ����
			for(int i = 0; i < M; i++) {
				sc.next(); // '|'
				int x = sc.nextInt(); // ��ġ
				int y = sc.nextInt(); // ���� ����
				for(int j = 0; j < y; j++) {
					int s = sc.nextInt(); // ����
					cipher.add(x++, s);
				}
			}
			// ���
			System.out.printf("#%d ", test);
			for(int i = 0; i < 10; i++) {
				System.out.printf("%d ", cipher.get(i));
			}
			System.out.println();
		}
		sc.close();
	}
}
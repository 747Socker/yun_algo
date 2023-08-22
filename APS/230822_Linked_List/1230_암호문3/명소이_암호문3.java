package ��ȣ��3;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("./src/��ȣ��3/input.txt"));
		for(int test = 1; test <= 10; test++) {
			// �Է�
			int N = sc.nextInt(); // ���� ��ȣ�� ����
			LinkedList<Integer> cipher = new LinkedList<>(); // ���� ��ȣ��
			for(int i = 0; i < N; i++) {
				cipher.add(sc.nextInt());
			}
			int M = sc.nextInt(); // ��ɾ� ����
			// ��ȣ ����
			for(int i = 0; i < M; i++) {
				String command = sc.next();
				switch(command) {
					case "I": // ����
					{
						int x = sc.nextInt(); // ���� ��ġ
						int y = sc.nextInt(); // ���� ����
						for(int j = 0; j < y; j++) {
							int s = sc.nextInt();
							cipher.add(x++, s);
						}
						break;
					}
					case "D": // ����
					{
						int x = sc.nextInt(); // ���� ��ġ
						int y = sc.nextInt(); // ���� ����
						for(int j = 0; j < y; j++) {
							cipher.remove(x);
						}
						break;
					}
					case "A": // �߰�
					{
						int y = sc.nextInt(); // �߰� ����
						for(int j = 0; j < y; j++) {
							int s = sc.nextInt();
							cipher.add(s);
						}
						break;
					}
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

package ����1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(new File("./src/����1/input.txt"));
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 0);
		for(int test = 1; test <= 10; test++) {
			// �Է�
			int len = scanner.nextInt(); // ����
			char[] expression = scanner.next().toCharArray(); // �����
			// ���� ǥ�������� ����
			ArrayList<Character> postfix = new ArrayList<>(); // ���� ǥ����
			Stack<Character> operator = new Stack<>(); // ������
			for(int i = 0; i < len; i++) {
				if(expression[i] >= '0' && expression[i] <= '9') { // �ǿ������� ���
					postfix.add(expression[i]);
				}else if(operator.empty()) {
					operator.add(expression[i]);
				}else if(priority.get(expression[i]) >= priority.get(operator.peek())) {
					operator.add(expression[i]);
				}else {
					postfix.add(operator.pop());
				}
			}
			while(!operator.empty()) {
				postfix.add(operator.pop());
			}
			// ����ϱ�
			Stack<Integer> nums = new Stack<>(); // �ǿ�����
			for(int i = 0; i < len; i++) {
				if(Character.isDigit(postfix.get(i))) {
					nums.add(postfix.get(i)-'0');
				}else {
					if(postfix.get(i)=='+') {
						int B = nums.pop();
						int A = nums.pop();
						nums.add(A+B);
					}
				}
			}
			// ���
			System.out.printf("#%d %d\n", test, nums.pop());
		}
		scanner.close();
	}
}

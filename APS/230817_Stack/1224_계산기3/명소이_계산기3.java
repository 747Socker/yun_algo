package ����3;

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
		Scanner scanner = new Scanner(new File("./src/����3/input.txt"));
		Map<Character, Integer> priorityOut = new HashMap<>(); // �켱����
		priorityOut.put('(', 0);
		priorityOut.put('+', 1);
		priorityOut.put('*', 2);
		Map<Character, Integer> priorityIn = new HashMap<>(); // �켱����
		priorityIn.put('(', 3);
		priorityIn.put('+', 1);
		priorityIn.put('*', 2);
		for(int test = 1; test <= 10; test++) {
			// �Է�
			int len = scanner.nextInt(); // ���� ����
			char[] expression = scanner.next().toCharArray(); // ��
			// ���� �����ڷ� ����
			ArrayList<Character> postfix = new ArrayList<>(); // ���� ǥ����
			Stack<Character> operator = new Stack<>(); // ������
			for(int i = 0; i < len; i++) {
				if(Character.isDigit(expression[i])) {
					postfix.add(expression[i]);
				}else if(operator.isEmpty()) {
					operator.add(expression[i]);
				}else if(expression[i] == ')'){
					while(operator.peek() != '(') {
						postfix.add(operator.pop());
					}
					operator.pop();
				}else if(priorityIn.get(expression[i]) >= priorityOut.get(operator.peek())) {
					operator.add(expression[i]);
				}else if(priorityIn.get(expression[i]) < priorityOut.get(operator.peek())) {
					while(priorityIn.get(expression[i]) < priorityOut.get(operator.peek())) {
						postfix.add(operator.pop());
					}
					operator.add(expression[i]);
				}
			}
			while(!operator.isEmpty()) {
				postfix.add(operator.pop());
			}
			// ���
			Stack<Integer> nums = new Stack<>(); // �ǿ�����
			for(int i = 0; i < postfix.size(); i++) {
				if(Character.isDigit(postfix.get(i))) {
					nums.add(postfix.get(i)-'0');
				}else {
					if(postfix.get(i) == '+') {
						int B = nums.pop();
						int A = nums.pop();
						nums.add(A+B);
					}else if(postfix.get(i) == '*') {
						int B = nums.pop();
						int A = nums.pop();
						nums.add(A*B);
					}
				}
			}
			// ���
			System.out.printf("#%d %d\n", test, nums.pop());
		}
		scanner.close();
	}
}

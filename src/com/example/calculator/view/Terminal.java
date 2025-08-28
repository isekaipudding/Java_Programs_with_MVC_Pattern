package com.example.calculator.view;

import java.util.Scanner;
import com.example.calculator.model.DTO;

public class Terminal {
    private final Scanner scanner;

    public Terminal(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showIntro() {
        System.out.println("[Calculator] 사칙연산을 선택하고 두 정수를 입력하세요.");
    }

    /** 연산 선택: "+", "-", "*", "/" 중 하나 반환, 잘못된 입력/EOF이면 null */
    public String askOperation() {
        System.out.println("[연산 선택]");
        System.out.println("1) 덧셈 (+)");
        System.out.println("2) 뺄셈 (-)");
        System.out.println("3) 곱셈 (*)");
        System.out.println("4) 나눗셈 (/)");
        System.out.print("연산을 선택하세요 [1/2/3/4 또는 + - * /]: ");

        if (!scanner.hasNextLine()) return null;
        String sel = scanner.nextLine().trim();

        switch (sel) {
            case "1":
            case "+": return "+";
            case "2":
            case "-": return "-";
            case "3":
            case "*":
            case "x":
            case "X": return "*";
            case "4":
            case "/":
            case "÷": return "/";
            default:
                showInvalidOperation();
                return null;
        }
    }

    /** 입력을 받아 DTO의 inputA, inputB를 설정. EOF면 false */
    public boolean readInputs(DTO dto) {
        System.out.print("첫 번째 정수: ");
        if (!scanner.hasNextLine()) return false;
        dto.setInputA(scanner.nextLine().trim());

        System.out.print("두 번째 정수: ");
        if (!scanner.hasNextLine()) return false;
        dto.setInputB(scanner.nextLine().trim());

        return true;
    }

    /** 결과 라벨과 함께 DTO의 result 출력 */
    public void showResult(String label, DTO dto) {
        System.out.println(label + ": " + dto.getResult());
    }

    public void showInvalidInteger(DTO dto) {
        System.out.println("정수를 입력해주세요.");
    }

    public void showDivideByZero() {
        System.out.println("0으로 나눌 수 없습니다.");
    }

    public void showInvalidOperation() {
        System.out.println("잘못된 선택입니다. 1/2/3/4 또는 + - * / 중에서 선택하세요.");
    }
}

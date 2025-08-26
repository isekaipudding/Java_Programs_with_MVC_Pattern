package com.example.calculator.controller;

import com.example.calculator.model.DTO;
import java.util.Scanner;

public class Controller {
    public void run(Scanner Scanner) {
        DTO dto = new DTO();

        System.out.println("[Calculator] 간단 테스트: 두 정수의 합을 구합니다.");

        System.out.print("첫 번째 정수: ");
        if (!Scanner.hasNextLine()) return;
        dto.setInputA(Scanner.nextLine().trim());

        System.out.print("두 번째 정수: ");
        if (!Scanner.hasNextLine()) return;
        dto.setInputB(Scanner.nextLine().trim());

        try {
            long a = Long.parseLong(dto.getInputA());
            long b = Long.parseLong(dto.getInputB());
            dto.setResult(String.valueOf(a + b));     // 계산 결과를 DTO에 저장
            System.out.println("합: " + dto.getResult()); // DTO에서 꺼내 출력
        } catch (NumberFormatException e) {
            dto.setResult(null); // 필요시 에러 상태 표시
            System.out.println("정수를 입력해주세요.");
        }
    }
}
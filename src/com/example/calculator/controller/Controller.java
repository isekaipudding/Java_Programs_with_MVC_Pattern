package com.example.calculator.controller;

import com.example.calculator.model.DTO;
import com.example.calculator.view.Terminal;
import com.example.calculator.service.Functions;

import java.util.Scanner;

public class Controller {

    public void run(Scanner scanner) {
        DTO dto = new DTO();
        Terminal term = new Terminal(scanner);
        Functions fn = new Functions();

        term.showIntro();

        // 1) 연산 선택 (view 담당)
        String op = term.askOperation();
        if (op == null) return;

        // 2) 두 수 입력 (view 담당, DTO에 세팅)
        if (!term.readInputs(dto)) return;

        // 3) service가 DTO를 파싱/연산/출력값 세팅 → view가 DTO로 출력
        try {
            switch (op) {
                case "+": fn.plus(dto); term.showResult("합", dto); break;
                case "-": fn.sub(dto);  term.showResult("차", dto); break;
                case "*": fn.mul(dto);  term.showResult("곱", dto); break;
                case "/": fn.div(dto);  term.showResult("나눗셈", dto); break;
                default:  term.showInvalidOperation();              break;
            }
        } catch (NumberFormatException e) {
            dto.setResult(null);
            term.showInvalidInteger(dto);
        } catch (ArithmeticException e) {
            dto.setResult(null);
            term.showDivideByZero();
        }
    }
}
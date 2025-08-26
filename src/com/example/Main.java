package com.example;

import com.example.calculator.controller.Controller; // 클래스명은 PascanneralCase!

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // System.in은 닫지 않습니다(다시 열 수 없음)
        Scanner scanner = new Scanner(System.in, "EUC-KR");

        // 배너
        System.out.println("======================================");
        System.out.println("  Project #2 - VS Code + Java (Menu)  ");
        System.out.println("  Base package : com.example          ");
        System.out.println("======================================");

        while (true) {
            // 메뉴
            System.out.println();
            System.out.println("===== 메뉴 =====");
            System.out.println("0 : 소개글(introduce) 보기");
            System.out.println("1 : 1번 프로그램 실행 (Calculator)");
            System.out.println("exit : 프로그램 종료");
            System.out.print("> ");

            if (!scanner.hasNextLine()) {
                System.out.println("\n입력이 종료되어 프로그램을 종료합니다.");
                return;
            }
            String command = scanner.nextLine().trim();

            switch (command) {
                case "0": {
                    System.out.println();
                    System.out.println("[Introduce]");
                    System.out.println("- 이 프로젝트는 모듈형 메뉴 구조를 사용합니다.");
                    System.out.println("- 현재 활성 프로그램: 1번 Calculator");
                    System.out.println("- 추후 2번 프로그램 이상을 확장할 계획입니다.");
                    break;
                }

                case "1": { // 1번 프로그램 실행
                    Controller controller = new Controller();
                    controller.run(scanner); // 권장 시그니처: run(Scanner)
                    System.out.println("\n[알림] Calculator 실행을 마치고 메뉴로 돌아갑니다.");
                    break;
                }

                case "exit": {
                    // 종료 확인 루프: yes → 종료, no → 메뉴로 복귀, 기타 → 재질문
                    while (true) {
                        System.out.print("정말 종료하시겠습니까? (yes/no): ");
                        if (!scanner.hasNextLine()) {
                            System.out.println("\n입력이 종료되어 프로그램을 종료합니다.");
                            return;
                        }
                        String answer = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
                        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                            System.out.println("프로그램을 종료합니다. 이용해 주셔서 감사합니다!");
                            return;
                        }
                        if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                            break; // 메뉴로 복귀
                        }
                        System.out.println("yes 또는 no로 입력해주세요.");
                    }
                    break;
                }

                default: {
                    System.out.println("알 수 없는 명령어입니다. 다시 입력하세요.");
                }
            }
        }
    }
}

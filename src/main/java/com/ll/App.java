package com.ll;

import java.util.Scanner;

class App {
    void run() {
        System.out.println("== 명언 앱 ==");
        int count = 0;


        while (true) {
            System.out.println("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                System.out.print("작가 : ");
                String AthoreName = scanner.nextLine();

                System.out.print("명언 : ");
                String WiseAnswer = scanner.nextLine();

                if (WiseAnswer.length() != 0) {
                    count++;
                    int a = count;
                }

                System.out.printf("작가 : %s 명언 : %s\n %d번 명언이 등록되었습니다.\n", AthoreName, WiseAnswer, count);
            }
        }
    }
}

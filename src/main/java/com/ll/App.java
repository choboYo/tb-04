package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    void run() {
        System.out.println("== 명언 앱 ==");
        int count = 0;
        String AthoreName = "";
        String WiseAnswer = "";
        List<Plus> pluses = new ArrayList<>();


        while (true) {
            System.out.println("명령) ");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();


            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("작가 : ");
                AthoreName = scanner.nextLine();


                System.out.print("명언 : ");
                WiseAnswer = scanner.nextLine();

                count++;

                Plus plus = new Plus(count, WiseAnswer, AthoreName);
                pluses.add(plus);

                System.out.printf("작가 : %s 명언 : %s\n %d번 명언이 등록되었습니다.\n", AthoreName, WiseAnswer, count);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언 ");
                System.out.println("-------------------");

                for (int i = pluses.size() - 1; i >= 0; i--) {
                    Plus plus = pluses.get(i);
                    System.out.printf("%d   %s    %s\n", plus.id, plus.authorName, plus.content);
                }

            }
            else if (cmd.substring(0,2).equals("삭제")) {
                int IdSearch = cmd.indexOf("=");
                int id =Integer.valueOf(cmd.substring(IdSearch + 1));
                pluses.remove(id -1);

            }
        }
    }
}


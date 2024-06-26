package com.ll.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner scanner;
    private int lastQuotationId;
    private List<Quotation> quotations;

    public App() {
        scanner = new Scanner(System.in);
        lastQuotationId = 0;
        quotations = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            String cmd = scanner.nextLine();

            Rq rq = new Rq(cmd);

            switch (rq.getAction()) {
                case "종료":
                    return;
                case "등록":
                    actionWrite();
                    break;
                case "목록":
                    actionList();
                    break;
                case "삭제":
                    actionRemove(rq);
                    break;
                case "수정":
                    actionModify(rq);
                    break;
                case "테스트":
                    autoTestMaker();
                    break;

            }
        }
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String authorName = scanner.nextLine();

        lastQuotationId++;
        int id = lastQuotationId;

        Quotation quotation = new Quotation(id, content, authorName);
        quotations.add(quotation);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");

        System.out.println("----------------------");

        if (quotations.isEmpty())
            System.out.println("등록된 명언이 없습니다.");

        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);
            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
        }
    }

    private void actionRemove(Rq rq) {
        int id = rq.getParamAsInt("id", 0);
        if (id == 0) {
            System.out.println("id를 정확히 입력해주세요.");
            return; //함수를 끝낸다.
        }
        int index = indexOfNumber(id);

        if (index == -1) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        } else if (index != -1) {
            quotations.remove(index);
        }


        System.out.printf("%d번 명언을 삭제합니다.\n", id);
    }

    private void autoTestMaker() {


        for (int i = 1; i < 4; i++) {
                int id = i;
            String content = "명언" + id;
            String authorName = "작가" + id;

            Quotation quotation = new Quotation(id, content, authorName);
            quotations.add(quotation);
        }


    }

    private int indexOfNumber(int id) {
        for (int i = 0; i < quotations.size(); i++) {
            Quotation quotation = quotations.get(i);
            // list 안에있는 id를 비교하여 매개변수 id와 일치하면 i
            if (quotation.id == id) {
                return i;
            }

        }
        return -1;
    }


    private void actionModify(Rq rq) {
        int id = rq.getParamAsInt("id", 0);
        if (id == 0) {
            System.out.println("id를 정확히 입력해주세요.");
            return; //함수를 끝낸다.
        }
        int index = indexOfNumber(id);

        if (index == -1) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        Quotation quotation = quotations.get(index);

        System.out.printf("명언(기존) : %s\n", quotation.content);
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.printf("작가(기존) : %s\n", quotation.authorName);
        System.out.print("작가 : ");
        String authorName = scanner.nextLine();

        quotation.content = content;
        quotation.authorName = authorName;

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);


    }


}




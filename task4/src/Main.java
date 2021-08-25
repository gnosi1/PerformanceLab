package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size[] = new int[720];
        try {
            FileReader fileReader = new FileReader(args[0]);
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                String arrTime[] = scan.nextLine().split(" ");
                String arrBegin[] = arrTime[0].split(":");
                int beginH = Integer.parseInt(arrBegin[0]);
                int beginM = Integer.parseInt(arrBegin[1]);
                String arrEnd[] = arrTime[1].split(":");
                int endH = Integer.parseInt(arrEnd[0]);
                int endM = Integer.parseInt(arrEnd[1]);
                int posBegin = (beginH - 8) * 60 + beginM;
                int posEnd = (endH - 8) * 60 + endM - 1;
                for (int i = posBegin; i <= posEnd; i++)
                    size[i]++;
            }
            fileReader.close();

            int maxVisitor = 0;
            for (int i = 0; i < 720; i++) {
                if (size[i] > maxVisitor)
                    maxVisitor = size[i];
            }

            int i = 0;
            while (i < 720) {
                int timeBegin = 0;
                int timeEnd = 0;
                if (size[i] == maxVisitor) {
                    timeBegin = 8 * 60 + i;
                    while (size[i] == maxVisitor) {
                        i++;
                    }
                    timeEnd = 8 * 60 + i;
                    int beginH = timeBegin / 60;
                    int beginM = timeBegin - beginH * 60;
                    int endH = timeEnd / 60;
                    int endM = timeEnd - endH * 60;

                    System.out.println(beginH + ":" + addZero(beginM) + " " + endH + ":" + addZero(endM));
                }
                i++;
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }

    public static String addZero(int number) {
        if (number >= 0 && number <= 9)
            return "0" + String.valueOf(number);
        else return String.valueOf(number);
    }
}

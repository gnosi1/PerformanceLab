package com.company;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        ArrayList<Short> list = new ArrayList<>();
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            list.add(scan.nextShort());
        }
        Collections.sort(list);

        double d = ((double) 90/100)*(list.size()-1)+1;
        int n = (int)Math.floor(d);
        double remains = d - n;
        double percentile = list.get(n - 1) +remains*(list.get(n) - list.get(n - 1));
        System.out.println(String.format("%.2f", percentile));

        double median;
        if(list.size() % 2 == 0)
            median = list.get(list.size() / 2);
        else
            median = ((double)list.get(list.size() / 2) + list.get((list.size() / 2) - 1))/2;
        System.out.println(String.format("%.2f", median));

        System.out.printf("%.2f%n", (double) Collections.max(list));

        System.out.printf("%.2f%n", (double) Collections.min(list));

        int sum = 0;
        for(short i: list) sum+=i;
        System.out.println(String.format("%.2f", (double)sum/list.size()));
    }
}

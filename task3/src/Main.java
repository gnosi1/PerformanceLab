package com.company;

import java.util.*;
import java.io.IOException;
import java.nio.file.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String files = args[0];
        String[] address = new String[5];
        for(int i=0; i<5;i++){
            address[i]= (files + "\\Cash" + (i+1) + ".txt");
        }

        String[][] data = new String[5][16];
        for(int i=0; i<5;i++){
            Path path = Paths.get(address[i]);
            Scanner scan = new Scanner(path);
            int q = 0;
            while (scan.hasNextLine()){
                data[i][q] = scan.nextLine();
                q++;
                if(q==16){
                    break;
                }
            }
        }

        double[] resultdata = new double[16];
        for(int i =0; i<16 ; i++){
            for(int p =0; p<5 ; p++){
                resultdata[i] = resultdata[i] + Double.parseDouble(data[p][i]);
            }
        }

        double max = resultdata[0];
        int count = 0;
        for(int i =1; i<16 ; i++){
            if(resultdata[i]>max){
                max = resultdata[i];
                count = i;
            }
        }
        System.out.print((count+1));
    }
}

package com.company;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Float> coorX = new ArrayList<>();
        ArrayList<Float> coorY = new ArrayList<>();
        ArrayList<Float> pointX = new ArrayList<>();
        ArrayList<Float> pointY = new ArrayList<>();

        try (BufferedReader file1 = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
             BufferedReader file2 = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])));
        ){
            String line;
            while ((line = file1.readLine()) != null){
                String[] fXY = line.replace("\\n","").split(" ");
                coorX.add(Float.parseFloat(fXY[0]));
                coorY.add(Float.parseFloat(fXY[1]));
            }

            while ((line = file2.readLine()) != null){
                String[] pXY = line.replace("\\n","").split(" ");
                pointX.add(Float.parseFloat(pXY[0]));
                pointY.add(Float.parseFloat(pXY[1]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arr = {0,1,2,3,0};
        for(int p=0; p< pointX.size(); p++){
            boolean top = false;
            for(int k=0; k< coorX.size();k++){
                if(pointX.get(p).equals(coorX.get(k)) && pointY.get(p).equals(coorY.get(k))){
                    top = true;
                    System.out.println(0);
                    break;
                }
            }
            if(top) continue;
            int rightAmount = 0;
            boolean isOnLine = false;
            for(int k=0;k<arr.length-1; k++){
                double A = -(coorY.get(arr[k + 1]) - coorY.get(arr[k]));
                double B = coorX.get(arr[k + 1]) - coorX.get(arr[k]);
                double C = -(A* coorX.get(arr[k]) +B* coorY.get(arr[k]));
                double D = A * pointX.get(p) +B* pointY.get(p) +C;
                if(D<0)
                    rightAmount++;
                if(D == 0 && (((coorX.get(arr[k]) <= pointX.get(p))&&(pointX.get(p) <= coorX.get(arr[k + 1]))) || ((coorX.get(arr[k + 1]) <= pointX.get(p))&&(pointX.get(p) <= coorX.get(arr[k]))))
                        && (((coorY.get(arr[k]) <= pointY.get(p))&&(pointY.get(p) <= coorY.get(arr[k + 1]))) || ((coorY.get(arr[k + 1]) <= pointY.get(p))&&(pointY.get(p) <= coorY.get(arr[k])))) )
                {
                    System.out.println(1);
                    isOnLine = true;
                    break;
                }
            }
            if(isOnLine) continue;
            if(rightAmount == 4)
                System.out.println(2);
            else
                System.out.println(3);
        }

    }
}

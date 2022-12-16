package day01;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;

class day01 {
    public static void main(String[] args) {
        BufferedReader reader;
        ArrayList<Integer> calorieSums = new ArrayList<Integer>();
        int tempSum = 0;

        try {

            reader = new BufferedReader(new FileReader("day01/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();

                if (line != null && !line.isEmpty()) {
                    tempSum += Integer.parseInt(line);
                }

                else {
                    calorieSums.add(tempSum);
                    tempSum = 0;
                }

            }

            reader.close();
            System.out.println("ARRAY: " + calorieSums);
            System.out.println("MAXIMUM VALUE (ANSWER): " + Collections.max(calorieSums));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
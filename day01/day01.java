package day01;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;

class day01 {

    static BufferedReader reader;
    static ArrayList<Integer> calorieSums = new ArrayList<Integer>();
    static int tempSum = 0;

    static int FindMaxCalories(int numberOfElfs) {
        List<Integer> topCalories = new ArrayList<Integer>();
        int topCaloriesSum = 0;

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

            Collections.sort(calorieSums);
            topCalories = calorieSums.subList(calorieSums.size() - numberOfElfs, calorieSums.size());
            topCaloriesSum = topCalories.stream().mapToInt(Integer::intValue).sum();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return topCaloriesSum;
    }

    public static void main(String[] args) {
        System.out.println(FindMaxCalories(3));
    }
}
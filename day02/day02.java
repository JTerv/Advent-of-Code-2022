package day02;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;

class day02 {

    static BufferedReader reader;
    static final char opponentRock = 'A';
    static final char opponentPaper = 'B';
    static final char opponentScissors = 'C';

    static final char yourRock = 'X';
    static final char yourPaper = 'Y';
    static final char yourScissors = 'Z';

    static final int loseValue = 0;
    static final int drawValue = 3;
    static final int winValue = 6;
    static final int rockValue = 1;
    static final int paperValue = 2;
    static final int scissorsValue = 3;

    static final char toLoseValue = 'X';
    static final char toDrawValue = 'Y';
    static final char toWinValue = 'Z';

    static int yourScore = 0;
    static int totalScore = 0;

    static char yourMove = ' ';

    static int ComputeTotalScore() {

        try {

            reader = new BufferedReader(new FileReader("day02/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);


                totalScore += ComputeScore(line.charAt(0), ComputeMove(line.charAt(0), line.charAt(2)));
                yourMove = ' ';
                yourScore = 0;

                line = reader.readLine();

            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalScore;
    }

    static int ComputeScore(char move1, char move2) {
        switch (move1) {
            case opponentRock:
                if (move2 == yourRock) {
                    yourScore += (rockValue + drawValue);
                } else if (move2 == yourPaper) {
                    yourScore += (paperValue + winValue);
                } else {
                    yourScore += (scissorsValue + loseValue);
                }
                break;
            case opponentPaper:
                if (move2 == yourRock) {
                    yourScore += (rockValue + loseValue);
                } else if (move2 == yourPaper) {
                    yourScore += (paperValue + drawValue);
                } else {
                    yourScore += (scissorsValue + winValue);
                }
                break;
            case opponentScissors:
                if (move2 == yourRock) {
                    yourScore += (rockValue + winValue);
                } else if (move2 == yourPaper) {
                    yourScore += (paperValue + loseValue);
                } else {
                    yourScore += (scissorsValue + drawValue);
                }
                break;
        }

        return yourScore;

    }

    static char ComputeMove(char move1, char move2) {
        switch (move1) {
            case opponentRock:
                if (move2 == toLoseValue) {
                    yourMove = yourScissors;
                } else if (move2 == toDrawValue) {
                    yourMove = yourRock;
                } else {
                    yourMove = yourPaper;
                }
                break;
            case opponentPaper:
                if (move2 == toLoseValue) {
                    yourMove = yourRock;
                } else if (move2 == toDrawValue) {
                    yourMove = yourPaper;
                } else {
                    yourMove = yourScissors;
                }
                break;
            case opponentScissors:
                if (move2 == toLoseValue) {
                    yourMove = yourPaper;
                } else if (move2 == toDrawValue) {
                    yourMove = yourScissors;
                } else {
                    yourMove = yourRock;
                }
                break;
        }

        return yourMove;
    }

    public static void main(String[] args) {
        System.out.println(ComputeTotalScore());
    }
}

// ATT 1: 17909731
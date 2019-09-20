package at.htl.football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        League League = new League();
        List<String> info = new ArrayList<>();
        List<Match> matchs = new ArrayList<>();
        String elements[];


        try {
            info = Files.readAllLines(Paths.get("bundesliga-1819.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < info.size(); i++) {
            elements = info.get(i).split(";");
            matchs.add(new Match(elements[1],elements[2],Integer.parseInt(elements[3]),Integer.parseInt(elements[4])));
            League.addMatchResult(matchs.get(i-1));
        }


        printTable(League.getTable());
    }

    private static void printTable(List<Team> teams){
        System.out.println("Team                   PTS    W      D     L    GF    GA    GD");

        for (int i = 0; i < teams.size(); i++) {
            System.out.printf("%-20s %5d %5d %5d %5d %5d %5d %5d\n", teams.get(i).getName(),teams.get(i).getPoints(), teams.get(i).getWins(), teams.get(i).getDraws(), teams.get(i).getDefeats(), teams.get(i).getGoalsShot(), teams.get(i).getGoalsRecived(), teams.get(i).getGoalDifference());
        }
    }

}

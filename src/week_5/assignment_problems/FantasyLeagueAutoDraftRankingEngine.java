package week_5.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class FantasyLeagueAutoDraftRankingEngine
{
    static boolean isDraftable(int matchesPlayed)
    {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured)
    {
        return matchesPlayed >= 5 && !injured;
    }

    static class Player implements Comparable<Player>
    {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed,
                      double battingAverage, boolean injured)
        {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        double fantasyPoints()
        {
            return battingAverage;
        }

        public int compareTo(Player other)
        {
            return Double.compare(
                other.fantasyPoints(),
                this.fantasyPoints()
            );
        }

        String getName()
        {
            return name;
        }
    }

    static String draftAndRank(Player[] players)
    {
        Player[] draftable = new Player[players.length];

        int count = 0;

        for (int i = 0; i < players.length; i++)
        {
            if (isDraftable(players[i].matchesPlayed)
                    || isDraftable(players[i].matchesPlayed,
                                   players[i].injured))
            {
                draftable[count] = players[i];
                count++;
            }
        }

        Player[] finalList = Arrays.copyOf(draftable, count);

        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++)
        {
            result = result + (i + 1) + ". " + finalList[i].getName();

            if (i < finalList.length - 1)
            {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter player name: ");
            String name = sc.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Is player injured? (true/false): ");
            boolean injured = sc.nextBoolean();

            sc.nextLine();

            players[i] = new Player(
                name,
                matchesPlayed,
                battingAverage,
                injured
            );
        }

        String result = draftAndRank(players);

        System.out.println("\nDraft Ranking:");
        System.out.println(result);

        sc.close();
    }
}
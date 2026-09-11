package week_5.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PlacementDriveShortlistingRankingEngine
{
    static boolean isEligible(double cgpa)
    {
        return cgpa >= 8.0;
    }

    static boolean isEligible(double cgpa, int codingScore)
    {
        return cgpa >= 7.0 && codingScore >= 70;
    }

    static class Candidate implements Comparable<Candidate>
    {
        String name;
        double cgpa;
        int codingScore;

        Candidate(String name, double cgpa, int codingScore)
        {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double compositeScore()
        {
            return (cgpa * 10) + codingScore;
        }

        public int compareTo(Candidate other)
        {
            return Double.compare(other.compositeScore(), this.compositeScore());
        }

        public String toString()
        {
            return name + " - " + compositeScore();
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter candidate name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        Candidate[] shortlisted = new Candidate[n];
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            if (isEligible(candidates[i].cgpa) ||
                isEligible(candidates[i].cgpa, candidates[i].codingScore))
            {
                shortlisted[count] = candidates[i];
                count++;
            }
        }

        Candidate[] finalList = Arrays.copyOf(shortlisted, count);

        Arrays.sort(finalList);

        System.out.println("\nShortlisted Candidates:");

        for (Candidate candidate : finalList)
        {
            System.out.println(candidate);
        }

        sc.close();
    }
}
package week_8.class_problems;

class Question
{
    String correctAnswer;
    double points;

    Question(String correctAnswer, double points)
    {
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    double grade(String studentAnswer)
    {
        return 0;
    }
}

class MCQQuestion extends Question
{
    MCQQuestion(String correctAnswer, double points)
    {
        super(correctAnswer, points);
    }

    @Override
    double grade(String studentAnswer)
    {
        if (studentAnswer.equalsIgnoreCase(correctAnswer))
        {
            return points;
        }

        return 0;
    }
}

class TrueFalseQuestion extends Question
{
    TrueFalseQuestion(String correctAnswer, double points)
    {
        super(correctAnswer, points);
    }

    @Override
    double grade(String studentAnswer)
    {
        if (studentAnswer.equalsIgnoreCase(correctAnswer))
        {
            return points;
        }

        return 0;
    }
}

class EssayQuestion extends Question
{
    EssayQuestion(String correctAnswer, double points)
    {
        super(correctAnswer, points);
    }

    @Override
    double grade(String studentAnswer)
    {
        String[] keywords = correctAnswer.toLowerCase().split(",");
        String answer = studentAnswer.toLowerCase();

        int matches = 0;

        for (String keyword : keywords)
        {
            if (answer.contains(keyword.trim()))
            {
                matches++;
            }
        }

        if (matches >= 2)
        {
            return points * 0.75;
        }
        else if (matches == 1)
        {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationQuestionGrader
{
    public static void main(String[] args)
    {
        Question[] questions =
        {
            new MCQQuestion("B", 10),
            new TrueFalseQuestion("TRUE", 10),
            new EssayQuestion("inheritance,polymorphism,encapsulation", 20)
        };

        String[] studentAnswers =
        {
            "B",
            "TRUE",
            "Inheritance and polymorphism are important concepts in Java"
        };

        double total = 0;

        for (int i = 0; i < questions.length; i++)
        {
            double score = questions[i].grade(studentAnswers[i]);

            System.out.println("Question " + (i + 1) + " Score: " + score);

            total = total + score;
        }

        System.out.println("Total Score: " + total);
    }
}
import java.util.Scanner;

public class GradeC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scan.nextInt();

        if (numSubjects <= 0) {
            System.out.println("Invalid number of subjects. Please enter a positive number.");
            return;
        }

        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = scan.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100.");
                return;
            }

            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scan.close();
    }
}

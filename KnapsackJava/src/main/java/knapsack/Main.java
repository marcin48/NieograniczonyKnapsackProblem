package knapsack;


public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem(50, 12, 5, 30);
        System.out.println(problem);

        Result result = problem.Solve(431);
        System.out.println(result);
    }
}

import java.util.Stack;

public class SolutionTwo {

    Stack<Integer> stack = new Stack<>();
    static final Integer MAX_NUMBER = (int) Math.pow(2, 20) - 1;
    static final Integer MIN_NUMBER = 0;

    public int solution(String S) {
        String[] arr = S.split("\\s+");
        for (String elem : arr) {

            try {
                switch (elem) {

                    case "POP":
                        stack.pop();
                        break;
                    case "DUP":
                        Integer topElement = stack.get(stack.size() - 1);
                        stack.push(topElement);
                        break;
                    case "+":
                        Integer addedValue = stack.pop() + stack.pop();
                        checkForError(addedValue);
                        stack.push(addedValue);
                        break;
                    case "-":
                        Integer subtractedValue = stack.pop() - stack.pop();
                        checkForError(subtractedValue);
                        stack.push(subtractedValue);
                        break;
                    default:
                        int number = Integer.parseInt(elem);
                        checkForError(number);
                        stack.push(number);
                }
            } catch (Exception e) {
                return -1;
            }
            System.out.println(stack);
        }

        return stack.isEmpty() ? -1 : stack.pop();
    }

    private void checkForError(Integer num) throws Exception {
        if (num < MIN_NUMBER | num > MAX_NUMBER) {
            throw new Exception("Overflow error");
        }
    }

    public static void main(String[] args) {
        SolutionTwo solution = new SolutionTwo();
//        System.out.printf("4 5 6 - 7 + | %s\n", solution.solution("4 5 6 - 7 +"));
//        System.out.printf("13 DUP 4 POP 5 DUP + DUP + -  | %s\n", solution.solution("13 DUP 4 POP 5 DUP + DUP + -"));
        System.out.printf("5 6 + - | %s\n", solution.solution("5 6 + -"));
//        System.out.printf("3 DUP 5 - - | %s\n", solution.solution("3 DUP 5 - -"));
        System.out.printf("1048575 DUP + | %s\n", solution.solution("1048575 DUP +"));
        System.out.printf("3 POP | %s\n", solution.solution("3 POP"));
    }
}

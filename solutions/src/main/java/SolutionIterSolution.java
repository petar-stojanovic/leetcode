import java.io.*;
import java.util.Iterator;

public class SolutionIterSolution {
    public static void main(String[] args) throws FileNotFoundException {

        FileReader inp = new FileReader("C:\\Users\\Petar\\Desktop\\leetcode\\solutions\\src\\main\\java\\testInput.txt");
        SolutionIter sol = new SolutionIter(inp);

        for (Integer x : sol) {
            System.out.println(x);
        }
    }
}

class SolutionIter implements Iterable<Integer> {

    BufferedReader reader;

    public SolutionIter(Reader inp) {
        this.reader = new BufferedReader(inp);
    }


    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private String nextLine = null;

            @Override
            public boolean hasNext() {
                try {
                    while ((nextLine = reader.readLine()) != null) {

                        if (isInteger(nextLine)) {
                            return true;
                        }
                    }
                    return false;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            private boolean isInteger(String line) {
                try {
                    int i =Integer.parseInt(line);
                    return i >= -1_000_000_000 && i <= 1_000_000_000;
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            public Integer next() {
                if(nextLine == null) {
                    throw new RuntimeException("No more elements");
                }
                return Integer.parseInt(nextLine);
            }

        };
    }
}
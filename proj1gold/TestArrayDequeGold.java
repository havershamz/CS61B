import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class TestArrayDequeGold {
    @Test
    public void firstTest() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.5) {
                student.addLast(i);
                solution.addLast(i);
                System.out.println("addLast("+ i +")");
                Integer int1 = solution.get(solution.size() - 1);
                Integer int2 = student.get(student.size() - 1);
                Assert.assertEquals(int1, int2);
            } else {
                student.addFirst(i);
                solution.addFirst(i);
                System.out.println("addFirst("+ i +")");
                Integer int1 = solution.get(0);
                Integer int2 = student.get(0);
                Assert.assertEquals(int1, int2);
            }
        }
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                Integer int1 = student.removeFirst();
                Integer int2 = solution.removeFirst();
                System.out.println("removeFirst()");
                Assert.assertEquals("removeFirst()", int1, int2);
            } else {
                Integer int1 = student.removeLast();
                Integer int2 = solution.removeLast();
                System.out.println("removeLast()");
                Assert.assertEquals("removeLast()", int1, int2);
            }
        }
    }
}


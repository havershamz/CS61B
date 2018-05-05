import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
public class ArrayDequeTest {
    @Test
    public void allTest() {
        ArrayDeque<String> ad = new ArrayDeque<>();

        Assert.assertEquals(ad.size(), 0);
        Assert.assertTrue(ad.isEmpty());

        ad.printDeque();
        ad.addFirst("number1");
        ad.addLast("number2");
        ad.addLast("number3");
        ad.printDeque();
        System.out.println();

        Assert.assertEquals(ad.get(0), "number1" );
        Assert.assertEquals(ad.get(1), "number2" );
        Assert.assertEquals(ad.size(), 3);
        Assert.assertTrue(!ad.isEmpty());

        ad.removeLast();

        Assert.assertEquals(ad.get(0), "number1" );
        Assert.assertEquals(ad.size(), 2);

        for(int i = 4; i< 20; i++) {
            ad.addLast("number" + i);
        }
        ad.printDeque();
        System.out.println();

        for(int i = 4; i< 20; i++) {
            ad.removeLast();
        }
        ad.printDeque();
        System.out.println();

        for(int i = 0; i> -17; i--) {
            ad.addFirst("number" + i);
        }
        ad.printDeque();
        System.out.println();

        for(int i = 4; i< 20; i++) {
            ad.removeFirst();
        }
        ad.printDeque();

    }
}


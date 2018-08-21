import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    OffByOne obo = new OffByOne();
    @Test
    public void testEqualChars() {
        char a = 'a';
        char b = 'b';
        char c = 'A';
        assertTrue(obo.equalChars(b, a));
        assertTrue(obo.equalChars(a, b));
        assertFalse(obo.equalChars(a, c));

    }
}

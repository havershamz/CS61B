import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    OffByN obo = new OffByN(5);
    @Test
    public void testEqualChars() {
        char a = 'a';
        char b = 'f';
        char c = 'b';
        assertTrue(obo.equalChars(b, a));
        assertTrue(obo.equalChars(a, b));
        assertFalse(obo.equalChars(a, c));

    }
}

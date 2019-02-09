import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class Solution {
    protected static void validateEqual(Object actual, Object expected) {
        if (actual instanceof Array) {
            System.out.println("actual value = " + Arrays.toString((Object[]) actual));
        } else {
            System.out.println("actual value = " + actual);
        }

        System.out.println("equal to expected = " + Objects.deepEquals(actual, expected));
    }
}

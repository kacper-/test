package comt.codility;

import org.junit.Assert;
import org.junit.Test;

public class TestTest {

    @Test
    public void solution() {
        int result = CTest.solution(new int[]{1, 2, 3, 5, 6});
        Assert.assertEquals(4, result);
    }
}
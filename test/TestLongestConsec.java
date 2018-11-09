import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.test.LongestConsec;

class TestLongestConsec {

	@Test
	void test() {
		
		String[] testArray = {"wlwsasph333mxx","owiaxujylentrklctozmymu","wpgozvxx22iu","wpgozvx2xiu"};
		String expected = "wlwsasph333mxxowiaxujylentrklctozmymu" ;
		
		assertEquals(expected, LongestConsec.longestConsec(testArray, 2),"result value test");
	}

}

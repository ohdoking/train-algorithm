import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.test.Kata2;
import com.test.LongestConsec;

class TestKata2 {

	@Test
	void test() {
		
		String expected = "70000 + 300 + 4" ;
		
		assertEquals(expected, Kata2.expandedForm(70304),"result value test");
	}

}

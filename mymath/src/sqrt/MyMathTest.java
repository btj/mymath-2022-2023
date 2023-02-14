package sqrt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	
	@Test
	void test() {
		int[] xs = {-5, 10, 0, 0};
		MyMath.insert(xs, 2, 7);
		assertArrayEquals(new int[] {-5, 7, 10, 0}, xs);
		MyMath.insert(xs, 3, 15);
		assertArrayEquals(new int[] {-5, 7, 10, 15}, xs);
	}

}

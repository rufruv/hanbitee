package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class JdbcUtilTest {

	@Test
	public void testGetName() {
		JdbcTest test = new JdbcTest();
		assertTrue(test.getName().equals("홍길동"));
	}

}

package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

class HashingTest
{
	@Test
	void testToHash()
	{
		try
		{
			Hashing exe = new Hashing("SHA");
			assertEquals("31F30DDBCB1BF8446576F0E64AA4C88A9F055E3C", exe.toHash("hoge"));
		} catch (NoSuchAlgorithmException e1)
		{
			fail("失敗");
		}
	}

}

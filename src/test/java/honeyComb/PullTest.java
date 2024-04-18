package honeyComb;

import org.junit.jupiter.api.Test;

public class PullTest
{
	@Test
	public void test()
	{
		RestStorage.pull("1");
	}
}

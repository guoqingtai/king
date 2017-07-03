package knight.z9_test.dwrtest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * @创建作者： LinkinPark
 * @创建时间： 2016年2月26日
 * @功能描述： commons-logging的测试类
 */
public class CommonsLoggingTest
{
	public static Log LOG = LogFactory.getLog(CommonsLoggingTest.class);


	@Test
	public void test()
	{
		LOG.debug("debug()...");
		LOG.info("info()...");
		LOG.error("error()...");
	}


}
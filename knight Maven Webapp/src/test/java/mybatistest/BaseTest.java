package mybatistest;

import org.junit.Test;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
//@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
//@ContextConfiguration({ "classpath:spring-common.xml" ,"classpath:spring-mybatis.xml","classpath:mapper/BookDao.xml","classpath:jdbc.properties","classpath:mybatis-config.xml"})
public class BaseTest {
	
	@Test
	public void test() {
	}

}
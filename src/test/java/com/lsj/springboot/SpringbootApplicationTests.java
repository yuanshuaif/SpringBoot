package com.lsj.springboot;
import com.lsj.springboot.entity.UserAnnotation;
import com.lsj.springboot.async.IUserService;
import com.lsj.springboot.rabbitMQ.springRabbitMQ.sender.FanoutSender;
import com.lsj.springboot.rabbitMQ.springRabbitMQ.sender.SimpleSender;
import com.lsj.springboot.rabbitMQ.springRabbitMQ.sender.TopicSender;
import com.lsj.springboot.redis.PcInformationService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	private MockMvc mvc;

	@Autowired
	private IUserService iUserService;
/*
	//初始化执行
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	//验证controller是否正常响应并打印返回结果
	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_PROBLEM_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}*/

	@Test
	public void contextLoads() {
		iUserService.save(new UserAnnotation());
	}

	/**
	 * ehcache被更多的作为本地的缓存机制，但是在业务复杂频频的系统中，单靠ehcache貌似有些吃力，这时我们可以
	 * 让Redis做为分布式缓存，ehcache做本地的缓存，形成拥有2种缓存的系统。在一个请求被路由到某台服务上时，系统先去Redis中找，Reids中有
	 * 对应的缓存就返回，没有的话再从本地的Ehcache中找，找到则返回，找不到就从数据库中查询了，查询了之后我们可以保持在Redis
	 * 和本地的Ehcache中。
	 */
	@Test
	public void testEhcache () {
		CacheManager create = CacheManager.create(this.getClass().getResourceAsStream("/ehcache.xml"));
		Cache cache = create.getCache("local");
		cache.put(new Element("key1", "value1"));
		Element element = cache.get("key1");
		System.out.println(element.getObjectKey()+" : "+element.getObjectValue());
	}

	@Autowired
	private SimpleSender simpleSender;
	@Autowired
	private TopicSender topicSender;
	@Autowired
	private FanoutSender fanoutSender;

	@Test
	public void simpleSender() throws Exception {
		simpleSender.send();
	}

	@Test
	public void topicSender() throws Exception {
		topicSender.send2();
	}

	@Test
	public void fanoutSender() throws Exception {
		fanoutSender.send1();
	}

	@Autowired
	private PcInformationService pcInformationService;

	@Test
	public void addRedisLock() throws Exception {

		new Thread() {
			@Override
			public void run() {
				try {
					pcInformationService.add();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		Thread.sleep(12000);
		new Thread() {
			@Override
			public void run() {
				try {
					pcInformationService.add();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		Thread.currentThread().join();
	}

}

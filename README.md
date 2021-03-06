##SpringBoot的基础工程
1.过滤器的使用
2.properties文件的使用
    2.1 application.properties/yml文件，可以直接使用@Value注入;
    2.2 其他的properties文件需要使用@PropertySource("classpath:/config/cs.properties")来指定文件的位置(只要存在该注解即可)，然后再使用@Value注入;
    2.3 将properties文件装配成一个bean,@ConfigurationProperties(prefix = "springboot.properties")
3.在spring boot中默认会加载（2的延申）
  (resources)classpath:/,file:./,file:./config/ 路径下以application命名的property或yaml文件；
4.对profile的支持
5.对日志的支持
    默认的日志系统slf4j
    在配置文件添加相关配置;logback-spring.xml文件
6.springboot在启动过程中添加了事件监听机制，支持的事件包括4种类型：
    ApplicationStartedEvent : spring boot启动开始时执行的事件,可做一些执行前的设置
    ApplicationEnvironmentPreparedEvent : spring boot 对应Enviroment已经准备完毕，但此时上下文context还没有创建
    ApplicationPreparedEvent : spring boot上下文context创建完成，但此时spring中的bean是没有完全加载完成的
    ApplicationFailedEvent : spring boot启动异常时执行事件
  实现监听步骤：
  1.监听类实现ApplicationListener接口
  2.将监听类添加到SpringApplication实例
7.lombok的使用
8.@Notnull与@Valid注解的组合使用
    @Valid开启校验功能;@Notnull属性非空校验
    hibernate的校验器
9.StreamAPI
    对hashMap等map集合的数据结构优化
    接口中可以定义默认实现方法、静态方法
    lambda表达式
    函数式接口(只定义了一个抽象方法的接口(public方法除外),并且提供了@FunctionalInteface注解)
    方法引用/构造器引用
    StreamAPI
    Optional容器
    新的日期API LocalDate | LocalTime | LocalDateTime（新的日期API都是不可变的）|DateTimeFormatter
    (实际使用中，计算日期就用LocalDate,计算日期加时刻用LocalDateTime，如果只有时刻就是LocalTime)
10.Enum;
11.单元测试:
       MockMvc: cotroller的单元测试
12.集成测试——热部署:
       spring-boot-devtools实现热部署
       可实现页面和代码的热部署
       <dependencies>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-devtools</artifactId>
               <optional>true</optional>
           </dependency>
       </dependencies>
       <build>
           <plugins>
               <plugin>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-maven-plugin</artifactId>
                   <configuration>
                       <fork>true</fork>  <!--必须的配置-->
                   </configuration>
               </plugin>
       </plugins>
       </build>
13.随机端口:
       server.port=${random.int[1000,9999]}
       启动服务时：
       o.s.b.w.embedded.tomcat.TomcatWebServer会打印Tomcat started on port(s): 3146 (http) with context path ''
       3146:端口     path:路径
       server.port=0
       eureka.instance.instance-id=${spring.application.name}:${random.int}
14.spring的事件处理 ApplicationEvent
15.国际化
    文件多语
        1）过滤器设置语言
        2）配置多语文件（spring框架使用MessageSource来处理多语）
        3）appContext.getMessage(key, params, locale); 获取当前语言的多语文件
    资源多语
        1）Language记录资源编码与序号的关系
        2）数据库中多语字段
        3）反射获取对应的字段值
16.多线程的部分操作
17.文件上传
    1.导包
   2.启动类配置（超过10M时，会有连接重置的问题）
   3.页面
   4.控制器
   5.全局的异常处理器（@ControllerAdvice、@ExceptionHandler(MultipartException.class)）
   
     OSS:阿里云的在线存储系统
     FastDFS:分布式文件存储系统
     
     
18.双指针、滑动窗口、字符串的匹配、加权随机下标、入栈法 、hash算法、链表、树、dfs、bfs、回溯算法、贪心算法、动态规划

com.lsj.springboot.arithmetic 目录下所有题目均来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
* 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

19.RabbitMQ
    1.简单使用
        1）导jar包
        2）properties 配置连接MQ的信息，自动创建连接、建立管道
        3）配置类：配置Queue
        4）发送者使用AmqpTemplate发送消息
        5）消费者
                @RabbitListener(queues = "lsj")——监听队列
                @RabbitHandler——处理消息
    
    2.多对多模式
        1）一对多模式，默认采用轮询的模式，每个消费者接收到的消息数量是一致的。
            可以设置能者多劳模式，让处理快的消费者处理更多的消息。
    
    3.高级使用
        1）对对象的支持：
            springboot以及完美的支持对象的发送和接收，不需要格外的配置。
        2）TopicExchange、DirectExchange
            配置类：队列、Topic交换机、队列与交换机Binding
            消费者：监听哪个队列、消费消息
            发送者：通过交换机发送消息
        3) FanoutExchange
            配置类：队列、Fanout交换机、队列与交换机Binding(Bean的名称不能重复)
                （队列可以绑定到不同类型的交换机上）
            消费者：监听哪个队列、消费消息
            发送者：通过交换机发送消息
    
    
    --  常规RabbitMQ的使用
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-amqp</artifactId>
            </dependency>
            集成了
            <!--rabbitmq 依赖的启动包 -->
            <dependency>
                <groupId>com.rabbitmq</groupId>
                <artifactId>amqp-client</artifactId>
                <version>5.1.2</version>
            </dependency>
            的功能
            
 该服务提供:
     SpringBoot+Mail服务;
     java设计模式:
     创建型模式——单例模式、原型模式、工厂方法模式、抽象工厂模式、建造者模式
     结构型模式——适配器模式、桥接模式、代理模式（CGLIB动态代理;JDK动态代理;静态代理;）、装饰者模式、外观模式、组合模式、享元模式
     行为型模式——责任链模式、策略模式、状态模式、观察者模式、模板方法模式、迭代器模式、中介者模式、命令模式、备忘录模式、访问者模式....
     未学——解释器模式
     

   
   
   
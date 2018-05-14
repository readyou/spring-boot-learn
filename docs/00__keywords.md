keyword | description
--------|-----------
Enable*注解 | 开始XX配置
@EnableAutoConfiguration | 让spring-boot猜测怎样配置
@Configuration | IoC容器的配置类注解，允许在上下文中注册额外的bean或导入其他配置类
@ComponentScan | 自动注入所有的`Spring components`，(@Component, @Service, @Repository, @Controller etc.)，还包括`@Configuration`注解的类
@SpringBootApplication | @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan的结合
@Import({ MyConfig.class, MyAnotherConfig.class }) | 如果不用`@ComponentScan`，可以用`@Import`添加要注入的类
spring-boot-maven-plugin | 管理spring-boot：打包、运行等等
mvn spring-boot:run | 运行spring-boot
Maven>Show Effective POM | 查看有效POM，将所有继承的依赖都展示出来
SpringApplication | Spring Boot主程序
[Customizing SpringApplication](https://docs.spring.io/spring-boot/docs/2.1.0.BUILD-SNAPSHOT/api/org/springframework/boot/SpringApplication.html) | 定制Application
[Fluent Builder API](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-fluent-builder-api) | 流式api
META-INF/spring.factories | TODO
ApplicationContextAware | TODO
MyBean(ApplicationArguments args) | bean获取命令行传入的参数
[ApplicationRunner](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-command-line-runner) | 注册SpringApplication启动后需要做的事情 
[custom Application Exit](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-application-exit) | 定制退出码
@ConfigurationProperties | 属性类注解，被注解的类，可以通过`@Autowired`注入，而获取系统配置的属性
@EnableConfigurationProperties | 配合@Configuration使用，注入属性类
[属性管理](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-external-config) | 
application-{profile}.properties | profile相关的属性配置yaml文件
application.properties | profile无关的属性配置yaml文件
[@PropertySource](https://docs.spring.io/spring/docs/5.0.6.BUILD-SNAPSHOT/javadoc-api/org/springframework/context/annotation/PropertySource.html) | 配合@Configuration，指定属性文件
@Autowired Environment env; | Environment是可以直接注入使用的
[Random Values](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-external-config-random-values) | 构造随机测试数据
[Application Property Files](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-external-config-application-property-files) | 系统配置文件分布
[YamlPropertySourceLoader](https://www.programcreek.com/java-api-examples/index.php?source_dir=KitchenSink-master/Java/Spring/boot/spring-boot-demo-yaml/src/main/java/szaq/spring/boot/ApplicationConfig.java) | 读取yml配置文件
bootstrap.yml | 用来程序引导时执行，应用于更加早期配置信息读取，如可以使用来配置application.yml中使用到参数等
acme.my-project.person.first-name | 属性文件推荐的写法
[日志配置](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-custom-log-configuration) | logback-spring.xml中可使用${LOG_PATH}等变量
@RestController | Restful Controller类型注解，不再需要@ResponseBody
@RequestMapping | 路由注解，可放在类上，也可放在方法上
[Spring MVC Auto-configuration](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-spring-mvc-auto-configuration) | spring mvc 配置说明
[启动原理](https://www.cnblogs.com/zheting/p/6707035.html) | 讲了启动原理，以及@Configuration, @Bean, @ComponentScan, @EnableAutoConfiguration的作用
[HttpMessageConverters](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-spring-mvc-message-converters) | 定制http消息转换
@GetMapping | RequestMapping中GET方法的简写
@PostMapping | RequestMapping中POST方法的简写
WebMvcConfigurerAdapter | @Configure注解 + 继承自各种Adapter，就可以扩展系统的功能
[Servlets, Filters, and listeners](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-embedded-container-servlets-filters-listeners) | Servlets, Filters, and listeners
@ServletComponentScan](https://blog.csdn.net/catoop/article/details/50501686) | 扫描@WebServlet、@WebFilter、@WebListener 注解
javax.persistence.Entity | jpa相关的类与注解
org.springframework.data.repository | spring-data-jpa相关类
org.springframework.data.domain.Pageable | spring-data相关领域类
[RestTemplate](https://blog.csdn.net/itguangit/article/details/78825505) | 方便调用内部服务的类，还可用于log tracing
@Conditional | 依赖配置，参数为实现了 Condition 的接口的类
@EnableXXX | 通常用来定制 spring-boot 配置，被注解的类会继承 XXXConfigurerAdapter

## Bean 相关
keyword | description
--------|-----------
@Bean(initMethod="init",destroyMethod="destroy") | @Bean 注解里面可以带参数，指定生命周期函数
@PostConstruct | 在 Bean 类里面指定 init 方法
@PreDestroy | 在 Bean 类里面指定destroy 方法






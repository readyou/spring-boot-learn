keyword | description
--------|-----------
Enable*注解 | 开始XX配置
@EnableAutoConfiguration | 让spring-boot猜测怎样配置
@Configuration | 允许在上下文中注册额外的bean或导入其他配置类
@ComponentScan | 自动注入所有的`Spring components`，(@Component, @Service, @Repository, @Controller etc.)，还包括`@Configuration`注解的类
@SpringBootApplication | @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan的结合
@Import({ MyConfig.class, MyAnotherConfig.class }) | 如果不用`@ComponentScan`，可以用`@Import`添加要注入的类
spring-boot-maven-plugin | 管理spring-boot：打包、运行等等
mvn spring-boot:run | 运行spring-boot
Maven>Show Effective POM | 查看有效POM，将所有继承的依赖都展示出来
SpringApplication | Spring Boot主程序

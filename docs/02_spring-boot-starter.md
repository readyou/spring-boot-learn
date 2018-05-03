# spring-boot-starter
在前面我们创建工程的时候，选择了依赖`Web`，我们打开`pom.xml`，将看到
```
	...
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.10.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	...
		<dependencies>
    		<dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter-web</artifactId>
    		</dependency>
	...
```

1. 这里的dependency里面没有`version`标签，这是为什么呢？因为我们继承了`spring-boot-starter-parent`，该包中加入了大部分我们需要的依赖包及其版本号，根据mvn的依赖继承原理，我们这里就不需要再写版本号了。
1. 我们的第一个依赖`spring-boot-starter-web`，它包含了编写一个web站点需要的东西，比如我们要使用的注解：`@SpringBootApplication`, `@RestController`, `@RequestMapping`, `@ResponseBody`，等等。

我们之后会经常使用别人写好的`starter`，必要的时候也需要自己写。为了弄清楚其中的原委，我们接下来写一个试试。

## 重构项目结构
### 1. 添加目录`learn-app`，将`src`目录移动到`learn-app`下，修改顶层`pom.xml`。

```
    ...
	<packaging>pom</packaging>
    ...
    	<modules>
    		<module>learn-app</module>
    	</modules>
    ...
```
1. 修改`packaging`为pom。
2. 添加`modules`标签，将`learn-app`模块引进来。

这一步不是必需的，只是为了方便我们以后的开发，也顺便演示一下项目结构的重构技巧。

### 2. 在learn-app下添加`pom.xml`
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<artifactId>learn-app</artifactId>
	<packaging>jar</packaging>

	<name>learn-app</name>
	<description>spring-boot-learn-app</description>

	<parent>
		<groupId>me.readyou</groupId>
		<artifactId>spring-boot-learn</artifactId>
		<version>0.0.1-SNAPSHOT</version>
	</parent>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
</project>
```
这里主要修改了parent标签。

### 3. 在`Maven Projects`窗口的`learn-app`下重新创建`Debug Configuration`（见工程初始化）

## 创建包`string-handler-spring-boot-starter`
通常写一个starter需要包含以下几个部分：
1. 主服务类：将来会通过`Autowired`使用的类。
1. 属性配置类：用来从配置文件或配置服务器获取配置。
1. 自动配置类：根据配置的属性，生成主服务类的对象，注入到系统中。
1. 将自动配置类添加到`resources/META-INF/spring.factories`文件中，没有这一步的话，上面一步不生效，即通过本配置，才能让系统找到相应的自动配置类，并进行依赖注入。

1. 新建目录与文件
    ```
    ├── pom.xml
    ├── src
    │   └── main
    │       ├── java
    │       │   └── me
    │       │       └── readyou
    │       │           └── springbootlearn
    │       │               └── starter
    │       │                   └── stringhandler
    │       │                       ├── StringHandlerAutoConfiguration.java
    │       │                       ├── StringHandlerProperties.java
    │       │                       └── StringHandlerService.java
    │       └── resources
    │           └── META-INF
    │               └── spring.factories
    ```
1. 编辑`pom.xml`：
    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
    
        <groupId>me.readyou</groupId>
        <artifactId>string-handler-spring-boot-starter</artifactId>
        <packaging>jar</packaging>
        <version>0.0.1-SNAPSHOT</version>
    
        <name>string-handler-spring-boot-starter</name>
        <description>starter to log execute time of controller</description>
    
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-autoconfigure</artifactId>
            </dependency>
        </dependencies>
        <dependencyManagement>
            <dependencies>
                <dependency>
                     <!--Import dependency management from Spring Boot-->
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-dependencies</artifactId>
                    <version>1.5.2.RELEASE</version>
                    <type>pom</type>
                    <scope>import</scope>
                </dependency>
            </dependencies>
        </dependencyManagement>
    </project>
    ```
    
1. 编辑`StringHandlerService.java`：
    ```
    package me.readyou.springbootlearn.starter.stringhandler;
    
    /**
     * Created by wuxinlong on 18/5/2.
     */
    // 这是我们要提供的Service，但这里并不需要@service的注解
    // 因为我们在自动配置类中，会直接调用构造函数生成对象
    public class StringHandlerService {
        private int handleType;
    
        public StringHandlerService(int handleType) {
            this.handleType = handleType;
        }
    
        public String doHandle(String str) {
            if (str == null) {
                return null;
            }
    
            switch (handleType) {
                case 1:
                    return str.toLowerCase();
                case 2:
                    return str.toUpperCase();
                default:
                    return str.toUpperCase();
            }
        }
    }
    ```
    
1. 编辑`StringHandlerProperties.java`：
    ```
    package me.readyou.springbootlearn.starter.stringhandler;
    
    import org.springframework.boot.context.properties.ConfigurationProperties;
    
    /**
     * Created by wuxinlong on 18/5/2.
     */
    @ConfigurationProperties("spring.boot.learn.string.handler")
    public class StringHandlerProperties {
        private int handleType;
    
        public int getHandleType() {
            return handleType;
        }
    
        public StringHandlerProperties setHandleType(int handleType) {
            this.handleType = handleType;
            return this;
        }
    }
    ```

1. 编辑`StringHandlerAutoConfiguration.java`，通过`Autowired`使用`StringHandlerProperties`获取属性，并利用属性生成真正的Service对象：
    ```
    package me.readyou.springbootlearn.starter.stringhandler;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
    import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
    import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
    import org.springframework.boot.context.properties.EnableConfigurationProperties;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    
    /**
     * Created by wuxinlong on 18/5/2.
     */
    @Configuration
    @ConditionalOnClass(StringHandlerService.class)
    @EnableConfigurationProperties(StringHandlerProperties.class)
    public class StringHandlerAutoConfiguration {
        @Autowired
        private StringHandlerProperties stringHandlerProperties;
    
        @Bean
        @ConditionalOnMissingBean
        @ConditionalOnProperty(prefix = "spring.boot.learn.string.handler", value = "enabled", havingValue = "true")
        StringHandlerService exampleService() {
            return new StringHandlerService(stringHandlerProperties.getHandleType());
        }
    }
    ```
    解释一下这里的几个注解：`@Bean`表示生成一个新的Bean；`@ConditionalOnMissingBean`表示没有该类时才配置，防止重复配置；`@ConditionalOnProperty`只有属性满足某些条件时才生效。

1. 编辑`spring.factories`
    ```
    org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    me.readyou.springbootlearn.starter.stringhandler.StringHandlerAutoConfiguration
    ```

1. 执行命令`mvn install`安装包到本地仓库。


## 使用starter包
1. 添加依赖
    ```
    <!-- spring-boot-learn/pom.xml -->
    ...
                <dependency>
                    <groupId>me.readyou</groupId>
                    <artifactId>string-handler-spring-boot-starter</artifactId>
                    <version>0.0.1-SNAPSHOT</version>
                </dependency>
            </dependencies>
        </dependencyManagement>
    ...
    ```
    
    ```
    <!-- spring-boot-learn/learn-app/pom.xml -->
    ...
    		<dependency>
    			<groupId>me.readyou</groupId>
    			<artifactId>string-handler-spring-boot-starter</artifactId>
    		</dependency>
    	</dependencies>
    ...
    ```

1. 修改`spring-boot-learn/learn-app/src/main/resources/application.properties`，添加配置：
    ```
    spring.boot.learn.string.handler.enabled=true
    spring.boot.learn.string.handler.handleType=2
    ```
    
1. 在controller类中使用
```
// ...
public class HelloController {
    @Autowired
    private StringHandlerService stringHandlerService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        String msg = "Hello World!";
        return stringHandlerService.doHandle(msg);
    }
}
```

## 效果
1. 重启服务，浏览器中可以看到全小写的`hello world!`。
2. 修改配置项：`spring.boot.learn.string.handler.handleType=2`，重启服务，浏览器中可以看到全大写的`HELLO WORLD!`。


## 原文链接
[https://github.com/readyou/spring-boot-learn/blob/master/docs/01_project-init.md](https://github.com/readyou/spring-boot-learn/blob/master/docs/01_project-init.md)
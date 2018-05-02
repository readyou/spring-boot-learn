# spring-boot-starter
在前面我们创建工程的时候，选择了依赖`Web`，我们打开`pom.xml`，将看到
```
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
```

1. 这里的dependency里面没有`version`标签，这是为什么呢？因为我们继承了`spring-boot-starter-parent`，该包中加入了大部分我们需要的依赖包及其版本号，根据mvn的依赖继承原理，我们这里就不需要再写版本号了。
1. 我们的第一个依赖`spring-boot-starter-web`，它包含了编写一个web站点需要的东西，比如我们要使用的注解：`@SpringBootApplication`, `@RestController`, `@RequestMapping`, `@ResponseBody`。

我们之后会经常使用别人写好的starter，必要的时候也需要自己写starter。为了弄清楚其中的原委，我们接下来写一个试试。


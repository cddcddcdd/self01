添加logback配置文件：logback-spring.xml

备注1.springboot工程无需再额外引入包

因为spring-boot-starter其中包含了spring-boot-starter-logging，该依赖内容就是 Spring Boot 默认的日志框架就是logback。

备注2.文件名称：logback-spring.xml

默认文件名称可以为：logback.xml、logback-spring.xml。 但是logback.xml比application.yml 更早的去加载，所以如果要在logback定义里使用springProperty标签读取配置文件里变量的话就会出问题。 所以建议使用logback-spring.xml。  如果不是这两个名称，需要在配置文件中额外制定logback配置文件的名称。比如：

```
logging:
  config: classpath:logback-delayed.xml
```

备注3.使用springProfile标签实现多环境配置功能，可以根据配置文件激活的profile来进行配置环境的快速切换。
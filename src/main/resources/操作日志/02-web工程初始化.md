## 步骤

- 引入web、mapstruct依赖
- 定义web公共处理类
- 配置tomcat请求日志（可选）

### 1.引入依赖

引入web依赖

```
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <artifactId>*</artifactId>
                    <groupId>org.apache.logging.log4j</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>commons-logging</artifactId>
                    <groupId>commons-logging</groupId>
                </exclusion>
            </exclusions>
        </dependency>
```

引入mapstruct依赖优化代码

```
		<dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-jdk8</artifactId>
            <version>1.4.1.Final</version>
        </dependency>
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct</artifactId>
            <version>1.4.1.Final</version>
        </dependency>
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-processor</artifactId>
            <version>1.4.1.Final</version>
        </dependency>
```

### 2.定义web公共处理类

#### 2.1请求返回相关基本类

| 类名         | 作用           |
| ------------ | -------------- |
| ApiResponse  | 统一返回类     |
| PageRequest  | 分页请求基础类 |
| PageResponse | 分页返回基础类 |
| Sort         | 排序请求基础类 |
| PageUtil     | 分页转换工具类 |

#### 2.2web异常统一处理类

| 类名                   | 作用                                 |
| ---------------------- | ------------------------------------ |
| SystemExceptionHandler | 程序里未直接处理的异常在此处统一处理 |

#### 2.3引入mybatisplus本身分页插件

| 类名              | 作用                |
| ----------------- | ------------------- |
| MybatisPlusConfig | 引入mybatisplus插件 |

#### 2.4使用mapstruct统一处理bean映射转换

| 类名      | 作用                 |
| --------- | -------------------- |
| Convertor | bean映射转换统一处理 |

其它：正常创建controller、service、dao层

### 3.配置tomcat请求日志

```
tomcat:
    min-spare-threads: 50
    max-threads: 500
    accesslog:
      buffered: true
      enabled: true
      file-date-format: .yyyy-MM-dd
      pattern: '%h %l %u %t "%r" %s %b %D'
      prefix: access_log
      rename-on-rotate: false
      request-attributes-enabled: false
      rotate: true
      suffix: .log
      directory: logs
```


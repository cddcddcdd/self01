## 步骤：
- 引入依赖包：mybatis-plus-boot-starter
- 配置：application.yml 添加数据库配置、启动类中添加 @MapperScan 注解
- 编码：实体类、Mapper接口
- 使用

### 1.引入依赖
#### springboot工程本身引入
  1>父工程、 spring-boot-starter、spring-boot-starter-test. lombok(可选)

```
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.2.RELEASE</version>
    <relativePath/>
</parent>
```

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    </dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.20</version>
    <scope>compile</scope>
</dependency>
```

#### 2>引入mp依赖、数据库依赖（比如mysql）

mybatis-plus-boot-starter

```
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.1</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.16</version>
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

### 2.配置

1>application.yml 添加数据库配置

```
spring:
  datasource:
    url: jdbc:mysql://101.34.124.113:3306/self01?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8&useLegacyDatetimeCode=false&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useAffectedRows=true
    username: ${DATABASE_USERNAME:cdd}
    password: ${DATABASE_PASSWORD:xxx}
    driverClassName: com.mysql.cj.jdbc.Driver

#mp日志打印-形式1：
#mybatis-plus:
# configuration:
#  log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
#mp日志打印-形式2：
logging:
  level:
    com:
      cdd:
        self01:
          repository:
            mapper: debug
```

2>启动类中添加 @MapperScan 注解，扫描Mapper文件夹：

```
@MapperScan("com.cdd.self01.repository.mapper")
@SpringBootApplication
public class DatabaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }
}
```

### 3.编码

1>  编写实体类

```
@Data
@TableName("user")
public class UserPO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
```

2>编写Mapper包下的UserMapper接口

```
public interface UserMapper extends BaseMapper<UserPO> {
}
```

### 4.使用

添加测试类，进行功能测试：

```
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UserPO> userList = userMapper.selectList(null);
        Assert.assertEquals(2, userList.size());
        userList.forEach(System.out::println);
    }
}
```
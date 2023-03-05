步骤

- 上传jar
- 引入jar

## 1.仓库服务

自己学习使用阿里云的仓库服务：<https://packages.aliyun.com>

仓库提供的maven对应settings文件在附件里。

## 2.上传jar

针对maven工程，要打包上传到仓库。参考链接：https://packages.aliyun.com/repos/2345119-snapshot-RHrX2D/guide

### 2.1设置仓库凭证

在settings.xml文件<servers></servers>中设置以下仓库的访问凭证

```
<servers>
  <server>
    <id>rdc-releases</id>
    <username>************************</username>
    <password>************</password>
  </server>
  <server>
    <id>rdc-snapshots</id>
    <username>************************</username>
    <password>************</password>
  </server>
</servers>
```



### 2.2制品上传配置

在settings.xml文件<profiles></profiles>中添加以下配置

```
<profiles>
  <profile>
    <id>rdc</id>
    <properties>
      <altReleaseDeploymentRepository>
        rdc-releases::default::https://packages.aliyun.com/maven/repository/2345119-release-zshY0J/
      </altReleaseDeploymentRepository>
      <altSnapshotDeploymentRepository>
        rdc-snapshots::default::https://packages.aliyun.com/maven/repository/2345119-snapshot-RHrX2D/
      </altSnapshotDeploymentRepository>
    </properties>
  </profile>
</profiles>
```

在settings.xml文件<activeProfiles></activeProfiles>中添加以下配置

```
<activeProfiles>
  <activeProfile>rdc</activeProfile>
</activeProfiles>
```

### 2.3配置镜像来源（非必须，拉取时一定要用）

在settings.xml文件<mirrors></mirrors>中添加阿里云公库代理配置

```
<mirrors>
  <mirror>
    <id>mirror</id>
    <mirrorOf>central,jcenter,!rdc-releases,!rdc-snapshots</mirrorOf>
    <name>mirror</name>
    <url>https://maven.aliyun.com/nexus/content/groups/public</url>
  </mirror>
</mirrors>
```

### 2.4 推送（deploy）

在maven工程的pom文件中添加distributionManagement发布节点

```
<distributionManagement>
        <repository>
            <id>rdc-releases</id>
            <name>rdc-releases</name>
            <url>https://packages.aliyun.com/maven/repository/2345119-release-zshY0J/</url>
        </repository>
        <snapshotRepository>
            <id>rdc-snapshots</id>
            <name>rdc-snapshots</name>
            <url>https://packages.aliyun.com/maven/repository/2345119-snapshot-RHrX2D/</url>
        </snapshotRepository>
    </distributionManagement>
```

使用idea的界面上maven页面下Lifecycle下的**deploy**按钮进行推送。 

## 3.引入jar

### 3.1 设置仓库凭证

与2.1一样

### 3.2 配置镜像来源

与2.3一样

### 3.3 配置仓库和包信息

在settings.xml文件（或者项目的pom文件中）<repositories></repositories>节点中加入对应的仓库使用地址。

```
<repositories>
  <repository>
    <id>rdc-releases</id>
    <url>https://packages.aliyun.com/maven/repository/2345119-release-zshY0J/</url>
    <releases>
      <enabled>true</enabled>
    </releases>
    <snapshots>
      <enabled>false</enabled>
    </snapshots>
  </repository>
  <repository>
    <id>rdc-snapshots</id>
    <url>https://packages.aliyun.com/maven/repository/2345119-snapshot-RHrX2D/</url>
    <releases>
      <enabled>false</enabled>
      </releases>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>
```

在你的pom.xml文件<denpendencies></denpendencies>节点中加入你要引用的文件信息。

```
<dependencies>
  <dependency>
    <groupId>[GROUP_ID]</groupId>
    <artifactId>[ARTIFACT_ID]</artifactId>
    <version>[VERSION]</version>
  </dependency>
</dependencies>
```



## 4.常见奇怪错误

### 4.1 引入jar包不成功

原因1.  是否因为网络等问题突然导致，下载出问题

解决措施：进入本地仓库（.m2\repository下）对应删掉下载不成功的包，刷新重新引入。

原因2. settings.xml文件下的mirrors节点只有第一个mirror生效，

解决措施：把你需要的mirror调整到第一个，再不成功把其它的mirror的临时注释掉。 重启idea，刷新重新引入。

原因3. mirror下的mirrorOf配置错误，配置了*，然后配置的repository不起作用了。

解决措施：正确配置mirrorOf，比如本文中的2.3节配置的mirrorOf值，使用了!去排除了某些镜像id，然后配置的repository对应的镜像id特殊处理就生效了。

```
<mirrorOf>central,jcenter,!rdc-releases,!rdc-snapshots</mirrorOf>
```


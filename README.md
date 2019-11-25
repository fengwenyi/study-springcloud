
## 模块

注册中心
配置中心
网关
模块
    - 模块1
    - 模块2
    - 接口

```
study-springcloud
├── README.md                       // 说明
├── pom.xml                         // 项目依赖
├── springcloud-config              // 配置中心
├── springcloud-eureka              // 服务注册中心
├── springcloud-gateway             // 网关
└── springcloud-modules             // 模块
    └── springcloud-module-user     // 用户模块
```

## 服务注册中心

#### Spring Cloud Eureka

`服务端`

依赖：

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

配置：

```yaml
eureka:
  instance:
    # 配置eureka.instance.prefer-ip-address = true 
    # 就可以将IP注册到Eureka Server上，
    # 而如果不配置就是机器的主机名。
    prefer-ip-address: true
    # 自定义 ip
    # ip-address: 192.168.1.11
  client:
    # 注册自身到eureka服务器
    register-with-eureka: false
    # 表示是否从eureka服务器获取注册信息
    fetch-registry: false
    service-url:
      defaultZone: http://localhost:8761/eureka/
  server:
    # 关闭自我保护模式
    enable-self-preservation: false
```

eureka.instance.ip-address和eureka.instance.prefer-ip-address = true同时设置，会用自动获取的ip还是手动设置的？

答案是听eureka.instance.ip-address的

`客户端`

依赖：

```
<!-- eureka 客户端 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

配置：

```yaml
# Eureka
eureka:
  instance:
    prefer-ip-address: true
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

#### Zookeeper


## 配置中心

#### 服务

`服务端`

依赖：

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

配置：

```yaml
spring:
  application:
    name: SpringCloud-Config-Server
  profiles:
    active: native
  # 配置中心
  cloud:
    config:
      server:
        native:
          search-locations: classpath:/config/
```

`客户端`

依赖：

```
<!-- 配置 客户端 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

配置：

```yaml
spring:
  application:
    name: SpringCloud-Module-User

  profiles:
    active: dev

  # 配置中心
  cloud:
    config:
      fail-fast: true
      label: user
      name: ${spring.application.name}
      profile: ${spring.profiles.active}
      # 配discovery，可以不用配 uri
#      uri: http://localhost:9901
      send-state: true
      discovery:
        enabled: true
        service-id: SpringCloud-Config-Server
```

#### Git

#### Zookeeper

#### Consul

##  网关

依赖：

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```

配置：

```yaml
spring:
  main:
    allow-bean-definition-overriding: true
  cloud:        # spring cloud gateway 路由配置方式
    gateway:
      discovery:      #是否与服务发现组件进行结合，通过 serviceId(必须设置成大写) 转发到具体的服务实例。默认为false，设为true便开启通过服务中心的自动根据 serviceId 创建路由的功能。
        locator:      #路由访问方式：http://Gateway_HOST:Gateway_PORT/大写的serviceId/**，其中微服务应用名默认大写访问。
          enabled: true
          lowerCaseServiceId: true
      routes:
        -  id: SpringCloud-Module-Order                     #网关路由到订单
           uri: lb://SpringCloud-Module-Order
           predicates:
             - Path=/order/**
```

#### 通过时间匹配

```yaml
spring:
  cloud:
    gateway:
      routes:
       - id: time_route
        uri: http://ityouknow.com
        predicates:
         - After=2018-01-20T06:06:06+08:00[Asia/Shanghai]
```

#### 通过 Cookie 匹配

```yaml
spring:
  cloud:
    gateway:
      routes:
         - id: cookie_route
              uri: http://ityouknow.com
              predicates:
              - Cookie=ityouknow, kee.e
```

#### 通过 Header 属性匹配

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: header_route
        uri: http://ityouknow.com
        predicates:
        - Header=X-Request-Id, \d+
```

#### 通过 Host 匹配

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: host_route
        uri: http://ityouknow.com
        predicates:
        - Host=**.ityouknow.com
```

#### 通过请求方式匹配

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: method_route
        uri: http://ityouknow.com
        predicates:
        - Method=GET
```

#### 通过请求路径匹配

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: host_route
        uri: http://ityouknow.com
        predicates:
        - Path=/foo/{segment}
```

#### 通过请求参数匹配

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: query_route
        uri: http://ityouknow.com
        predicates:
        - Query=smile
```

#### 通过请求 ip 地址进行匹配

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: remoteaddr_route
        uri: http://ityouknow.com
        predicates:
        - RemoteAddr=192.168.1.1/24
```

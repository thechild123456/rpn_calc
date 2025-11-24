# SpringBoot 示例项目

这是一个完整的SpringBoot示例项目，展示了如何构建一个RESTful API服务，包括项目结构、配置文件、主类、控制器和示例数据。

## 项目结构

```
springboot-demo/
├── pom.xml                          # Maven配置文件
├── README.md                        # 项目说明文档
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── springbootdemo/
│   │   │               ├── SpringbootDemoApplication.java    # 主启动类
│   │   │               ├── config/
│   │   │               │   └── DataInitializer.java         # 数据初始化配置
│   │   │               ├── controller/
│   │   │               │   └── UserController.java          # REST控制器
│   │   │               ├── model/
│   │   │               │   └── User.java                    # 用户实体类
│   │   │               ├── repository/
│   │   │               │   └── UserRepository.java          # 数据访问层
│   │   │               └── service/
│   │   │                   └── UserService.java             # 业务逻辑层
│   │   └── resources/
│   │       ├── application.properties                       # 应用配置文件
│   │       └── application.yml                              # YAML格式配置文件
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── springbootdemo/
│                       └── SpringbootDemoApplicationTests.java # 测试类
```

## 技术栈

- **Spring Boot 3.2.0** - 核心框架
- **Spring Web** - Web开发
- **Spring Data JPA** - 数据访问
- **H2 Database** - 内存数据库
- **Hibernate** - ORM框架
- **Maven** - 构建工具
- **JUnit 5** - 测试框架

## 功能特性

- ✅ RESTful API设计
- ✅ 分层架构（Controller-Service-Repository）
- ✅ 数据持久化（JPA/Hibernate）
- ✅ 内存数据库（H2）
- ✅ 自动数据初始化
- ✅ 完整的CRUD操作
- ✅ 异常处理
- ✅ 日志记录

## API端点

### 用户管理API

| 方法 | 路径 | 描述 |
|------|------|------|
| GET | /api/users | 获取所有用户 |
| GET | /api/users/{id} | 根据ID获取用户 |
| POST | /api/users | 创建新用户 |
| PUT | /api/users/{id} | 更新用户信息 |
| DELETE | /api/users/{id} | 删除用户 |
| GET | /api/users/search?name={name} | 根据名称搜索用户 |
| GET | /api/users/age/above/{age} | 获取年龄大于指定值的用户 |
| GET | /api/users/email/{email} | 根据邮箱获取用户 |

## 快速开始

### 1. 克隆项目
```bash
git clone <repository-url>
cd springboot-demo
```

### 2. 构建项目
```bash
mvn clean install
```

### 3. 运行应用
```bash
mvn spring-boot:run
```

或者使用打包的jar文件：
```bash
java -jar target/springboot-demo-0.0.1-SNAPSHOT.jar
```

### 4. 访问应用

- **应用地址**: http://localhost:8080/api
- **H2控制台**: http://localhost:8080/api/h2-console
  - JDBC URL: jdbc:h2:mem:testdb
  - 用户名: sa
  - 密码: password

## 测试API

### 获取所有用户
```bash
curl http://localhost:8080/api/users
```

### 创建新用户
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "张三",
    "email": "zhangsan@example.com",
    "age": 28
  }'
```

### 根据ID获取用户
```bash
curl http://localhost:8080/api/users/1
```

### 更新用户
```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "李四",
    "email": "lisi@example.com",
    "age": 30
  }'
```

### 删除用户
```bash
curl -X DELETE http://localhost:8080/api/users/1
```

## 示例数据

应用启动时会自动插入以下示例数据：

| ID | 姓名 | 邮箱 | 年龄 |
|----|------|------|------|
| 1 | 张三 | zhangsan@example.com | 28 |
| 2 | 李四 | lisi@example.com | 32 |
| 3 | 王五 | wangwu@example.com | 25 |
| 4 | 赵六 | zhaoliu@example.com | 35 |
| 5 | 钱七 | qianqi@example.com | 29 |

## 配置说明

### application.properties
包含基本的应用配置，如端口、上下文路径等。

### application.yml
提供更详细的配置，包括：
- 数据库连接配置
- JPA/Hibernate配置
- 日志配置
- Jackson配置

## 开发说明

### 项目结构遵循最佳实践
- **Controller层**: 处理HTTP请求和响应
- **Service层**: 实现业务逻辑
- **Repository层**: 数据访问和持久化
- **Model层**: 定义数据模型

### 扩展建议
1. 添加用户认证和授权（Spring Security）
2. 集成Swagger/OpenAPI文档
3. 添加数据验证（Bean Validation）
4. 实现分页查询
5. 添加缓存支持（Redis）
6. 集成测试覆盖率报告

## 注意事项

- 本项目使用H2内存数据库，重启后数据会丢失
- 如需持久化存储，请配置外部数据库（如MySQL、PostgreSQL）
- 生产环境请修改默认配置和安全设置

## 许可证

MIT License
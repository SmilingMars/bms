## 1. 简介
bms（book management system）作为一个图书管理系统系统，提供了用户登录鉴权、图书信息管理的简易功能。其中，bms-web 是实现具体功能的模块。

该项目基于 SpringBoot ，并使用 Java8 进行开发，使用 H2 作为内存数据库，使用 MybatisPlus、Mybatis 作为持久层框架，使用 guava cache 作为本地缓存。

## 2. 演示

直接运行 BmsWebApplication.java 即可启动项目。

接口访问地址：http://localhost:7007

## 3. 接口

swagger 文档地址：http://localhost:7007/swagger-ui/index.html

**登录接口**

+ 接口文档：http://localhost:7007/swagger-ui/index.html#/%E7%99%BB%E5%BD%95%E6%8E%A5%E5%8F%A3/loginUsingPOST

+ 账号/密码：admin/damin

+ 请求示例

  ```curl
  curl --location --request POST 'localhost:7007/auth/login' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "name": "admin",
      "password": "admin"
  }'
  ```

+ 响应示例

  响应参数中的 model，即为后续接口鉴权所需的 accessToken（有效期为1小时）

  ```json
  {
      "state": "0",
      "msg": "请求成功",
      "model": "e67395b1-f342-4043-9a37-124b1da489d0"
  }
  ```

**登出接口、图书信息接口**

- 请求示例

  请求时，需携带从登录接口获取的 accessToken 作为请求头。

  ```curl
  curl --location --request POST 'localhost:7007/auth/logout' \
  --header 'accessToken: e67395b1-f342-4043-9a37-124b1da489d0'
  ```

  ```curl
  curl --location --request POST 'localhost:7007/book/add' \
  --header 'accessToken: e67395b1-f342-4043-9a37-124b1da489d0' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "isbn": "12345",
      "author": "rui",
      "name": "rui"
  }'
  ```

##4. H2

控制台地址：http://localhost:7007/h2

jdbc 链接：  jdbc:h2:mem:db

账号/密码：root/root

sql 文件：resources 目录下，h2/schema.sql、h2/data.sql

**注意！H2 为内存模式，应用关闭后，数据库数据即被清空。**

## 5. 关键类

**auth（登录鉴权模块）**

+ 接口 AuthController
+ 鉴权拦截器：AuthInterceptor
+ 允许不鉴权的注解：@NoAuth
+ userId上下文：UserIdHolder

**book（图书信息模块）**

+ 接口 BookController

**common（通用模块）**

+ 自定义服务异常：ServiceException
+ 统一异常处理类：ExceptionAdvice
+ 响应参数包装类：ResultBoxAdvice
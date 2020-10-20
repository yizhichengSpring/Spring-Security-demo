使用Spring Securiry 和 JWT 实现的登录鉴权操作,提供白名单功能
------
相关中间件

- 脚手架 Spring boot
- 无状态登录 JWT
- 鉴权 Spring Security
- ORM  MyBatis
- 工具 huool [https://www.hutool.cn/](https://www.hutool.cn/)
- 接口文档 [https://doc.xiaominfo.com/](https://doc.xiaominfo.com/)

------

### 第一步:

创建数据库**security-demo**，执行sql文件夹下的SQL脚本

### 第二步:

启动项目接口，端口号9000

### 第三步:

| 接口名称          | 接口url                                                      | 是否需要token |
| ----------------- | ------------------------------------------------------------ | ------------- |
| 登录接口          | localhost:9000/admin/login?userName=yizhicheng&password=123456 | 否            |
| 白名单接口        | localhost:9000/admin/noauth                                  | 否            |
| 需要携带token接口 | localhost:9000/admin/auth                                    | 是            |

### 接口文档

[localhost:9000/doc.html](localhost:9000/doc.html)



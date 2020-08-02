###


### 异常记录
####在使用JDBC连接MySql时报错：You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support
解决方法：
在配置文件中的 连接字符串后面加上?serverTimezone=UTC

UTC是统一标准世界时间

 完整的连接字符串示例：jdbc:mysql://localhost:3306/hello?serverTimezone=UTC

如果指定使用gmt+8时区，需要写成GMT%2B8，否则可能报解析为空的错误

https://www.cnblogs.com/appium/p/11214370.html
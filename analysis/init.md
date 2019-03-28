1. 创建POM文件，引入依赖，设置JDK版本，设置编码，设置resources目录
2. 添加.gitignore文件
3. IDEA中source目录无法创建java文件，可以手动将src/main/java标记为sources root
4. 创建数据库：
```
create database mybatis_analysis
```
5. 创建table：
```
create table user (
    id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    username varchar(20),
    sex varchar(20),
    age int,
    PRIMARY KEY (id)
)
```
6. 插入数据：
```
insert into user(username, sex, age) values
("aaa", "male", 18),
("bbb", "female", 18)
```

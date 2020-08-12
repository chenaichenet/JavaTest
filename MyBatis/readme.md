# Mybatis框架
```text
main：主文件夹
    java：源文件夹
    resource：资源文件夹
    webapp：web文件夹
test：测试源文件夹
pom.xml为依赖文件
```
## 笔记
### 框架概述
```text
MyBatis是一个基于Java的持久层框架。
MyBatis是一个SQL映射框架，提供数据库操作能力，增强的JDBC。
使用MyBatis让开发人员可以专注于SQL的处理，不必关心Connection，Statement，ResulSet的创建和销毁，SQL的执行。
```
### 第一个实例
```text
1、pom中引入mybatis框架依赖，对应数据库驱动。（针对xml文件不能正确加载的情况，在build中引入扫描插件）
2、编写dao、domain包文件，分别定义实体类、接口、及其实现类，在dao中，定义mapper映射文件。
3、在resource中定义mybatis配置文件，以及数据库的配置文件。
```
### 主要类的介绍
```text
1、Resources：mybatis中的一个类，负责读取主配置文件。
2、SqlSessionFactoryBuilder：创建SqlSessionFactory对象。
3、SqlSessionFactory：重量级对象，程序创建这个对象，耗时比较长，使用资源比较多。在整个项目中，有一个就够用了。
    1）SqlSessionFactory是一个接口，接口的实现类是DefaultSqlSessionFactory。
    2）SqlSessionFactory作用，通过openSession()，获取SqlSession对象。
    3）openSession()，无参时，获取的是非自动提交事务的SqlSession对象。
    4）opesSession(boolean)，为true时，获取的是自动提交事务的SqlSession对象。
4、SqlSession，一个接口，定义的操作数据的方法，例如selectOne()，selectList()，insert()等。
    5）其实现类是DefaultSqlSession。
    6）SqlSession对象不是线程安全的，需要在方法内使用，在执行sql语句之前，使用openSession()获取SqlSession对象，在执行完sql语句后需要关闭它。这样能保证它的使用是线程安全的。
```
### MyBatis中的Dao代理
```text
classmate包中使用的是传统的实现类；student包中使用的是动态代理。
```
```text
• 使用动态代理的要求
    ○ dao接口和mapper文件放在同一目录。
    ○ dao接口和mapper文件名称一致。
    ○ mapper文件中的namespace的值是dao接口的全限定名称。
    ○ mapper文件中的<select>等标签的id是接口中的方法名。
    ○ dao接口总不要使用重载方法，不要使用同名，不同参的方法。
```
### MyBatis动态SQL
```text
<if test="xxx"></if>

<where>
    <if></if>
</where>

<foreach collection="list" item="clsid" open="(" close=")" separator=",">
    #{clisd}
</foreach>
```
```text
对于foreach标签
    ○ collection：表示接口中的方法参数类型，如果是数组使用array，如果是list集合使用list。
    ○ open：循环开始的字符。
    ○ close：循环结束时的字符。
    ○ separator：集合成员之间的分隔符。
    ○ item：自定义的表示数组或集合成员的变量。
```
### MyBatis配置文件
```text
• <settings>：MyBatis中全局的调整设置，它们会改变MyBatis运行时行为，应谨慎设置。
• <typeAliases>：定义别名，两种方式：使用<typeAlias>，可以定义单个类的别名；使用<package>，可以对一个包中的所有类定义别名。
• <environments>：定义数据库连接信息。
    ○ <transactionManager>：事务的管理，type定义事务处理的类型。
        § JDBC：表示mybatis底层调用JDBC中的Connection对象的commit，rollback，来处理事务。
        § MANAGED：表示mybatis事务处理，委托给其他的容器（服务器软件，框架）。
    ○ <dataSource>：表示数据源，在Java体系中，规定实现了javax.sql.DataSource接口的都是数据源（数据源就是表示Connection对象的）。
        § type：指定数据源的类型。
        § POOLED：使用连接池，mybatis会创建PooledDataSource类。
        § UPOOLED：不使用连接池，在每一次执行sql语句，先创建连接，执行sql，再关闭连接。mybatis会创建一个UnPooledDataSource，管理Connection对象的使用。
        § JNDI：Java命名和目录服务（类似Windows的注册表）。
• <mappers>：sql映射文件的位置。
    ○ 使用<mapper>每次指定一个映射文件。有两种方式，resource属性，和class属性，用一种即可。
        § resource属性：指定映射文件，（mapper.xml）。
        § class属性：class指定的是mapper接口的地址，但是这时候就需要将接口类 和映射文件放在同一个目录下。
    ○ 使用<package name="mapper文件所在的包名"/>可以一次指定多个映射文件。
        § 使用该标签，需要mapper文件名和接口名称一样，且mapper文件和dao接口需要在同一个目录下。
```

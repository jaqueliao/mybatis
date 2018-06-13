package pojo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.jaque.pojo.User;

public class usertest {
	
	@Test
    public void test1() throws IOException {
        // 核心配置文件
        String resource = "SqlMapConfig.xml";
        // 通过流将核心配置文件加载进来
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过配置文件创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过会话工厂获取会话
        SqlSession openSession = factory.openSession();
        // 通过会话执行sql 第一个参数是名称空间+SqlID 第二个参数表示sql执行需要的参数
        User user = openSession.selectOne("test.findUserById", 1);
        System.out.println(user.toString());
        // 关闭会话
        openSession.close();

    }
	
	@Test
    public void test2() throws IOException {
        // 核心配置文件
        String resource = "SqlMapConfig.xml";
        // 通过流将核心配置文件加载进来
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过配置文件创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过会话工厂获取会话
        SqlSession openSession = factory.openSession();
        // 调用User.xml中的魔化查询方法 返回集合
        List<User> selectList = openSession.selectList("test.findUserByName", "张");
        // 循环结果
        System.out.println(selectList.size());
        for (User user : selectList) {
            System.out.println(user.toString());
        }
        // 关闭会话
        openSession.close();
    }
	@Test
    public void test3() throws IOException {
        // 核心配置文件
        String resource = "SqlMapConfig.xml";
        // 通过流将核心配置文件加载进来
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过配置文件创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过会话工厂获取会话
        SqlSession openSession = factory.openSession();
        // 创建需要插入的User对象
        User user = new User();
        user.setUsername("Jimisun");
        user.setSex("1");
        user.setAddress("北京");
        System.out.println("====插入前的User的id=" + user.getId());
        // 会话调用插入的sql
        openSession.insert("test.insertUser", user);
        // 默认mybatis自动开启事务,需要手动提交事务
        openSession.commit();
        System.out.println("====插入后的User的id=" + user.getId());
        // 关闭会话
        openSession.close();
    }
	
}

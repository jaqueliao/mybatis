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
        // ���������ļ�
        String resource = "SqlMapConfig.xml";
        // ͨ���������������ļ����ؽ���
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // ͨ�������ļ������Ự����
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // ͨ���Ự������ȡ�Ự
        SqlSession openSession = factory.openSession();
        // ͨ���Ựִ��sql ��һ�����������ƿռ�+SqlID �ڶ���������ʾsqlִ����Ҫ�Ĳ���
        User user = openSession.selectOne("test.findUserById", 1);
        System.out.println(user.toString());
        // �رջỰ
        openSession.close();

    }
	
	@Test
    public void test2() throws IOException {
        // ���������ļ�
        String resource = "SqlMapConfig.xml";
        // ͨ���������������ļ����ؽ���
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // ͨ�������ļ������Ự����
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // ͨ���Ự������ȡ�Ự
        SqlSession openSession = factory.openSession();
        // ����User.xml�е�ħ����ѯ���� ���ؼ���
        List<User> selectList = openSession.selectList("test.findUserByName", "��");
        // ѭ�����
        System.out.println(selectList.size());
        for (User user : selectList) {
            System.out.println(user.toString());
        }
        // �رջỰ
        openSession.close();
    }
	@Test
    public void test3() throws IOException {
        // ���������ļ�
        String resource = "SqlMapConfig.xml";
        // ͨ���������������ļ����ؽ���
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // ͨ�������ļ������Ự����
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // ͨ���Ự������ȡ�Ự
        SqlSession openSession = factory.openSession();
        // ������Ҫ�����User����
        User user = new User();
        user.setUsername("Jimisun");
        user.setSex("1");
        user.setAddress("����");
        System.out.println("====����ǰ��User��id=" + user.getId());
        // �Ự���ò����sql
        openSession.insert("test.insertUser", user);
        // Ĭ��mybatis�Զ���������,��Ҫ�ֶ��ύ����
        openSession.commit();
        System.out.println("====������User��id=" + user.getId());
        // �رջỰ
        openSession.close();
    }
	
}

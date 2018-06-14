package com.jaque.utils;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class SqlSessionUtil {

    public static SqlSession getSqlSession() throws Exception{
        String resource = "SqlMapConfig.xml";
         //ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
        InputStream is = Resources.getResourceAsStream(resource);
        //����sqlSession�Ĺ���
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
      //������ִ��ӳ���ļ���sql��sqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        return sqlSession;
    }
}
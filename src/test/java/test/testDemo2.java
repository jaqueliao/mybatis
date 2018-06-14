package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.jaque.mapper.UserMapper;
import com.jaque.pojo.User;
import com.jaque.utils.SqlSessionUtil;

public class testDemo2 {
	   @Test
	    public void testFindUserById() throws Exception{
	        // ͨ���Ự������ȡ�Ự
	        SqlSession openSession = SqlSessionUtil.getSqlSession();
	        //ͨ��getMapper������ʵ�����ӿ�
	        UserMapper mapper = openSession.getMapper(UserMapper.class);
	        
	        User user = mapper.findUserById(2);
	        System.out.println(user);
	    }
}

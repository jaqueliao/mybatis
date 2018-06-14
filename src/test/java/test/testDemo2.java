package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.jaque.mapper.UserMapper;
import com.jaque.pojo.User;
import com.jaque.utils.SqlSessionUtil;

public class testDemo2 {
	   @Test
	    public void testFindUserById() throws Exception{
	        // 通过会话工厂获取会话
	        SqlSession openSession = SqlSessionUtil.getSqlSession();
	        //通过getMapper方法来实例化接口
	        UserMapper mapper = openSession.getMapper(UserMapper.class);
	        
	        User user = mapper.findUserById(2);
	        System.out.println(user);
	    }
}

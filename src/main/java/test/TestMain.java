package test;

import cn.maybe.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;

public class TestMain {



    @Test
    public  void  testMybatis(){

        String resource ="mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            User user = session.selectOne("findById",1);
            session.commit();
            System.out.println(user.getUsername());
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}

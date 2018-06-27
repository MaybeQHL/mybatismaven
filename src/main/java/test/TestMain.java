package test;

import cn.maybe.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestMain {



    @Test
    public  void  testMybatis(){

        String resource ="mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            //创建会话工厂，传入mybatis的配置信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //通过工厂得到SqlSession
            SqlSession session = sqlSessionFactory.openSession();
            //通过SqlSession来操作数据库
            //List中的User泛型，和resultType中指定的类型一致
           //查询
            User user = session.selectOne("findById",1);
            List<User> userList = session.selectList("findUserListById",1);
            //查询(动态sql测试)
            List<User> userList2=session.selectList("findByUserName","张三");
            for (User item:
                   userList2) {
                System.out.println("动态"+item.getUsername());
            }
           //添加
            User  userNew=new User();
            userNew.setUsername("asd");
            userNew.setSex(1);
            session.insert("insertUser",userNew);
            System.out.println(userNew.getId());
           //删除
            session.delete("deleteUser",userNew.getId());
            //提交事务
            session.commit();
            //释放资源
            session.close();
//            for (User item:userList) {
//                System.out.println(item.getUsername());
//
//            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}

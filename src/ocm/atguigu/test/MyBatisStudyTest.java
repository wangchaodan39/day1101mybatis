package ocm.atguigu.test;

import ocm.atguigu.Employee;
import ocm.atguigu.dao.EmployeeMapper;
import ocm.atguigu.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class MyBatisStudyTest {

    @Test
    public  void test05()throws  Exception{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
//            Employee employee = mapper.getEmpById(1);
//            System.out.println(employee);
            Employee empAndDept = mapper.getEmpAndDept(1);
            System.out.println(empAndDept);
            System.out.println(empAndDept.getDept());

        } finally {
              sqlSession.close();
        }

    }

//    @Test
//    public void test3()throws Exception{
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        try{
//            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            Employee employee=new Employee(null,"later","1","wangyi@163.com");
//            mapper.addEmployee(employee);
//            System.out.println(employee.getId());
//
//            sqlSession.commit();
//
//        } finally {
//
//        }
//        sqlSession.close();
//
//
//
//    }



    @Test
    public void test()throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Employee employee = sqlSession.selectOne("com.atgui.mybatis.EmployeeMapper.selectEmp", 1);
        System.out.println(employee);
        sqlSession.close();

    }

    public SqlSessionFactory getSqlSessionFactory() throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
          return sqlSessionFactory;


    }

    @Test
    public void TestInterFace()throws Exception{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmployee(1);

        System.out.println( employee);

        sqlSession.close();


    }

}
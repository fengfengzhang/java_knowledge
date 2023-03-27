package com.zhangfeng.mybatis;

import com.zhangfeng.mybatis.bean.Department;
import com.zhangfeng.mybatis.bean.Employee;
import com.zhangfeng.mybatis.mapper.DepartmentMapper;
import com.zhangfeng.mybatis.mapper.EmployeeMapper;
import com.zhangfeng.mybatis.mapper.EmployeeMapperAnnotation;
import com.zhangfeng.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 1、接口式编程
 * 	原生：		Dao		====>  DaoImpl
 * 	mybatis：	Mapper	====>  xxMapper.xml
 *
 * 2、SqlSession代表和数据库的一次会话；用完必须关闭；
 * 3、SqlSession和connection一样她都是非线程安全。每次使用都应该去获取新的对象。
 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
 * 		（将接口和xml进行绑定）
 * 		EmployeeMapper empMapper =	sqlSession.getMapper(EmployeeMapper.class);
 * 5、两个重要的配置文件：
 * 		mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统运行环境信息
 * 		sql映射文件：保存了每一个sql语句的映射信息：
 * 					将sql抽取出来。
 *
 *
 */
/**
 * @ClassName MyBatisTest
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/27 22:56
 */
public class MyBatisTest {

    @Test
    public void test01() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpById(1);
        System.out.println(employee);

        EmployeeMapperAnnotation employeeMapperAnnotation = sqlSession.getMapper(EmployeeMapperAnnotation.class);
        employee = employeeMapperAnnotation.getEmpById(1);
        System.out.println(employee);
        sqlSession.close();

    }


    /**
     * 测试增删改
     * 1、mybatis允许增删改直接定义以下类型返回值
     * 		Integer、Long、Boolean、void
     * 2、我们需要手动提交数据
     * 		sqlSessionFactory.openSession();===》手动提交
     * 		sqlSessionFactory.openSession(true);===》自动提交
     * @throws IOException
     */
    @Test
    public void test02() throws IOException{


        //1、获取到的SqlSession不会自动提交数据
        SqlSession openSession = SqlSessionUtils.getSqlSession();

        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            //测试添加
           /* Employee employee = new Employee(null, "jerry4",null, "1");
            mapper.addEmp(employee);
            System.out.println(employee.getId());*/

            //测试修改
            Employee employee = new Employee(1, "Tom", "jerry@atguigu.com", "0");
            boolean updateEmp = mapper.updateEmp(employee);
            System.out.println(updateEmp);
            //测试删除
            //mapper.deleteEmpById(2);
            //2、手动提交数据
            openSession.commit();
        }finally{
            openSession.close();
        }

    }


    @Test
    public void test03() throws IOException{


        //1、获取到的SqlSession不会自动提交数据
        SqlSession openSession = SqlSessionUtils.getSqlSession();

        try{
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            //Employee employee = mapper.getEmpByIdAndLastName(1, "tom");
            Map<String, Object> map = new HashMap<>();
            map.put("id", 2);
            map.put("lastName", "Tom");
            map.put("tableName", "tbl_employee");
            Employee employee = mapper.getEmpByMap(map);

            System.out.println(employee);

			/*List<Employee> like = mapper.getEmpsByLastNameLike("%e%");
			for (Employee employee : like) {
				System.out.println(employee);
			}*/

			/*Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
			System.out.println(map);*/
			/*Map<String, Employee> map = mapper.getEmpByLastNameLikeReturnMap("%r%");
			System.out.println(map);*/

        }finally{
            openSession.close();
        }
    }



    @Test
    public void test04() throws IOException{
        SqlSession openSession = SqlSessionUtils.getSqlSession();

        try{
            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
			/*Department department = mapper.getDeptByIdPlus(1);
			System.out.println(department);
			System.out.println(department.getEmps());*/
            Department deptByIdStep = mapper.getDeptByIdStep(1);
            System.out.println(deptByIdStep.getDepartmentName());
            System.out.println(deptByIdStep.getEmps());
        }finally{
            openSession.close();
        }
    }
}

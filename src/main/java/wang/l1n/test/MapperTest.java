package wang.l1n.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wang.l1n.dao.DepartmentMapper;
import wang.l1n.dao.EmployeeMapper;
import wang.l1n.entity.Department;
import wang.l1n.entity.Employee;

import java.util.UUID;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/3/31 20:40
 * @description:  测试dao层
 * @ContextConfiguration:  指定Spring配置文件的位置
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void test01() {
        System.out.println(departmentMapper);

//        插入部门
//        departmentMapper.insertSelective(new Department(1,"开发部"));
//        departmentMapper.insertSelective(new Department(2,"测试部"));

//        employeeMapper.insertSelective(new Employee(null,"jerry","M","l1nker4@outlook.com",1));

        //批量插入
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i=0;i<100;i++){
            String uid = UUID.randomUUID().toString().substring(0,5) +i;
            employeeMapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));
        }
        System.out.println("运行完成");

    }
}

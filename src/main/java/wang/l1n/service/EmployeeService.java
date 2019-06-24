package wang.l1n.service;

import wang.l1n.entity.Employee;

import java.util.List;

/**
 * @author ：L1nker4
 * @date ： 创建于  2019/4/2 13:26
 * @description：
 */
public interface EmployeeService {
    public List<Employee> getAll();

    List<Employee> getEmps();

    void saveEmp(Employee employee);

    boolean checkUser(String empName);

    Employee getEmp(Integer id);

    void updateEmp(Employee employee);

    void deleteEmp(Integer id);

    void deleteBatch(List<Integer> ids);
}

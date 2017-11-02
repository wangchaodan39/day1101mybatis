package ocm.atguigu.dao;

import ocm.atguigu.Employee;
import org.omg.CORBA.portable.ValueOutputStream;

public interface EmployeeMapper {


    //查询
    public Employee getEmployee(Integer id);
    //添加
    public void  addEmployee(Employee employee);


    //删除
    public void  deleteEmployee(Integer id);


    //修改
     public void updateEmployee(Employee employee);

}

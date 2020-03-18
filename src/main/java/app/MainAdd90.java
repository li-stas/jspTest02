package app;

import app.model.Dept;
import app.model.Emp;
import app.services.DeptService;
import app.services.DeptServiceImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainAdd90 {
    public static void main(String[] args) throws SQLException {
        DeptService deptService = new DeptServiceImpl();

        Dept dept = new Dept(90,"Auto90","Sumy");
        deptService.saveDept(dept);

        Emp emp9000 = new Emp(9000, "DAVID", "SALESMAN",7698,
                LocalDateTime.parse("1991-09-29", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                1550,1700);
        emp9000.setDept(dept);
        dept.addEmp(emp9000);

        Emp emp9001 = new Emp(9001, "OLGA", "SALESMAN",7698,
                LocalDateTime.parse("2013-09-04",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                1999,999);
        emp9001.setDept(dept);
        dept.addEmp(emp9001);
        deptService.updateDept(dept);
    }
}

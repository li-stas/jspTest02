package app.services;

import app.model.Dept;
import app.model.Emp;

import java.util.List;

public interface DeptService {
    Dept findDept(int deptno);
    void saveDept(Dept dept);
    void deleteDept(Dept dept);
    void updateDept(Dept dept);
    List<Dept> findAllDepts();
    Emp findEmpByDeptNo(int deptno);
}

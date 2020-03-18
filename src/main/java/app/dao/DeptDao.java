package app.dao;

import app.model.Dept;
import app.model.Emp;


import java.util.List;

public interface DeptDao {
    Dept findByDeptNo(int deptno);
    void save(Dept dept);
    void update(Dept dept);
    void delete(Dept dept);
    Emp findEmpByDeptNo(int deptno);
    List<Dept> findAll();
}

package app.services;

import app.dao.DeptDao;
import app.dao.DeptDaoImpl;
import app.model.Dept;
import app.model.Emp;

import java.util.List;

public class DeptServiceImpl implements DeptService {

    private DeptDao deptsDao = new DeptDaoImpl();

    public DeptServiceImpl() {
    }

    public Dept findDept(int deptno) {
        return deptsDao.findByDeptNo(deptno);
    }

    public void saveDept(Dept dept) {
        deptsDao.save(dept);
    }

    public void deleteDept(Dept dept) {
        deptsDao.delete(dept);
    }

    public void updateDept(Dept dept) {
        deptsDao.update(dept);
    }

    public List<Dept> findAllDepts() {
        return deptsDao.findAll();
    }

    public Emp findEmpByDeptNo(int depno) {
        return deptsDao.findEmpByDeptNo(depno);
    }
}

package app.dao;

import app.model.Dept;
import app.model.Emp;
import app.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeptDaoImpl implements DeptDao {

    @Override
    public Dept findByDeptNo(int deptno) {
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Dept dept = session.get(Dept.class, deptno);
        session.close();

        return dept;
    }


    @Override
    public void save(Dept dept) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(dept);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Dept dept) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(dept);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Dept dept) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(dept);
        tx1.commit();
        session.close();
    }


    @Override
    public Emp findEmpByDeptNo(int depno) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Emp emp = session.get(Emp.class, depno);
        session.close();

        return emp;
    }

    @Override
    public List<Dept> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Dept> depts = (List<Dept>) session.createQuery("From Dept").list();
        session.close();

        return depts;
    }
}

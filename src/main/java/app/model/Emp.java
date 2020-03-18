package app.model;
import app.services.LocalDateTimeAttributeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table (name = "emp")
public class Emp {
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице

    @Id
    @Column(name = "empno")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int empno; //NUMERIC(4) NOT NULL,

    @Column(name = "ename")
    private String ename; //VARCHAR(10) NOT NULL,

    @Column(name = "job")
    private String job;// VARCHAR(10) NOT NULL,

    @Column(name = "mgr")
    private int mgr; // NUMERIC(4),

    @Column(name = "hiredate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime hiredate; // DATE NOT NULL,

    @Column(name = "sal")
    private float sal; // FLOAT NOT NULL,

    @Column(name = "comm")
    private float comm; //FLOAT,    //

    /*
     поле deptno с аннотацией @ManyToOne (многим EmpNo может соответствовать один DepNo)
     и аннотацию @JoinColumn. Она указывает, через какой столбец в таблице Emp происходит связь с таблицей Dept
     тот самый внешний ключ, о котором мы говорили ранее).
         */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptno")
    /*private int deptno; // NUMERIC(2),*/
    private Dept dept;

    public Emp() {
    }

    public Emp(String ename, String job, int mgr,  LocalDateTime hiredate, float sal, float comm) {
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;

    }

    public Emp(int empno, String ename, String job, int mgr,  LocalDateTime hiredate, float sal, float comm) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
    }

    public Emp(int empno, String ename, String job, int mgr,  LocalDateTime hiredate, float sal) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public  LocalDateTime getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDateTime hiredate) {
        this.hiredate = hiredate;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    public float getComm() {
        return comm;
    }

    public void setComm(float comm) {
        this.comm = comm;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return empno == emp.empno &&
                mgr == emp.mgr &&
                Float.compare(emp.sal, sal) == 0 &&
                Float.compare(emp.comm, comm) == 0 &&
                Objects.equals(ename, emp.ename) &&
                Objects.equals(job, emp.job) &&
                Objects.equals(hiredate, emp.hiredate) &&
                Objects.equals(dept, emp.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno, ename, job, mgr, hiredate, sal, comm, dept);
    }

    @Override
    public String toString() {
        return "model.Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                '}';
    }
}

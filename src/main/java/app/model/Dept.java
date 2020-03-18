package app.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "dept")
public class Dept {

    @Id
    @Column(name = "deptno")
    //@GeneratedValue(strategy = GenerationType.AUTO) // GenerationType.IDENTITY
    private int deptno; // NUMERIC(2) NOT NuLL,

    @Column(name = "dname")
    private String dname; // VARCHAR(15) NOT NULL,
    @Column(name = "loc")
    private String loc; // VARCHAR(15) NOT NULL,
    /*
    аннотация @OneToMany. Она означает, что одному объекту класса Dept может соответствовать несколько Работников(Emp).
    Настройка "mappedBY" указывает на поле depno класса Emp. Таким образом Работники(Emp) и Dept связаны между с собой.
    Настройка orphanRemoval вполне хорошо переводится с английского — "удалять сирот". Если мы удалим DeptNo (отдел)
    из  БД — все связанные с ним Работники (EmpNo) также будут удалены.
     */
    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Emp> emps;

    public Dept() {
    }

    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
        emps = new ArrayList<>();
    }
    public Dept( String dname, String loc) {
        this.dname = dname;
        this.loc = loc;
        emps = new ArrayList<>();
    }

    public void addEmp(Emp emp) {
        emp.setDept(this);
        emps.add(emp);
    }
    public void removeEmp(Emp emp) {
        emps.remove(emp);
    }

    int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return deptno == dept.deptno &&
                Objects.equals(dname, dept.dname) &&
                Objects.equals(loc, dept.loc) &&
                Objects.equals(emps, dept.emps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptno, dname, loc, emps);
    }

    @Override
    public String toString() {
        return "model.Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}

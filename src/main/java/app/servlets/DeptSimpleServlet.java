package app.servlets;

import app.model.Dept;
import app.services.DeptService;
import app.services.DeptServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeptSimpleServlet extends HttpServlet {

    private DeptService service = new DeptServiceImpl();

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Dept> dept = service.findAllDepts();
        req.setAttribute("dept", dept);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showDept.jsp");
        dispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");
        Dept dept = new Dept(dname, loc);
        service.saveDept(dept);
        resp.sendRedirect("/depts");

    }

    @Override
    protected void	doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        Dept dept = service.findDept(deptno);
        dept.setDname(req.getParameter("dname"));
        dept.setLoc(req.getParameter("loc"));
        service.updateDept(dept);
        resp.sendRedirect("/depts");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        service.deleteDept(service.findDept(deptno));
        resp.sendRedirect("/depts");
    }
}
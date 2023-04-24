/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa05;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo Mencías
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long> {

    @Override
    public Empleado create(Empleado p) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();

        session.save(p);

        t.commit();
        session.close();;
        return p;

    }

    @Override
    public boolean delete(Long id) {
        

        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        Empleado emp = findById(id);
        boolean res = false;

        if(emp==null){
            res=false;
        }else{
            session.delete(emp);
            res= true;
        }
        
        t.commit();
        session.close();
        
        return res;

    }

    @Override
    public Empleado update(Empleado p, Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        Empleado emp = findById(id);

        if(emp!=null)
            session.update(p);

        
        t.commit();
        session.close();
        return emp;
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> listaEmpleados = null;
        Session session = HibernateUtil.getSession();
        Transaction t= session.beginTransaction();

        listaEmpleados = session.createQuery("FROM usuarios").list();
        t.commit();
        session.close();
        return listaEmpleados;
    }

    @Override
    public Empleado findById(Long id) {
        Empleado emp = null;
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        emp = session.get(Empleado.class, id);
        
        t.commit();
        session.close();
        return emp;
    }

}

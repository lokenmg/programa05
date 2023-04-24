/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa05;

import org.hibernate.Session;

/**
 *
 * @author Rodrigo Mencías
 */
public class Programa05 {

    public static void main(String[] args) {
        DAOEmpleado dao=new DAOEmpleado();
        Empleado emp= new Empleado();
        
        //emp.setClave(11);
        emp.setNombre("rodrigo");
        emp.setDireccion("mariano");
        emp.setTelefono("7896541230");
        
        dao.create(emp);
       long a=11;
//        dao.delete(a);
    }
}

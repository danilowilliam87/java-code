package modulo_jdbc;

import modulo_jdbc.db.CrudDepartment;
import modulo_jdbc.db.DB;
import modulo_jdbc.model.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            Department department = new Department( "utilities2");
            CrudDepartment crudDepartment = new CrudDepartment();

            int novoId = crudDepartment.salvar(department);
            System.out.println("novo id : " + novoId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

package modulo_jdbc.service.impl;

import modulo_jdbc.db.DB;
import modulo_jdbc.service.DepartmentDao;
import modulo_jdbc.service.SellerDao;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoImpl(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao(){
//        return new DepartmentDaoImpl();
        return null;
    }
}

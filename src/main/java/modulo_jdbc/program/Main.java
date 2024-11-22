package modulo_jdbc.program;

import modulo_jdbc.model.Department;
import modulo_jdbc.model.Seller;
import modulo_jdbc.service.SellerDao;
import modulo_jdbc.service.impl.DaoFactory;
import modulo_jdbc.service.impl.SellerDaoImpl;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(7);
        System.out.println("=== TESTE FIND BY ID SELLER ===");
        System.out.println(seller);
        System.out.println();
        System.out.println("=== TESTE FIND ALL BY ID SELLER ===");
        Department department = new Department(1, null);
        List<Seller>sellers = sellerDao.findAllByDepartment(department);
        sellers.forEach(System.out::println);
        System.out.println();
        System.out.println("=== TESTE FIND ALL  SELLER ===");
        sellers = sellerDao.findAll();
        sellers.forEach(System.out::println);
        System.out.println();
        System.out.println("=== TESTE INSERT SELLER ===");
        Department department1 = new Department( 2, null);
        Seller seller1 = new Seller(7,"Tony Stark","homemdeferro@teste.com",new Date(), 10000.00, department1);
        sellerDao.update(seller1);
        System.out.println();
        System.out.println("=== TESTE UPDATE SELLER ===");
        System.out.println(sellerDao.findById(7));
        System.out.println("=== TESTE DELETE SELLER ===");
        sellerDao.deleteByd(7);
        System.out.println("== BUSCANDO REGISTRO APOS EXCLUSÃO");
        System.out.println(sellerDao.findById(7));


    }
}

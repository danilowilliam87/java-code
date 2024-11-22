package modulo_jdbc.service;

import modulo_jdbc.model.Department;
import modulo_jdbc.model.Seller;

import java.util.List;

public interface SellerDao {

    void insert(Seller seller);
    void update(Seller seller);
    void deleteByd(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findAllByDepartment(Department department);
}

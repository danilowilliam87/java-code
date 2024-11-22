package modulo_jdbc.service;

import modulo_jdbc.model.Department;

import java.util.List;

public interface DepartmentDao {

    void insert(Department department);
    void update(Department department);
    void deleteByd(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}

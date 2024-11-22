package modulo_jdbc.service.impl;

import modulo_jdbc.db.DB;
import modulo_jdbc.db.DbException;
import modulo_jdbc.model.Department;
import modulo_jdbc.model.Seller;
import modulo_jdbc.service.SellerDao;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class SellerDaoImpl implements SellerDao {

    private Connection connection;

    public SellerDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller seller) {
        String sqlInsert = "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
      try {
          connection.setAutoCommit(false);
          preparedStatement = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
          preparedStatement.setString(1, seller.getName());
          preparedStatement.setString(2, seller.getEmail());
          preparedStatement.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
          preparedStatement.setDouble(4, seller.getBaseSalary());
          preparedStatement.setInt(5, seller.getDepartment().getId());
          int rowsAff = preparedStatement.executeUpdate();

          if(rowsAff > 0){
              ResultSet resultSet = preparedStatement.getGeneratedKeys();
              if(resultSet.next()){
                  seller.setId(resultSet.getInt(1));
              }
          }
          connection.commit();
      }catch (Exception e){
          try {
              System.out.println("INSERT ERROR : " + e.getMessage());
              connection.rollback();
          }catch (SQLException e1){
              throw new DbException("RollBack Error : " + e1.getMessage());
          }
      }finally {
          DB.closePreparedStatement(preparedStatement);
      }
    }

    @Override
    public void update(Seller seller) {
        String sqlUpdate = "UPDATE seller SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? " +
                "WHERE Id = ?";
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sqlUpdate, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, seller.getName());
            preparedStatement.setString(2, seller.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
            preparedStatement.setDouble(4, seller.getBaseSalary());
            preparedStatement.setInt(5, seller.getDepartment().getId());
            preparedStatement.setInt(6, seller.getId());
            int rowsAff = preparedStatement.executeUpdate();

            if(rowsAff > 0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next()){
                    seller.setId(resultSet.getInt(1));
                }
            }
            connection.commit();
        }catch (Exception e){
            try {
                System.out.println("UPDATE ERROR : " + e.getMessage());
                connection.rollback();
            }catch (SQLException e1){
                throw new DbException("RollBack Error : " + e1.getMessage());
            }
        }finally {
            DB.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public void deleteByd(Integer id) {
        String sqlDelete = "DELETE from seller WHERE Id = ?";
        PreparedStatement preparedStatement = null;

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, id);
            int rowsAff = preparedStatement.executeUpdate();
            connection.commit();
        }catch (Exception exception){
            try {
                connection.rollback();
            }catch (Exception e){
                throw new DbException("RollBack Error : " + e.getMessage());
            }
        }finally {
            DB.closePreparedStatement(preparedStatement);
        }
    }

    @Override
    public Seller findById(Integer id) {
        String selectById = "SELECT seller.*, department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.Id " +
                            "WHERE seller.Id = ?";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if(Objects.nonNull(connection)){
            try {
                preparedStatement = this.connection.prepareStatement(selectById);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    Department department = createDepartment(resultSet);
                    return createSeller(resultSet, department);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                DB.closeResultSet(resultSet);
                DB.closePreparedStatement(preparedStatement);
            }
        }
        return null;
    }

    @Override
    public List<Seller> findAll() {
        String selectAll = "SELECT seller.*, department.Name as DepName " +
                "FROM seller INNER JOIN department " +
                "ON seller.DepartmentId = department.Id " +
                "ORDER BY Name";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Seller> sellers = new ArrayList<>();

        if(Objects.nonNull(connection)){
            try {
                preparedStatement = this.connection.prepareStatement(selectAll);
                resultSet = preparedStatement.executeQuery();
                Map<Integer, Department> map = new HashMap<>();
                while (resultSet.next()){
                    Department dep = map.get(resultSet.getInt("DepartmentId"));

                    if(Objects.isNull(dep)){
                        dep = createDepartment(resultSet);
                        map.put(resultSet.getInt("DepartmentId"), dep);
                    }

                    sellers.add(createSeller(resultSet, dep));
                }
                return sellers;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                DB.closeResultSet(resultSet);
                DB.closePreparedStatement(preparedStatement);
            }
        }
        return List.of();
    }

    @Override
    public List<Seller> findAllByDepartment(Department department) {
        String selectById = "SELECT seller.*, department.Name as DepName " +
                "FROM seller INNER JOIN department " +
                "ON seller.DepartmentId = department.Id " +
                "WHERE DepartmentId = ? " +
                "ORDER BY Name";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Seller> sellers = new ArrayList<>();

        if(Objects.nonNull(connection)){
            try {
                preparedStatement = this.connection.prepareStatement(selectById);
                preparedStatement.setInt(1, department.getId());
                resultSet = preparedStatement.executeQuery();
                Map<Integer, Department> map = new HashMap<>();
                while (resultSet.next()){
                    Department dep = map.get(resultSet.getInt("DepartmentId"));

                    if(Objects.isNull(dep)){
                        dep = createDepartment(resultSet);
                        map.put(resultSet.getInt("DepartmentId"), dep);
                    }

                   sellers.add(createSeller(resultSet, dep));
                }
                return sellers;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                DB.closeResultSet(resultSet);
                DB.closePreparedStatement(preparedStatement);
            }
        }
        return List.of();
    }

    private Department createDepartment(ResultSet resultSet) throws SQLException {
        Integer departmentId = resultSet.getInt("DepartmentId");
        String departmentName = resultSet.getString("DepName");
        return new Department(departmentId, departmentName);
    }

    private Seller createSeller(ResultSet resultSet, Department department) throws SQLException {
        Integer idSeller = resultSet.getInt("Id");
        String name = resultSet.getString("Name");
        String email = resultSet.getString("Email");
        Double baseSalary = resultSet.getDouble("BaseSalary");
        Date birthDate = resultSet.getDate("BirthDate");
        return new Seller(idSeller, name, email, birthDate, baseSalary, department);
    }
}

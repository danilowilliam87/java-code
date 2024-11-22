package modulo_jdbc.db;

import modulo_jdbc.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CrudDepartment {




    public int salvar(Department department){
        int result = 0;
        int newId = 0;
        String sqlinsert = "INSERT INTO department(Name)" +
                           " VALUES(?);";
        Connection connection = DB.getConnection();
        try (
            PreparedStatement preparedStatement = connection.prepareStatement(sqlinsert, Statement.RETURN_GENERATED_KEYS)){
            connection.setAutoCommit(false);
            preparedStatement.setString(1, department.getName());

            int ok = preparedStatement.executeUpdate();

            if(ok > 0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()){
                    newId = resultSet.getInt(1);
                }
            }

            connection.commit();
        }catch (Exception e){
            try {
                connection.rollback();
            }catch (Exception e1){
                throw new CrudException("Erro ao realizar rollback");
            }
            throw new CrudException("Erro ao inserir Department : " + e.getMessage());
        }
        return newId;
    }

    public boolean atualizarDepartamento(int id, Department department){
        int result = 0;
        String sqlUpdate = "UPDATE department SET Name = ?" +
                           "WHERE Id = ?;";

        try (Connection connection = DB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)){
             preparedStatement.setInt(1, id);
             preparedStatement.setString(2, department.getName());
             return preparedStatement.executeUpdate() > 0;
        }catch (Exception e){
            throw new CrudException("Erro aop atualizar departamento : " + e.getMessage());
        }
    }

    public boolean deletarDepartamento(int idDepartamento){
        
        return false;
    }
}

package com.oftalmo.DAO;

import com.oftalmo.model.medicos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class medicosDAO extends conexaodb {

    private static final String INSERT_MEDICOS_SQL = "INSERT INTO medicos (nome, crm) VALUES (?,?);";
    private static final String SELECT_MEDICOS_BY_ID = "SELECT id, nome, crm FROM medicos WHERE id = ?";
    private static final String SELECT_ALL_MEDICOS = "SELECT * FROM medicos;";
    private static final String DELETE_MEDICOS_SQL = "DELETE FROM medicos WHERE id = ?;";
    private static final String UPDATE_MEDICOS_SQL = "UPDATE medicos SET nome = ?, crm = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medicos;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insertmedicos(medicos entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_MEDICOS_SQL)) {
            preparedStatement.setString(1, entidade.getnome());
            preparedStatement.setString(2, entidade.getcrm());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public medicos selectmedicos(int id) {
        medicos entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_MEDICOS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String crm = rs.getString("crm");
                entidade = new medicos(nome, crm, id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<medicos> selectAllmedicos() {
        List<medicos> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_MEDICOS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String crm = rs.getString("crm");
                entidades.add(new medicos(nome, crm, id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletemedicos(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_MEDICOS_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatemedicos(medicos entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_MEDICOS_SQL)) {
            statement.setString(1, entidade.getnome());
            statement.setString(2, entidade.getcrm());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

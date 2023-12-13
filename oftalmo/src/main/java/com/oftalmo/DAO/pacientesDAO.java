package com.oftalmo.DAO;

import com.oftalmo.model.pacientes;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class pacientesDAO extends conexaodb {

    private static final String INSERT_PACIENTES_SQL = "INSERT INTO pacientes (nome, cpf, dt_nascimento) VALUES (?,?,?);";
    private static final String SELECT_PACIENTES_BY_ID = "SELECT id, nome, cpf, dt_nascimento FROM pacientes WHERE id = ?";
    private static final String SELECT_ALL_PACIENTES = "SELECT * FROM pacientes;";
    private static final String DELETE_PACIENTES_SQL = "DELETE FROM pacientes WHERE id = ?;";
    private static final String UPDATE_PACIENTES_SQL = "UPDATE pacientes SET nome = ?, cpf = ?, dt_nascimento = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM pacientes;";

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

    public void insertpacientes(pacientes entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_PACIENTES_SQL)) {
            preparedStatement.setString(1, entidade.getnome());
            preparedStatement.setString(2, entidade.getcpf());
            preparedStatement.setDate(3, entidade.getdt_nascimento());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public pacientes selectpacientes(int id) {
        pacientes entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_PACIENTES_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date dt_nascimento = rs.getDate("dt_nascimento");
                entidade = new pacientes(nome, cpf, dt_nascimento, id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<pacientes> selectAllpacientes() {
        List<pacientes> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_PACIENTES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date dt_nascimento = rs.getDate("dt_nascimento");
                entidades.add(new pacientes(nome, cpf, dt_nascimento, id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletepacientes(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_PACIENTES_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatepacientes(pacientes entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_PACIENTES_SQL)) {
            statement.setString(1, entidade.getnome());
            statement.setString(2, entidade.getcpf());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

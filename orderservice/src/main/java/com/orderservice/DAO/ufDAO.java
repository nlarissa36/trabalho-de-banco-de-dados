package com.orderservice.DAO;

import com.oftalmo.model.uf;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ufDAO extends conexaodb {

    private static final String INSERT_UF_SQL = "INSERT INTO uf (descricao, codigo) VALUES (?,?);";
    private static final String SELECT_UF_BY_ID = "SELECT id, descricao, codigo FROM uf WHERE id = ?";
    private static final String SELECT_ALL_UF = "SELECT * FROM uf;";
    private static final String DELETE_UF_SQL = "DELETE FROM uf WHERE id = ?;";
    private static final String UPDATE_UF_SQL = "UPDATE uf SET descricao = ?, codigo = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM uf;";

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

    public void insertuf(ufDAO entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_UF_SQL)) {
            preparedStatement.setString(1, entidade.getdescricao());
            preparedStatement.setInt(2, entidade.getcodigo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ufDAO selectuf(int id) {
        ufDAO entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_UF_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Integer codigo = rs.getInt("codigo");
                entidade = new ufDAO(descricao, codigo, id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ufDAO> selectAlluf() {
        List<ufDAO> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_UF)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Integer codigo = rs.getInt("codigo");
                entidades.add(new ufDAO(descricao, codigo, id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteuf(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_UF_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateuf(ufDAO entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_UF_SQL)) {
            statement.setString(1, entidade.getdescricao());
            statement.setInt(2, entidade.getcodigo());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

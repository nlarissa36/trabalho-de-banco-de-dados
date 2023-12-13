package com.oftalmo.DAO;

import com.oftalmo.model.receitas_oculos;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class receitas_oculosDAO extends conexaodb {

    private static final String INSERT_RECEITA_OCULOS_SQL = "INSERT INTO receitas_oculos (detalhamento, dt_consulta, id_consulta_medica) VALUES (?,?,?);";
    private static final String SELECT_RECEITA_OCULOS_BY_ID = "SELECT id, detalhamento, dt_consulta, id_consulta_medica FROM receitas_oculos WHERE id = ?";
    private static final String SELECT_ALL_RECEITA_OCULOS = "SELECT * FROM receitas_oculos;";
    private static final String DELETE_RECEITA_OCULOS_SQL = "DELETE FROM receitas_oculos WHERE id = ?;";
    private static final String UPDATE_RECEITA_OCULOS_SQL = "UPDATE receitas_oculos SET detalhamento = ?, dt_consulta = ?, id_consulta_medica = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM receitas_oculos;";

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

    public void insertreceitas_oculos(receitas_oculos entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RECEITA_OCULOS_SQL)) {
            preparedStatement.setString(1, entidade.getdetalhamento());
            preparedStatement.setDate(2, entidade.getdt_consulta());
            preparedStatement.setInt(3, entidade.getid_consulta_medica());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public receitas_oculos selectreceitas_oculos(int id) {
        receitas_oculos entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RECEITA_OCULOS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String detalhamento = rs.getString("detalhamento");
                Date dt_consulta = rs.getDate("dt_consulta");
                Integer id_consulta_medica = rs.getInt("id_consulta_medica");
                entidade = new receitas_oculos(detalhamento, dt_consulta, id_consulta_medica, id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<receitas_oculos> selectAllreceitas_oculos() {
        List<receitas_oculos> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RECEITA_OCULOS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String detalhamento = rs.getString("detalhamento");
                Date dt_consulta = rs.getDate("dt_consulta");
                Integer id_consulta_medica = rs.getInt("id_consulta_medica");
                entidades.add(new receitas_oculos(detalhamento, dt_consulta, id_consulta_medica, id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletereceitas_oculos(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_RECEITA_OCULOS_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatereceitas_oculos(receitas_oculos entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_RECEITA_OCULOS_SQL)) {
            statement.setString(1, entidade.getdetalhamento());
            statement.setDate(2, entidade.getdt_consulta());
            statement.setInt(3, entidade.getid_consulta_medica());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

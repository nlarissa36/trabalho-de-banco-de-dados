package com.oftalmo.DAO;

import com.oftalmo.model.atributos_estrutura_lente;
import com.oftalmo.model.consultas_medicas;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class consultas_medicasDAO extends conexaodb {

    private static final String INSERT_CONSULTAS_MEDICAS_SQL = "INSERT INTO consultas_medicas (assinatura, dt_consulta) VALUES (?,?);";
    private static final String SELECT_CONSULTAS_MEDICAS_BY_ID = "SELECT id, assinatura, dt_consulta FROM consultas_medicas WHERE id = ?";
    private static final String SELECT_CONSULTAS_MEDICAS = "SELECT * FROM consultas_medicas;";
    private static final String DELETE_CONSULTAS_MEDICAS_SQL = "DELETE FROM consultas_medicas WHERE id = ?;";
    private static final String UPDATE_CONSULTAS_MEDICAS_SQL = "UPDATE consultas_medicas SET descricao = ?, lado_olho = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM consultas_medicas;";

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

    public void insertconsultas_medicas(consultas_medicas entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CONSULTAS_MEDICAS_SQL)) {
            preparedStatement.setString(1, entidade.getassinatura());
            preparedStatement.setDate(2, entidade.getdt_consulta());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public consultas_medicas selectconsultas_medicas(int id) {
        consultas_medicas entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CONSULTAS_MEDICAS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String assinatura = rs.getString("assinatura");
                String dt_consulta = rs.getString("dt_consulta");
                entidade = new consultas_medicas(assinatura, dt_consulta, id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<consultas_medicas> selectAllconsultas_medicas() {
        List<consultas_medicas> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONSULTAS_MEDICAS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                String lado_olho = rs.getString("lado_olho");
                entidades.add(new atributos_estrutura_lente(descricao, lado_olho, id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteconsultas_medicas(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ATRIBUTOS_ESTRUTURA_LENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateatributos_estrutura_lente(atributos_estrutura_lente entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ATRIBUTOS_ESTRUTURA_LENTE_SQL)) {
            statement.setString(1, entidade.getdescricao());
            statement.setString(2, entidade.getlado_olho());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

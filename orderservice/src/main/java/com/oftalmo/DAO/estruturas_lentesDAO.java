package com.oftalmo.DAO;

import com.oftalmo.model.estruturas_lentes;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class estruturas_lentesDAO extends conexaodb {

    private static final String INSERT_ESTRUTURAS_LENTES_SQL = "INSERT INTO estruturas_lentes (tipo_correcao, distancia_pupilar, id_receita_oculos) VALUES (?,?,?);";
    private static final String SELECT_ESTRUTURAS_LENTES_BY_ID = "SELECT id, tipo_correcao, distancia_pupilar, id_receita_oculos FROM estruturas_lentes WHERE id = ?";
    private static final String SELECT_ALL_ESTRUTURAS_LENTES = "SELECT * FROM estruturas_lentes;";
    private static final String DELETE_ESTRUTURAS_LENTES_SQL = "DELETE FROM estruturas_lentes WHERE id = ?;";
    private static final String UPDATE_ESTRUTURAS_LENTES_SQL = "UPDATE estruturas_lentes SET tipo_correcao = ?, distancia_pupilar = ?, id_receita_oculos = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM estruturas_lentes;";

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

    public void insertestruturas_lentes(estruturas_lentes entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_ESTRUTURAS_LENTES_SQL)) {
            preparedStatement.setString(1, entidade.gettipo_correcao());
            preparedStatement.setInt(2, entidade.getdistancia_pupilar());
            preparedStatement.setInt(3, entidade.getid_receita_oculos());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public estruturas_lentes selectestruturas_lentes(int id) {
        estruturas_lentes entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ESTRUTURAS_LENTES_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String tipo_correcao = rs.getString("tipo_correcao");
                Integer distancia_pupilar = rs.getInt("distancia_pupilar");
                Integer id_receita_oculos = rs.getInt("id_receita_oculos");
                entidade = new estruturas_lentes(tipo_correcao, distancia_pupilar,id_receita_oculos, id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<estruturas_lentes> selectAllestruturas_lentes() {
        List<estruturas_lentes> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_ESTRUTURAS_LENTES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo_correcao = rs.getString("tipo_correcao");
                Integer distancia_pupilar = rs.getInt("distancia_pupilar");
                Integer id_receita_oculos = rs.getInt("id_receita_oculos");
                entidades.add(new estruturas_lentes(tipo_correcao, distancia_pupilar, id_receita_oculos, id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteestruturas_lentes(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_ESTRUTURAS_LENTES_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateestruturas_lentes(estruturas_lentes entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_ESTRUTURAS_LENTES_SQL)) {
            statement.setString(1, entidade.gettipo_correcao());
            statement.setInt(2, entidade.getdistancia_pupilar());
            statement.setInt(3, entidade.getid_receita_oculos());
            statement.setInt(4, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

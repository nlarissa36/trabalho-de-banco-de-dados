package DAO;

import model.endereco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class enderecoDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO endereco (rua, numero, bairro, cep, id_cidade) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM endereco WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM endereco;";
    private static final String DELETE_SQL = "DELETE FROM endereco WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE endereco SET rua = ?, numero = ?, bairro = ?, cep = ?, id_cidade = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM endereco;";

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

    public void insertEndereco(endereco entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getRua());
            preparedStatement.setString(2, entidade.getNumero());
            preparedStatement.setString(3, entidade.getBairro());
            preparedStatement.setString(4, entidade.getCep());
            preparedStatement.setInt(5, entidade.getIdCidade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public endereco selectEndereco(int id) {
        endereco entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String rua = rs.getString("rua");
                String numero = rs.getString("numero");
                String bairro = rs.getString("bairro");
                String cep = rs.getString("cep");
                Integer idCidade = rs.getInt("idCidade");
                entidade = new endereco(rua, bairro, numero, cep, idCidade);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<endereco> selectAllEndereco() {
        List<endereco> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String rua = rs.getString("rua");
                String numero = rs.getString("numero");
                String bairro = rs.getString("bairro");
                String cep = rs.getString("cep");
                Integer idCidade = rs.getInt("idCidade");
                entidades.add(new endereco(rua, bairro, numero, cep, idCidade));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteEndereco(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateEndereco(endereco entidade, int id) throws SQLException {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getRua());
            preparedStatement.setString(2, entidade.getNumero());
            preparedStatement.setString(3, entidade.getBairro());
            preparedStatement.setString(4, entidade.getCep());
            preparedStatement.setInt(5, entidade.getIdCidade());
            preparedStatement.setInt(6, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
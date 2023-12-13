package DAO;

import model.cidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cidadeDAO extends ConexaoDB {

    private static final String INSERT_SQL = "INSERT INTO cidade (descricao, codigo, idUf) VALUES (?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT * FROM cidade WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM cidade;";
    private static final String DELETE_SQL = "DELETE FROM cidade WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE cidade SET descricao = ?, codigo = ?, idUf = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM cidade;";

    private static final String SELECT_UF = "SELECT descricao FROM uf WHERE id = ?;";

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
    public void verificaInsertIgual(String desc){
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)){
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                if (descricao.equals(desc)){
                    System.out.println("A descrição inserida já existe!");
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println("Houve algum erro no insert!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertCidade(cidade entidade){
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getCodigo());
            preparedStatement.setInt(3, entidade.getId_uf());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("O id da uf inserido não existe!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public cidade selectCidade(int id) {
        cidade entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Integer codigo = rs.getInt("codigo");
                Integer idUf = rs.getInt("idUf");
                entidade = new cidade(descricao, codigo, idUf);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e){
            System.out.println("O id informado não existe!");
        }
        return entidade;
    }
    public List<String> selectCidadeUf(int id, List<String> lista){
        try(PreparedStatement preparedStatement = prepararSQL(SELECT_UF)){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String descricao = rs.getString("descricao");
                lista.add(descricao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e){
            System.out.println("O id informado não existe!");
        }
        return lista;
    }
    public List<cidade> selectAllCidade() {

        List<cidade> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Integer codigo = rs.getInt("codigo");
                Integer idUf = rs.getInt("idUf");
                entidades.add(new cidade(descricao, codigo, idUf));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteCidade(int id){
        try (PreparedStatement statement = prepararSQL(DELETE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            System.out.println("Id inserido não existente!");
        }
        return false;
    }

    public boolean updateCidade(cidade entidade, int id) {
        try (PreparedStatement preparedStatement = prepararSQL(UPDATE_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getCodigo());
            preparedStatement.setInt(3, entidade.getId_uf());
            preparedStatement.setInt(4, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
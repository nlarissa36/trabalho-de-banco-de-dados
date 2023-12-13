
import java.sql.SQLException;
import java.util.List;

import com.oftalmo.DAO.ufDAO;
import com.oftalmo.model.uf;

public class teste_uf {

    public static void main(String[] args) throws SQLException {

        ufDAO ufDAO = new ufDAO();
        uf uf = new uf("ABC",1);
        

        //count
        System.out.println(ufDAO.count());

        //salvar
        ufDAO.insertuf(uf);

        //buscar por ID
        uf = ufDAO.selectuf(1);
        System.out.println(uf);

        //Update
        uf.setdescricao("Pediatra");
        ufDAO.updateuf(uf);
        uf = ufDAO.selectuf(1);
        System.out.println(uf);

        //Select all
        List<uf> marcas = ufDAO.selectAlluf();
        marcas.forEach(System.out::println);

        //Delete
        ufDAO.deleteuf(1);
        ufDAO.selectAlluf().forEach(System.out::println);

    }
    
}

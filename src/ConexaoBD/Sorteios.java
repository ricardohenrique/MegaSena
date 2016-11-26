/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;
//import br.uninove.poo.negocio.Carro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class Sorteios {
 
    //Método que retorna a lsta de carros, com todos os carros do sistema
    public List<Carro> getListaDeCarros() {
 
        try {
            //Conecta ao banco através da classe de conexão:
            Conexao con = new Conexao();
            con.getConexao();
 
            //Select na tablea de carros:
            String sql = "select * from sorteios;";
 
            //Executa a query
            PreparedStatement comando = con.getConexao().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
 
            //Prepara a lista de carros para retornar
            List<Carro> listaDeCarros = new ArrayList<Carro>();
 
            //para cada item retonrado no select, faça...
            while (resultado.next()) {
                Carro c = new Carro(); //Cria um carro novo na memória
                c.setId(resultado.getInt("id")); //Seta o ID dele
                c.setdezena_01(resultado.getString("dezena_01")); //Seta a primeira dezena
                c.setdezena_02(resultado.getString("dezena_02")); //Seta a segunda dezena
                c.setdezena_03(resultado.getString("dezena_03")); //Seta a terceira dezena
                c.setdezena_04(resultado.getDouble("dezena_04")); //Seta a qaurta dezena
                c.setdezena_05(resultado.getDouble("dezena_05")); //Seta a quinta dezena
                c.setdezena_06(resultado.getInt("dezena_06")); //Seta a sexta dezena
 
                //insere o carro na lista local
                listaDeCarros.add(c);
            }
 
            //Ao terminar o laço, fecha a conexão
            resultado.close();
            comando.close();
            con.getConexao().close();
 
            //Retorna a lista de carros
            return listaDeCarros;
 
        } catch (Exception e) { //Se der algum exessão...
            System.out.println(e.getMessage());
            return null;
        }
    }
}

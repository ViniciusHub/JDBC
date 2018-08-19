/*
 * Nome: Vinicius Gustavo de Oliveira
 * Data: 18/08/2018
 * Programa: Primeiro CRUD em JDBC no JavaPOO.
 */
package crud;

import java.sql.*;


public class Main {

       
    
    public static void main(String[] args) {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://ipdobanco/nomedobanco", "Usuario", "Senha");
//Conexão com o Banco//
            Statement minhaDeclaracao = cnx.createStatement();
//Interface utilizada para executar instruções SQL//
            ResultSet meuResultado = minhaDeclaracao.executeQuery("select * from empregado");
//Linha 21: Interface utilizada pra guardar dados vindos de um banco de dados nesse caso de um Select.//
            
            
                while (meuResultado.next()){
                    System.out.println(meuResultado.getString("ultimo_nome") + "," + meuResultado.getString("primeiro_nome"));
                }
//Printando resultado especificado("ultimo_nome , primeiro_nome") dentro do select da tabela empregado dado anteriormente.//
                        
                    String sql = "update empregado"
                                + " set email='vinipicuinha@hotmail.com' "
                                + " where id=1";
//Digitando outro comando para fazer, nesse caso o Update//
            
                        minhaDeclaracao.executeUpdate(sql);
//O Siginificado dessa linha é: "Dentro do objeto minhaDeclaracao pré compilado pela minha interface Statement.execute uma (atualização/inserção/delete no banco)// 
            
                        System.out.println("Update complete");
//Ver Status do programa//
            
            String sqla = "delete from empregado where id='1'";
//Digitando outro comando para fazer, nesse caso o Delete//    
            
            int rowsAffected = minhaDeclaracao.executeUpdate(sqla);
//Fazendo com que mostre as linhas afetadas pelo comando.//
         
            System.out.println("Rows affected: " + rowsAffected);
//Printando//   
         
            System.out.println("Delete complete");
//Ver Status do programa//  
         
            String sqlb = "insert into empregado"
                       + " (id, primeiro_nome, ultimo_nome, email)"
                       + " values ('3', 'Vinicius', 'Rocco', 'ViniciusRocco@gmail.com')";
//Digitando outro comando para fazer, nesse caso o Insert// 
            
            minhaDeclaracao.executeUpdate(sqlb);
//Executando comando//
            
            System.out.println("Insert Complete");
//Ver Status do programa//
            
        } catch (Exception exc) {
/**Caso tenha algum problema dentro do seu TRY ele vai para o CATCH**/

            exc.printStackTrace();
/**para vc saber qual foi o erro que deu vc pode usar o metodo printStackTrace() que tem dentro das classes "Exception"**/

        }
        
        
    }
    
}

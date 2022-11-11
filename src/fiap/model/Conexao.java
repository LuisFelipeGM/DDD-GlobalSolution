/**Classe para fazer a Conexao com o Banco de Dados no SQL Developer
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import java.sql.*;

public class Conexao {
	
	/**Metodo para abrir a conexao com o Banco de dados
	 * @author Luis Felipe
	 * @param null
	 * @return Connection - retorna a Conexao aberta 
	 */
	public static Connection abrirConexao() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			final String USER = "RM94051";
			final String PASS = "010903";
			con = DriverManager.getConnection(url,USER,PASS);
			//System.out.println("Conexao Aberta!");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	/**Metodo para fechar a conexao com o Banco de dados
	 * @author Luis Felipe
	 * @param con - a conexao aberta com o metodo abrirConexao()
	 * @return null
	 */
	public static void fecharConexao(Connection con) {
		try {
			con.close();
			//System.out.println("Conexao fechada!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
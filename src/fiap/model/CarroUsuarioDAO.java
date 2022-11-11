/**Classe para o CRUD dos objetos do tipo CarroUsuario no Banco de Dados utilizando a classe Conexao
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CarroUsuarioDAO implements IDAO{
	
	private Connection con;
	private CarroUsuario carroUsuario;
	
	public CarroUsuarioDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	/**Metodo para inserir um objeto CarroUsuario no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String inserir(Object obj) {
		carroUsuario = (CarroUsuario) obj;
		String sql = "INSERT INTO T_GS_CARRO_USUARIO (ID_CARRO_USUARIO, ID_CARRO, ID_USUARIO, DT_INICIO, DT_FIM) "
				+ "VALUES (?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), TO_DATE(?, 'DD/MM/YYYY'))";
		try {
			
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = carroUsuario.getDtInicio().format(formatter);
			
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			String dataFim = carroUsuario.getDtFim().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, carroUsuario.getIdCarroUsuario());
			ps.setInt(2, carroUsuario.getIdCarro());
			ps.setInt(3, carroUsuario.getIdUsuario());
			ps.setString(4, dataInicio);
			ps.setString(5, dataFim);
			if (ps.executeUpdate() > 0) {
				return "Inserido com Sucesso";
			} else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para alterar um objeto CarroUsuario no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String alterar(Object obj) {
		carroUsuario = (CarroUsuario) obj;
		String sql = "UPDATE T_GS_CARRO_USUARIO SET ID_CARRO = ?, ID_USUARIO = ?, "
				+ "DT_INICIO = TO_DATE(?, 'DD/MM/YYYY'), DT_FIM = TO_DATE(?, 'DD/MM/YYYY') WHERE ID_CARRO_USUARIO = ? ";
		try {
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataInicio = carroUsuario.getDtInicio().format(formatter);
						
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			String dataFim = carroUsuario.getDtFim().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, carroUsuario.getIdCarro());
			ps.setInt(2, carroUsuario.getIdUsuario());
			ps.setString(3, dataInicio);
			ps.setString(4, dataFim);
			ps.setInt(5, carroUsuario.getIdCarroUsuario());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}
	
	/**Metodo para excluir um objeto CarroUsuario no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da operação 
	*/
	public String excluir(Object obj) {
		carroUsuario = (CarroUsuario) obj;
		String sql = "DELETE FROM T_GS_CARRO_USUARIO WHERE ID_CARRO_USUARIO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, carroUsuario.getIdCarroUsuario());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para consultar o Banco de Dados e trazer um objeto do tipo CarroUsuario
	* @author Luis Felipe
	* @param int - id do objeto no Banco de Dados
	* @return List<String> - com a lista com todos os valores do objeto
	*/
	public List<String> listarUm(int id){
		String sql = "SELECT ID_CARRO_USUARIO, ID_CARRO, ID_USUARIO, "
				+ "TO_CHAR(DT_INICIO, 'DD/MM/YYYY') DT_INICIO, TO_CHAR(DT_FIM, 'DD/MM/YYYY') DT_FIM FROM T_GS_CARRO_USUARIO WHERE ID_CARRO = ?";
		List<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString("ID_CARRO_USUARIO"));
				resul.add(rs.getString("ID_CARRO"));
				resul.add(rs.getString("ID_USUARIO"));
				resul.add(rs.getString("DT_INICIO"));
				resul.add(rs.getString("DT_FIM"));
				return resul;
			} else {
				return resul;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}

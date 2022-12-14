/**Classe para o CRUD dos objetos do tipo Empresa no Banco de Dados utilizando a classe Conexao
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO implements IDAO{
	
	private Connection con;
	private Empresa empresa;
	
	public EmpresaDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	/**Metodo para inserir um objeto Empresa no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da opera??o 
	*/
	public String inserir(Object obj) {
		empresa = (Empresa) obj;
		String sql = "INSERT INTO T_GS_EMPRESA (ID_EMPRESA, NM_EMPRESA, NR_CNPJ, DS_EMAIL, DS_SENHA) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, empresa.getIdEmpresa());
			ps.setString(2, empresa.getNmEmpresa());
			ps.setString(3, empresa.getNrCnpj());
			ps.setString(4, empresa.getDsEmail());
			ps.setString(5, empresa.getDsSenha());
			if (ps.executeUpdate() > 0) {
				return "Inserido com Sucesso";
			} else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para alterar um objeto Empresa no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da opera??o 
	*/
	public String alterar(Object obj) {
		empresa = (Empresa) obj;
		String sql = "UPDATE T_GS_EMPRESA SET NM_EMPRESA = ?, NR_CNPJ = ?, DS_EMAIL = ?, DS_SENHA = ? WHERE ID_EMPRESA = ? ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, empresa.getNmEmpresa());
			ps.setString(2, empresa.getNrCnpj());
			ps.setString(3, empresa.getDsEmail());
			ps.setString(4, empresa.getDsSenha());
			ps.setInt(5, empresa.getIdEmpresa());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}
	
	/**Metodo para excluir um objeto Empresa no Banco de dados
	* @author Luis Felipe
	* @param null
	* @return String - com o resultado da opera??o 
	*/
	public String excluir(Object obj) {
		empresa = (Empresa) obj;
		String sql = "DELETE FROM T_GS_EMPRESA WHERE ID_EMPRESA = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, empresa.getIdEmpresa());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	/**Metodo para consultar o Banco de Dados e trazer um objeto do tipo InfoCarro
	* @author Luis Felipe
	* @param int - id do objeto no Banco de Dados
	* @return List<String> - com a lista com todos os valores do objeto
	*/
	public List<String> listarUm(int id){
		String sql = "SELECT * FROM T_GS_EMPRESA WHERE ID_EMPRESA = ?";
		List<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString("ID_EMPRESA"));
				resul.add(rs.getString("NM_EMPRESA"));
				resul.add(rs.getString("NR_CNPJ"));
				resul.add(rs.getString("DS_SENHA"));
				resul.add(rs.getString("DS_EMAIL"));
				return resul;
			} else {
				return resul;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}

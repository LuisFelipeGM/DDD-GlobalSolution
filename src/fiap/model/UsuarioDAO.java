package fiap.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IDAO{

	private Connection con;
	private Usuario usuario;
	
	public UsuarioDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		usuario = (Usuario) obj;
		String sql = "INSERT INTO T_GS_USUARIO (ID_USUARIO, NM_COMPLETO, DS_EMAIL, DS_SENHA, NR_CPF) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, usuario.getIdUsuario());
			ps.setString(2, usuario.getNmCompleto());
			ps.setString(3, usuario.getDsEmail());
			ps.setString(4, usuario.getDsSenha());
			ps.setString(5, usuario.getNrCPF());
			if (ps.executeUpdate() > 0) {
				return "Inserido com Sucesso";
			} else {
				return "Erro ao inserir";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	
	public String alterar(Object obj) {
		usuario = (Usuario) obj;
		String sql = "UPDATE T_GS_USUARIO SET NM_COMPLETO = ?, DS_EMAIL = ?, DS_SENHA = ?, NR_CPF = ? WHERE ID_USUARIO = ? ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, usuario.getNmCompleto());
			ps.setString(2, usuario.getDsEmail());
			ps.setString(3, usuario.getDsSenha());
			ps.setString(4, usuario.getNrCPF());
			ps.setInt(5, usuario.getIdUsuario());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}
	
	public String excluir(Object obj) {
		usuario = (Usuario) obj;
		String sql = "DELETE FROM T_GS_USUARIO WHERE ID_USUARIO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, usuario.getIdUsuario());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public List<String> listarUm(int id){
		String sql = "SELECT * FROM T_GS_USUARIO WHERE ID_USUARIO = ?";
		List<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString("ID_USUARIO"));
				resul.add(rs.getString("NM_COMPLETO"));
				resul.add(rs.getString("DS_EMAIL"));
				resul.add(rs.getString("DS_SENHA"));
				resul.add(rs.getString("DS_CPF"));
				return resul;
			} else {
				return resul;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
}

package fiap.model;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InfoCarroDAO implements IDAO{
	
	private Connection con;
	private InfoCarro infoCarro;
	
	public InfoCarroDAO(Connection con) {
		setCon(con);
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		infoCarro = (InfoCarro) obj;
		String sql = "INSERT INTO T_GS_INFO_CARRO (ID_INFO_CARRO, ID_CARRO, NR_PNEU_CALIBRAGEM, DS_PNEU_VIDA_UTIL, DS_SUSPENSAO_VIDA_UTIL, "
				+ "DS_QUILOMETRAGEM, DS_FREIO_VIDA_UTIL, DT_ULT_MANUTENCAO) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'))";
		try {
			
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataUltManutencao = infoCarro.getDtUltManutencao().format(formatter);
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, infoCarro.getIdInfoCarro());
			ps.setInt(2, infoCarro.getIdCarro());
			ps.setInt(3, infoCarro.getNrPneuCalibragem());
			ps.setInt(4, infoCarro.getDsPneuVidaUtil());
			ps.setInt(5, infoCarro.getDsSuspensaoVidaUtil());
			ps.setInt(6, infoCarro.getDsQuilometragem());
			ps.setInt(7, infoCarro.getDsFreioVidaUtil());
			ps.setString(8, dataUltManutencao);
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
		infoCarro = (InfoCarro) obj;
		String sql = "UPDATE T_GS_INFO_CARRO SET ID_CARRO = ?, NR_PNEU_CALIBRAGEM = ?, DS_PNEU_VIDA_UTIL = ?, DS_SUSPENSAO_VIDA_UTIL = ?, "
				+ "DS_QUILOMETRAGEM = ?, DS_FREIO_VIDA_UTIL = ?, DT_ULT_MANUTENCAO = TO_DATE(?, 'DD/MM/YYYY') WHERE ID_INFO_CARRO = ? ";
		try {
			// Transformando o LocalDate em String para mandar para o Banco de Dados
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataUltManutencao = infoCarro.getDtUltManutencao().format(formatter);
						
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, infoCarro.getIdCarro());
			ps.setInt(2, infoCarro.getNrPneuCalibragem());
			ps.setInt(3, infoCarro.getDsPneuVidaUtil());
			ps.setInt(4, infoCarro.getDsSuspensaoVidaUtil());
			ps.setInt(5, infoCarro.getDsQuilometragem());
			ps.setInt(6, infoCarro.getDsFreioVidaUtil());
			ps.setString(7, dataUltManutencao);
			ps.setInt(8, infoCarro.getIdInfoCarro());
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
		infoCarro = (InfoCarro) obj;
		String sql = "DELETE FROM T_GS_INFO_CARRO WHERE ID_INFO_CARRO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, infoCarro.getIdInfoCarro());
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
		String sql = "SELECT ID_INFO_CARRO, ID_CARRO, NR_PNEU_CALIBRAGEM, DS_PNEU_VIDA_UTIL, DS_SUSPENSAO_VIDA_UTIL, "
				+ "DS_QUILOMETRAGEM, DS_FREIO_VIDA_UTIL, TO_CHAR(DT_ULT_MANUTENCAO, 'DD/MM/YYYY') DT_ULT_MANUTENCAO "
				+ "FROM T_GS_INFO_CARRO WHERE ID_INFO_CARRO = ?";
		List<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString("ID_INFO_CARRO"));
				resul.add(rs.getString("ID_CARRO"));
				resul.add(rs.getString("NR_PNEU_CALIBRAGEM"));
				resul.add(rs.getString("DS_PNEU_VIDA_UTIL"));
				resul.add(rs.getString("DS_SUSPENSAO_VIDA_UTIL"));
				resul.add(rs.getString("DS_QUILOMETRAGEM"));
				resul.add(rs.getString("DS_FREIO_VIDA_UTIL"));
				resul.add(rs.getString("DT_ULT_MANUTENCAO"));
				return resul;
			} else {
				return resul;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}

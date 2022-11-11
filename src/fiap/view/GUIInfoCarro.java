/**Classe de Interface GUI InfoCarro
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.view;


import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import fiap.controller.InfoCarroController;

@SuppressWarnings({ "serial", "unused" })
public class GUIInfoCarro extends JPanel{
	
	private JLabel lbIdInfoCarro, lbIdCarro, lbNrPneuCalibragem, lbPneuVidaUtil, lbSuspensaoVidaUtil;
	private JLabel lbQuilometragem, lbFreioVidaUtil, lbDtUltManutencao;
	private JTextField tfIdInfoCarro, tfIdCarro, tfNrPneuCalibragem, tfPneuVidaUtil, tfSuspensaoVidaUtil;
	private JTextField tfQuilometragem, tfFreioVidaUtil, tfDtUltManutencao;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;

	
	public GUIInfoCarro() {
		inicializarComponentes();
		definirEventos();
	}
	
	/**Metodo para inicializar todos os componentes do GUI InfoCarro
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		//Instanciando Botoes 
		btPesquisa = new JButton(new ImageIcon(getClass().getResource("imagens/search_icon.png")));
		btNovo = new JButton(new ImageIcon(getClass().getResource("imagens/new_icon.png")));
		btAtualiza = new JButton(new ImageIcon(getClass().getResource("imagens/update_icon.png")));
		btApaga = new JButton(new ImageIcon(getClass().getResource("imagens/delete_icon.png")));
		
		//Instanciando Labels
		lbIdInfoCarro = new JLabel("ID Info Carro:");
		lbIdCarro = new JLabel("ID Carro:");
		lbNrPneuCalibragem = new JLabel("Calibragem Pneu: ");
		lbPneuVidaUtil = new JLabel("Pneu Vida Útil: ");
		lbSuspensaoVidaUtil = new JLabel("Suspensão Vida Útil: ");
		lbQuilometragem = new JLabel("Quilometragem: ");
		lbFreioVidaUtil = new JLabel("Freio Vida Util:");
		lbDtUltManutencao = new JLabel("Data Última Manutenção:");
		
		//Instanciando Text Field
		tfIdInfoCarro = new JTextField();
		tfIdCarro = new JTextField();
		tfNrPneuCalibragem = new JTextField();
		tfPneuVidaUtil = new JTextField();
		tfSuspensaoVidaUtil = new JTextField();
		tfQuilometragem = new JTextField();
		tfFreioVidaUtil = new JTextField();
		tfDtUltManutencao = new JTextField();
			
		
		lbIdInfoCarro.setBounds(25, 30, 100, 25);
		tfIdInfoCarro.setBounds(130, 30, 200, 25);
		
		lbIdCarro.setBounds(25, 65, 100, 25);
		tfIdCarro.setBounds(130, 65, 200, 25);
		
		lbNrPneuCalibragem.setBounds(25, 100, 150, 25);
		tfNrPneuCalibragem.setBounds(140, 100, 200, 25);
		
		lbPneuVidaUtil.setBounds(25, 135, 100, 25);
		tfPneuVidaUtil.setBounds(130, 135, 200, 25);
		
		lbSuspensaoVidaUtil.setBounds(25, 170, 150, 25);
		tfSuspensaoVidaUtil.setBounds(160, 170, 200, 25);
		
		lbQuilometragem.setBounds(25, 205, 100, 25);
		tfQuilometragem.setBounds(130, 205, 200, 25);
		
		lbFreioVidaUtil.setBounds(25, 240, 100, 25);
		tfFreioVidaUtil.setBounds(130, 240, 200, 25);
		
		lbDtUltManutencao.setBounds(25, 275, 150, 25);
		tfDtUltManutencao.setBounds(180, 275, 200, 25);
		
	
		
		//set Bounds Bot�es
		btPesquisa.setBounds(150, 430, 60, 40);
		btNovo.setBounds(290, 430, 60, 40);
		btAtualiza.setBounds(430, 430, 60, 40);
		btApaga.setBounds(570, 430, 60, 40);
		
		//Add os elementos
		add(btPesquisa);
		add(btNovo);
		add(btAtualiza);
		add(btApaga);
		
		add(lbIdInfoCarro);
		add(lbIdCarro);
		add(lbNrPneuCalibragem);
		add(lbPneuVidaUtil);
		add(lbSuspensaoVidaUtil);
		add(lbQuilometragem);
		add(lbFreioVidaUtil);
		add(lbDtUltManutencao);
		
		add(tfIdInfoCarro);
		add(tfIdCarro);
		add(tfNrPneuCalibragem);
		add(tfPneuVidaUtil);
		add(tfSuspensaoVidaUtil);
		add(tfQuilometragem);
		add(tfFreioVidaUtil);
		add(tfDtUltManutencao);
		
	}
	
	/**Metodo para definir os eventos do GUI InfoCarro
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void definirEventos() {

		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoCarroController icc = new InfoCarroController();
				List<String> dados = new ArrayList<String>();
				if (tfIdInfoCarro.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Info Carro");
					tfIdInfoCarro.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdInfoCarro.getText());
					dados = icc.listaUmaEmpresa(id);
					if (dados.isEmpty() == false) {
						tfIdCarro.setText(dados.get(1));
						tfNrPneuCalibragem.setText(dados.get(2));
						tfPneuVidaUtil.setText(dados.get(3));
						tfSuspensaoVidaUtil.setText(dados.get(4));
						tfQuilometragem.setText(dados.get(5));
						tfFreioVidaUtil.setText(dados.get(6));
						tfDtUltManutencao.setText(dados.get(7));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
				}
				
				
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoCarroController icc = new InfoCarroController();
				if (tfIdInfoCarro.getText().equals("") || tfIdCarro.getText().equals("") || 
						tfNrPneuCalibragem.getText().equals("") || tfPneuVidaUtil.getText().equals("") ||
						tfSuspensaoVidaUtil.getText().equals("") || tfQuilometragem.getText().equals("") || 
						tfFreioVidaUtil.getText().equals("") || tfDtUltManutencao.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int idInfoCarro = Integer.parseInt(tfIdInfoCarro.getText());
					int IdCarro = Integer.parseInt(tfIdCarro.getText());
					int NrPneuCalibragem = Integer.parseInt(tfNrPneuCalibragem.getText());
					int PneuVidaUtil = Integer.parseInt(tfPneuVidaUtil.getText());
					int SuspensaoVidaUtil = Integer.parseInt(tfSuspensaoVidaUtil.getText());
					int Quilometragem = Integer.parseInt(tfQuilometragem.getText());
					int FreioVidaUtil = Integer.parseInt(tfFreioVidaUtil.getText());
					
					String aux = tfDtUltManutencao.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataM = LocalDate.parse(data);
					
					JOptionPane.showMessageDialog(null, icc.insereInfoCarro(idInfoCarro, IdCarro, NrPneuCalibragem, 
							PneuVidaUtil, SuspensaoVidaUtil, Quilometragem, FreioVidaUtil, dataM));
					
					tfIdInfoCarro.setText("");
					tfIdCarro.setText("");
					tfNrPneuCalibragem.setText("");
					tfPneuVidaUtil.setText("");
					tfSuspensaoVidaUtil.setText("");
					tfQuilometragem.setText("");
					tfFreioVidaUtil.setText("");
					tfDtUltManutencao.setText("");
				}
				
			}
		});
		
		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoCarroController icc = new InfoCarroController();
				if (tfIdInfoCarro.getText().equals("") || tfIdCarro.getText().equals("") || 
						tfNrPneuCalibragem.getText().equals("") || tfPneuVidaUtil.getText().equals("") ||
						tfSuspensaoVidaUtil.getText().equals("") || tfQuilometragem.getText().equals("") || 
						tfFreioVidaUtil.getText().equals("") || tfDtUltManutencao.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int idInfoCarro = Integer.parseInt(tfIdInfoCarro.getText());
					int IdCarro = Integer.parseInt(tfIdCarro.getText());
					int NrPneuCalibragem = Integer.parseInt(tfNrPneuCalibragem.getText());
					int PneuVidaUtil = Integer.parseInt(tfPneuVidaUtil.getText());
					int SuspensaoVidaUtil = Integer.parseInt(tfSuspensaoVidaUtil.getText());
					int Quilometragem = Integer.parseInt(tfQuilometragem.getText());
					int FreioVidaUtil = Integer.parseInt(tfFreioVidaUtil.getText());
					
					String aux = tfDtUltManutencao.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataM = LocalDate.parse(data);
					
					JOptionPane.showMessageDialog(null, icc.alteraInfoCarro(idInfoCarro, IdCarro, NrPneuCalibragem, 
							PneuVidaUtil, SuspensaoVidaUtil, Quilometragem, FreioVidaUtil, dataM));
					
					tfIdInfoCarro.setText("");
					tfIdCarro.setText("");
					tfNrPneuCalibragem.setText("");
					tfPneuVidaUtil.setText("");
					tfSuspensaoVidaUtil.setText("");
					tfQuilometragem.setText("");
					tfFreioVidaUtil.setText("");
					tfDtUltManutencao.setText("");
				}
				
			}
		});
		
		btApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoCarroController icc = new InfoCarroController();
				if (tfIdInfoCarro.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Info Carro");
				} else {
					int idInfoCarro = Integer.parseInt(tfIdInfoCarro.getText());
					
					JOptionPane.showMessageDialog(null, icc.excluiInfoCarro(idInfoCarro));
					
					tfIdInfoCarro.setText("");
					tfIdCarro.setText("");
					tfNrPneuCalibragem.setText("");
					tfPneuVidaUtil.setText("");
					tfSuspensaoVidaUtil.setText("");
					tfQuilometragem.setText("");
					tfFreioVidaUtil.setText("");
					tfDtUltManutencao.setText("");
				}
			}
		});
		
		
		
	}
}
/**Classe de Interface GUI Bateria
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import fiap.controller.BateriaController;

@SuppressWarnings({ "serial", "unused" })
public class GUIBateria extends JPanel{
	
	private JLabel lbIdBateria, lbIdInfoCarro, lbBateriaCarga, lbBateriaVidaUtil;
	private JTextField tfIdBateria, tfIdInfoCarro, tfBateriaCarga, tfBateriaVidaUtil;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;
	
	public GUIBateria() {
		inicializarComponentes();
		definirEventos();
	}
	
	/**Metodo para inicializar todos os componentes do GUI Bateria
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
		lbIdBateria = new JLabel("ID Bateria:");
		lbIdInfoCarro = new JLabel("ID Info Carro:");
		lbBateriaCarga = new JLabel("Carga Bateria: ");
		lbBateriaVidaUtil = new JLabel("Bateria Vida Util: ");
		
		//Instanciando Text Field
		tfIdBateria = new JTextField();
		tfIdInfoCarro = new JTextField();
		tfBateriaCarga = new JTextField();
		tfBateriaVidaUtil = new JTextField();
		
		
		lbIdBateria.setBounds(25, 30, 100, 25);
		tfIdBateria.setBounds(130, 30, 200, 25);
		
		lbIdInfoCarro.setBounds(25, 65, 100, 25);
		tfIdInfoCarro.setBounds(130, 65, 200, 25);
		
		lbBateriaCarga.setBounds(25, 100, 100, 25);
		tfBateriaCarga.setBounds(130, 100, 200, 25);
		
		lbBateriaVidaUtil.setBounds(25, 135, 100, 25);
		tfBateriaVidaUtil.setBounds(130, 135, 200, 25);
				
		
		//set Bounds Botoes
		btPesquisa.setBounds(150, 430, 60, 40);
		btNovo.setBounds(290, 430, 60, 40);
		btAtualiza.setBounds(430, 430, 60, 40);
		btApaga.setBounds(570, 430, 60, 40);
		
		//Add os elementos
		add(btPesquisa);
		add(btNovo);
		add(btAtualiza);
		add(btApaga);
		
		add(lbIdBateria);
		add(lbIdInfoCarro);
		add(lbBateriaCarga);
		add(lbBateriaVidaUtil);
		
		add(tfIdBateria);
		add(tfIdInfoCarro);
		add(tfBateriaCarga);
		add(tfBateriaVidaUtil);

	}
	
	/**Metodo para inicializar todos os componentes do GUI Bateria
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void definirEventos() {

		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BateriaController bc = new BateriaController();
				List<String> dados = new ArrayList<String>();
				if (tfIdBateria.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Bateria");
					tfIdBateria.requestFocus();
				} else {
					int idBateria = Integer.parseInt(tfIdBateria.getText());
					dados = bc.listaUmaBateria(idBateria);
					if (dados.isEmpty() == false) {
						tfIdInfoCarro.setText(dados.get(1));
						tfBateriaCarga.setText(dados.get(2));
						tfBateriaVidaUtil.setText(dados.get(3));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
				}
				
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BateriaController bc = new BateriaController();
				if (tfIdBateria.getText().equals("") || tfIdInfoCarro.getText().equals("") || 
						tfBateriaCarga.getText().equals("") || tfBateriaVidaUtil.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int idBateria = Integer.parseInt(tfIdBateria.getText());
					int idInfoCarro = Integer.parseInt(tfIdInfoCarro.getText());
					int BateriaCarga = Integer.parseInt(tfBateriaCarga.getText());
					int BateriaVidaUtil = Integer.parseInt(tfBateriaVidaUtil.getText());
					
					JOptionPane.showMessageDialog(null, bc.insereBateria(idBateria, idInfoCarro, BateriaCarga, BateriaVidaUtil));
					
					tfIdBateria.setText("");
					tfIdInfoCarro.setText("");
					tfBateriaCarga.setText("");
					tfBateriaVidaUtil.setText("");
				}
				
			}
		});
		
		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BateriaController bc = new BateriaController();
				if (tfIdBateria.getText().equals("") || tfIdInfoCarro.getText().equals("") || 
						tfBateriaCarga.getText().equals("") || tfBateriaVidaUtil.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int idBateria = Integer.parseInt(tfIdBateria.getText());
					int idInfoCarro = Integer.parseInt(tfIdInfoCarro.getText());
					int BateriaCarga = Integer.parseInt(tfBateriaCarga.getText());
					int BateriaVidaUtil = Integer.parseInt(tfBateriaVidaUtil.getText());
					
					JOptionPane.showMessageDialog(null, bc.alteraBateria(idBateria, idInfoCarro, BateriaCarga, BateriaVidaUtil));
					
					tfIdBateria.setText("");
					tfIdInfoCarro.setText("");
					tfBateriaCarga.setText("");
					tfBateriaVidaUtil.setText("");
				}
				
			}
		});
		
		btApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BateriaController bc = new BateriaController();
				if (tfIdBateria.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Bateria");
				} else {
					int idBateria = Integer.parseInt(tfIdBateria.getText());
					
					JOptionPane.showMessageDialog(null, bc.excluiBateria(idBateria));
					
					tfIdBateria.setText("");
					tfIdInfoCarro.setText("");
					tfBateriaCarga.setText("");
					tfBateriaVidaUtil.setText("");
				}
			}
		});
		
		
		
	}
}
/**Classe de Interface GUI Carro
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

import fiap.controller.CarroController;

@SuppressWarnings({ "serial", "unused" })
public class GUICarro extends JPanel{
	
	private JLabel lbIdCarro, lbIdEmpresa, lbNrSerie, lbMarca, lbModelo;
	private JLabel lbNrPlaca, lbDtFabricaco;
	private JTextField tfIdCarro, tfIdEmpresa, tfNrSerie, tfMarca, tfModelo;
	private JTextField tfNrPlaca, tfDtFabricaco;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;
	
	public GUICarro() {
		inicializarComponentes();
		definirEventos();
	}
	
	/**Metodo para inicializar todos os componentes do GUI Carro
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
		lbIdCarro = new JLabel("ID Carro:");
		lbIdEmpresa = new JLabel("ID Empresa:");
		lbNrSerie = new JLabel("Número Série: ");
		lbMarca = new JLabel("Marca: ");
		lbModelo = new JLabel("Modelo: ");
		lbNrPlaca = new JLabel("Placa: ");
		lbDtFabricaco = new JLabel("Data Fabricação:");
		
		//Instanciando Text Field
		tfIdCarro = new JTextField();
		tfIdEmpresa = new JTextField();
		tfNrSerie = new JTextField();
		tfMarca = new JTextField();
		tfModelo = new JTextField();
		tfNrPlaca = new JTextField();
		tfDtFabricaco = new JTextField();
		
		
		
		
		lbIdCarro.setBounds(25, 30, 100, 25);
		tfIdCarro.setBounds(130, 30, 200, 25);
		
		lbIdEmpresa.setBounds(25, 65, 100, 25);
		tfIdEmpresa.setBounds(130, 65, 200, 25);
		
		lbNrSerie.setBounds(25, 100, 100, 25);
		tfNrSerie.setBounds(130, 100, 200, 25);
		
		lbMarca.setBounds(25, 135, 100, 25);
		tfMarca.setBounds(130, 135, 200, 25);
		
		lbModelo.setBounds(25, 170, 100, 25);
		tfModelo.setBounds(130, 170, 200, 25);
		
		lbNrPlaca.setBounds(25, 205, 100, 25);
		tfNrPlaca.setBounds(130, 205, 200, 25);
		
		lbDtFabricaco.setBounds(25, 240, 100, 25);
		tfDtFabricaco.setBounds(130, 240, 200, 25);
		
	
		
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
		
		add(lbIdCarro);
		add(lbIdEmpresa);
		add(lbNrSerie);
		add(lbMarca);
		add(lbModelo);
		add(lbNrPlaca);
		add(lbDtFabricaco);
		
		add(tfIdCarro);
		add(tfIdEmpresa);
		add(tfNrSerie);
		add(tfMarca);
		add(tfModelo);
		add(tfNrPlaca);
		add(tfDtFabricaco);
	}
	
	/**Metodo para inicializar todos os componentes do GUI Carro
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void definirEventos() {

		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarroController cc = new CarroController();
				List<String> dados = new ArrayList<String>();
				if (tfIdCarro.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Carro");
					tfIdCarro.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdCarro.getText());
					dados = cc.listaUmCarro(id);
					if (dados.isEmpty() == false) {
						tfIdEmpresa.setText(dados.get(1));
						tfNrSerie.setText(dados.get(5));
						tfMarca.setText(dados.get(2));
						tfModelo.setText(dados.get(3));
						tfNrPlaca.setText(dados.get(4));
						tfDtFabricaco.setText(dados.get(6));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
				}
				
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarroController cc = new CarroController();
				if (tfIdCarro.getText().equals("") || tfIdEmpresa.getText().equals("") || 
						tfNrSerie.getText().equals("") || tfMarca.getText().equals("") || 
						tfModelo.getText().equals("") || tfNrPlaca.getText().equals("") || 
						tfDtFabricaco.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int idCarro = Integer.parseInt(tfIdCarro.getText());
					int idEmpresa = Integer.parseInt(tfIdEmpresa.getText());
					int numSerie = Integer.parseInt(tfNrSerie.getText());
					String aux = tfDtFabricaco.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataF = LocalDate.parse(data);
					
					JOptionPane.showMessageDialog(null, cc.insereCarro(idCarro, idEmpresa, numSerie, tfMarca.getText(),
							tfModelo.getText(), tfNrPlaca.getText(), dataF));
					
					tfIdCarro.setText("");
					tfIdEmpresa.setText("");
					tfNrSerie.setText("");
					tfMarca.setText("");
					tfModelo.setText("");
					tfNrPlaca.setText("");
					tfDtFabricaco.setText("");
				}
				
				
			}
		});
		
		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarroController cc = new CarroController();
				if (tfIdCarro.getText().equals("") || tfIdEmpresa.getText().equals("") || 
						tfNrSerie.getText().equals("") || tfMarca.getText().equals("") || 
						tfModelo.getText().equals("") || tfNrPlaca.getText().equals("") || 
						tfDtFabricaco.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int idCarro = Integer.parseInt(tfIdCarro.getText());
					int idEmpresa = Integer.parseInt(tfIdEmpresa.getText());
					int numSerie = Integer.parseInt(tfNrSerie.getText());
					String aux = tfDtFabricaco.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataF = LocalDate.parse(data);
					
					JOptionPane.showMessageDialog(null, cc.alteraCarro(idCarro, idEmpresa, numSerie, tfMarca.getText(),
							tfModelo.getText(), tfNrPlaca.getText(), dataF));
					
					tfIdCarro.setText("");
					tfIdEmpresa.setText("");
					tfNrSerie.setText("");
					tfMarca.setText("");
					tfModelo.setText("");
					tfNrPlaca.setText("");
					tfDtFabricaco.setText("");
				}
				
			}
		});
		
		btApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarroController cc = new CarroController();
				if (tfIdCarro.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Carro");
				} else {
					int idCarro = Integer.parseInt(tfIdCarro.getText());
					
					JOptionPane.showMessageDialog(null, cc.excluiCarro(idCarro));
					
					tfIdCarro.setText("");
					tfIdEmpresa.setText("");
					tfNrSerie.setText("");
					tfMarca.setText("");
					tfModelo.setText("");
					tfNrPlaca.setText("");
					tfDtFabricaco.setText("");
				}
			}
		});
		
		
		
	}
}
/**Classe de Interface GUI CarroUsuario
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

import fiap.controller.CarroUsuarioController;

@SuppressWarnings({ "serial", "unused" })
public class GUICarroUsuario extends JPanel{
	
	private JLabel lbIdCarroUsuario, lbIdCarro, lbIdUsuario, lbDtInicio, lbDtFim;
	private JTextField tfIdCarroUsuario, tfIdCarro, tfIdUsuario, tfDtInicio, tfDtFim;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;
	
	public GUICarroUsuario() {
		inicializarComponentes();
		definirEventos();
	}
	
	/**Metodo para inicializar todos os componentes do GUI CarroUsuario
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
		lbIdCarroUsuario = new JLabel("ID Carro Usuario:");
		lbIdCarro = new JLabel("ID Carro:");
		lbIdUsuario = new JLabel("ID Usuario:");
		lbDtInicio = new JLabel("Data Inicio:");
		lbDtFim = new JLabel("Data Fim:");
		
		//Instanciando Text Field
		tfIdCarroUsuario = new JTextField();
		tfIdCarro = new JTextField();
		tfIdUsuario = new JTextField();
		tfDtInicio = new JTextField();
		tfDtFim = new JTextField();
		
		
		lbIdCarroUsuario.setBounds(25, 30, 100, 25);
		tfIdCarroUsuario.setBounds(130, 30, 200, 25);
		
		lbIdCarro.setBounds(25, 65, 100, 25);
		tfIdCarro.setBounds(130, 65, 200, 25);
		
		lbIdUsuario.setBounds(25, 100, 100, 25);
		tfIdUsuario.setBounds(130, 100, 200, 25);
		
		lbDtInicio.setBounds(25, 135, 100, 25);
		tfDtInicio.setBounds(130, 135, 200, 25);
		
		lbDtFim.setBounds(25, 170, 100, 25);
		tfDtFim.setBounds(130, 170, 200, 25);
				
	
		
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
		
		add(lbIdCarroUsuario);
		add(lbIdCarro);
		add(lbIdUsuario);
		add(lbDtInicio);
		add(lbDtFim);
		
		add(tfIdCarroUsuario);
		add(tfIdCarro);
		add(tfIdUsuario);
		add(tfDtInicio);
		add(tfDtFim);

	}
	
	/**Metodo para inicializar todos os componentes do GUI CarroUsuario
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void definirEventos() {

		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarroUsuarioController cuc = new CarroUsuarioController();
				List<String> dados = new ArrayList<String>();
				if (tfIdCarroUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Empresa");
					tfIdCarroUsuario.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdCarroUsuario.getText());
					dados = cuc.listaUmCarroUsuario(id);
					if (dados.isEmpty() == false) {
						tfIdCarro.setText(dados.get(1));
						tfIdUsuario.setText(dados.get(2));
						tfDtInicio.setText(dados.get(3));
						tfDtFim.setText(dados.get(4));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}

				}
				
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarroUsuarioController cuc = new CarroUsuarioController();
				if (tfIdCarroUsuario.getText().equals("") || tfIdCarro.getText().equals("") ||
						tfIdUsuario.getText().equals("") || tfDtInicio.getText().equals("") ||
						tfDtFim.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int idCarroUsuario = Integer.parseInt(tfIdCarroUsuario.getText());
					int idCarro = Integer.parseInt(tfIdCarro.getText());
					int idUsuario = Integer.parseInt(tfIdUsuario.getText());
					
					
					String aux = tfDtInicio.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataI = LocalDate.parse(data);
					
					
					aux = tfDtFim.getText();
					String data2 = aux.substring(6, 10) + "-";
					data2 += aux.substring(3, 5) + "-";
					data2 += aux.substring(0, 2);
					LocalDate dataF = LocalDate.parse(data2);
					
					
					
					JOptionPane.showMessageDialog(null, cuc.insereCarroUsuario(idCarroUsuario, idCarro, idUsuario, dataI, dataF));
					
					tfIdCarroUsuario.setText("");
					tfIdCarro.setText("");
					tfIdUsuario.setText("");
					tfDtInicio.setText("");
					tfDtFim.setText("");
					
				}
				
			}
		});
		
		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarroUsuarioController cuc = new CarroUsuarioController();
				if (tfIdCarroUsuario.getText().equals("") || tfIdCarro.getText().equals("") ||
						tfIdUsuario.getText().equals("") || tfDtInicio.getText().equals("") ||
						tfDtFim.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int idCarroUsuario = Integer.parseInt(tfIdCarroUsuario.getText());
					int idCarro = Integer.parseInt(tfIdCarro.getText());
					int idUsuario = Integer.parseInt(tfIdUsuario.getText());
					
					String aux = tfDtInicio.getText();
					String data = aux.substring(6, 10) + "-";
					data += aux.substring(3, 5) + "-";
					data += aux.substring(0, 2);
					LocalDate dataI = LocalDate.parse(data);
					
					
					aux = tfDtFim.getText();
					String data2 = aux.substring(6, 10) + "-";
					data2 += aux.substring(3, 5) + "-";
					data2 += aux.substring(0, 2);
					LocalDate dataF = LocalDate.parse(data2);
					
					JOptionPane.showMessageDialog(null, cuc.alteraCarroUsuario(idCarroUsuario, idCarro, idUsuario, dataI, dataF));
					
					tfIdCarroUsuario.setText("");
					tfIdCarro.setText("");
					tfIdUsuario.setText("");
					tfDtInicio.setText("");
					tfDtFim.setText("");
					
				}
				
				
			}
		});
		
		btApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarroUsuarioController cuc = new CarroUsuarioController();
				if (tfIdCarroUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do Carro Usuario");
				} else {
					int idCarroUsuario = Integer.parseInt(tfIdCarroUsuario.getText());
					
					JOptionPane.showMessageDialog(null, cuc.excluiCarroUsuario(idCarroUsuario));
					
					tfIdCarroUsuario.setText("");
					tfIdCarro.setText("");
					tfIdUsuario.setText("");
					tfDtInicio.setText("");
					tfDtFim.setText("");
					
				}
			}
		});
		
		
		
	}
}
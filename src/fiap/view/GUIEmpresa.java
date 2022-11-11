/**Classe de Interface GUI Empresa
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

import fiap.controller.EmpresaController;

@SuppressWarnings({ "serial", "unused" })
public class GUIEmpresa extends JPanel{
	
	private JLabel lbIdEmpresa, lbNomeEmpresa, lbSenha, lbEmail, lbNrCNPJ;
	private JTextField tfIdEmpresa, tfNomeEmpresa, tfSenha, tfEmail, tfNrCNPJ;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;
	
	public GUIEmpresa() {
		inicializarComponentes();
		definirEventos();
	}
	
	/**Metodo para inicializar todos os componentes do GUI Empresa
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
		lbIdEmpresa = new JLabel("ID Empresa:");
		lbNomeEmpresa = new JLabel("Nome Empresa:");
		lbSenha = new JLabel("Senha: ");
		lbEmail = new JLabel("Email: ");
		lbNrCNPJ = new JLabel("CNPJ: ");
		
		//Instanciando Text Field
		tfIdEmpresa = new JTextField();
		tfNomeEmpresa = new JTextField();
		tfSenha = new JTextField();
		tfEmail = new JTextField();
		tfNrCNPJ = new JTextField();
		
		
		lbIdEmpresa.setBounds(25, 30, 100, 25);
		tfIdEmpresa.setBounds(130, 30, 200, 25);
		
		lbNomeEmpresa.setBounds(25, 65, 100, 25);
		tfNomeEmpresa.setBounds(130, 65, 200, 25);
		
		lbEmail.setBounds(25, 100, 100, 25);
		tfEmail.setBounds(130, 100, 200, 25);
		
		lbSenha.setBounds(25, 135, 100, 25);
		tfSenha.setBounds(130, 135, 200, 25);
		
		lbNrCNPJ.setBounds(25, 170, 100, 25);
		tfNrCNPJ.setBounds(130, 170, 200, 25);
				
	
		
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
		
		add(lbIdEmpresa);
		add(lbNomeEmpresa);
		add(lbSenha);
		add(lbEmail);
		add(lbNrCNPJ);
		
		add(tfIdEmpresa);
		add(tfNomeEmpresa);
		add(tfSenha);
		add(tfEmail);
		add(tfNrCNPJ);

	}
	
	/**Metodo para inicializar todos os componentes do GUI Empresa
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void definirEventos() {

		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpresaController ec = new EmpresaController();
				List<String> dados = new ArrayList<String>();
				if (tfIdEmpresa.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Empresa");
					tfIdEmpresa.requestFocus();
				} else {
					int id = Integer.parseInt(tfIdEmpresa.getText());
					dados = ec.listaUmaEmpresa(id);
					if (dados.isEmpty() == false) {
						tfNomeEmpresa.setText(dados.get(1));
						tfEmail.setText(dados.get(4));
						tfSenha.setText(dados.get(3));
						tfNrCNPJ.setText(dados.get(2));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
				}
				
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpresaController ec = new EmpresaController();
				if (tfIdEmpresa.getText().equals("") || tfNomeEmpresa.getText().equals("") ||
						tfEmail.getText().equals("") || tfSenha.getText().equals("") || 
						tfNrCNPJ.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdEmpresa.getText());
					JOptionPane.showMessageDialog(null, ec.insereEmpresa(id, tfNomeEmpresa.getText(), 
							tfNrCNPJ.getText(), tfEmail.getText(), tfSenha.getText()));
					
					tfIdEmpresa.setText("");
					tfNomeEmpresa.setText("");
					tfEmail.setText("");
					tfSenha.setText("");
					tfNrCNPJ.setText("");
					
				}
				
			}
		});
		
		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpresaController ec = new EmpresaController();
				if (tfIdEmpresa.getText().equals("") || tfNomeEmpresa.getText().equals("") ||
						tfEmail.getText().equals("") || tfSenha.getText().equals("") || 
						tfNrCNPJ.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					int id = Integer.parseInt(tfIdEmpresa.getText());
					JOptionPane.showMessageDialog(null, ec.alteraEmpresa(id, tfNomeEmpresa.getText(), 
							tfNrCNPJ.getText(), tfEmail.getText(), tfSenha.getText()));
					
					tfIdEmpresa.setText("");
					tfNomeEmpresa.setText("");
					tfEmail.setText("");
					tfSenha.setText("");
					tfNrCNPJ.setText("");
					
				}
				
			}
		});
		
		btApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpresaController ec = new EmpresaController();
				if (tfIdEmpresa.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID da Empresa");
				} else {
					int id = Integer.parseInt(tfIdEmpresa.getText());
					JOptionPane.showMessageDialog(null, ec.excluiEmpresa(id));
					
					tfIdEmpresa.setText("");
					tfNomeEmpresa.setText("");
					tfEmail.setText("");
					tfSenha.setText("");
					tfNrCNPJ.setText("");
					
				}
				
			}
		});
		
		
		
	}
}
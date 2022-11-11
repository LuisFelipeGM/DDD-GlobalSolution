package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
		
		lbSenha.setBounds(25, 100, 100, 25);
		tfSenha.setBounds(130, 100, 200, 25);
		
		lbEmail.setBounds(25, 135, 100, 25);
		tfEmail.setBounds(130, 135, 200, 25);
		
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
	
	private void definirEventos() {

		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		
	}
}
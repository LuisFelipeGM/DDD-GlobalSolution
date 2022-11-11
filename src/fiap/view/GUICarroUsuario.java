package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import fiap.controller.EmpresaController;

@SuppressWarnings({ "serial", "unused" })
public class GUICarroUsuario extends JPanel{
	
	private JLabel lbIdCarroUsuario, lbIdCarro, lbIdUsuario, lbDtInicio, lbDtFim;
	private JTextField tfIdCarroUsuario, tfIdCarro, tfIdUsuario, tfDtInicio, tfDtFim;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;
	
	public GUICarroUsuario() {
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
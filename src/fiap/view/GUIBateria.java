package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import fiap.controller.EmpresaController;

@SuppressWarnings({ "serial", "unused" })
public class GUIBateria extends JPanel{
	
	private JLabel lbIdBateria, lbIdInfoCarro, lbBateriaCarga, lbBateriaVidaUtil;
	private JTextField tfIdBateria, tfIdInfoCarro, tfBateriaCarga, tfBateriaVidaUtil;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;
	
	public GUIBateria() {
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
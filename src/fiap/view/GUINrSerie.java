/**Classe de Interface GUI NrSerie
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import fiap.controller.ConsultaController;

@SuppressWarnings({ "serial", "unused" })
public class GUINrSerie extends JPanel{
	
	private JLabel lbNrSerie;
	private JTextField tfNrSerie;
	private JButton btPesquisa;
	
	public GUINrSerie() {
		inicializarComponentes();
		definirEventos();
	}
	
	/**Metodo para inicializar todos os componentes do GUI NrSerie
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		//Instanciando Botoes 
		btPesquisa = new JButton(new ImageIcon(getClass().getResource("imagens/search_icon.png")));
		
		
		//Instanciando Labels
		lbNrSerie = new JLabel("Número de Série:");

		
		//Instanciando Text Field
		tfNrSerie = new JTextField();
		
		lbNrSerie.setBounds(25, 30, 100, 25);
		tfNrSerie.setBounds(130, 30, 200, 25);
		
				
		
		//set Bounds Botoes
		btPesquisa.setBounds(350, 430, 60, 40);

		
		//Add os elementos
		add(btPesquisa);

		add(lbNrSerie);

		add(tfNrSerie);

	}
	
	/**Metodo para definir os eventos do GUI NrSerie
	* @author Luis Felipe
	* @param null 
	* @return void
	*/
	private void definirEventos() {

		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaController consulta = new ConsultaController();
				int nrSerie = Integer.parseInt(tfNrSerie.getText());
				String dados = consulta.listaUmUsuario(nrSerie);
				if (dados == null) {
					JOptionPane.showMessageDialog(null, "Número de Série Inválido!");
				} else {
					JOptionPane.showMessageDialog(null, dados);
				}
				
				
			}
		});
		
		
		
	}
}
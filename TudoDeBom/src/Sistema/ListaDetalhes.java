package Sistema;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * - Tela para exibir o historico de transações e compras 
 * 
 * @author Eduardo Silva
 * 
 */
public class ListaDetalhes extends JFrame {
	private static List<ConsultaHistorico> lista;
	private JList<ConsultaHistorico> list; 
	/**
	 * Launch the application.
	 */
	public static void detalhesPedidos() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDetalhes frame = new ListaDetalhes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaDetalhes() {
		setBounds(100, 100, 657, 329);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 621, 217);
		getContentPane().add(scrollPane);
		
		/**
		 * 
		 * - Estrutura de repetição para exibir lista em tela
		 * 
		 * @author Eduardo Silva
		 * 
		 */
		HistoricoBancoDados bd =  new HistoricoBancoDados();
		
		bd.consultarHistorio();
		lista = new ArrayList<>(HistoricoBancoDados.getListaHistorico());
		DefaultListModel<ConsultaHistorico> model = new DefaultListModel<ConsultaHistorico>();
		
		for (int i = 0; i < lista.size(); i++) {
		     model.addElement(lista.get(i));
		    
		    
		}
		
		list = new JList<ConsultaHistorico>(model);
		scrollPane.setViewportView(list);
		/**
		 * 
		 * - botão para exibir mais detalhes de uma determinada compra
		 * 
		 * @author Eduardo Silva
		 * 
		 */
		JButton btnNewButton = new JButton("Exibir Detalhes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoBancoDados bd = new HistoricoBancoDados();
				String id = model.get(list.getSelectedIndex()).getIdPedido();
				bd.exibirDetalhesCompleto(id);
				ListaCompleta.listaCompleta();
			}
		});
		btnNewButton.setBounds(496, 8, 135, 23);
		getContentPane().add(btnNewButton);

	}

}

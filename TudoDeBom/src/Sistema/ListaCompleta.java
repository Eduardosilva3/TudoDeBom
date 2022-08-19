package Sistema;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * - JFrame para exibir detalhes de uma compra feita pelo usuario.
 * 
 * @author Eduardo Silva
 * 
 */
public class ListaCompleta extends JFrame {
	private List<String> lista;
	/**
	 * Launch the application.
	 */
	public static void listaCompleta() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCompleta frame = new ListaCompleta();
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
	public ListaCompleta() {
		setBounds(100, 100, 538, 321);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 502, 222);
		getContentPane().add(scrollPane);
		

		HistoricoBancoDados bd =  new HistoricoBancoDados();
		lista = new ArrayList<>(bd.getProdutoRetorno());
		DefaultListModel<String> model = new DefaultListModel<String>();
		
		for (int i = 0; i < lista.size(); i++) {
		     model.addElement(lista.get(i));
		    
		    
		}
		JList<String> list = new JList<String>(model);
		
		
		scrollPane.setViewportView(list);
		/**
		 * 
		 * - Botão para fechar tela de detalhes
		 * 
		 * @author Eduardo Silva
		 * 
		 */
		JButton btnNewButton = new JButton("Fechar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(423, 244, 89, 23);
		getContentPane().add(btnNewButton);

	}

}

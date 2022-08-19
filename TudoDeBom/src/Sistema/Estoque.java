package Sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class Estoque extends JFrame {

	private JPanel contentPane;
	private static List<String> lista;
	
	/**
	 * Launch the application.
	 */
	
	public static void estoque() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estoque frame = new Estoque();
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
	public Estoque() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 49, 505, 268);
		contentPane.add(scrollPane);
		HistoricoBancoDados bd = new HistoricoBancoDados();
		lista = new ArrayList<>(bd.getEstoque());
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		
		for (int i = 0; i < lista.size(); i++) {
		     model.addElement(lista.get(i));
		    
		    
		}
		
		JList<String> list = new JList<String>(model);
		
		
		scrollPane.setViewportView(list);
	}

}

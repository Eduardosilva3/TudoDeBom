package Sistema;


import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.List;

import Sistema.BancoDeDados;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * Design da Tela auxiliar - Cliente2
 * 
 * @author Katryn
 * 
 */

@SuppressWarnings("serial")
public class ClienteTela extends JInternalFrame{
	private JTextField txtCliNome;
	private JTextField txtCliEmail;
	private JTextField txtCliData;
	private JTextField txtCliCelular;
	private JTextField txtCliCPF;
	private JTextField txtIdCli;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTable tableClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteTela frame = new ClienteTela();
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
	public ClienteTela() {
		conexao = BancoDeDados.conectar();
		setBorder(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setNormalBounds(new Rectangle(15, 15, 465, 385));
		getContentPane().setBackground(SystemColor.menu);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Clientes");
		setBounds(100, 100, 611, 454);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome Completo: *");
		lblNewLabel_1.setBounds(62, 165, 130, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Email: *");
		lblNewLabel_2.setBounds(62, 266, 69, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Data de nascimento: *");
		lblNewLabel_4.setBounds(265, 266, 138, 14);
		getContentPane().add(lblNewLabel_4);

		txtCliNome = new JTextField();
		txtCliNome.setBounds(62, 190, 395, 20);
		getContentPane().add(txtCliNome);
		txtCliNome.setColumns(10);

		txtCliEmail = new JTextField();
		txtCliEmail.setBounds(62, 283, 168, 20);
		getContentPane().add(txtCliEmail);
		txtCliEmail.setColumns(10);

		txtCliData = new JTextField();
		txtCliData.setBounds(265, 283, 192, 20);
		getContentPane().add(txtCliData);
		txtCliData.setColumns(10);

		JLabel lblNewLabel = new JLabel("CPF: *");
		lblNewLabel.setBounds(62, 221, 81, 14);
		getContentPane().add(lblNewLabel);

		txtCliCelular = new JTextField();
		txtCliCelular.setBounds(265, 235, 192, 20);
		getContentPane().add(txtCliCelular);
		txtCliCelular.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Celular: *");
		lblNewLabel_3.setBounds(265, 221, 100, 14);
		getContentPane().add(lblNewLabel_3);

		txtCliCPF = new JTextField();
		txtCliCPF.setBounds(62, 235, 168, 20);
		txtCliCPF.setColumns(10);
		getContentPane().add(txtCliCPF);

		/**
		 * Botão responsável pro cadastrar os clientes
		 * 
		 * @author Neuvani
		 */
		JButton btnAdicionar = new JButton("CADASTRAR");
		btnAdicionar.setBounds(41, 356, 102, 23);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar.setForeground(new Color(245, 245, 245));
		btnAdicionar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnAdicionar.setBackground(new Color(46, 139, 87));
		getContentPane().add(btnAdicionar);

		/**
		 * Botão responsável pro pesquisar os clientes (por nome)
		 */
		JButton btnAlterar = new JButton("PESQUISAR");
		btnAlterar.setBounds(153, 356, 102, 23);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		btnAlterar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		getContentPane().add(btnAlterar);

		/**
		 * Botão responsável pela atualização dos clientes
		 */

		JButton btnNewButton_2 = new JButton("ATUALIZAR");
		btnNewButton_2.setBounds(265, 356, 102, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		getContentPane().add(btnNewButton_2);

		/**
		 * Método responsável por remover um cliente cadastrado
		 */
		JButton btnRemover = new JButton("EXCLUIR");
		btnRemover.setBounds(377, 356, 89, 23);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setForeground(new Color(230, 230, 250));
		btnRemover.setBackground(new Color(205, 92, 92));
		btnRemover.setFont(new Font("Segoe UI", Font.BOLD, 11));
		getContentPane().add(btnRemover);

		txtIdCli = new JTextField();
		txtIdCli.setBounds(10, 36, 298, 20);
		
		/**
		 * O evento abaixo é do tipo 'Enquanto for digitando'.
		 * */
		txtIdCli.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisar_cliente();
			}
		});
		getContentPane().add(txtIdCli);
		txtIdCli.setColumns(10);

		JLabel label = new JLabel("Pesquisar");
		label.setBounds(319, 36, 70, 14);
		getContentPane().add(label);

		JLabel lblNewLabel_5 = new JLabel("* Campos obrigatórios");
		lblNewLabel_5.setBounds(383, 331, 138, 14);
		getContentPane().add(lblNewLabel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 67, 585, 87);
		getContentPane().add(scrollPane_1);
		
		tableClientes = new JTable();
		tableClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Email", "CPF", "Data Nasc.", "Celular"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			@SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableClientes.getColumnModel().getColumn(0).setPreferredWidth(43);
		tableClientes.getColumnModel().getColumn(1).setPreferredWidth(130);
		tableClientes.getColumnModel().getColumn(2).setPreferredWidth(95);
		scrollPane_1.setViewportView(tableClientes);

	}

	private void consultar() {
		String sql = "select * from clientes where cpf_cliente=?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtIdCli.getText());
			rs = pst.executeQuery();
			if (rs.next()) {
				txtCliNome.setText(rs.getString(2));
				txtCliCelular.setText(rs.getString(6));
				txtCliEmail.setText(rs.getString(3));
				txtCliData.setText(rs.getString(5));
				txtCliCPF.setText(rs.getString(4));
			} else {
				JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
				// As linhas abaixo limpam os campos
				txtCliNome.setText(null);
				txtCliCelular.setText(null);
				txtCliEmail.setText(null);
				txtCliData.setText(null);
				txtCliCPF.setText(null);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Método para adicionar usuários
	 */
	private void adicionar() {
		String sql = "insert into clientes(nome_cliente,email_cliente,cpf_cliente,data_nasc,celular_cliente) values(?,?,?,?,?)";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtCliNome.getText());
			pst.setString(2, txtCliEmail.getText());
			pst.setString(3, txtCliCPF.getText());
			pst.setString(4, txtCliData.getText());
			pst.setString(5, txtCliCelular.getText());

			/**
			 * validação
			 *
			 */
			if ((txtCliNome.getText().isEmpty()) || (txtCliCelular.getText().isEmpty())
					|| (txtCliCPF.getText().isEmpty()) || (txtCliData.getText().isEmpty())
					|| (txtCliEmail.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
			} else {

				/**
				 * A linha abaixo confirma e atualiza a tabela clientes com os dados do
				 * formulário
				 */
				int adicionado = pst.executeUpdate();
				System.out.println(adicionado);
				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
					txtCliNome.setText(null);
					txtCliCelular.setText(null);
					txtCliEmail.setText(null);
					txtCliData.setText(null);
					txtCliCPF.setText(null);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Criando o método para alterar os dados do usuário
	 */
	private void alterar() {
		String sql = "update clientes set nome_cliente=?,email_cliente=?,data_nasc=?,celular_cliente=? where cpf_cliente=?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtCliNome.getText());
			pst.setString(2, txtCliEmail.getText());
			pst.setString(3, txtCliData.getText());
			pst.setString(4, txtCliCelular.getText());
			pst.setString(5, txtCliCPF.getText());

			int adicionado = pst.executeUpdate();
			if (adicionado > 0) {
				JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso");
				txtCliNome.setText(null);
				txtCliCelular.setText(null);
				txtCliEmail.setText(null);
				txtCliData.setText(null);
				txtCliCPF.setText(null);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	/**
	 * Método responsável pela remoção de usuários
	 */
	private void remover() {
		int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário?", "Atenção",
				JOptionPane.YES_NO_OPTION);

		if (confirma == JOptionPane.YES_OPTION) {
			String sql = "delete from clientes where cpf_cliente=?";

			try {
				pst = conexao.prepareStatement(sql);
				pst.setString(1, txtIdCli.getText());
				int apagado = pst.executeUpdate();
				if (apagado > 0) {
					JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
					txtCliNome.setText(null);
					txtCliCelular.setText(null);
					txtCliEmail.setText(null);
					txtCliData.setText(null);
					txtCliCPF.setText(null);
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	/**
	 * Método para pesquisar clientes por filtro e total
	 * */
	private void pesquisar_cliente() {
		String sql = "select * from clientes where nome_cliente like ?";
		try {
			pst = conexao.prepareStatement(sql);
			//Passando o conteúdo da caixa de pesquisa para o '?'
			pst.setString(1, txtIdCli.getText()+"%");
			rs = pst.executeQuery();
			// A linha abaixo usa biblioteca r2xml.jar para preencher a tabela
			tableClientes.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}

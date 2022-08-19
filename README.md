<div align="center">
<img src="https://user-images.githubusercontent.com/106891550/184989414-eb297f24-50da-4584-817c-5bf29741c1ab.png" width="700px"/>
</div>


Uma API para gerenciar transações na nova plataforma da <b>Farmácia Tudo de Bom</b> (loja fictícia).

O sistema  precisa ter as seguintes opções:
- Cadastro de Clientes
- Listagem de Clientes
- Atualização de Clientes
- Deletar Clientes
- Histórico de Transações
- Os Medicamentos Genéricos têm 20% de desconto


## Documentação

[Documentação](https://drive.google.com/drive/folders/1DyyfdhtnQ7aWwHYOW6irNbnZChyGh6Uf?usp=sharing)


## Licença

[MIT](https://choosealicense.com/licenses/mit/)


## Autores

- [@katrynribeiro](https://www.github.com/katrynribeiro)
- [@tatiramoos](https://www.github.com/tatiramoos)
- [@eduardosilva3](https://www.github.com/eduardosilva3)
- [@luiz-lab](https://www.github.com/luiz-lab)


## Lista dos Endpoints

- GET  /clientes -> Retorna uma lista de usuários

		// Método responsável pela listagem dos clientes
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
		
- GET  /clientes/carmem -> Retorna o usuário com username carmem

        // Método responsável por pesquisar um cliente pelo nome
        JButton btnAlterar = new JButton("PESQUISAR");
		btnAlterar.setBounds(153, 356, 102, 23);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
- POST  /clientes -> Cria um usuário

        // Método responsável pelo cadastro dos clientes
        JButton btnAdicionar = new JButton("CADASTRAR");
		btnAdicionar.setBounds(41, 356, 102, 23);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
- PUT  /clientes/carmem -> Atualiza o usuário carmem

        // Método responsável pela atualização do cliente
        JButton btnNewButton_2 = new JButton("ATUALIZAR");
		btnNewButton_2.setBounds(265, 356, 102, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
- DELETE  /clientes/carmem -> Remove o usuário carmem

        // Método responsável por deletar os clientes
        JButton btnRemover = new JButton("EXCLUIR");
		btnRemover.setBounds(377, 356, 89, 23);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}

Esse projeto faz parte do treinamento <b>If Black, Then Code</b> - Desafio #1 <b>IBM</b> e <b>Gama Academy</b>.

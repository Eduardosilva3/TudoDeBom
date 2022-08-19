package Sistema;
/**
 * 
 * - classe para receber dados da consulta do historico do banco de dados
 * 
 * @author Eduardo Silva
 * 
 */
public class ConsultaHistorico {
	private String idPedido;
	private String cpf;
	private String nome;
	private String valorTotal;
	private String data;
	
	

	public String getIdPedido() {
		return idPedido;
	}



	



	public ConsultaHistorico(String idPedido, String cpf, String nome, String valorTotal, String data) {
		super();
		this.idPedido = idPedido;
		this.cpf = cpf;
		this.nome = nome;
		this.valorTotal = valorTotal;
		this.data = data;
	}







	@Override
	public String toString() {
		return "ID-Pedido=" + idPedido + "|  CPF: " + cpf + "| Nome: " + nome + "| valorTotal ="
				+ valorTotal + "| Data: "+ data;
	}



	
}

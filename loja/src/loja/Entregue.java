package loja;

public class Entregue extends Situacao {

	@Override
	public void abrirChamado(PedidoInterface pedido) {
		System.out.println("chamado para pós venda");
	}
	
	

}

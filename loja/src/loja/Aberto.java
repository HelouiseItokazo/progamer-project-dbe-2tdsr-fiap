package loja;

public class Aberto extends Situacao{

	@Override
	public void abrirChamado(PedidoInterface pedido) {
		
		System.out.println("chamado para financeiro");		
	}

	@Override
	public void pagar(PedidoInterface pedido) {
		pedido.setSituacao(new Pago());
	}

	@Override
	public void cancelar(PedidoInterface pedido) {
		pedido.setSituacao(new Cancelado());

	}
	
	

}

package loja;

public class Cancelado extends Situacao {

	@Override
	public void abrirChamado(PedidoInterface pedido) {
		System.out.println("chamado para comercial");
	}

	@Override
	public void reabrir(PedidoInterface pedido) {
		pedido.setSituacao(new Aberto());
	}
	
	

}

package loja;

public class Pago extends Situacao{

	@Override
	public void abrirChamado(PedidoInterface pedido) {
		new ChamadoFacade().abrir(pedido);
		System.out.println("chamado para logistica");		
	}

	@Override
	public void entregar(PedidoInterface pedido) {
		pedido.setSituacao(new Entregue());
	}

	@Override
	public void cancelar(PedidoInterface pedido) {
		pedido.setSituacao(new Cancelado());

	}
	
	

}

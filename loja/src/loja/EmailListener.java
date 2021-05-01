package loja;

public class EmailListener implements PedidoListeners{

	@Override
	public void update(PedidoInterface pedido) {
		System.out.println("Enviando e-mail..");
	}
	
}

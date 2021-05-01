package loja;

public class LogListener implements PedidoListeners{

	@Override
	public void update(PedidoInterface pedido) {
		System.out.println("Registrando log");
	}

}

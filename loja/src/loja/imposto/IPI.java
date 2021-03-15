package loja.imposto;

import java.math.BigDecimal;

import loja.Pedido;

public class IPI implements Imposto{

	@Override
	public BigDecimal calcular(Pedido pedido) {
		return pedido.getValor().multiply(new BigDecimal("0.04"));
	}

}

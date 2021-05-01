package loja;

import java.math.BigDecimal;

public class PedidoProxy implements PedidoInterface {
	
	private Pedido pedido;
	private String endereco;
	
	public String getEndereco() {
		if (endereco == null) {
			endereco = pedido.getEndereco();
		}
		return endereco;
	}

	public void abrirChamado() {
		pedido.abrirChamado();
	}

	public int getQuantidadeDeItens() {
		return pedido.getQuantidadeDeItens();
	}

	public BigDecimal getValor() {
		return pedido.getValor();
	}

	public void pagar() {
		pedido.pagar();
	}

	public void entregar() {
		pedido.entregar();
	}

	public void cancelar() {
		pedido.cancelar();
	}

	public void reabrir() {
		pedido.reabrir();
	}

	public void setSituacao(Situacao situacao) {
		pedido.setSituacao(situacao);
	}

	public Situacao getSituacao() {
		return pedido.getSituacao();
	}

	public PedidoProxy(Pedido pedido) {
		super();
		this.pedido = pedido;
	}
	
	

	
}

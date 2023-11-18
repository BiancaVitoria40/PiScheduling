package com.teste.api.model.entidades;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@JsonIgnore
	@OneToOne
	@JoinColumn(name = "reserva_id")
	private ItemCarrinho reserva; // Um para um com Reserva após o pagamento

	private String status; // Confirmado, Pendente

	private LocalDateTime dataCriacao;

	public Pedido(String status, LocalDateTime dataCriacao, ItemCarrinho reserva) {
		super();
		this.status = status;
		this.dataCriacao = dataCriacao;
		this.reserva = reserva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public ItemCarrinho getReserva() {
		return reserva;
	}

	public void setReserva(ItemCarrinho reserva) {
		this.reserva = reserva;
	}

}

package edu.ifmt.cobrancaifmt;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // criando endidade java que sera salva no banco de dados
public class Titulo {

	@Id //Identifica a entidade;
	@GeneratedValue(strategy = GenerationType.IDENTITY) //estratégia - fica por conta do DB
	private Long codigo;
	@NotBlank(message = "A descricao é obrigatoria")
	@Size (max = 60, message="A descrição não pode ter mais que 60 caracteres")
	private String descricao;
	@NotBlank(message = "A data é obrigatoria")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	@NotNull (message = "O valor nao pode ser nulo")	//especificando que o valor nao pode ser null
	@DecimalMin (value ="0.01", message = "O valor não pode ser menor que 0,01")
	@DecimalMax( value = "999.99", message = "O valor não pode ser maior que 999.99")
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valor;
	@Enumerated(value = EnumType.STRING) //salva no db como string
	private StatusTitulo status;

	
	public boolean isPendente() {
		return StatusTitulo.PENDENTE.equals(this.status);
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public StatusTitulo getStatus() {
		return status;
	}
	public void setStatus(StatusTitulo status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titulo other = (Titulo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}

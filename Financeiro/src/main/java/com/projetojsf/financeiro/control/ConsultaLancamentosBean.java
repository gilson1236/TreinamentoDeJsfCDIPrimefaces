package com.projetojsf.financeiro.control;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.projetojsf.financeiro.model.Lancamento;
import com.projetojsf.financeiro.repository.Lancamentos;
import com.projetojsf.financeiro.service.CadastroLancamentos;
import com.projetojsf.financeiro.service.NegocioException;

@Named
@ViewScoped
public class ConsultaLancamentosBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Lancamentos lancamentosRepository;
	
	@Inject
	private CadastroLancamentos cadastro;
	
	private Lancamento lancamentoSelecionado;
	
	private List<Lancamento> lancamentos;
	
	public void consultar() {
		this.lancamentos = lancamentosRepository.todos();
	}
	
	public List<Lancamento> getLancamentos(){
		return lancamentos;
	}
	
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			this.cadastro.excluir(this.lancamentoSelecionado);
			this.consultar();
			
			context.addMessage(null, new FacesMessage("Lançamento excluído com Sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}
	
	
	
}

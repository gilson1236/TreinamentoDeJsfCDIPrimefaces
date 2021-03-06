package com.projetojsf.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.projetojsf.financeiro.model.Lancamento;
import com.projetojsf.financeiro.repository.Lancamentos;

@SuppressWarnings("rawtypes")
@FacesConverter(forClass = Lancamento.class)
public class LancamentosConverter implements Converter{

	@Inject
	private Lancamentos lancamentos;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Lancamento retorno = null;
		
		if(value!=null && !"".equals(value)) {
			retorno = this.lancamentos.porId(Long.parseLong(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null ) {
			Lancamento lancamento = (Lancamento)value;
			return lancamento.getId() == null? null : lancamento.getId().toString();
		}
		
		return null;
	}

}

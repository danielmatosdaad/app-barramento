package br.app.barramento.controlesessao.interfaces;

import br.app.servico.infra.integracao.dto.AplicativoDTO;

public interface ISessaoAplicativo extends ISessao{

	public AplicativoDTO getAplicativoDTO();	
}

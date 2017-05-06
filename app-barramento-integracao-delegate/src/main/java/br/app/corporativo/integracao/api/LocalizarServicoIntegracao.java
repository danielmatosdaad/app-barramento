package br.app.corporativo.integracao.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoIntegracao<IServicoUsuario> extends AbstractLocalizadorServico<IServicoUsuario> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "local.servico.integracao";
	private static final String REGISTRO_NOME_REMOTO = "remoto.servico.integracao";

	public LocalizarServicoIntegracao(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoIntegracao() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_LOCAL, REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

}

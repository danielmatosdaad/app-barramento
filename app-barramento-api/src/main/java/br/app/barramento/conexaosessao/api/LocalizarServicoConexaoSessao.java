package br.app.barramento.conexaosessao.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoConexaoSessao<IConexao> extends AbstractLocalizadorServico<IConexao> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL_USUARIO = "remoto.conexao.sessao.usuario";
	private static final String REGISTRO_NOME_REMOTO_USUARIO = "local.conexao.sessao.usuario";
	public static final String REGISTRO_NOME_LOCAL_APLICATIVO = "local.conexao.sessao.aplicativo";
	public static final String REGISTRO_NOME_REMOTO_APLICATIVO = "remoto.conexao.sessao.aplicativo";

	public LocalizarServicoConexaoSessao(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_REMOTO_USUARIO, REGISTRO_NOME_LOCAL_USUARIO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoConexaoSessao() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_REMOTO_USUARIO, REGISTRO_NOME_LOCAL_USUARIO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoConexaoSessao(TipoLocalizador remoto, String registroNomeLocal,
			String registroNomeRemoto) {
		super(remoto, registroNomeLocal, registroNomeRemoto,
				LOCALIZACAO_SERVICO);
	}

}

package br.app.barramento.integracao.dto;

public enum TipoAcao {

	SALVAR("SALVAR"), 
	SALVAR_LISTA("SALVAR_LISTA"), 
	EXCLUIR("EXCLUIR"), 
	ATUALIZAR("ATUALIZAR"), 
	BUSCAR_TODOS("BUSCAR_TODOS"), 
	BUSCAR_POR_ID("BUSCAR_POR_ID"), 
	EXCLUIR_POR_ID("EXCLUIR_POR_ID"), 
	BUSCAR_POR_INTERVALO("BUSCAR_POR_INTERVALO"), 
	SALVAR_SEM_RELACIONAMENTO("SALVAR_SEM_RELACIONAMENTO"), 
	EXECUTAR("EXECUTAR"),
	CONVERTER_ARQUIVO_COMPONENTE_TELA("CONVERTER_ARQUIVO_COMPONENTE_TELA"),
	CONVERTER_COMPOSITE_COMPONENTE_TELA("CONVERTER_COMPOSITE_COMPONENTE_TELA"),
	CONVERTER_COMPONENTE_TELA_UI("CONVERTER_COMPONENTE_TELA_UI"),
	SALVAR_TELA_UI("SALVAR_TELA_UI"),
	ABRIR_SESSAO_APLICATIVO("ABRIR_SESSAO_APLICATIVO"),
	ABRIR_SESSAO_USUARIO("ABRIR_SESSAO_USUARIO");
	
	private TipoAcao(String value) {

		this.value = value;
	}

	String value;

	public String getValue() {
		return value;
	}

	public static boolean isAcaoDAO(TipoAcao acao) {

		if (acao == null) {
			return false;
		}
		switch (acao) {

		case BUSCAR_POR_ID:
		case BUSCAR_POR_INTERVALO:
		case EXCLUIR_POR_ID:
		case BUSCAR_TODOS:
		case SALVAR:
		case SALVAR_LISTA:
		case ATUALIZAR:
		case EXCLUIR:
			return true;
		default:
			break;
		}
		return false;
	}

}

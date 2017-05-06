/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.app.barramento.servico.imp;

import java.io.Serializable;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import br.app.barramento.conexaosessao.api.ConexaoSessaoDelegate;
import br.app.barramento.controlesessao.dto.SessaoEnvioDTO;
import br.app.barramento.controlesessao.dto.SessaoRespostaDTO;
import br.app.barramento.controlesessao.dto.TipoSessao;
import br.app.barramento.controlesessao.interfaces.IConexao;
import br.app.barramento.controlesessao.interfaces.IControleSessaoLocal;
import br.app.barramento.controlesessao.interfaces.IControleSessaoRemote;
import br.app.barramento.controlesessao.interfaces.ISessao;
import br.app.barramento.controlesessao.interfaces.ISessaoUsuario;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;

/**
 *
 * @author daniel.matos
 */
@Stateless
@Remote(value = { IControleSessaoRemote.class })
@Local(value = { IControleSessaoLocal.class })
public class ControleSessaoImp implements IControleSessaoRemote, IControleSessaoLocal, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public SessaoRespostaDTO abrir(SessaoEnvioDTO sessaoEnvio) throws NegocioException, InfraEstruturaException {

		SessaoRespostaDTO resposta = new SessaoRespostaDTO();
		System.out.println("recebi a requisicao");

		ConexaoSessaoDelegate conexaoSessaoDelegate = getConexaoSessaoDelegate(sessaoEnvio.getTipoSessao());

		IConexao conexao = conexaoSessaoDelegate.getServico();

		ISessao sessao = conexao.abrirConexao(sessaoEnvio);
		System.out.println(conexao);
		resposta.setSessaoConexao(conexao);
		resposta.setSessao(sessao);
		return resposta;

	}

	private ConexaoSessaoDelegate getConexaoSessaoDelegate(TipoSessao tipoSessao) throws NegocioException {

		switch (tipoSessao) {
		case APLICATIVO:
			return ConexaoSessaoDelegate.getInstancia(TipoAcao.ABRIR_SESSAO_APLICATIVO);
		case USUARIO:
			return ConexaoSessaoDelegate.getInstancia(TipoAcao.ABRIR_SESSAO_USUARIO);
		default:
			break;
		}
		throw new NegocioException("Autenticacao invalidade", new RuntimeException());
	}

	@Override
	public void fechar(ISessaoUsuario sessaoEnvio) {

	}

}

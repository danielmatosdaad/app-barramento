package br.app.smart.api.main;

import br.app.barramento.controlesessao.api.ControleSessaoDelegate;
import br.app.barramento.controlesessao.dto.SessaoEnvioDTO;
import br.app.barramento.controlesessao.dto.SessaoRespostaDTO;
import br.app.barramento.controlesessao.interfaces.IConexao;
import br.app.barramento.controlesessao.interfaces.IControleSessao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.repositorio.servico.integracao.CatalogoServico;
import br.app.repositorio.servico.integracao.IRepositorio;
import br.app.repositorio.servico.integracao.InformacaoServico;
import br.app.repositorio.servico.integracao.RepositorioServico;

public class Main {

	public static void main(String args[]) throws InfraEstruturaException, NegocioException, ClassNotFoundException {

//		ControleSessaoDelegate delegate = ControleSessaoDelegate.getInstancia();
//		IControleSessao servico = delegate.getServico();
//
//		SessaoEnvioDTO envio = new SessaoEnvioDTO();
//		SessaoRespostaDTO resposta = servico.abrir(envio);
//		IConexao conexo = resposta.getConexao();
//		IRepositorio repositorio = resposta.getSessao().getRepositorioServico();
//
//		RepositorioServico rs = repositorio.buscar(RepositorioServico.RESPOSITORIO_CORPORATIVO);
//
//		if (rs != null) {
//
//			CatalogoServico catalogo = rs.buscar("CATALOGO_PMT");
//			if (catalogo != null) {
////
////				InformacaoServico informacoesServico = catalogo
////						.buscarInformacaoServico("br.app.corporativo.parametro.api.IServicoParametro");
//				if (informacoesServico != null) {
//
//					System.out.println(informacoesServico.getInterfaces());
//					System.out.println(informacoesServico.getDelegate());
//					System.out.println(informacoesServico.getEnvio());
//					System.out.println(informacoesServico.getReposta());
//				}
//			}
//
//		}

	}
}

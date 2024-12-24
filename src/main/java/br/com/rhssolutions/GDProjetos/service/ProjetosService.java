package br.com.rhssolutions.GDProjetos.service;

import br.com.rhssolutions.GDProjetos.domain.model.Projeto;

public interface ProjetosService {
    Iterable<Projeto> lista();

    Projeto salvar(Projeto projeto);

    void excluirPorId(Long id);

    Projeto buscarPorId(Long id);

    Projeto atualizar(Long id, Projeto projeto);
}

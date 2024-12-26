package br.com.rhssolutions.GDProjetos.service.impl;

import br.com.rhssolutions.GDProjetos.domain.model.Projeto;
import br.com.rhssolutions.GDProjetos.domain.repository.ProjetoRepository;
import br.com.rhssolutions.GDProjetos.service.ProjetosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetosServiceImpl implements ProjetosService {

    final ProjetoRepository projetosRepository;

    public ProjetosServiceImpl(ProjetoRepository projetosRepository) {
        this.projetosRepository = projetosRepository;
    }

    public Projeto salvar(Projeto projeto) {
        if (projetosRepository.findByNome(projeto.getNome()).isPresent()) {
            throw new IllegalArgumentException("Projeto já cadastrado com este nome!!");
        }
        if (projeto.getDataInicio().isAfter(projeto.getDataFim())) {
            throw new IllegalArgumentException("Data de início não pode ser maior que a data de fim");
        }
        return projetosRepository.save(projeto);
    }

    public List<Projeto> lista() {
        return projetosRepository.findAll();
    }

    public void excluirPorId(Long id) {
        var projeto = projetosRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Projeto não encontrado"));
        projetosRepository.delete(projeto);
    }

    public Projeto buscarPorId(Long id) {
        return projetosRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Projeto não encontrado"));
    }

    public Projeto atualizar(Long id, Projeto projetoAtualizado) {
        var projetoAtual = buscarPorId(id);
        projetoAtual.setNome(projetoAtualizado.getNome());
        projetoAtual.setDescricao(projetoAtualizado.getDescricao());
        projetoAtual.setDataInicio(projetoAtualizado.getDataInicio());
        projetoAtual.setDataFim(projetoAtualizado.getDataFim());
        projetoAtual.setStatus(projetoAtualizado.getStatus());

        if (projetoAtualizado.getDataInicio().isAfter(projetoAtualizado.getDataFim())) {
            throw new IllegalArgumentException("Data de início não pode ser maior que a data de fim");
        }

        return projetosRepository.save(projetoAtual);
    }


}

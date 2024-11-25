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


}

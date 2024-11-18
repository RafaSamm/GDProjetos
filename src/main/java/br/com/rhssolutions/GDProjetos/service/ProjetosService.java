package br.com.rhssolutions.GDProjetos.service;

import br.com.rhssolutions.GDProjetos.domain.model.Projeto;
import br.com.rhssolutions.GDProjetos.domain.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetosService {

    final ProjetoRepository projetosRepository;

    public ProjetosService(ProjetoRepository projetosRepository) {
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
}

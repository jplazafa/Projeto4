package com.example.democrud2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.democrud2.model.Produto;
import com.example.democrud2.repository.ProdutoRepository;

@Service // Indica que esta classe é um serviço gerenciado pelo Spring (lógica de negócios).
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository; // Injeta o repositório para operações no banco de dados.

    public List<Produto> findAll() {
        // Retorna todos os registros do banco de dados.
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        // Busca um registro pelo ID no banco de dados.
        return produtoRepository.findById(id);
    }

    public Produto save(Produto model) {
        // Salva um novo registro no banco de dados.
        return produtoRepository.save(model);
    }

    public boolean deleteById(Long id) {
        // Remove um registro pelo ID, se existir.
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Produto> update(Long id, Produto updatedModel) {
        // Atualiza um registro existente pelo ID.
        return produtoRepository.findById(id).map(existingModel -> {
            existingModel.setName(updatedModel.getName()); // Atualiza o campo "name".
            existingModel.setDescription(updatedModel.getDescription()); // Atualiza o campo "description".
            return produtoRepository.save(existingModel); // Salva as alterações no banco de dados.
        });
    }
}
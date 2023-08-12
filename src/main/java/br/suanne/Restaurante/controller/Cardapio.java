package br.suanne.Restaurante.controller;
import br.suanne.Restaurante.model.Funcionario;
import br.suanne.Restaurante.dto.CardapioRequestDTO;
import br.suanne.Restaurante.dto.CardapioResponseDTO;
import br.suanne.Restaurante.model.Prato;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("cardapio")
public class Cardapio {

    private List<Prato> pratos = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    @GetMapping
    public List<CardapioResponseDTO> getAll() { return pratos.stream().map(CardapioResponseDTO::new).toList();}
    @PostMapping
    public void addPrato(@RequestBody CardapioRequestDTO data) { pratos.add(new Prato(data));}
    @DeleteMapping
    public void deletePrato (@PathVariable Long id) {pratos.removeIf(prato -> prato.getId().equals(id));}

    public void editPrato(@PathVariable Long id, @RequestBody CardapioRequestDTO data) {
        for (Prato prato : pratos) {
            if (prato.getId().equals(id)){
                prato.setTitulo(data.titulo());
                prato.setDescricao(data.descricao());
                prato.setPreco(data.preco());
                break;
            }
        }
    }

    @PostMapping("/funcionario")
    public void addFuncionario(@RequestBody Funcionario data) {
        funcionarios.add(data);
    }

    @DeleteMapping("/funcionario/{id}")
    public void deleteFuncionario(@PathVariable Long id) {
        funcionarios.removeIf(funcionario -> funcionario.getId().equals(id));
    }

    @PutMapping("/funcionario/{id}")
    public void editFuncionario(@PathVariable Long id, @RequestBody Funcionario data) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId().equals(id)) {
                funcionario.setNome(data.getNome());
                funcionario.setCpf(data.getCpf());
                break;
            }
        }
    }

    @GetMapping("/funcionario")
    public List<Funcionario> getAllFuncionarios() {
        return funcionarios;
    }
}

package com.marlei.ms.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import com.marlei.ms.fornecedor.dto.ItemDoPedidoDTO;
import com.marlei.ms.fornecedor.entity.Pedido;
import com.marlei.ms.fornecedor.entity.PedidoItem;
import com.marlei.ms.fornecedor.entity.Produto;
import com.marlei.ms.fornecedor.repository.PedidoRepository;
import com.marlei.ms.fornecedor.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {
        if(itens == null) {
            return null;
        }
        List<PedidoItem> pedidoItens = toPedidoItem(itens);
        Pedido pedido = new Pedido(pedidoItens);
        pedido.setTempoDePreparo(itens.size());
        return pedidoRepository.save(pedido);
    }

    public Pedido getPedidoPorId(Long id) {
        return this.pedidoRepository.findById(id).orElse(new Pedido());
    }

    private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {
        List<Long> idsProdutos = itens
                .stream()
                .map(item -> item.getId())
                .collect(Collectors.toList());
        List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);
        List<PedidoItem> pedidoItens = itens
                .stream()
                .map(item -> {
                    Produto produto = produtosDoPedido
                            .stream()
                            .filter(p -> p.getId() == item.getId())
                            .findFirst().get();

                    PedidoItem pedidoItem = new PedidoItem();
                    pedidoItem.setProduto(produto);
                    pedidoItem.setQuantidade(item.getQuantidade());
                    return pedidoItem;
                })
                .collect(Collectors.toList());
        return pedidoItens;
    }
}

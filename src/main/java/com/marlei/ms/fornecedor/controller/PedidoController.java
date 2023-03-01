package com.marlei.ms.fornecedor.controller;

import java.util.List;

import com.marlei.ms.fornecedor.dto.ItemDoPedidoDTO;
import com.marlei.ms.fornecedor.entity.Pedido;
import com.marlei.ms.fornecedor.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private static final Logger LOG = LoggerFactory.getLogger(PedidoController.class);

    private final PedidoService pedidoService;

    @PostMapping
    public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
        LOG.info("pedido recebido");
        return pedidoService.realizaPedido(produtos);
    }

    @GetMapping("/{id}")
    public Pedido getPedidoPorId(@PathVariable Long id) {
        return pedidoService.getPedidoPorId(id);
    }
}

package com.marlei.ms.fornecedor.repository;

import com.marlei.ms.fornecedor.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

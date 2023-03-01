package com.marlei.ms.fornecedor.repository;

import com.marlei.ms.fornecedor.entity.InfoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<InfoFornecedor, Long> {

    InfoFornecedor findByEstado(String estado);
}

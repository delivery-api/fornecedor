package com.marlei.ms.fornecedor.service;

import com.marlei.ms.fornecedor.controller.InfoController;
import com.marlei.ms.fornecedor.entity.InfoFornecedor;
import com.marlei.ms.fornecedor.repository.InfoRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InfoService {

    private static final Logger LOG = LoggerFactory.getLogger(InfoService.class);

    private final InfoRepository infoRepository;

    public InfoFornecedor getInfoPorEstado(String estado) {

        LOG.info("buscando informações por estado de {}", estado);
        return infoRepository.findByEstado(estado);
    }
}

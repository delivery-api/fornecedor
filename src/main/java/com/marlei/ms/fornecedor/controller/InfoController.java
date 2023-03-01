package com.marlei.ms.fornecedor.controller;

import com.marlei.ms.fornecedor.entity.InfoFornecedor;
import com.marlei.ms.fornecedor.service.InfoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/infos")
public class InfoController {

    private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

    private final InfoService infoService;

    @GetMapping("/{estado}")
    public InfoFornecedor getInfoPorEstado(@PathVariable String estado){

        LOG.info("recebido pedido de informações do fornecedor de {}", estado);
        return infoService.getInfoPorEstado(estado);
    }
}

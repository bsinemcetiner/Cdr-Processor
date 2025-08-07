package com.Argela.service;

import com.Argela.dataTransferObject.CdrRequest;
import com.Argela.entities.Cdr;
import com.Argela.mapper.CdrMapper;
import com.Argela.repository.CdrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CdrServiceImpl implements CdrService {

    private final CdrRepository cdrRepository;
    private final CdrMapper cdrMapper;

    @Override
    public Cdr save(CdrRequest request) {
        return cdrRepository.save(cdrMapper.toEntity(request));
    }

    @Override
    public List<Cdr> saveAll(List<CdrRequest> requestList) {
        List<Cdr> cdrList = requestList.stream()
                .map(cdrMapper::toEntity)
                .collect(Collectors.toList());
        return cdrRepository.saveAll(cdrList);
    }
}

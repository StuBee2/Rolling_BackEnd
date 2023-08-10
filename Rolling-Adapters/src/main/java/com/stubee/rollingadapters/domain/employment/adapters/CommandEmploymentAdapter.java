package com.stubee.rollingadapters.domain.employment.adapters;

import com.stubee.rollingcommons.commons.annotations.Adapter;
import com.stubee.rollingdomains.domain.employment.model.Employment;
import com.stubee.rollingexternal.persistence.domain.employment.mapper.EmploymentMapper;
import com.stubee.rollingexternal.persistence.domain.employment.repository.CommandEmploymentJpaRepository;
import com.stubee.rollingports.domain.employment.ports.CommandEmploymentPort;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class CommandEmploymentAdapter implements CommandEmploymentPort {

    private final CommandEmploymentJpaRepository commandEmploymentJpaRepository;
    private final EmploymentMapper employmentMapper;

    @Override
    public Employment register(final Employment employment) {
        return employmentMapper.toDomain(commandEmploymentJpaRepository.save(employmentMapper.toEntity(employment)));
    }

}
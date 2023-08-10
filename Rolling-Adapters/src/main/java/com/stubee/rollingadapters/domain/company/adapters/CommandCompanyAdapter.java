package com.stubee.rollingadapters.domain.company.adapters;

import com.stubee.rollingcommons.commons.annotations.Adapter;
import com.stubee.rollingdomains.domain.company.model.Company;
import com.stubee.rollingdomains.domain.company.model.CompanyId;
import com.stubee.rollingexternal.persistence.domain.company.entity.CompanyEntity;
import com.stubee.rollingexternal.persistence.domain.company.mapper.CompanyMapper;
import com.stubee.rollingexternal.persistence.domain.company.repository.CommandCompanyJpaRepository;
import com.stubee.rollingports.domain.company.ports.CommandCompanyPort;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class CommandCompanyAdapter implements CommandCompanyPort {

    private final CommandCompanyJpaRepository commandCompanyJpaRepository;
    private final CompanyMapper companyMapper;

    @Override
    public Company create(final Company company) {
        return companyMapper.toDomain(save(companyMapper.toEntity(company)));
    }

    @Override
    public void update(final Company company) {
        save(companyMapper.toEntityWithId(company));
    }

    @Override
    public void deleteById(final CompanyId companyId) {
        commandCompanyJpaRepository.deleteById(companyId.id());
    }

    private CompanyEntity save(final CompanyEntity entity) {
        return commandCompanyJpaRepository.save(entity);
    }

}
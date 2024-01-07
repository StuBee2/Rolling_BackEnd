package rolling.jpamysql.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rolling.application.company.outport.CommandCompanyPort;
import rolling.domain.company.model.Company;
import rolling.domain.company.model.CompanyId;

import java.util.List;

import static rolling.jpamysql.company.CompanyMapper.*;

@Component
@RequiredArgsConstructor
class CompanyJPAAdapter implements CommandCompanyPort {

    private final CompanyJpaRepository repository;

    @Override
    public Company save(final Company company) {
        try {
            CompanyId id = company.companyId();
        } catch (NullPointerException e) {
            return toDomain(repository.save(toEntity(company)));
        }

        return toDomain(repository.save((toEntityWithId(company))));
    }

    @Override
    public void updateAll(final List<Company> companyList) {
        companyList.forEach(company -> repository.save(toEntityWithId(company)));
    }

    @Override
    public void deleteById(final CompanyId companyId) {
        repository.deleteById(companyId.getId());
    }

}
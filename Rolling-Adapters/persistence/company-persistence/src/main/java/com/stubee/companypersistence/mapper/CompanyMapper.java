package com.stubee.companypersistence.mapper;

import com.stubee.persistencecommons.annotations.DomainObjectMapper;
import com.stubee.persistencecommons.entity.CompanyEntity;
import com.stubee.rollingdomains.common.model.Grades;
import com.stubee.rollingdomains.domain.company.model.Company;
import com.stubee.rollingdomains.domain.company.model.CompanyDetails;
import com.stubee.rollingdomains.domain.company.model.CompanyId;
import com.stubee.rollingdomains.domain.company.model.RegistrantId;

import java.util.List;

@DomainObjectMapper
public class CompanyMapper implements com.stubee.persistencecommons.mapper.DomainObjectMapper<CompanyEntity, Company> {

    /** Company Entity Except Id */
    @Override
    public CompanyEntity toEntity(final Company domain) {
        return CompanyEntity.builder()
                .name(domain.companyDetails().name())
                .address(domain.companyDetails().companyAddress().address())
                .description(domain.companyDetails().description())
                .imgUrl(domain.companyDetails().imgUrl())
                .companyStatus(domain.companyDetails().companyStatus())
                .totalGrade(domain.companyGrades().totalGrade())
                .salaryAndBenefits(domain.companyGrades().salaryAndBenefits())
                .workLifeBalance(domain.companyGrades().workLifeBalance())
                .organizationalCulture(domain.companyGrades().organizationalCulture())
                .careerAdvancement(domain.companyGrades().careerAdvancement())
                .registrantId(domain.registrantId().getId())
                .build();
    }

    /** Company Entity With Id */
    public CompanyEntity toEntityWithId(final Company domain) {
        return CompanyEntity.builder()
                .id(domain.companyId().getId())
                .name(domain.companyDetails().name())
                .address(domain.companyDetails().companyAddress().address())
                .description(domain.companyDetails().description())
                .imgUrl(domain.companyDetails().imgUrl())
                .companyStatus(domain.companyDetails().companyStatus())
                .totalGrade(domain.companyGrades().totalGrade())
                .salaryAndBenefits(domain.companyGrades().salaryAndBenefits())
                .workLifeBalance(domain.companyGrades().workLifeBalance())
                .organizationalCulture(domain.companyGrades().organizationalCulture())
                .careerAdvancement(domain.companyGrades().careerAdvancement())
                .registrantId(domain.registrantId().getId())
                .createdAt(domain.companyDetails().createdAt())
                .build();
    }

    @Override
    public Company toDomain(final CompanyEntity entity) {
        if(entity==null) {
            return null;
        }

        return Company.createWithId(CompanyId.create(entity.getId()), companyDetails(entity),
                companyGrades(entity), RegistrantId.create(entity.getRegistrantId()));
    }

    public List<Company> toDomainList(final List<CompanyEntity> entityList) {
        return entityList.stream().map(this::toDomain).toList();
    }

    private CompanyDetails companyDetails(final CompanyEntity entity) {
        return CompanyDetails.createWithDate(entity.getName(), entity.getAddress(), entity.getDescription(), entity.getImgUrl(),
                entity.getCompanyStatus(), entity.getCreatedAt(), entity.getModifiedAt());
    }

    private Grades companyGrades(final CompanyEntity entity) {
        return Grades.createWithTotal(entity.getTotalGrade(), entity.getSalaryAndBenefits(), entity.getWorkLifeBalance(),
                entity.getOrganizationalCulture(), entity.getCareerAdvancement());
    }

}
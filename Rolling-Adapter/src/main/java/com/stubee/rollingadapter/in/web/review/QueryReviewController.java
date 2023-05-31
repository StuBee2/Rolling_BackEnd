package com.stubee.rollingadapter.in.web.review;

import com.stubee.rollingcore.common.dto.PageDto;
import com.stubee.rollingcore.domain.review.dto.response.ReviewInfoResponse;
import com.stubee.rollingapplication.domain.review.port.api.QueryReviewUseCase;
import com.stubee.rollingcore.domain.review.dto.response.ReviewQueryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Query Review", description = "Query Review API")
@RestController
@RequestMapping(value = "/review")
@RequiredArgsConstructor
public class QueryReviewController {

    private final QueryReviewUseCase queryReviewUseCase;

    @Operation(description = "id로 Review 단건 조회")
    @GetMapping("/info/{id}")
    @ResponseStatus(OK)
    public ReviewInfoResponse getInfo(final @PathVariable("id") UUID reviewId) {
        return queryReviewUseCase.getInfo(reviewId);
    }

    @Operation(description = "내가 쓴 Review List 조회")
    @GetMapping("/my")
    @ResponseStatus(OK)
    public List<ReviewQueryResponse> getMy(@ModelAttribute PageDto pageDto) {
        return queryReviewUseCase.getMy(pageDto);
    }

    @Operation(description = "Member Id로 Review List 조회")
    @GetMapping("/list/member/{id}")
    @ResponseStatus(OK)
    public List<ReviewQueryResponse> getReviewByMember(final @PathVariable("id") UUID memberId,
                                                       @ModelAttribute PageDto pageDto) {
        return queryReviewUseCase.getByMemberId(memberId, pageDto);
    }

    @Operation(description = "Company Id로 Review List 조회")
    @GetMapping("/list/company/{id}")
    @ResponseStatus(OK)
    public List<ReviewInfoResponse> getReviewByCompany(final @PathVariable("id") UUID companyID,
                                                       @ModelAttribute PageDto pageDto) {
        return queryReviewUseCase.getByCompanyId(companyID, pageDto);
    }

}
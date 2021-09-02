package co.withyou.care.common.review.mapper;

import org.mybatis.spring.annotation.MapperScan;

import co.withyou.care.common.review.service.ReviewVO;

@MapperScan
public interface ReviewMapper {
	ReviewVO selectReview(ReviewVO vo);
	int insertReview(ReviewVO vo);
	int deleteReview(int number);
	int updateReview(ReviewVO vo);

}

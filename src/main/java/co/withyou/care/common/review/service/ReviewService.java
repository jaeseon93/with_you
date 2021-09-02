package co.withyou.care.common.review.service;

public interface ReviewService {
	ReviewVO selectReview(ReviewVO vo);
	int insertReview(ReviewVO vo);
	int deleteReview(int number);
	int updateReview(ReviewVO vo);
}

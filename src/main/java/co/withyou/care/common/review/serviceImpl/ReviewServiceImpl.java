package co.withyou.care.common.review.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.common.review.mapper.ReviewMapper;
import co.withyou.care.common.review.service.ReviewService;
import co.withyou.care.common.review.service.ReviewVO;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewMapper mapper;

	@Override
	public ReviewVO selectReview(ReviewVO vo) {
		return mapper.selectReview(vo);
	}
	
	@Override
	public int insertReview(ReviewVO vo) {
		return mapper.insertReview(vo);
	}

	@Override
	public int deleteReview(int number) {
		return mapper.deleteReview(number);
	}

	@Override
	public int updateReview(ReviewVO vo) {
		return mapper.updateReview(vo);
	}


}

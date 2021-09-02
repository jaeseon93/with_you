package co.withyou.care.family.bestLike.mapper;

import org.mybatis.spring.annotation.MapperScan;

import co.withyou.care.family.apply.service.ApplyService;
import co.withyou.care.family.bestLike.service.BestLikeService;

@MapperScan
public interface BestLikeMapper extends BestLikeService{

}

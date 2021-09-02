package co.withyou.care.family.blackList.mapper;

import org.mybatis.spring.annotation.MapperScan;

import co.withyou.care.family.apply.service.ApplyService;
import co.withyou.care.family.bestLike.service.BestLikeService;
import co.withyou.care.family.blackList.service.BlackListService;

@MapperScan
public interface BlackListMapper extends BlackListService{

}

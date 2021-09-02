package co.withyou.care.family.search.mapper;

import org.mybatis.spring.annotation.MapperScan;

import co.withyou.care.family.search.service.SearchService;


@MapperScan
public interface SearchMapper extends SearchService{

}

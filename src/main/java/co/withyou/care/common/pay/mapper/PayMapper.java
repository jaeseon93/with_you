package co.withyou.care.common.pay.mapper;

import org.mybatis.spring.annotation.MapperScan;

import co.withyou.care.common.pay.service.PayService;


@MapperScan
public interface PayMapper extends PayService{

}

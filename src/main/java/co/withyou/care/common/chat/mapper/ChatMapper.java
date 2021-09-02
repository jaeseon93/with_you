package co.withyou.care.common.chat.mapper;

import org.mybatis.spring.annotation.MapperScan;

import co.withyou.care.common.chat.service.ChatService;

@MapperScan
public interface ChatMapper extends ChatService{

}

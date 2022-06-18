package edu.hi.ex.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Mapper
public interface TimeMapper {

    @Select("select sysdate from dual")
    public String getTime();
    
    public String getTime2();
}

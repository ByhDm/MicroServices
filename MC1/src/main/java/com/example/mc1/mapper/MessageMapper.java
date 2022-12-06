package com.example.mc1.mapper;

import com.example.mc1.dto.MessageDTO;
import com.example.mc1.entity.MessageEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageEntity messageDTOToMessageEntity(MessageDTO messageDTO);
}

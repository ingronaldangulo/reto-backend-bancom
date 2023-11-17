package pe.com.bancom.domain.dto;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostDtoTest {

    @Test
    void testDtoExist(){
        PostDto postDto = PostDto.builder()
                .id(1)
                .text("Mi primer post")
                .dateCreation(new Date())
                .build();

        assertEquals(1, postDto.getId());
        assertEquals("Mi primer post",postDto.getText());
    }
}

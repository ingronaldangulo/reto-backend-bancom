package pe.com.bancom.domain.entity;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostEntityTest {

    @Test
    void testEntityExist(){
        PostEntity postEntity = PostEntity.builder()
                .id(1)
                .text("Mi primer post")
                .dateCreation(new Date())
                .build();

        assertEquals(1, postEntity.getId());
        assertEquals("Mi primer post",postEntity.getText());
    }
}

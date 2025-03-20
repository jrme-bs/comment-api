package com.dtos;

import com.entities.CommentUser;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO pour représenter un commentaire.
 */
@Data
public class CommentDTO {
    private String id;
    private Integer pizzaId;
    private CommentUser user;
    private String content;
    private String photoUrl;
    private boolean isApproved;
    private LocalDateTime createdAt;
}

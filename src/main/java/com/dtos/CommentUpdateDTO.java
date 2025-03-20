package com.dtos;

import lombok.Data;

/**
 * DTO pour la mise à jour d'un commentaire existant.
 */
@Data
public class CommentUpdateDTO {
    private String content;
}
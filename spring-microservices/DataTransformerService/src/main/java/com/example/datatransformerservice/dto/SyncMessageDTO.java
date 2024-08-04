package com.example.datatransformerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SyncMessageDTO {
    private Long id;

    private String message;

    private LocalDateTime sentTime;

    private LocalDateTime processedTime;

    private boolean syncActive;
}

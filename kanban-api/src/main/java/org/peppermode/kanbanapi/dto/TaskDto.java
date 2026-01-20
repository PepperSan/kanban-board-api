package org.peppermode.kanbanapi.dto;

public record TaskDto(
        Long id,
        String title,
        String description,
        int priority
) {}

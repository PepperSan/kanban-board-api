package org.peppermode.kanbanapi.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateBoardRequest(
        @NotBlank String name
) {}

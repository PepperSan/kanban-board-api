package org.peppermode.kanbanapi.domain;

import lombok.Data;

@Data
public class Task {
    private String id;
    private String title;
    private String description;
    private int priority;
}

package org.peppermode.kanbanapi.domain;

import lombok.Data;
import java.util.List;

@Data
public class Column {
    private String id;
    private String name;
    private List<Task> tasks;
}

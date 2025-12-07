package org.peppermode.kanbanapi.domain;

import lombok.Data;
import java.util.List;

@Data
public class Board {
    private String id;
    private String name;
    private List<Column> columns;
}



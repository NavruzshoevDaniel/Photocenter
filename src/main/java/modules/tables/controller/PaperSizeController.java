package modules.tables.controller;

import modules.tables.entity.PaperSize;
import modules.tables.mapper.Mapper;
import modules.tables.repository.PaperSizeRepository;
import modules.tables.view.AbstractTableDataView;


import java.util.Map;

public class PaperSizeController extends AbstractTableController<PaperSize> {
    public PaperSizeController(AbstractTableDataView<PaperSize> view) {
        super(view);
        repository = new PaperSizeRepository();
    }

    @Override
    protected PaperSize createData(Map<String, Object> parameters) {
        return new PaperSize(new Mapper(parameters));
    }
}

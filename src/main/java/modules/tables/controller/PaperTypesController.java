package modules.tables.controller;

import modules.tables.entity.PaperType;
import modules.tables.mapper.Mapper;
import modules.tables.repository.PaperTypeRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class PaperTypesController extends AbstractTableController<PaperType> {
    public PaperTypesController(AbstractTableDataView<PaperType> view) {
        super(view);
        repository = new PaperTypeRepository();
    }

    @Override
    protected PaperType createData(Map<String, Object> parameters) {
        return new PaperType(new Mapper(parameters));
    }
}

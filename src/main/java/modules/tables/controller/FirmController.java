package modules.tables.controller;

import modules.tables.entity.Firm;
import modules.tables.mapper.Mapper;
import modules.tables.repository.FirmRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class FirmController extends AbstractTableController<Firm> {
    public FirmController(AbstractTableDataView<Firm> view) {
        super(view);
        repository = new FirmRepository();
    }

    @Override
    protected Firm createData(Map<String, Object> parameters) {
        return new Firm(new Mapper(parameters));
    }
}

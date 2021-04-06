package modules.tables.controller;

import modules.tables.entity.OutletType;
import modules.tables.mapper.Mapper;
import modules.tables.repository.OutletTypeRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class OutletTypesController extends AbstractTableController<OutletType> {
    public OutletTypesController(AbstractTableDataView<OutletType> view) {
        super(view);
        repository = new OutletTypeRepository();
    }

    @Override
    protected OutletType createData(Map<String, Object> parameters) {
        return new OutletType(new Mapper(parameters));
    }
}

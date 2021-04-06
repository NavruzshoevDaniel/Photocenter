package modules.tables.controller;

import modules.tables.entity.Outlet;
import modules.tables.mapper.Mapper;
import modules.tables.repository.OutletRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class OutletController extends AbstractTableController<Outlet>{
    public OutletController(AbstractTableDataView<Outlet> view) {
        super(view);
        repository= new OutletRepository();
    }

    @Override
    protected Outlet createData(Map<String, Object> parameters) {
        return new Outlet(new Mapper(parameters));
    }
}

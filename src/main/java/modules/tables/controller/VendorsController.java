package modules.tables.controller;

import modules.tables.entity.Vendor;
import modules.tables.mapper.Mapper;
import modules.tables.repository.VendorRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class VendorsController extends AbstractTableController<Vendor>{
    public VendorsController(AbstractTableDataView<Vendor> view) {
        super(view);
        repository= new VendorRepository();
    }

    @Override
    protected Vendor createData(Map<String, Object> parameters) {
        return new Vendor(new Mapper(parameters));
    }
}

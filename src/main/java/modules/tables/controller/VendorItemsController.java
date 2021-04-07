package modules.tables.controller;

import modules.tables.entity.VendorItem;
import modules.tables.mapper.Mapper;
import modules.tables.repository.VendorItemRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class VendorItemsController extends AbstractTableController<VendorItem>{

    public VendorItemsController(AbstractTableDataView<VendorItem> view) {
        super(view);
        repository= new VendorItemRepository();
    }

    @Override
    protected VendorItem createData(Map<String, Object> parameters) {
        return new VendorItem(new Mapper(parameters));
    }
}

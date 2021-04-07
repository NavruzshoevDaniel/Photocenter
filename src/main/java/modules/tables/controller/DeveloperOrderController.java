package modules.tables.controller;

import modules.tables.entity.DeveloperOrder;
import modules.tables.mapper.Mapper;
import modules.tables.repository.DeveloperOrderRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class DeveloperOrderController extends AbstractTableController<DeveloperOrder> {
    public DeveloperOrderController(AbstractTableDataView<DeveloperOrder> view) {
        super(view);
        repository = new DeveloperOrderRepository();
    }

    @Override
    protected DeveloperOrder createData(Map<String, Object> parameters) {
        return new DeveloperOrder(new Mapper(parameters));
    }
}

package modules.tables.controller;

import modules.tables.entity.ServiceOrder;
import modules.tables.mapper.Mapper;
import modules.tables.repository.ServiceOrderRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class ServiceOrderController extends AbstractTableController<ServiceOrder>{
    public ServiceOrderController(AbstractTableDataView<ServiceOrder> view) {
        super(view);
        repository= new ServiceOrderRepository();
    }

    @Override
    protected ServiceOrder createData(Map<String, Object> parameters) {
        return new ServiceOrder(new Mapper(parameters));
    }
}

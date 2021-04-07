package modules.tables.controller;

import modules.tables.entity.SaleOrder;
import modules.tables.mapper.Mapper;
import modules.tables.repository.SaleOrderRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class SaleOrderController extends AbstractTableController<SaleOrder>{
    public SaleOrderController(AbstractTableDataView<SaleOrder> view) {
        super(view);
        repository= new SaleOrderRepository();
    }

    @Override
    protected SaleOrder createData(Map<String, Object> parameters) {
        return new SaleOrder(new Mapper(parameters));
    }
}

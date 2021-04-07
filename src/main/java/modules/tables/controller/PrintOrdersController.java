package modules.tables.controller;

import modules.tables.entity.PrintOrder;
import modules.tables.mapper.Mapper;
import modules.tables.repository.PrintOrderRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class PrintOrdersController extends AbstractTableController<PrintOrder>{

    public PrintOrdersController(AbstractTableDataView<PrintOrder> view) {
        super(view);
        repository= new PrintOrderRepository();
    }

    @Override
    protected PrintOrder createData(Map<String, Object> parameters) {
        return new PrintOrder(new Mapper(parameters));
    }
}

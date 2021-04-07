package modules.tables.controller;

import modules.tables.entity.Order;
import modules.tables.mapper.Mapper;
import modules.tables.repository.OrderRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class OrderController extends AbstractTableController<Order> {
    public OrderController(AbstractTableDataView<Order> view) {
        super(view);
        repository = new OrderRepository();
    }

    @Override
    protected Order createData(Map<String, Object> parameters) {
        return new Order(new Mapper(parameters));
    }
}

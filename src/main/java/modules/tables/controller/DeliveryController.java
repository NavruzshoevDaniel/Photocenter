package modules.tables.controller;

import modules.tables.entity.Delivery;
import modules.tables.mapper.Mapper;
import modules.tables.repository.DeliveryRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class DeliveryController extends AbstractTableController<Delivery> {
    public DeliveryController(AbstractTableDataView<Delivery> view) {
        super(view);
        repository= new DeliveryRepository();
    }

    @Override
    protected Delivery createData(Map<String, Object> parameters) {
        return new Delivery(new Mapper(parameters));
    }
}

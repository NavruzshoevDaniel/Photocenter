package modules.tables.controller;

import modules.tables.entity.DeveloperPrice;
import modules.tables.mapper.Mapper;
import modules.tables.repository.DeveloperPriceRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class DeveloperPricesController extends AbstractTableController<DeveloperPrice> {
    public DeveloperPricesController(AbstractTableDataView<DeveloperPrice> view) {
        super(view);
        repository = new DeveloperPriceRepository();
    }

    @Override
    protected DeveloperPrice createData(Map<String, Object> parameters) {
        return new DeveloperPrice(new Mapper(parameters));
    }
}

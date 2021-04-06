package modules.tables.controller;

import modules.tables.entity.PrintPrice;
import modules.tables.mapper.Mapper;
import modules.tables.repository.PrintPriceRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class PrintPricesController extends AbstractTableController<PrintPrice> {
    public PrintPricesController(AbstractTableDataView<PrintPrice> view) {
        super(view);
        repository = new PrintPriceRepository();
    }

    @Override
    protected PrintPrice createData(Map<String, Object> parameters) {
        return new PrintPrice(new Mapper(parameters));
    }
}

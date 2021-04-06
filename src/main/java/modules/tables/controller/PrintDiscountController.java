package modules.tables.controller;

import modules.tables.entity.PrintDiscount;
import modules.tables.mapper.Mapper;
import modules.tables.repository.PrintDiscountRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class PrintDiscountController extends AbstractTableController<PrintDiscount> {
    public PrintDiscountController(AbstractTableDataView<PrintDiscount> view) {
        super(view);
        repository = new PrintDiscountRepository();
    }

    @Override
    protected PrintDiscount createData(Map<String, Object> parameters) {
        return new PrintDiscount(new Mapper(parameters));
    }
}

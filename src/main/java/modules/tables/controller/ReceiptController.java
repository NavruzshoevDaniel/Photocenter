package modules.tables.controller;

import modules.tables.entity.Receipt;
import modules.tables.mapper.Mapper;
import modules.tables.repository.ReceiptRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class ReceiptController extends AbstractTableController<Receipt> {
    public ReceiptController(AbstractTableDataView<Receipt> view) {
        super(view);
        repository= new ReceiptRepository();
    }

    @Override
    protected Receipt createData(Map<String, Object> parameters) {
        return new Receipt(new Mapper(parameters));
    }
}

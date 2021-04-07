package modules.tables.controller;

import modules.tables.entity.Item;
import modules.tables.mapper.Mapper;
import modules.tables.repository.ItemRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class ItemController extends AbstractTableController<Item> {
    public ItemController(AbstractTableDataView<Item> view) {
        super(view);
        repository = new ItemRepository();
    }

    @Override
    protected Item createData(Map<String, Object> parameters) {
        return new Item(new Mapper(parameters));
    }
}

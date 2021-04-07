package modules.tables.controller;

import modules.tables.entity.Storage;
import modules.tables.mapper.Mapper;
import modules.tables.repository.StorageRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class StorageController extends AbstractTableController<Storage>{
    public StorageController(AbstractTableDataView<Storage> view) {
        super(view);
        repository= new StorageRepository();
    }

    @Override
    protected Storage createData(Map<String, Object> parameters) {
        return new Storage(new Mapper(parameters));
    }
}

package modules.tables.controller;

import modules.tables.entity.ServiceType;
import modules.tables.mapper.Mapper;
import modules.tables.repository.ServiceTypeRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class ServiceTypeController extends AbstractTableController<ServiceType>{
    public ServiceTypeController(AbstractTableDataView<ServiceType> view) {
        super(view);
        repository= new ServiceTypeRepository();
    }

    @Override
    protected ServiceType createData(Map<String, Object> parameters) {
        return new ServiceType(new Mapper(parameters));
    }
}

package modules.tables.controller;

import modules.tables.entity.Profession;
import modules.tables.mapper.Mapper;
import modules.tables.repository.ProfessionRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class ProfessionController extends AbstractTableController<Profession>{
    public ProfessionController(AbstractTableDataView<Profession> view) {
        super(view);
        repository= new ProfessionRepository();
    }

    @Override
    protected Profession createData(Map<String, Object> parameters) {
        return new Profession(new Mapper(parameters));
    }
}

package modules.tables.controller;

import modules.tables.entity.Frame;
import modules.tables.mapper.Mapper;
import modules.tables.repository.FrameRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class FramesController extends AbstractTableController<Frame>{
    public FramesController(AbstractTableDataView<Frame> view) {
        super(view);
        repository= new FrameRepository();
    }

    @Override
    protected Frame createData(Map<String, Object> parameters) {
        return new Frame(new Mapper(parameters));
    }
}

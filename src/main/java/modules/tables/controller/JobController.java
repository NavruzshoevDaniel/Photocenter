package modules.tables.controller;

import modules.tables.entity.Job;
import modules.tables.mapper.Mapper;
import modules.tables.repository.JobRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

public class JobController extends AbstractTableController<Job> {
    public JobController(AbstractTableDataView<Job> view) {
        super(view);
        repository = new JobRepository();
    }

    @Override
    protected Job createData(Map<String, Object> parameters) {
        return new Job(new Mapper(parameters));
    }
}

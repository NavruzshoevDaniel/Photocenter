package modules.quarries.controllers;

import modules.quarries.dto.SearchCriteria;
import modules.quarries.mappers.IQueryMapper;

import java.util.List;

public interface IFilterQueryController {

    void postSearchCriteria(List<SearchCriteria> searchCriteria);
}

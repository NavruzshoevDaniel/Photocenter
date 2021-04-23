package modules.quarries.views;

import commons.sqlbuilder.Operation;
import commons.view.filters.SearchTextFormFilter;
import modules.quarries.controllers.IFilterQueryController;
import modules.quarries.mappers.PointsOrderingMapper;

import java.util.Arrays;
import java.util.List;

public class PointsOrderingView extends AbstractFilterQueryView {
    public PointsOrderingView( IFilterQueryController controller) {
        super( controller);
    }

    @Override
    protected void configureFilters(List<ContainerFilter> containerFilters) {
        SearchTextFormFilter searchTextFormFilter = new SearchTextFormFilter(
                PointsOrderingMapper.OUTLET_TYPE.getViewPresentation(),
                Arrays.asList(1, 2, 2, 1)
        );
        containerFilters.add(new ContainerFilter(PointsOrderingMapper.OUTLET_TYPE, searchTextFormFilter,
                Operation.LIKE));
    }
}

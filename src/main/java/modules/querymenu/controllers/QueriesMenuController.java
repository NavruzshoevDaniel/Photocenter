package modules.querymenu.controllers;

import lombok.extern.slf4j.Slf4j;
import modules.quarries.controllers.FilterQueryController;
import modules.quarries.mappers.ColumnsMapper;
import modules.quarries.views.PointsOrderingView;
import modules.quarries.views.factory.QueriesViewFactory;
import modules.querymenu.entity.IQuarries;
import modules.querymenu.router.IQuarriesRouter;
import modules.querymenu.router.QueriesRouter;
import modules.querymenu.view.IQueriesMenuView;
import modules.quarries.views.AbstractFilterQueryView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class QueriesMenuController implements IQueriesMenuController {
    private final IQuarries quarries;
    private final IQueriesMenuView queriesMenuView;
    private final IQuarriesRouter router = new QueriesRouter();

    public QueriesMenuController(IQuarries quarries, IQueriesMenuView queriesMenuView) {
        this.quarries = quarries;
        this.queriesMenuView = queriesMenuView;
    }

    @Override
    public void init() {
        queriesMenuView.addQuarriesList(quarries.getQuarriesNames());
    }

    @Override
    public void routeToQuery(String query) {
        try {
            String queryPropertyKey = quarries.getPropertyKeyBy(query);
            FilterQueryController queryController = new FilterQueryController(queryPropertyKey);
            AbstractFilterQueryView view = QueriesViewFactory.getInstance()
                    .createView(queryPropertyKey, queryController);
            queryController.setFilterQueryView(view);

        } catch (IOException | InstantiationException |
                InvocationTargetException | NoSuchMethodException |
                IllegalAccessException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void routeToMenu() {
        router.routeToMenu(queriesMenuView.getJFrame());
    }
}

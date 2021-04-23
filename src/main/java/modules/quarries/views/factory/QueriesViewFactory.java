package modules.quarries.views.factory;

import commons.view.factory.ViewFactory;
import lombok.extern.slf4j.Slf4j;
import modules.quarries.controllers.IFilterQueryController;
import modules.quarries.views.AbstractFilterQueryView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class QueriesViewFactory extends ViewFactory {
    private static final Path CONFIG_TABLE_FILE = Paths.get("queries","queriesViews.properties");

    private QueriesViewFactory() {
        super();
    }

    @Override
    protected Path getConfigPath() {
        return CONFIG_TABLE_FILE;
    }

    public static QueriesViewFactory getInstance() {
        return QueriesViewFactory.Handle.INSTANCE;
    }

    public AbstractFilterQueryView createView(String tableName, IFilterQueryController controller)
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            InvocationTargetException,
            NoSuchMethodException {
        final String property = tablesProperty.getProperty(tableName);
        if (property == null) {
            throw new IllegalArgumentException("No such view:" + tableName);
        }
        final Class<?> tableClass = Class.forName(property);
        final Constructor<?> constructor = tableClass.getConstructor(IFilterQueryController.class);
        return (AbstractFilterQueryView) constructor.newInstance(controller);
    }

    private static class Handle {
        private static final QueriesViewFactory INSTANCE = new QueriesViewFactory();
    }

}

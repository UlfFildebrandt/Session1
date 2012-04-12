package arch.datadisplay.retrieval;

import java.util.ArrayList;
import java.util.List;

import arch.datasourceinterface.IDataSource;

abstract class DataAggregator implements IDataAggregator {

    protected List<IDataSource> dataSources = new ArrayList<IDataSource>();

    @Override
    public void addDataSource(IDataSource inf) {
        dataSources.add(inf);
    }

    @Override
    public void addDataSource(List<IDataSource> infs) {
        dataSources.addAll(infs);
    }
}

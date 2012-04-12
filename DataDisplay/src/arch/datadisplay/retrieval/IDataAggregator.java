package arch.datadisplay.retrieval;

import java.util.List;

import arch.datasourceinterface.IDataItem;
import arch.datasourceinterface.IDataSource;

public interface IDataAggregator {
    public List<IDataItem> get();

    public void addDataSource(IDataSource inf);

    public void addDataSource(List<IDataSource> infs);
}

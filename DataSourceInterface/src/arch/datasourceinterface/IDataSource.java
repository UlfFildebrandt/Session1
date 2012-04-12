package arch.datasourceinterface;

import java.util.List;

public interface IDataSource {
    public List<IDataItem> getData();

    public String getArea();
}

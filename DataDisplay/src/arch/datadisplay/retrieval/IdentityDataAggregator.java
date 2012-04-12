package arch.datadisplay.retrieval;

import java.util.ArrayList;
import java.util.List;

import arch.datasourceinterface.IDataItem;
import arch.datasourceinterface.IDataSource;

final class IdentityDataAggregator extends DataAggregator {

    @Override
    public ArrayList<IDataItem> get() {
        ArrayList<IDataItem> itemList = new ArrayList<IDataItem>();

        for (int dataSourceIdx = 0; dataSourceIdx < this.dataSources.size(); dataSourceIdx++) {
            IDataSource dataSource = this.dataSources.get(dataSourceIdx);

            List<IDataItem> dataSourceList = dataSource.getData();
            for (int dataSourceItemsIdx = 0; dataSourceItemsIdx < dataSourceList.size(); dataSourceItemsIdx++)
                itemList.add(dataSourceList.get(dataSourceItemsIdx));
        }

        return itemList;
    }
}

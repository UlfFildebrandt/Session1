package arch.datadisplay.ui;

import java.util.ArrayList;

import arch.datasourceinterface.IDataSource;

public class TableObject {
    private String type;
    private String title;
    private StringBuilder buffer;

    private ArrayList<IDataSource> dataSources = new ArrayList<IDataSource>();

    public TableObject(String type, String title, StringBuilder buffer) {
        super();
        this.type = type;
        this.title = title;
        this.buffer = buffer;
    }

    public String getType() {
        return this.type;
    }

    public String getTitle() {
        return this.title;
    }

    public StringBuilder getBuffer() {
        return this.buffer;
    }

    public void addDataSource(IDataSource ds) {
        this.dataSources.add(ds);
    }

    public ArrayList<IDataSource> getDataSources() {
        return this.dataSources;
    }

}

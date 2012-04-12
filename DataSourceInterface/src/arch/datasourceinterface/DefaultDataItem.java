package arch.datasourceinterface;

public class DefaultDataItem implements IDataItem {

    private String company = "";
    private int revenue = 0;
    private String area = "";

    public DefaultDataItem(String company, int revenue) {
        this.company = company;
        this.revenue = revenue;
    }

    @Override
    public String getCompany() {
        return this.company;
    }

    @Override
    public int getRevenue() {
        return this.revenue;
    }

    @Override
    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

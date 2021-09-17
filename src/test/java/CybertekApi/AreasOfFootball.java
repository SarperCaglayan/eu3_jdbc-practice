package CybertekApi;

public class AreasOfFootball {

    private int id;
    private String name;
    private String countryCode;
    private String ensignUrl;
    private int parentAreaId;
    private String parentArea;

    @Override
    public String toString() {
        return "AreasofAPIfootball{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", ensignUrl='" + ensignUrl + '\'' +
                ", parentAreaId=" + parentAreaId +
                ", parentArea='" + parentArea + '\'' +
                '}';
    }

    public AreasOfFootball() {
    }

    public AreasOfFootball(int id, String name, String countryCode, String ensignUrl, int parentAreaId, String parentArea) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.ensignUrl = ensignUrl;
        this.parentAreaId = parentAreaId;
        this.parentArea = parentArea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getEnsignUrl() {
        return ensignUrl;
    }

    public void setEnsignUrl(String ensignUrl) {
        this.ensignUrl = ensignUrl;
    }

    public int getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(int parentAreaId) {
        this.parentAreaId = parentAreaId;
    }

    public String getParentArea() {
        return parentArea;
    }

    public void setParentArea(String parentArea) {
        this.parentArea = parentArea;
    }
}

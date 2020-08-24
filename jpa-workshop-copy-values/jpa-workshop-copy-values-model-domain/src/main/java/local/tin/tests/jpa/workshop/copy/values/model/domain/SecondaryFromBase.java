package local.tin.tests.jpa.workshop.copy.values.model.domain;

/**
 *
 * @author benitodarder
 */
public class SecondaryFromBase extends Base {

    private String value02;
    private Double value03;
    private MasterFromBase masterFromBase;

    public String getValue02() {
        return value02;
    }

    public void setValue02(String value02) {
        this.value02 = value02;
    }

    public Double getValue03() {
        return value03;
    }

    public void setValue03(Double value03) {
        this.value03 = value03;
    }

    public MasterFromBase getMasterFromBase() {
        return masterFromBase;
    }

    public void setMasterFromBase(MasterFromBase master) {
        this.masterFromBase = master;
    }

    @Override
    public String toString() {
        return "SecondaryFromBase{" + "value02=" + value02 + ", value03=" + value03 + ", masterFromBase=" + masterFromBase + ", " + super.toString() + '}';
    }


}

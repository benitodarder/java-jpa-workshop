package local.tin.tests.jpa.workshop.copy.values.model.domain;

import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author benitodarder
 */
public class MasterFromBase extends Base {

    private Double value01;
    private String value02;
    private Double value03;
    private Collection<SecondaryFromBase> secondaryFromBases;

    public Double getValue01() {
        return value01;
    }

    public void setValue01(Double value01) {
        this.value01 = value01;
    }

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

    public Collection<SecondaryFromBase> getSecondaryFromBases() {
        if (secondaryFromBases == null) {
            secondaryFromBases = new HashSet<>();
        }
        return secondaryFromBases;
    }

    public void setSecondaryFromBases(Collection<SecondaryFromBase> secondaryFromBases) {
        this.secondaryFromBases = secondaryFromBases;
    }

    @Override
    public String toString() {
        return "MasterFromBase{" + "value01=" + value01 + ", value02=" + value02 + ", value03=" + value03 + ", secondaryFromBases=" + secondaryFromBases+ ", " + super.toString() + '}';
    }





}

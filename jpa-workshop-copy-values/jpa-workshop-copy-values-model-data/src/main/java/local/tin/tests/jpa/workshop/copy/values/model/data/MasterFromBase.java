package local.tin.tests.jpa.workshop.copy.values.model.data;

import java.util.Collection;
import java.util.HashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author benitodarder
 */
@Entity
@Table(name = "MASTER_FROM_BASE")
@PrimaryKeyJoinColumn(name = "ID")
public class MasterFromBase extends Base { 
    
    
    @Column(name = "VALUE01")
    private Double value01;
    @Column(name = "VALUE02")
    private String value02;
    @Column(name = "VALUE03")
    private Double value03;
    @OneToMany(mappedBy = "masterFromBase", fetch = FetchType.LAZY)
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
    
}

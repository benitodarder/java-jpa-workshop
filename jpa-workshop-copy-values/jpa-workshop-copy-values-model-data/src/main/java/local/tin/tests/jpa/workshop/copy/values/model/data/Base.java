package local.tin.tests.jpa.workshop.copy.values.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import local.tin.tests.jpa.workshop.model.data.abstracts.AbstractNamed;

/**
 *
 * @author benitodarder
 */
@Entity
@Table(name = "BASE")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Base extends AbstractNamed {
    
    @Id
    @GeneratedValue(generator = "base_sequence_generator")
    @SequenceGenerator(name = "base_sequence_generator", sequenceName = "seq_base_Id")
    private Integer id;
    @Column(name = "COMMONVALUE")
    private String commonValue;    

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }



    public String getCommonValue() {
        return commonValue;
    }

    public void setCommonValue(String commonValue) {
        this.commonValue = commonValue;
    }
    
    
    
}

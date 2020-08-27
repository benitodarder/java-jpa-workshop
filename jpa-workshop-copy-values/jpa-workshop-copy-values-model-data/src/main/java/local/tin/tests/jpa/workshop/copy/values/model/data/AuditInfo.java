package local.tin.tests.jpa.workshop.copy.values.model.data;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author benitodarder
 */
@MappedSuperclass
public class AuditInfo  {

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "AU_USERIDINS")
    private Integer idUserInsert;

    @Column(name = "INSERTDATE")
    private Timestamp insertDate;

    @Column(name = "AU_USERIDUPD")
    private Integer idUserUpdate;

    @Column(name = "MODIFYDATE")
    private Timestamp modifyDate;

    @Column(name = "DBUSERINS")
    private String dbUserIns;

    @Column(name = "DBUSERUPD")
    private String dbUserUpdate;



    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public Integer getIdUserInsert() {
        return idUserInsert;
    }

    public void setIdUserInsert(Integer idUserInsert) {
        this.idUserInsert = idUserInsert;
    }


    public Timestamp getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }


    public Integer getIdUserUpdate() {
        return idUserUpdate;
    }

    public void setIdUserUpdate(Integer idUserUpdate) {
        this.idUserUpdate = idUserUpdate;
    }


    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }


    public String getDbUserIns() {
        return dbUserIns;
    }

    public void setDbUserIns(String dbUserIns) {
        this.dbUserIns = dbUserIns;
    }


    public String getDbUserUpdate() {
        return dbUserUpdate;
    }

    public void setDbUserUpdate(String dbUserUpdate) {
        this.dbUserUpdate = dbUserUpdate;
    }
}

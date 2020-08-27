package local.tin.tests.jpa.workshop.copy.values.model.domain;

import java.util.Date;

/**
 *
 * @author benitodarder
 */
public class AuditInfo  {

    private Integer version;
    private Integer idUserInsert;
    private Date insertDate;
    private Integer idUserUpdate;
    private Date modifyDate;
    private String dbUserIns;
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


    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }


    public Integer getIdUserUpdate() {
        return idUserUpdate;
    }

    public void setIdUserUpdate(Integer idUserUpdate) {
        this.idUserUpdate = idUserUpdate;
    }


    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
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

    @Override
    public String toString() {
        return "AuditInfo{" + "version=" + version + ", idUserInsert=" + idUserInsert + ", insertDate=" + insertDate + ", idUserUpdate=" + idUserUpdate + ", modifyDate=" + modifyDate + ", dbUserIns=" + dbUserIns + ", dbUserUpdate=" + dbUserUpdate + '}';
    }
    
    
}


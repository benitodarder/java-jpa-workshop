package local.tin.tests.jpa.workshop.model.domain;

import local.tin.tests.jpa.workshop.model.domain.interfaces.IDomain;

/**
 *
 * @author benitodarder
 */
public class Pagination implements IDomain {
    
    private int page;
    private int pageSize;

    public Pagination() {
    }    
    
    public Pagination(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

package local.tin.tests.jpa.workshop.dao.utils;

import java.sql.Timestamp;
import java.util.Date;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author benitodarder
 */
public class CommonDAOUtilsTest {
    
    @Test
    public void getTimeStampFromDate_returns_expected_timestamp() {
        Date now = new Date();
        
        Timestamp timestamp = CommonDAOUtils.getInstance().getTimeStampFromDate(now);
        
        assertThat(timestamp.getTime(), equalTo(now.getTime()));
    }
    
    @Test
    public void getSQLDateFromDate_returns_expected_timestamp() {
        Date now = new Date();
        
        java.sql.Date sqlDate = CommonDAOUtils.getInstance().getSQLDateFromDate(now);
        
        assertThat(sqlDate.getTime(), equalTo(now.getTime()));
    }      
    
}

package local.tin.tests.jpa.workshop.model.domain.errors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import local.tin.tests.jpa.workshop.model.domain.abstracts.AbstractDomain;
import local.tin.tests.jpa.workshop.model.domain.enums.ErrorCode;
import local.tin.tests.jpa.workshop.model.domain.interfaces.IDomain;

/**
 *
 * @author benito.darder
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({AbstractDomain.class})
public class CommonError implements IDomain {
    
    private ErrorCode errorCode;
    private String errorMessage;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
   
}

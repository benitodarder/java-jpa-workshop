package local.tin.tests.jpa.workshop.model.domain.interfaces;

/**
 *
 * @author benito.darder
 */
public interface INamed extends IEnableable {
    
    /**
     * Returns the element name
     * 
     * @return String
     */
    public String getName();
   
    /**
     * Sets the element name
     * 
     * @param name
     */
    public void setName(String name);    
        
}

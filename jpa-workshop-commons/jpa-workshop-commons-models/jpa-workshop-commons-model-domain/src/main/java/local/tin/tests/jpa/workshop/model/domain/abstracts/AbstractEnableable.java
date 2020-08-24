package local.tin.tests.jpa.workshop.model.domain.abstracts;

import local.tin.tests.jpa.workshop.model.domain.interfaces.IEnableable;

/**
 *
 * @author benitodarder
 */
public abstract class AbstractEnableable implements IEnableable {
    
    private boolean enabled;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }    

    @Override
    public String toString() {
        return "AbstractEnableable{" + "enabled=" + enabled + '}';
    }


    
}

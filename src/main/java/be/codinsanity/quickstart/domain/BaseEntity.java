/** 
 * @file BaseEntity.java 
 * @brief Base entity class for all hibernate tables 
 **/
package be.codinsanity.quickstart.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @class BaseEntity
 * @brief Base entity class for all hibernate tables.
 * 
 * This is base entity class for all hibernate tables
 * 
 * <P>
 * $Id: BaseEntity.java 7026 2012-12-20 16:50:31Z jcauwenbergh $
 * 
 * @version $Revision: 7026 $ $Date: 2012-12-20 17:50:31 +0100 (Thu, 20 Dec 2012) $
 * @author <a href="mailto:leigh.emrys@ext.europarl.europa.eu">Leigh Emrys-Jones</A>
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -3066060433243889140L;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

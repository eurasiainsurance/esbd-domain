package tech.lapsa.esbd.dao.entities.dict;

import javax.ejb.Local;
import javax.ejb.Remote;

public interface CompanyActivityKindEntityService extends ADictEntityService<CompanyActivityKindEntity> {

    public static final String BEAN_NAME = "CompanyActivityKindEntityServiceBean";

    @Local
    public interface CompanyActivityKindEntityServiceLocal
	    extends ADictEntityServiceLocal<CompanyActivityKindEntity>, CompanyActivityKindEntityService {
    }

    @Remote
    public interface CompanyActivityKindEntityServiceRemote
	    extends ADictEntityServiceRemote<CompanyActivityKindEntity>, CompanyActivityKindEntityService {
    }
}

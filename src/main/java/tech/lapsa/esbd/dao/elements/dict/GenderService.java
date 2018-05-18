package tech.lapsa.esbd.dao.elements.dict;

import javax.ejb.Local;
import javax.ejb.Remote;

import com.lapsa.insurance.elements.Sex;

import tech.lapsa.esbd.dao.elements.ElementsService;

public interface GenderService extends ElementsService<Sex> {

    public static final String BEAN_NAME = "GenderServiceBean";

    @Local
    public interface GenderServiceLocal extends ElementsServiceLocal<Sex>, GenderService {
    }

    @Remote
    public interface GenderServiceRemote extends ElementsServiceRemote<Sex>, GenderService {
    }
}
package tech.lapsa.esbd.dao.elements;

import javax.ejb.Singleton;

import com.lapsa.insurance.elements.CancelationReason;

import tech.lapsa.esbd.dao.elements.CancelationReasonService.CancelationReasonServiceLocal;
import tech.lapsa.esbd.dao.elements.CancelationReasonService.CancelationReasonServiceRemote;
import tech.lapsa.esbd.dao.elements.mapping.CancelationReasonMapping;

@Singleton(name = CancelationReasonService.BEAN_NAME)
public class CancelationReasonServiceBean
	extends AElementsService<CancelationReason>
	implements CancelationReasonServiceLocal, CancelationReasonServiceRemote {

    public CancelationReasonServiceBean() {
	super(CancelationReasonService.class, CancelationReasonMapping.getInstance()::forId, CancelationReason.class);
    }
}

package tech.lapsa.esbd.dao.beans.elements;

import java.time.LocalDate;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.xml.ws.soap.SOAPFaultException;

import com.lapsa.insurance.elements.InsuranceClassType;

import tech.lapsa.esbd.connection.Connection;
import tech.lapsa.esbd.connection.ConnectionPool;
import tech.lapsa.esbd.dao.NotFound;
import tech.lapsa.esbd.dao.beans.ESBDDates;
import tech.lapsa.esbd.dao.beans.elements.mapping.InsuranceClassTypeMapping;
import tech.lapsa.esbd.dao.elements.InsuranceClassTypeService;
import tech.lapsa.esbd.dao.elements.InsuranceClassTypeService.InsuranceClassTypeServiceLocal;
import tech.lapsa.esbd.dao.elements.InsuranceClassTypeService.InsuranceClassTypeServiceRemote;
import tech.lapsa.esbd.dao.entities.SubjectPersonEntity;
import tech.lapsa.java.commons.exceptions.IllegalArgument;
import tech.lapsa.java.commons.function.MyNumbers;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;

@Stateless(name = InsuranceClassTypeService.BEAN_NAME)
public class InsuranceClassTypeServiceBean implements InsuranceClassTypeServiceLocal, InsuranceClassTypeServiceRemote {

    @EJB
    private ConnectionPool pool;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public InsuranceClassType getById(final Integer id) throws NotFound, IllegalArgument {
	MyNumbers.requireNonZero(IllegalArgument::new, id, "id");
	try (Connection con = pool.getConnection()) {
	    final String classCode = con.getClassText(id);
	    if (classCode == null || classCode.trim().equals(""))
		throw new NotFound(InsuranceClassType.class.getSimpleName() + " not found with ID = '" + id + "'");
	    return getByCode(classCode);
	}
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public InsuranceClassType getByCode(final String code) throws IllegalArgument, NotFound {
	MyStrings.requireNonEmpty(IllegalArgument::new, code, "code");
	final InsuranceClassType result = InsuranceClassTypeMapping.getInstance().forId(code);
	if (result == null)
	    throw new NotFound(InsuranceClassType.class.getSimpleName() + " not found with CODE = '" + code + "'");
	return result;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public InsuranceClassType getForSubject(final SubjectPersonEntity individual) throws IllegalArgument, NotFound {
	MyObjects.requireNonNull(IllegalArgument::new, individual, "individual");
	final LocalDate today = LocalDate.now();
	return getForSubject(individual, today);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public InsuranceClassType getForSubject(final SubjectPersonEntity subjectPerson, final LocalDate date)
	    throws NotFound, IllegalArgument {
	MyObjects.requireNonNull(IllegalArgument::new, subjectPerson, "subjectPerson");
	MyObjects.requireNonNull(IllegalArgument::new, date, "date");
	try (Connection con = pool.getConnection()) {
	    final String esbdDate = ESBDDates.convertLocalDateToESBDDate(date);
	    try {
		final int aClassID = con.getClassId(new Long(subjectPerson.getId()).intValue(), esbdDate, 0);
		if (aClassID == 0)
		    throw new NotFound("WS-call getClassId returned zero value for CLIENT_ID = " + subjectPerson.getId()
			    + " and date = " + esbdDate);
		try {
		    return getById(aClassID);
		} catch (final IllegalArgument e) {
		    // it should not happens
		    throw new EJBException(e.getMessage());
		}
	    } catch (final SOAPFaultException e) {
		throw new NotFound("WS-call getClassId returned exception for CLIENT_ID = " + subjectPerson.getId()
			+ " and date = " + esbdDate, e);
	    }
	}
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public InsuranceClassType getDefault() {
	return InsuranceClassType.CLASS_3;
    }
}

package tech.lapsa.esbd.domain.embedded;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tech.lapsa.esbd.domain.ADomain;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.patterns.domain.HashCodePrime;

@Embeddable
@HashCodePrime(239)
public class ContractInfo extends ADomain {

    private static final long serialVersionUID = 1L;

    public static final ContractInfoBuilder builder() {
	return new ContractInfoBuilder();
    }

    public static final ContractInfoBuilder builder(final ContractInfo source) {
	MyObjects.requireNonNull(source, "source");
	return new ContractInfoBuilder(source);
    }

    public static final class ContractInfoBuilder
	    extends ADomainBuilder<ContractInfo, ContractInfoBuilder> {

	// private & protected

	protected String number;

	private String getNumber() {
	    return number;
	}

	private void setNumber(final String number) {
	    this.number = number;
	}

	protected LocalDate dateOf;

	private LocalDate getDateOf() {
	    return dateOf;
	}

	private void setDateOf(final LocalDate dateOf) {
	    this.dateOf = dateOf;
	}

	@Override
	protected ContractInfoBuilder _this() {
	    return this;
	}

	// constructor

	protected ContractInfoBuilder() {
	}

	protected ContractInfoBuilder(final ContractInfo source) {
	    super(source);
	    number = source.number;
	    dateOf = source.dateOf;
	}

	// public

	public ContractInfoBuilder withNumber(final String number) {
	    setStringIfNullOrThrow("number", this::getNumber, this::setNumber, number);
	    return this;
	}

	public ContractInfoBuilder withDateOf(final LocalDate dateOf) {
	    setBuilderProperty("dateOf", this::getDateOf, this::setDateOf, dateOf);
	    return this;
	}

	@Override
	public ContractInfo build() {
	    return new ContractInfo(number,
		    dateOf);
	}
    }

    // constructor

    protected ContractInfo(final String number,
	    final LocalDate dateOf) {
	this.number = number;
	this.dateOf = dateOf;
    }

    protected ContractInfo() {
	number = null;
	dateOf = null;
    }

    // certificateNumber

    @Basic
    @Column(name = "CONTRACT_NUMBER")
    final String number;

    public final String getNumber() {
	return number;
    }

    // certificateValidFrom

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "CONTRACT_DATE_OF")
    final LocalDate dateOf;

    public LocalDate getDateOf() {
	return dateOf;
    }
}

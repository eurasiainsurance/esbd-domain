package tech.lapsa.esbd.domain.embedded;

import java.time.LocalDate;

import com.lapsa.insurance.elements.Sex;

import tech.lapsa.esbd.domain.ADomain;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.patterns.domain.HashCodePrime;

@HashCodePrime(293)
public class PersonalInfo extends ADomain {

    private static final long serialVersionUID = 1L;

    public static final PersonalInfoBuilder builder() {
	return new PersonalInfoBuilder();
    }

    public static final PersonalInfoBuilder builder(final PersonalInfo source) {
	MyObjects.requireNonNull(source, "source");
	return new PersonalInfoBuilder(source);
    }

    public static final class PersonalInfoBuilder
	    extends ADomainBuilder<PersonalInfo, PersonalInfoBuilder> {

	// private & protected

	protected String name;

	private String getName() {
	    return name;
	}

	private void setName(String name) {
	    this.name = name;
	}

	protected String surename;

	private String getSurename() {
	    return surename;
	}

	private void setSurename(String surename) {
	    this.surename = surename;
	}

	protected String patronymic;

	private String getPatronymic() {
	    return patronymic;
	}

	private void setPatronymic(String patronymic) {
	    this.patronymic = patronymic;
	}

	protected LocalDate dayOfBirth;

	private LocalDate getDayOfBirth() {
	    return dayOfBirth;
	}

	private void setDayOfBirth(LocalDate dayOfBirth) {
	    this.dayOfBirth = dayOfBirth;
	}

	protected Sex gender;

	private Sex getGender() {
	    return gender;
	}

	private void setGender(Sex gender) {
	    this.gender = gender;
	}

	@Override
	protected PersonalInfoBuilder _this() {
	    return this;
	}

	// constructor

	protected PersonalInfoBuilder() {
	}

	protected PersonalInfoBuilder(PersonalInfo source) {
	    super(source);
	    this.name = source.name;
	    this.surename = source.surename;
	    this.patronymic = source.patronymic;
	    this.dayOfBirth = source.dayOfBirth;
	    this.gender = source.gender;
	}

	// public

	public PersonalInfoBuilder withName(final String name) {
	    setStringIfNullOrThrow("name", this::getName, this::setName, name);
	    return this;
	}

	public PersonalInfoBuilder withSurename(final String surename) {
	    setStringIfNullOrThrow("surename", this::getSurename, this::setSurename, surename);
	    return this;
	}

	public PersonalInfoBuilder withPatronymic(final String patronymic) {
	    setStringIfNullOrThrow("patronymic", this::getPatronymic, this::setPatronymic, patronymic);
	    return this;
	}

	public PersonalInfoBuilder withDayOfBirth(final LocalDate dayOfBirth) {
	    setBuilderProperty("dayOfBirth", this::getDayOfBirth, this::setDayOfBirth, dayOfBirth);
	    return this;
	}

	public PersonalInfoBuilder withGender(final Sex gender) {
	    setBuilderProperty("gender", this::getGender, this::setGender, gender);
	    return this;
	}

	@Override
	public PersonalInfo build() {
	    return new PersonalInfo(name,
		    surename,
		    patronymic,
		    dayOfBirth,
		    gender);
	}
    }

    // constructor

    protected PersonalInfo(final String name,
	    final String surename,
	    final String patronymic,
	    final LocalDate dayOfBirth,
	    final Sex gender) {
	this.name = name;
	this.surename = surename;
	this.patronymic = patronymic;
	this.dayOfBirth = dayOfBirth;
	this.gender = gender;
    }

    protected PersonalInfo() {
	this.name = null;
	this.surename = null;
	this.patronymic = null;
	this.dayOfBirth = null;
	this.gender = null;
    }

    // name

    final String name;

    public String getName() {
	return name;
    }

    // surename

    final String surename;

    public String getSurename() {
	return surename;
    }

    // patronymic

    final String patronymic;

    public String getPatronymic() {
	return patronymic;
    }

    // dayOfBirth

    final LocalDate dayOfBirth;

    public LocalDate getDayOfBirth() {
	return dayOfBirth;
    }

    // gender

    final Sex gender;

    public Sex getGender() {
	return gender;
    }
}

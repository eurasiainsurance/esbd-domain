package tech.lapsa.esbd.dao.entities.embeded;

import java.time.LocalDate;
import java.util.function.Consumer;

import tech.lapsa.esbd.dao.entities.AEntity;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.patterns.domain.HashCodePrime;

@HashCodePrime(47)
public class DriverLicenseInfo extends AEntity {

    private static final long serialVersionUID = 1L;

    public static final DriverLicenseInfoBuilder builder() {
	return new DriverLicenseInfoBuilder();
    }

    public static final class DriverLicenseInfoBuilder {

	private String number;
	private LocalDate dateOfIssue;

	private DriverLicenseInfoBuilder() {
	}

	public DriverLicenseInfoBuilder withNumber(final String number) {
	    this.number = MyStrings.requireNonEmpty(number, "number");
	    return this;
	}

	public DriverLicenseInfoBuilder withDateOfIssue(final LocalDate dateOfIssue) {
	    this.dateOfIssue = MyObjects.requireNonNull(dateOfIssue, "dateOfIssue");
	    return this;
	}

	public DriverLicenseInfo build() {
	    final DriverLicenseInfo res = new DriverLicenseInfo();
	    res.number = MyStrings.requireNonEmpty(number, "number");
	    res.dateOfIssue = MyObjects.requireNonNull(dateOfIssue, "dateOfIssue");
	    return res;
	}

	public void buildTo(final Consumer<DriverLicenseInfo> consumer) {
	    consumer.accept(build());
	}
    }

    private DriverLicenseInfo() {
    }

    // number

    private String number;

    public String getNumber() {
	return number;
    }

    // dateOfIssue

    private LocalDate dateOfIssue;

    public LocalDate getDateOfIssue() {
	return dateOfIssue;
    }
}

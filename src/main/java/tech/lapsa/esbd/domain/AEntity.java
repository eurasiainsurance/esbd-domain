package tech.lapsa.esbd.domain;

import tech.lapsa.java.commons.function.MyObjects;

public abstract class AEntity extends ADomain implements Cloneable {

    private static final long serialVersionUID = 1L;

    public static abstract class AEntityBuilder<ET extends ADomain, BT extends AEntityBuilder<ET, BT>>
	    extends ADomainBuilder<ET, BT> {

	// private & protected

	protected Integer id;

	private Integer getId() {
	    return id;
	}

	private void setId(Integer id) {
	    this.id = id;
	}

	protected abstract BT _this();

	// constructor

	protected AEntityBuilder() {
	}

	// public

	public BT withId(final Integer id) {
	    setNumberIfNullOrThrow("id", this::getId, this::setId, id);
	    return _this();
	}
    }

    @Override
    public Object clone() {
	try {
	    return super.clone();
	} catch (CloneNotSupportedException e) {
	    throw new RuntimeException(e);
	}
    }

    public <T> T clone(Class<T> clazz) {
	final Object cloned = clone();
	return MyObjects.requireA(cloned, clazz);
    }

    // constructor

    protected AEntity(Integer id) {
	this.id = id;
    }

    protected AEntity() {
	this.id = null;
    }

    // id

    private final Integer id;

    public Integer getId() {
	return id;
    }
}

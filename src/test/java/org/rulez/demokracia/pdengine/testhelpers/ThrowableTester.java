package org.rulez.demokracia.pdengine.testhelpers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ThrowableTester {

	private Throwable thrown;

	public ThrowableTester() {
		super();
	}

	public ThrowableTester assertThrows(Thrower thrower) {
		thrown = null;
		try {
			thrower.throwException();
		} catch (Throwable exception) {
			thrown = exception;
		}
		if (thrown == null) {
			fail("no exception thrown");			
		}
		return this;
	}

	public ThrowableTester assertMessageIs(String message) {
		assertEquals(message, thrown.getMessage());
		return this;
	}

	public Throwable getException() {
		return thrown;
	}

	public ThrowableTester assertException(Class<? extends RuntimeException> klass) {
		assertEquals(thrown.getClass(), klass);
		return this;
	}
}

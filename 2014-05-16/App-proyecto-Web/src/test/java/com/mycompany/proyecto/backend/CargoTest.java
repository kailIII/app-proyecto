package com.mycompany.proyecto.backend;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.mycompany.proyecto.model.Cargo;

public class CargoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Cargo cargo = new Cargo();
		cargo.setNombre("CARGO TEST");
		cargo.setDescripcion("GERENTE");
		cargo.setActivo(1);
		
		
	}

}

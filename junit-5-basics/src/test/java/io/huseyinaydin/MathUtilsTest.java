package io.huseyinaydin;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Burasý mathutils sýnýfýnýn test metodudur!")
class MathUtilsTest {

	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;

	@Nested
	@DisplayName("add method")
	@Tag("matematik")
	class AddTest {

		@Test
		@DisplayName("iki tane pozitif eleman ekleme metodu")
		void testAddPositive() {
			System.out.println("test 1 çalýþtý");
			assertEquals(2, mathUtils.add(1, 1), "Bu metot toplamý dönderir!");
		}

		@Test
		@DisplayName("iki tane negatif eleman ekleme metodu")
		void testAddNegative() {
			System.out.println("test 2 çalýþtý");
			assertEquals(-2, mathUtils.add(-1, -1), ()->"Bu metot toplamý dönderir!");
		}

	}

	@BeforeAll
	void beforeAllInit() {
		System.out.println("Çalýþtýrmadan önce burayý çalýþtýrmak lazým!");
	}

	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		System.out.println("before each init çalýþtý!");
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		//testReporter.publishEntry("çalýþýyor : " + this.testInfo.getDisplayName() + " etiket : " + this.testInfo.getTags());
	}

	@AfterEach
	void cleanUp() {
		System.out.println("Temizlendi!");
	}

	@Test
	@DisplayName(value = "Test metodu")
	void test() {
		// fail("Not yet implemented");
		System.out.println("test 3 çalýþtý");

		int sonuc = mathUtils.add(1, 1);
		int olmasýGerekenSonuc = 2;
		assertEquals(sonuc, olmasýGerekenSonuc, "Olmasý gereken sonuç 2 olmalý!");
		// assertArrayEquals(expected, actual);
		// assertIterableEquals(expected, actual);
		// assertTrue
	}

	@Test
	@DisplayName("çarpma iþlemi")
	@Tag("matematik")
	void testMultiply() {
		System.out.println("test 4 çalýþtý");
		System.out.println("çalýþýyor : " + this.testInfo.getDisplayName() + " etiket : " + this.testInfo.getTags());
		//this.testReporter.publishEntry("çalýþýyor : " + this.testInfo.getDisplayName() + " etiket : " + this.testInfo.getTags());
		// assertEquals(4, mathUtils.multiply(2, 2),"Olmasý gereken sonuç 4 olmalý!");
		// toplu iþlem yapar assertAll
		assertAll(() -> assertEquals(4, mathUtils.multiply(2, 2), "Olmasý gereken sonuç 4 olmalý!"),
				() -> assertEquals(0, mathUtils.multiply(2, 0), "Olmasý gereken sonuç 0 olmalý!"),
				() -> assertEquals(2, mathUtils.multiply(2, 1), "Olmasý gereken sonuç 2 olmalý!"));
	}

	@Test
	// @EnabledOnOs(value = OS.LINUX)
	@Tag("matematik")
	void testDivide() {
		/*
		 * assertThrows(ArithmeticException.class, new Executable() { public void
		 * execute() throws Throwable { mathUtils.divide(10, 0); }
		 * },"Sýfýr'a bölünemez!");
		 */
		System.out.println("test 5 çalýþtý");
		boolean isServerUp = true;

		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(10, 0), "Sýfýr'a bölünemez!");
	}

	
	@Test //teste tabi tutar
	@RepeatedTest(3) //test tekrar ediyor 3 defa
	@Tag("geometri")
	void testComputeCircleRadius() {
		//RepetitionInfo repetitionInfo) {
		//System.out.println("þu an ki tur:" + repetitionInfo.getCurrentRepetition());
		System.out.println("test 6 çalýþtý");
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Deðerin 0 çýkmasý lazým!");
	}

	// @EnabledOnOs()
	// @EnabledIf
	// @EnabledIfSystemProperty
	// @EnabledIfEnvironmentVariable
	// @EnabledOnJre

	@Test
	@Disabled
	@DisplayName("devre dýþý test metodu")
	void testDisabled() {
		System.out.println("test 7 çalýþtý");
		fail("hata");
	}

}

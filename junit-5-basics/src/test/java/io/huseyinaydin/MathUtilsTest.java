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
@DisplayName("Buras� mathutils s�n�f�n�n test metodudur!")
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
			System.out.println("test 1 �al��t�");
			assertEquals(2, mathUtils.add(1, 1), "Bu metot toplam� d�nderir!");
		}

		@Test
		@DisplayName("iki tane negatif eleman ekleme metodu")
		void testAddNegative() {
			System.out.println("test 2 �al��t�");
			assertEquals(-2, mathUtils.add(-1, -1), ()->"Bu metot toplam� d�nderir!");
		}

	}

	@BeforeAll
	void beforeAllInit() {
		System.out.println("�al��t�rmadan �nce buray� �al��t�rmak laz�m!");
	}

	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		System.out.println("before each init �al��t�!");
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		//testReporter.publishEntry("�al���yor : " + this.testInfo.getDisplayName() + " etiket : " + this.testInfo.getTags());
	}

	@AfterEach
	void cleanUp() {
		System.out.println("Temizlendi!");
	}

	@Test
	@DisplayName(value = "Test metodu")
	void test() {
		// fail("Not yet implemented");
		System.out.println("test 3 �al��t�");

		int sonuc = mathUtils.add(1, 1);
		int olmas�GerekenSonuc = 2;
		assertEquals(sonuc, olmas�GerekenSonuc, "Olmas� gereken sonu� 2 olmal�!");
		// assertArrayEquals(expected, actual);
		// assertIterableEquals(expected, actual);
		// assertTrue
	}

	@Test
	@DisplayName("�arpma i�lemi")
	@Tag("matematik")
	void testMultiply() {
		System.out.println("test 4 �al��t�");
		System.out.println("�al���yor : " + this.testInfo.getDisplayName() + " etiket : " + this.testInfo.getTags());
		//this.testReporter.publishEntry("�al���yor : " + this.testInfo.getDisplayName() + " etiket : " + this.testInfo.getTags());
		// assertEquals(4, mathUtils.multiply(2, 2),"Olmas� gereken sonu� 4 olmal�!");
		// toplu i�lem yapar assertAll
		assertAll(() -> assertEquals(4, mathUtils.multiply(2, 2), "Olmas� gereken sonu� 4 olmal�!"),
				() -> assertEquals(0, mathUtils.multiply(2, 0), "Olmas� gereken sonu� 0 olmal�!"),
				() -> assertEquals(2, mathUtils.multiply(2, 1), "Olmas� gereken sonu� 2 olmal�!"));
	}

	@Test
	// @EnabledOnOs(value = OS.LINUX)
	@Tag("matematik")
	void testDivide() {
		/*
		 * assertThrows(ArithmeticException.class, new Executable() { public void
		 * execute() throws Throwable { mathUtils.divide(10, 0); }
		 * },"S�f�r'a b�l�nemez!");
		 */
		System.out.println("test 5 �al��t�");
		boolean isServerUp = true;

		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(10, 0), "S�f�r'a b�l�nemez!");
	}

	
	@Test //teste tabi tutar
	@RepeatedTest(3) //test tekrar ediyor 3 defa
	@Tag("geometri")
	void testComputeCircleRadius() {
		//RepetitionInfo repetitionInfo) {
		//System.out.println("�u an ki tur:" + repetitionInfo.getCurrentRepetition());
		System.out.println("test 6 �al��t�");
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "De�erin 0 ��kmas� laz�m!");
	}

	// @EnabledOnOs()
	// @EnabledIf
	// @EnabledIfSystemProperty
	// @EnabledIfEnvironmentVariable
	// @EnabledOnJre

	@Test
	@Disabled
	@DisplayName("devre d��� test metodu")
	void testDisabled() {
		System.out.println("test 7 �al��t�");
		fail("hata");
	}

}

package test.laura.demo;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;

import laura.demo.PlaneSeat;

public class Test_PlaneSeat {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test_1() {
		assertEquals(2, PlaneSeat.solution(2, "1A 2F 1C"));
	}

	@Test
	public void test_2() {
		assertEquals(4, PlaneSeat.solution(2, ""));
	}
	
	@Test
	public void test_3() {
		assertEquals(8, PlaneSeat.solution(5, "5K 1A 2F 1C"));
	}
	
	
	@Test
	public void test_4() {
		assertEquals(4, PlaneSeat.solution(2, "    "));
	}
	
	@Test
	public void test_5() {
		assertEquals(11, PlaneSeat.solution(7, "5G 1A 2F 1C 5A"));
	}
	
	@Test
	public void test_6() {
		assertEquals(1, PlaneSeat.solution(1, "1A 2F 1D"));
	}
	
	@Test
	public void test_7() {
		assertEquals(6, PlaneSeat.solution(4, "1A 2H 1C"));
	}
	
//	@Test
//	public void test_1() {
//		assertEquals(0, MTB.solution(2, "1A 2F 1C"));
//	}
}

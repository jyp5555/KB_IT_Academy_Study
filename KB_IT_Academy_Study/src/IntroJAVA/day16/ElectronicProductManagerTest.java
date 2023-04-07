package IntroJAVA.day16;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class ElectronicProductManagerTest {

	@Test
	public void testGetProductSize() {
//		TV samsungTv = (TV) new ElectronicProduct(); 다운캐스팅, 런타임오류!
		TV samsungTv = new TV(123, "samsung OLED", 1000000, "samsung", new Date(), new Date(), "선릉", "OLED", true);
		TV lgTv = new TV(133, "lg OLED", 1000000, "samsung", new Date(), new Date(), "선릉", "OLED", true);
		WashingMachine trom = new WashingMachine(233, "trom", 1000000, "", new Date(), new Date(), "선릉", true, true);

		
		ElectronicProductManager epm = new ElectronicProductManager();
		epm.add(samsungTv);
		epm.add(lgTv);
		epm.add(trom);
		
		int result = epm.getSize();
		
		assertEquals(3, result, 0);
	}
	
	@Test
	public void testGetProductSize2() {
		TV samsungTv = new TV(123, "samsung OLED", 1000000, "samsung", new Date(), new Date(), "선릉", "OLED", true);
		TV lgTv = new TV(133, "lg OLED", 1000000, "samsung", new Date(), new Date(), "선릉", "OLED", true);
		WashingMachine trom = new WashingMachine(233, "trom", 1000000, "", new Date(), new Date(), "선릉", true, true);
		
		ElectronicProductManager epm = new ElectronicProductManager();
		epm.add(samsungTv);
		epm.add(lgTv);
		epm.add(trom);
		epm.deleteByIndex(0);
		
		int result = epm.getSize();
		
		assertEquals(2, result, 0);
	}

}

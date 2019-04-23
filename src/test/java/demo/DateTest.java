package demo;

import org.junit.Test;

import com.dada.utils.Morse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author WuTengda
 */
public class DateTest {

	@Test
	public void test() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
		LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
		System.out.println("今天开始日期 = " + today_start.format(dateTimeFormatter));
		System.out.println("今天结束日期 = " + today_end.format(dateTimeFormatter));
	}

	@Test
	public void MorsePass() {
		Morse morse = new Morse();
		System.out.println("加密后:" + morse.encryption("123456"));
		System.out.println("解密后:" + morse.decode(morse.encryption("123456")));

	}
}

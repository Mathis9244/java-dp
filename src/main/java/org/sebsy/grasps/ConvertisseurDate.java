package org.sebsy.grasps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Pure Fabrication : spécialiste des conversions de dates.
 */
public class ConvertisseurDate {

	private static final DateTimeFormatter FORMATTER =
			DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public LocalDateTime toLocalDateTime(String dateStr) {
		return LocalDateTime.parse(dateStr, FORMATTER);
	}
}

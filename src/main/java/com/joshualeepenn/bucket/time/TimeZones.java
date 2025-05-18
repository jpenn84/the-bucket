package com.joshualeepenn.bucket.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.joshualeepenn.bucket.strings.Math.PLUS_MINUS;

/**
 * A class for time zones.
 */
public class TimeZones {

    /**
     * Gets all available {@link java.time.ZoneId ZoneIds} as an alphabetical list of records of regions and their
     * UTC offsets.
     *
     * @return An alphabetical List of {@link TimeZoneRegionAndOffset}
     */
    public static List<TimeZoneRegionAndOffset> getRegionAndOffsetList() {
        List<TimeZoneRegionAndOffset> offsets = new ArrayList<>();
        LocalDateTime localDateTime = LocalDateTime.now();

        for (String zoneId : ZoneId.getAvailableZoneIds()) {
            ZoneId id = ZoneId.of(zoneId);

            // Get offset from localDateTime
            ZoneOffset zoneOffset = localDateTime.atZone(id).getOffset();

            // Replace "Z" (Zulu) offset with numeric offset for consistency
            String offset = zoneOffset.getId().replaceAll("Z", PLUS_MINUS + "00:00");

            // Add to the list
            offsets.add(new TimeZoneRegionAndOffset(id.toString(), String.format("(UTC %s)", offset)));
        }

        // Alphabetize by region
        offsets.sort(Comparator.comparing(TimeZoneRegionAndOffset::region));

        return offsets;
    }

    /**
     * A record for holding a {@link java.time.ZoneId ZoneId's} region and offset as strings.
     *
     * @param region The {@link java.time.ZoneId ZoneId}.
     * @param offset A human-readable string representing the UTC offset.
     */
    public record TimeZoneRegionAndOffset(String region, String offset) {}

}

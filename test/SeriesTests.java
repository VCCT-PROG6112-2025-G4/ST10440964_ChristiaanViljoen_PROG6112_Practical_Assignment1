package st10440964_christiaanviljoen_prog6112_practicalassignment;

/**
 *
 * @author Christiaan Viljoen ST10440964
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTests {

    private Series app;

    @BeforeEach
    void setUp() {
        app = new Series();
        
        boolean added = app.addSeries("101", "Extreme Sports", 12, 10);
        assertTrue(added, "Seed data should add successfully");
    }

    @Test
    void TestSearchSeries() {
        SeriesModel found = app.findSeriesById("101");
        assertNotNull(found, "Series should be found");
        assertEquals("101", found.getSeriesId());
        assertEquals("Extreme Sports", found.getSeriesName());
        assertEquals(12, found.getSeriesAge());
        assertEquals(10, found.getNumberOfEpisodes());
    }

    @Test
    void TestSearchSeries_SeriesNotFound() {
        SeriesModel found = app.findSeriesById("102");
        assertNull(found, "No series should be found for unknown id");
    }

    @Test
    void TestUpdateSeries() {
        boolean updated = app.updateSeriesById("101", "Extreme Sports 2025", 10, 12);
        assertTrue(updated, "Update should succeed for existing series");

        SeriesModel after = app.findSeriesById("101");
        assertNotNull(after);
        assertEquals("Extreme Sports 2025", after.getSeriesName());
        assertEquals(10, after.getSeriesAge());
        assertEquals(12, after.getNumberOfEpisodes());
    }

    @Test
    void TestDeleteSeries() {
        boolean deleted = app.deleteSeriesById("101");
        assertTrue(deleted, "Delete should succeed for existing series");

        SeriesModel after = app.findSeriesById("101");
        assertNull(after, "Series should be gone after delete");
    }

    @Test
    void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = app.deleteSeriesById("999");
        assertFalse(deleted, "Delete should fail for non-existent id");
    }

    @Test
    void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(app.isValidAge(2), "Lower bound should be valid");
        assertTrue(app.isValidAge(12), "Typical valid age");
        assertTrue(app.isValidAge(18), "Upper bound should be valid");
    }

    @Test
    void TestSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse(app.isValidAge(1), "Below lower bound should be invalid");
        assertFalse(app.isValidAge(19), "Above upper bound should be invalid");
    }
}

package st10440964_christiaanviljoen_prog6112_practicalassignment.unittest;

import st10440964_christiaanviljoen_prog6112_practicalassignment.Series;
import st10440964_christiaanviljoen_prog6112_practicalassignment.SeriesModel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeriesTest {
    private Series seriesApp;

    @Before
    public void setUp() {
        seriesApp = new Series();
        // Add a sample series to test with
        seriesApp.addSeries("101", "Extreme Sports", 12, 10);
    }

    @Test
    public void TestSearchSeries() {
        SeriesModel s = seriesApp.findSeriesById("101");
        assertNotNull("Series should be found", s);
        assertEquals("Extreme Sports", s.getSeriesName());
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        SeriesModel s = seriesApp.findSeriesById("999");
        assertNull("Series should not be found", s);
    }

    @Test
    public void TestUpdateSeries() {
        boolean updated = seriesApp.updateSeriesById("101", 
                "Updated Sports", 15, 20);
        assertTrue("Series should be updated", updated);

        SeriesModel s = seriesApp.findSeriesById("101");
        assertEquals("Updated Sports", s.getSeriesName());
        assertEquals(15, s.getSeriesAge());
        assertEquals(20, s.getNumberOfEpisodes());
    }

    @Test
    public void TestDeleteSeries() {
        boolean deleted = seriesApp.deleteSeriesById("101");
        assertTrue("Series should be deleted", deleted);

        SeriesModel s = seriesApp.findSeriesById("101");
        assertNull("Series should no longer exist", s);
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = seriesApp.deleteSeriesById("999");
        assertFalse("Deleting non-existent series should return false", deleted);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue("Age 10 should be valid", seriesApp.isValidAge(10));
    }

    @Test
    public void TestSeriesAgeRestriction_AgeInvalid() {
        assertFalse("Age 32 should be invalid", seriesApp.isValidAge(32));
        assertFalse("Age 1 should be invalid", seriesApp.isValidAge(1));
    }
}

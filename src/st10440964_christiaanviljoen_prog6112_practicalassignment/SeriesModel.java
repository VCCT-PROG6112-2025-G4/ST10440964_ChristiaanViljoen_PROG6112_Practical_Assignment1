package st10440964_christiaanviljoen_prog6112_practicalassignment;

/**
 *
 * @author Christiaan Viljoen ST10440964
 */

public class SeriesModel {
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int numberOfEpisodes;

    public SeriesModel(String seriesId, String seriesName, 
            int seriesAge, int numberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getSeriesAge() {
        return seriesAge;
    }

    public void setSeriesAge(int seriesAge) {
        this.seriesAge = seriesAge;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    @Override
    public String toString() {
        return "SERIES ID: " + seriesId + "\n"
             + "SERIES NAME: " + seriesName + "\n"
             + "SERIES AGE RESTRICTION: " + seriesAge + "\n"
             + "NUMBER OF EPISODES: " + numberOfEpisodes + "\n";
    }
}
package brickset;

import java.io.ObjectInputStream;
import java.util.*;

public interface LegoSetManager {

    /**
     * {@return an unmodifiable list of all sets}
     */
    default List<LegoSet> getLegoSets(){
        return new LegoSetRepository().getAll();
    };

    /**
     * Prints each sub-theme that appears in any LEGO Set that belongs to the <code>Harry Potter</code> theme (just once).
     */
    void printSubThemesOfHarryPotterSets();

    /**
     * Returns the sorted list of the LEGO Sets, using the following stages:
     *
     * <ol>
     *     <li>pieces (descending)
     *     <li>year (ascending)
     *     <li>number (descending)
     * </ol>
     *
     * @return the {@link List} instance
     */
    List<LegoSet> getSortedLegoSets();

    /**
     * Returns a dictionary that maps the sub-themes to the number of corresponding LEGO Sets that belong to the {@code Harry Potter} theme.
     *
     * @return the {@link Map} instance
     */
    Map<String, Long> getCountOfHarryPotterSetsBySubTheme();


    /**
     * Returns the average amount of tags that belong to any set with the given theme.
     *
     * @param theme the condition
     * @return the {@link OptionalInt} instance
     */
    OptionalDouble getAverageAmountOfTagsByTheme(String theme);

    /**
     * Returns a dictionary that groups the LEGO Sets by the theme, and then by the sub-theme.
     *
     * @return the {@link Map} instance
     */
    Map<String, Map<String, Set<LegoSet>>> getLegoSetsByThemeAndSubTheme();

    /**
     * Returns all LEGO sets which have at least the specified minimum number of pieces.
     *
     * @param minPieces minimum number of pieces
     * @return {@link List} of matching {@link LegoSet}
     */
    List<LegoSet> getLegoSetsWithMinPieces(int minPieces);

    /**
     * Returns all distinct themes present among all LEGO sets.
     *
     * @return {@link Set} of unique theme names
     */
    Set<String> getAllThemes();

    /**
     * Returns a map of theme to total sum of pieces for all LEGO sets of that theme.
     *
     * @return {@link Map} with theme keys and sum of pieces as values
     */
    Map<String, Integer> getTotalPiecesByTheme();

    /**
     * Returns a list of LEGO sets that do not specify weight in their dimensions.
     *
     * @return {@link List} of {@link LegoSet} missing weight info
     */
    List<LegoSet> getSetsWithMissingWeight();

    /**
     * Groups LEGO sets by their packaging type.
     *
     * @return {@link Map} from {@link PackagingType} to {@link List} of LEGO sets
     */
    Map<PackagingType, List<LegoSet>> groupSetsByPackagingType();

    /**
     * Finds all LEGO sets that contain the specified tag (case-insensitive).
     *
     * @param tag tag to search for
     * @return {@link List} of LEGO sets containing the tag
     */
    List<LegoSet> findSetsByTag(String tag);

    /**
     * Returns the average volume (depth * width * height) of LEGO sets for the specified theme.
     * Sets missing any dimension are ignored.
     *
     * @param theme theme to filter
     * @return {@link OptionalDouble} average volume or empty if none
     */
    OptionalDouble getAverageVolumeByTheme(String theme);

    /**
     * Returns the LEGO set with the greatest weight, or empty if none specify weight.
     *
     * @return {@link Optional} of the heaviest LEGO set
     */
    Optional<LegoSet> getHeaviestSet();

    /**
     * Finds LEGO sets whose tags contain the given partial string (case-insensitive).
     *
     * @param partial partial tag substring to match
     * @return {@link List} of matching LEGO sets
     */
    List<LegoSet> findSetsByTagPartial(String partial);

    /**
     * Returns the top N LEGO sets sorted by piece count in descending order.
     *
     * @param n number of top sets to return
     * @return {@link List} of top N LEGO sets by pieces
     */
    List<LegoSet> getTopNSetsByPieces(int n);
}



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * In-memory store for Recommendation objects.
 *
 * Acts as the catalogue from which users browse, clone, and save lists.
 * No external persistence is used — data lives for the duration of the JVM session.
 */
public class RecommendationStore {

    private final List<Recommendation> recommendations = new ArrayList<>();

    // ── CRUD ─────────────────────────────────────────────────────────────────

    /** Adds a recommendation to the store. */
    public void save(Recommendation rec) {
        recommendations.add(rec);
    }

    /**
     * Finds a recommendation by 1-based index (as displayed to the user).
     *
     * @return an Optional containing the match, or empty if out of range.
     */
    public Optional<Recommendation> findByIndex(int oneBasedIndex) {
        int idx = oneBasedIndex - 1;
        if (idx < 0 || idx >= recommendations.size()) {
            return Optional.empty();
        }
        return Optional.of(recommendations.get(idx));
    }

    /**
     * Removes the recommendation at the given 1-based index.
     *
     * @return true if removed, false if index was invalid.
     */
    public boolean deleteByIndex(int oneBasedIndex) {
        int idx = oneBasedIndex - 1;
        if (idx < 0 || idx >= recommendations.size()) {
            return false;
        }
        recommendations.remove(idx);
        return true;
    }

    /** Returns an unmodifiable view of all recommendations. */
    public List<Recommendation> all() {
        return Collections.unmodifiableList(recommendations);
    }

    public int size() { return recommendations.size(); }
    public boolean isEmpty() { return recommendations.isEmpty(); }
}
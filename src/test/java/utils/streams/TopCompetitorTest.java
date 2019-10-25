package utils.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TopCompetitorTest {

    @Test
    void topNCompetitors() {
        var competitors = Arrays.asList("microsoft", "apple", "amazon", "google");
        var reviews = Arrays.asList("microsoft is out of competition, however microsoft was good before"
                , "apple has reliable products", "apple has many fans"
                , "google has promising products"
                , "amazon try to be a leader in the market");
        var results = new TopCompetitor().topNCompetitors(0, 3, competitors, 0, reviews);
        var expected = Arrays.asList("apple", "microsoft", "amazon");
        Assertions.assertTrue(results.equals(expected), "incorrect top competitions!");
    }
}
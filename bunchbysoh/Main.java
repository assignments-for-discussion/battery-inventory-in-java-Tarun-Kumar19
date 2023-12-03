package bunchbysoh;

public class Main {

    //Class is define to store counts of batteries based on their State of Health (SoH)
    static class CountsBySoH {
        public int healthy = 0;
        public int exchange = 0;
        public int failed = 0;
    }

    /**
     * Counts batteries based on their State of Health (SoH) and classifies them into
     * healthy, exchange, or failed categories.
     *
     * @param presentCapacities An array representing the present capacities of batteries.
     * @return CountsBySoH object containing the counts for each category.
     */
    static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
        CountsBySoH counts = new CountsBySoH();

        // Looping through each battery's present capacity and classify based on SoH
        for (int capacity: presentCapacities) {
            // Calculate State of Health (SoH) as a percentage
            double soh = 100.0 * capacity / 120.0;

            // Classify the battery based on SoH
            if (soh > 80.0) {
                counts.healthy++;
            } else if (soh >= 62.0) {
                counts.exchange++;
            } else {
                counts.failed++;
            }
        }

        return counts;
    }

    /**
     * Test function to verify the counting and classification of batteries by SoH.
     */
    static void testBucketingByHealth() {
        System.out.println("Counting batteries by SoH...\n");

        // Example present capacities of batteries
        int[] presentCapacities = {113, 116, 80, 95, 92, 70};

        // Count and classify batteries
        CountsBySoH counts = countBatteriesByHealth(presentCapacities);

        // Asserts to verify the counts match the expected values
        assert(counts.healthy == 2);
        assert(counts.exchange == 3);
        assert(counts.failed == 1);

        System.out.println("Done counting :)\n");
    }

    static void additionalTests() {
        System.out.println("Running additional tests...\n");

        // Test with batteries having test SoH values
        int[] testSOHvalues1 = {98, 76, 40}; // 100 * value / 120 = SoH%
        CountsBySoH testSOHvalues1 = countBatteriesByHealth(testSOHvalues1);
        assert(testSOHvalues1.healthy == 1);
        assert(testSOHvalues1.exchange == 1);
        assert(testSOHvalues1.failed == 1);

        // Test with batteries having test SoH values
        int[] testSOHvalues2 = {97, 74, 47}; // 100 * value / 120 = SoH%
        CountsBySoH testSOHvalues2 = countBatteriesByHealth(testSOHvalues2);
        assert(testSOHvalues2.healthy == 1);
        assert(testSOHvalues2.exchange == 1);
        assert(testSOHvalues2.failed == 1);

        // Test with batteries having test SoH values
        int[] testSOHvalues3 = {101, 73, 43}; // 100 * value / 120 = SoH%
        CountsBySoH testSOHvalues3 = countBatteriesByHealth(testSOHvalues3);
        assert(testSOHvalues3.healthy == 1);
        assert(testSOHvalues3.exchange == 1);
        assert(testSOHvalues3.failed == 1);

        // Test with an empty SoH array
        int[] emptySoHArray = {};
        CountsBySoH emptySoHArray = countBatteriesByHealth(emptySoHArray);
        assert(emptySoHArray.healthy == 0);
        assert(emptySoHArray.exchange == 0);
        assert(emptySoHArray.failed == 0);

        // Test with a single battery with 100% SoH
        int[] singleBattery100SoH = {120}; // 100 * 120 / 120 = 100%
        CountsBySoH countsSingleBattery100 = countBatteriesByHealth(singleBattery100SoH);
        assert(countsSingleBattery100.healthy == 1);
        assert(countsSingleBattery100.exchange == 0);
        assert(countsSingleBattery100.failed == 0);

        // Test with a single battery with 0% SoH
        int[] singleBattery0SoH = {0}; // 100 * 0 / 120 = 0%
        CountsBySoH countsSingleBattery0 = countBatteriesByHealth(singleBattery0SoH);
        assert(countsSingleBattery0.healthy == 0);
        assert(countsSingleBattery0.exchange == 0);
        assert(countsSingleBattery0.failed == 1);

        System.out.println("Additional tests passed :)\n");
    }

   
    public static void main(String[] args) {
        testBucketingByHealth(); // calling function that contains main logic for battery classification 
        additionalTests(); // calling function having additional edge cases
    }
}

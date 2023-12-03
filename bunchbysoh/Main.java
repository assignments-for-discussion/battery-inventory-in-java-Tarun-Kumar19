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

    /**
     * Main function to run the test.
     *
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        testBucketingByHealth();
    }
}

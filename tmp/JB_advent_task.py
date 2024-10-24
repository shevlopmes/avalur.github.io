from typing import List, Set


class WaterTesting:
    def __init__(self, reservoirs: List[bool]):
        """
        Initialize with a list of reservoirs where True represents dirty water
        and False represents clean water.
        """
        self.reservoirs = reservoirs
        self.test_count = 0

    def test_sample(self, indices: List[int]) -> int:
        """
        Simulate testing a group of reservoirs.
        Returns the count of dirty samples in the group.
        """
        self.test_count += 1
        return sum(self.reservoirs[i] for i in indices)

    def find_dirty_reservoirs(self) -> Set[int]:
        """
        Main function to identify all dirty reservoirs with minimal tests.
        Returns the indices of dirty reservoirs.
        """
        n = len(self.reservoirs)
        all_indices = list(range(n))

        # First test: Check the total number of dirty reservoirs
        total_dirty = self.test_sample(all_indices)

        if total_dirty == 0:
            return set()
        if total_dirty == n:
            return set(all_indices)

        return self._recursive_find(all_indices, total_dirty)

    def _recursive_find(self, indices: List[int], known_dirty: int) -> Set[int]:
        """
        Recursively find dirty reservoirs in a group with a known number of dirty samples.
        """
        if known_dirty == 0:
            return set()

        if known_dirty == len(indices):
            return set(indices)

        if len(indices) == 1:
            return {indices[0]} if known_dirty == 1 else set()

        # Split into two groups
        mid = len(indices) // 2
        left_indices = indices[:mid]

        # Test left group
        left_dirty = self.test_sample(left_indices)

        # Recursively process both groups
        left_result = self._recursive_find(left_indices, left_dirty)
        right_result = self._recursive_find(indices[mid:], known_dirty - left_dirty)

        return left_result | right_result


# Test cases
def run_tests():
    # Test case 1: Example from the problem
    reservoirs1 = [True, True, False, False, False, False, False]  # 2 dirty out of 7
    tester1 = WaterTesting(reservoirs1)
    result1 = tester1.find_dirty_reservoirs()
    print(f"Test 1 - Found dirty reservoirs at indices: {result1}")
    print(f"Number of tests used: {tester1.test_count}")

    # Test case 2: All clean
    reservoirs2 = [False] * 8
    tester2 = WaterTesting(reservoirs2)
    result2 = tester2.find_dirty_reservoirs()
    print(f"\nTest 2 - Found dirty reservoirs at indices: {result2}")
    print(f"Number of tests used: {tester2.test_count}")

    # Test case 3: All dirty
    reservoirs3 = [True] * 8
    tester3 = WaterTesting(reservoirs3)
    result3 = tester3.find_dirty_reservoirs()
    print(f"\nTest 3 - Found dirty reservoirs at indices: {result3}")
    print(f"Number of tests used: {tester3.test_count}")

    # Test case 4: Mixed case with more reservoirs
    reservoirs4 = [True, False, True, False, False, True, False, True, False, False, True, False]
    tester4 = WaterTesting(reservoirs4)
    result4 = tester4.find_dirty_reservoirs()
    print(f"\nTest 4 - Found dirty reservoirs at indices: {result4}")
    print(f"Number of tests used: {tester4.test_count}")


if __name__ == "__main__":
    run_tests()

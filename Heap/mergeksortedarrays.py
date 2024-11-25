import heapq

def merge_k_sorted_arrays(arrays):
    # Min-heap to store (element, array_index, element_index)
    heap = []
    
    # Initialize the heap with the first element of each array
    for i in range(len(arrays)):
        if arrays[i]:  # Make sure the array is not empty
            heapq.heappush(heap, (arrays[i][0], i, 0))
    
    result = []
    
    # Continue extracting elements until the heap is empty
    while heap:
        # Extract the smallest element from the heap
        val, array_index, element_index = heapq.heappop(heap)
        result.append(val)
        
        # If there's a next element in the same array, add it to the heap
        if element_index + 1 < len(arrays[array_index]):
            next_element = arrays[array_index][element_index + 1]
            heapq.heappush(heap, (next_element, array_index, element_index + 1))
    
    return result

# Example usage
arrays = [
    [1, 4, 7],
    [2, 5, 8],
    [3, 6, 9]
]

merged_array = merge_k_sorted_arrays(arrays)
print("Merged array:", merged_array)
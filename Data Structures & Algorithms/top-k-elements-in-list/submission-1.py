class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dictionary = {}
        
        # O(n)
        for number in nums:
            if number in dictionary:
                dictionary[number] += 1
            else:
                dictionary[number] = 1

        sorted_data = dict(sorted(dictionary.items(), key=lambda item: item[1], reverse=True))

        returnValue = [0] * k

        counterThatRemThinksThisIsStupidILovePython = 0

        for key, value in sorted_data.items():
            returnValue[counterThatRemThinksThisIsStupidILovePython] = key
            counterThatRemThinksThisIsStupidILovePython += 1
            if counterThatRemThinksThisIsStupidILovePython > k-1:
                return returnValue

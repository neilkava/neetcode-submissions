class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        hset = set()
        for i in nums:
            lngt = len(hset)
            hset.add(i)
            if len(hset) == lngt:
                return True
        return False
        
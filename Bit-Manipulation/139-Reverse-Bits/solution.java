class Solution {
    public int reverseBits(int n) {
        
        // 00000000000000000000000000010101
        // 31                             0
        //    29                        2

        int res = 0;

        // Iterate through all bits of a 32-bit number
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res |= (bit << (31-i));
        }   
        return res;
    }
}

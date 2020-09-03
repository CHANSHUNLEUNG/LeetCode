package Questions.greedy.question605;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int maxNumber = 0;
        for (int index = 0; index < flowerbed.length; index++) {
            int pre = (index == 0) ? 0 : flowerbed[index - 1];
            int next = (index == flowerbed.length - 1) ? 0 : flowerbed[index + 1];
            if (flowerbed[index] == 0 && pre == 0 && next == 0) {
                flowerbed[index] = 1;
                maxNumber++;
            }
        }
        return maxNumber >= n;
    }
}

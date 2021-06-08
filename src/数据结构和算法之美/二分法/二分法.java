package 数据结构和算法之美.二分法;

public class 二分法 {
    //最简单情况，有序数组，无重复数据
    public int bsearch(int[] a, int n, int value) {
        int left = 0;
        int right = n-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (a[mid]==value){
                return mid;
            }
            if (a[mid]>value){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
    //迭代方法实现二分法
    public int bsearch1(int[] a, int n, int value){
        return bsearchInternally(a,0,n-1,value);
    }
    public int bsearchInternally(int[] a, int left,int right, int value){
        if (left>right)return -1;
        int mid = left+(right-left)/2;
        if (a[mid]==value){
            return value;
        }
        if (a[mid]>value){
           return bsearchInternally(a,left,mid-1,value);
        }else {
            return bsearchInternally(a,mid+1,right,value);
        }
    }

    /**
     * 变体一：查找第一个值等于给定值的元素
     */
    public int bsearch2(int[] a, int n, int value){
        int left = 0;
        int right = n-1;
        int mid = left+(right-left)>>1;//背一下位运算
        while (left<=right){
            if (a[mid]>value){
                right=mid-1;
            }else if (a[mid]<value){
                left=mid+1;
            }else {
                if (mid!=0||a[mid-1]==value){
                    right=mid-1;

                }else {
                    return mid;
                }
            }
        }
        return -1;
    }
    /**我们重点看第 51 行代码。
     * 如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；
     * 如果 mid 不等于 0，但 a[mid]的前一个元素 a[mid-1]不等于 value，
     * 那也说明 a[mid]就是我们要找的第一个值等于给定值的元素。
     * 如果经过检查之后发现 a[mid]前面的一个元素 a[mid-1]也等于 value，
     * 那说明此时的 a[mid]肯定不是我们要查找的第一个值等于给定值的元素。
     * 那我们就更新 high=mid-1，因为要找的元素肯定出现在[low, mid-1]之间。
     **/

    /**
     * 变体二：查找最后一个值等于给定值的元素
     */

    public int bsearch3(int[] a, int n, int value){
        int left = 0;
        int right = n-1;
        while (left<=right){
            int mid =left+(right-left)>>1;
            if (a[mid]>value){
                right=mid-1;
            }else if (a[mid]<value){
                left=mid+1;
            }else {
                if (mid!=n-1||a[mid+1]==value){
                    left=mid+1;
                }else {
                    return mid;
                }
            }
        }
        return -1;
    }

    /**
     * 变体三：查找第一个大于等于给定值的元素
     */
    public int bsearch4(int[] a, int n, int value){
        return -1;
    }
    /**
     * 变体四：查找最后一个小于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch5(int[] a, int n, int value){
        return -1;
    }


    public static void main(String[] args) {
        int [] a = new int[]{1,1,2,2,3,3,3,3,3,4,4,5};
        二分法 e = new 二分法();
        System.out.println(e.bsearch2(a,a.length,3));
    }
}

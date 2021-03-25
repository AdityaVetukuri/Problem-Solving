public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ans[] = new int[m+n];
        int x=0;
        int y=0;
        int z=0;
        while(x<m && y<n){
            if(nums1[x]<=nums2[y]){
                ans[z]=nums1[x];
                x++;
                z++;
            }
            else{
                ans[z]=nums2[y];
                y++;
                z++;
            }
        }
        while(x==m && y<n){
            ans[z]=nums2[y];
            y++;
            z++;
        }
        while(x<m && y==n){
            ans[z]=nums1[x];
            x++;
            z++;
        }
        for(int i =0;i<m+n;i++){
            nums1[i]=ans[i];
        }
    }
}

int main()
{

    int n,k;
    scanf("%d %d",&n, &k);
    int *arr = (int*)malloc(sizeof(int)*k);
    for(int i=0; i<k; i++)
    {
        arr[i]=i+1;
        n=n-(i+1);
    }
    if(n<0)
    {
        printf("-1");
        return 0;
    }
    int cur =k-1;
    while(n>0)
    {
        n--;
        arr[cur]++;
        cur--;
        if(cur==-1)
            cur=k-1;
    }

    printf("%d",arr[k-1]-arr[0]);

}
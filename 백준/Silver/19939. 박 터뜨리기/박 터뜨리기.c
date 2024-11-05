int main()
{
    int n, k, s;
    scanf("%d %d", &n, &k);
    if(k%2==0){
        s=n-((k/2)*(k+1));
    }else{
        s=n-(k*((k+1)/2));
    }
    if(s>=0){
        if(s%k==0){
            printf("%d", k-1);
        }else{
            printf("%d", k);
        }
    }else{
        printf("-1");
    }
    return 0;
}
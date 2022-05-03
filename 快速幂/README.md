# 快速幂

递归版

```java
int pow(int a, int n){
    if(n == 0){
        return 1;
    }else if((n & 1) == 0){
        int temp = pow(a, n >> 2);
        return temp * temp;
    }else{
        int temp = pow(a, n >> 2);
        return temp * temp * a;
    }
}
```

```java
int pow(int a, int n){
    int ans = 1;
    while(n != 0){
        if((n & 1) == 1){
            ans *= a;
        }
        a *= a;
        n >>= 1;
    }
}
```

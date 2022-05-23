def intercambia(L,i,j):
    tmp = L[i]
    L[i] = L[j]
    L[j] = tmp

    
def bubblesort1(A):
    for i in range(1,len(A)):
        for j in range(0,len(A)-1):
            if(A[j] < A[j +1]):
                intercambia(A,j,j+1)


def bubblesort2(A): 
    n= len(A)
    b = True
    p = 0

    while(p < n-1 and b):
        b = False
        for j in range(0,n-p-1):
            if(A[j] > A[j +1]): 
                print("Pasada {}".format(p))
                print(A)
                temp = A[j]
                print(A)
                A[j] = A[j+1]
                A[j+1] = temp
                print(A)
                b = True 
        p+= 1  


def main():
    A=[2,10,9,8,7,6,5,4,3,1] 
    print()
    print(A)
    bubblesort2(A)
    print(A) 
    print()


main()
    

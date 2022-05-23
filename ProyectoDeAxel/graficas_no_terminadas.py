
def intercambia(A,i,j):
    tmp=A[i]
    A[i]=A[j]
    A[j]=tmp


def particionar(A,p,r):
    x=A[r]
    i=p-1
    for j in range(p,r):
          if A[j]<= x:
               i+=1
               intercambia(A,i,j)
        
    intercambia(A,i+1,r)
    return i+1

def QuickSort(A,p,r):
    if p<r:
       q=particionar(A,p,r)
       print("elemento pivote",A[q])
       print("{}--{}--{}".format(A[p:q],A[q],A[q+1:r+1]))
       QuickSort(A,p,q-1)
       QuickSort(A,q+1,r) 



################################################################# 

def QuickSorth(A,p,r):
    if p<r:
       q=particionarH(A,p,r)
       #print("elemento pivote",A[q])
       #print("{}--{}".format(A[p:q+1],A[q+1:r+1]))
       QuickSortH(A,p,q-1)
       QuickSortH(A,q+1,r)
    
def particionarH(A,p,r):
    x=A[p]
    i=p-1
    j=pr+1
    
    while True:
        while True:
            j-=1
            if A[j]<=x:
                break
                
        while True:
            i+=1
            if A[i]>=x:
                break
                
        if i<j :
            intercambia(A,i,j)
        else:
            return j
            


################################################################# 

import math

def MaxHeapyfy(A,i,tamHeap):
    L=2*i+1
    r=2*i+2
    if l<= tamHeap-1 and A[L]>A[i]:
        posMax=L
    else:
        posMax=i
    if R<= tamHeap-1 and A[R]>A[posMax]:
        posMax=R
        
    if posMax !=i:
        intercambia(A,i,posMax)
        MaxHeapyfy(A,posMax,tamHeap)
    



def BHeapMaxIni(A,tamHeap):
    for i in range(math.ceil(tamHeap-1)/2,-1,-1):
        MaxHeapyfy(A,i,tamHeap)
        



def heapsort(A,tamheap):
    BHeapMaxIni(A,tamHeap)
    print(A)
    for i in range(leng(A)-1,0,-1):
        print("intercambia {} con {}".format(A[0],A[i]))
        intercambia(A,0,i)
        tamHeap-=1
        MaxHeapyfy(A,0,tamHeap)
        print(A[0:tamHeap])
        print(A)
    


def main():
    s=[2,8,7,1,3,5,6,4]
    s1=[2,8,7,1,3,5,6,4]
    s2=[2,8,7,1,3,5,6,4]
    print(s)
    QuickSort(s,0,len(s)-1)
    print(s)
    
    
    print(s1)
    QuickSortH(s1,0,len(s1)-1)
    print(s1)
    
    print(s2)
    heapSort(s2,len(s2))
    print(s2)
    
    
main()

def graficas():
    
    
    fig,ax=plt.subplots()
    ax.plot(nD,Tm,label="Merge Sort", marker="*", color="r")
    ax.plot(nD,Tm,label="Quick Sort", marker="*", color="y")
    ax.plot(nD,Tm,label="Heap Sort", marker="*", color="g")
    plt.title("MergeSort vs QuickSort vs HeapSort ") 





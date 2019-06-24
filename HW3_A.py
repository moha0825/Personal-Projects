# Lubna Mohamed Abdirahman, moha0825, Lab Section 011, HW 3, Problem A
def RGB_to_CMYK(r,g,b):  
    R = r/255
    G = g/255
    B = b/255
    K = (1 - max(R,G,B))
    if (K == 1):
        C = 0
        M = 0
        Y = 0
        K = round(K * 100)
        return [C,M,Y,K]
    C = round(((1-R-K)/(1-K)) * (100))
    M = round(((1-G-K)/(1-K)) * (100))
    Y = round(((1-B-K)/(1-K)) * (100))
    K = round(K*100)
    return [C,M,Y,K]
    
def main():
    R = int(input("Red component: "))
    G = int(input("Green component: "))
    B = int(input("Blue component: "))  
    cmyk = RGB_to_CMYK(R,G,B)
    print("CMYK representation: ", cmyk[0], cmyk[1], cmyk[2], cmyk[3])   
    
if __name__=="__main__":
    main()

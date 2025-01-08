def is_vps(string):
    stack=[]
    for char in string : 
        if char=="(":
            stack.append('(')
        elif char==")": 
            if not stack:
                return False; 
            stack.pop()
            
    return not stack
            
    
    
def main(): 
    T=int(input())
    i=0
    while i<T: 
        string=input()
        if is_vps(string)==True: 
            print("YES")
        else: 
            print("NO")
        i+=1
    
    
if __name__ =="__main__":
    main()
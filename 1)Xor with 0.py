def main():
    str_ = "Hello World"
    
    str1 = [''] * len(str_)
    length = len(str_)
    
    for i in range(length):
        str1[i] = chr(ord(str_[i]) ^ 0)
        print(str1[i], end='')

    print()

if __name__=="__main__":
    main()

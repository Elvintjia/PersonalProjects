#Factors finder
def iswholenum(num):
    if float(int(num)) == num:
        return True
    else:
        return False
print("Running factor finder...")
while True:
    wholenum = input("Please input the integer (Only integers and not float or negatives): ")
    try:
        wholenum = int(wholenum)
    except:
        print("Error, that is not an integer.")
    else:
        if wholenum < 0:
            print("Error, that is a negative number.")
        elif wholenum == 1:
            print("Error, why would you want to find factors of 1?")
        elif wholenum == 0:
            print("Error, why would you want to find factors of 0?")
        else:
            break
print("Processing input...")
divider = 2
factors = []
while True:
    if wholenum == divider:
        factors.append(divider)
        break
    result = wholenum / divider
    if iswholenum(result):
        wholenum = result
        factors.append(divider)
        divider = 2
    else:
        divider = divider + 1
statement = "Factors: "
statement = statement + str(factors[0])
prev = factors[0]
factors = factors[1:]
repeat = 1
while len(factors) != 0:
    if prev != factors[0]:
        statement = statement + " * " + str(factors[0])
        prev = factors[0]
        factors = factors[1:]
    else:
        while prev == factors[0]:
            repeat = repeat + 1
            factors = factors[1:]
            if len(factors) == 0:
                break
        statement = statement + "^" + str(repeat)
        repeat = 1
print(statement)
input('Press ENTER to exit')
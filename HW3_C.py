# Lubna Mohamed Abdirahman, moha0825, Lab Section 011, HW 3, Problem C
def loan_payment(p,r,t):
    # P = "Principal"
    # R = "Interest-Rate"
    # T = "Term"
    # F = "Face value"
    # I = "Interest"

    if r < 0:
        print("Error: The Interest Rate is too low, the minimum is 0 percent.")
        return
    elif r > 15:
        print("Error: The Interest Rate is too high, the maximum is 15 percent.")
        return
    elif p > 10000:
        print("Error: The Principal borrowing amount is too high. The maximum is $10000.")
        return
    elif p < 100:
        print("Error: The Principal borrowing amount is too low. The minimum is $100.")
        return
    elif t < 0:
        print("Error: The Term of the loan is too short. Must be greater than 0%.")
        return
    elif t > 10:
        print("Error: The Term of the loan is too long. Maximum is 10.")
        return

    t = int(t)
    i = p * (r/int(100)) * t
    f = p + i
    length_of_term = t * int(12)
    monthly_payment = f / length_of_term

    print("The face value of the loan is: $",'{0:.2f}'.format(f))
    print("Your monthly payment each month for", length_of_term, "month(s) is: $",'{0:.2f}'.format(monthly_payment))
    
def main():
    print("Welcome to the installment loan evaluation program.")
    print("\n")
    p = float(input("Please input the amount of money you will be borrowing: "))
    r = float(input("Please input the interest rate: "))
    t = int(input("Please input the term for the loan (in years): "))
    print("\n")
    loan_payment(p,r,t)

if __name__=="__main__":
    main()
    
    
